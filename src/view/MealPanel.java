package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridLayout;
import java.util.ArrayList;
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
	JPanel mealPanel = new JPanel();
	private List<MealCheckBox>  mealCheckBoxs = new ArrayList<MealCheckBox>();

	public MealPanel(int iType) {
		this.iType = iType;
		initMainPanel();

		JPanel panel_2 = new JPanel();

		add(panel_2, BorderLayout.WEST);

		JPanel panel_3 = new JPanel();
		add(panel_3, BorderLayout.EAST);

	}

	public MealPanel(Ticket ticket) {
		this.iType = ticket.getSeatType();

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
	}

	public void initSelectedValue(List<Food> foodMenu) {
		
		for(MealCheckBox m : mealCheckBoxs) {			
			for(Food f:foodMenu) {
				if(f.getItemNumber() == m.getFood().getItemNumber()) {
					m.setSelected(true);
				}				
			}
		}
	}

	private void initMenuPanel(List<Food> foodMenu) {
		if (foodMenu != null && foodMenu.size() != 0) {
			for (Food item : foodMenu) {
				MealCheckBox mealCheckBox = new MealCheckBox(item);
				mealCheckBox.setSelected(true);
				mealCheckBox.setCheckboxEnabled(false);
				mealPanel.add(mealCheckBox);
				mealCheckBoxs.add(mealCheckBox);
			}
		}else {
			JLabel noFoodLabel = new JLabel("You select no food!");
			mealPanel.add(noFoodLabel, BorderLayout.CENTER);
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
				MealCheckBox mealCheckBox = new MealCheckBox(item);
				mealPanel.add(mealCheckBox);
				mealCheckBoxs.add(mealCheckBox);
			}
		}
	}

	public List<Food> getSelectedFoods() {
		List<Food> selectedFoods = new ArrayList<Food>();
		for(MealCheckBox m : mealCheckBoxs) {
			if(m.isSelected()) {
				selectedFoods.add(m.getFood());
			}			
		}
		return selectedFoods;
	}

	public static void main(String[] args) {
		JFrame jFrame = new JFrame();
		MealPanel msf = new MealPanel(1);
		jFrame.getContentPane().add(msf, BorderLayout.CENTER);
		jFrame.setSize(300, 400);
		jFrame.setVisible(true);

	}
}
