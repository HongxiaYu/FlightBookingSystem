import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridLayout;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;

import entity.Food;
import util.MealCheckBox;
import util.SelectedMealList;

import javax.swing.BorderFactory;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MealSelectPanel extends JPanel {
	private int iType = 1;
	SelectedMealList selectedMealList;

	public MealSelectPanel(int iType, int customerID, int seatID) {
		this.iType = iType;
		selectedMealList = new SelectedMealList(customerID, seatID);

		initMainPanel();

		JPanel panel_2 = new JPanel();

		add(panel_2, BorderLayout.WEST);

		JPanel panel_3 = new JPanel();
		add(panel_3, BorderLayout.EAST);

	}

	private void initMainPanel() {
		JPanel panel = new JPanel();
		this.setLayout(new BorderLayout());
		JLabel lblPleaseChooseYour = new JLabel("Please choose your meal");
		this.add(lblPleaseChooseYour, BorderLayout.NORTH);
		lblPleaseChooseYour.setHorizontalAlignment(SwingConstants.CENTER);

		this.add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(0, 1));
		panel.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
		initMenuPanel(panel);

		JPanel panel_1 = new JPanel();
		add(panel_1, BorderLayout.SOUTH);

		JButton btnNewButton = new JButton("RESET");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Component[] components = panel.getComponents();
				for (Component c : components) {
					if (c instanceof MealCheckBox) {
						MealCheckBox cb = (MealCheckBox) c;
						cb.setSelected(false);
					}
				}

			}
		});
		panel_1.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("  OK  ");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectedMealList.clear();
				Component[] components = panel.getComponents();
				for (Component c : components) {
					if (c instanceof MealCheckBox) {
						MealCheckBox cb = (MealCheckBox) c;
						if (cb.isSelected()) {
							addSelectFood(cb.getFood());
						}
					}
				}
				System.out.println("Total Price: " + selectedMealList.getMealTotalPrice());
			}
		});
		panel_1.add(btnNewButton_1);

	}

	private void initMenuPanel(JPanel menuPanel) {
		List<Food> foodMenu = null;
		if (iType == 1) {
			foodMenu = DataLager.getFirstClassMenu();
		} else {
			foodMenu = DataLager.getEconomyClassMenu();
		}

		if (foodMenu != null) {
			for (Food item : foodMenu) {
				menuPanel.add(new MealCheckBox(item));
			}
		}

	}

	public void addSelectFood(Food f) {
		selectedMealList.add(f);
	}

	public SelectedMealList getSelectedFoods() {
		return selectedMealList;
	}

	public static void main(String[] args) {
		JFrame jFrame = new JFrame();
		MealSelectPanel msf = new MealSelectPanel(1, 1, 1);
		jFrame.getContentPane().add(msf, BorderLayout.CENTER);
		jFrame.setSize(300, 400);
		jFrame.setVisible(true);

	}
}
