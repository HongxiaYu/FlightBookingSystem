package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridLayout;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;

import data.DataLager;
import entity.Food;
import entity.Ticket;
import util.MealCheckBox;
import util.SelectedMealList;

import javax.swing.BorderFactory;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MealPanel extends JPanel {
	private int iType = 1;
	private SelectedMealList selectedMealList;
	JPanel mealPanel = new JPanel();

	public MealPanel(int iType) {
		this.iType = iType;
		selectedMealList = new SelectedMealList();

		initMainPanel();

		JPanel panel_2 = new JPanel();

		add(panel_2, BorderLayout.WEST);

		JPanel panel_3 = new JPanel();
		add(panel_3, BorderLayout.EAST);

	}

	public MealPanel(Ticket ticket) {
		this.iType = ticket.getSeatType();
		selectedMealList = new SelectedMealList();
		selectedMealList.setSeatID(ticket.getSeat().getId());
		selectedMealList.setSelectedFoods(ticket.getFoods());

		this.add(mealPanel, BorderLayout.CENTER);
		mealPanel.setLayout(new GridLayout(0, 1));
		mealPanel.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));

		initMenuPanel(ticket.getFoods());

		JPanel panel_2 = new JPanel();

		add(panel_2, BorderLayout.WEST);

		JPanel panel_3 = new JPanel();
		add(panel_3, BorderLayout.EAST);
	}

	private void initMainPanel() {
		this.setLayout(new BorderLayout());
		JLabel lblPleaseChooseYour = new JLabel("Please choose your meal");
		this.add(lblPleaseChooseYour, BorderLayout.NORTH);
		lblPleaseChooseYour.setHorizontalAlignment(SwingConstants.CENTER);

		this.add(mealPanel, BorderLayout.CENTER);
		mealPanel.setLayout(new GridLayout(0, 1));
		mealPanel.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
		initMenuPanel();

		// JPanel panel_1 = new JPanel();
		// add(panel_1, BorderLayout.SOUTH);
		//
		// JButton btnNewButton = new JButton("RESET");
		// btnNewButton.addActionListener(new ResetMealAction());
		// panel_1.add(btnNewButton);
		//
		// JButton btnNewButton_1 = new JButton(" OK ");
		// btnNewButton_1.addActionListener(new ConfirmMealAction());
		// panel_1.add(btnNewButton_1);
	}

	public void initSelectedValue() {

	}

	private void initMenuPanel(List<Food> foodMenu) {
		if (foodMenu != null) {
			for (Food item : foodMenu) {
				MealCheckBox mealCheckBox = new MealCheckBox(item);
				mealCheckBox.setSelected(true);
				mealCheckBox.setCheckboxEnabled(false);
				mealPanel.add(mealCheckBox);
			}
		}

	}

	private void initMenuPanel() {
		List<Food> foodMenu = null;
		if (iType == 1) {
			foodMenu = FlightBookingApp.getDataLager().getFirstClassMenu();
		} else {
			foodMenu = FlightBookingApp.getDataLager().getEconomyClassMenu();
		}

		if (foodMenu != null) {
			for (Food item : foodMenu) {
				mealPanel.add(new MealCheckBox(item));
			}
		}
	}

	private void addSelectFood(Food f) {
		selectedMealList.add(f);
	}

	public void setSelectedFoods(SelectedMealList selectedMealList) {
		this.selectedMealList = selectedMealList;
	}

	public SelectedMealList getSelectedFoods() {
		return selectedMealList;
	}

	public static void main(String[] args) {
		JFrame jFrame = new JFrame();
		MealPanel msf = new MealPanel(1);
		jFrame.getContentPane().add(msf, BorderLayout.CENTER);
		jFrame.setSize(300, 400);
		jFrame.setVisible(true);

	}

	class ResetMealAction implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			Component[] components = mealPanel.getComponents();
			for (Component c : components) {
				if (c instanceof MealCheckBox) {
					MealCheckBox cb = (MealCheckBox) c;
					cb.setSelected(false);
				}
			}

		}
	}

	class ConfirmMealAction implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			selectedMealList.clear();
			Component[] components = mealPanel.getComponents();
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
	}

}
