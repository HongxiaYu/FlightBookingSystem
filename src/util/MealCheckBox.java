package util;

import java.awt.BorderLayout;

import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import entity.Food;

public class MealCheckBox extends JPanel {

	Food food;
	JCheckBox chckbxNewCheckBox;

	public MealCheckBox(Food food) {
		this.food = food;
		chckbxNewCheckBox = new JCheckBox(food.getItemNumber() + "  " + food.getFoodName() + " ");
		this.setLayout(new BorderLayout());
		
		this.add(chckbxNewCheckBox, BorderLayout.CENTER);
		this.add(new JLabel(" " + food.getFoodPrice() + "SEK  "), BorderLayout.EAST);
	}
	
	public void setSelected(boolean b) {
		if(chckbxNewCheckBox!=null) {
			chckbxNewCheckBox.setSelected(b);
		}
	}
	
	public boolean isSelected() {
		if(chckbxNewCheckBox!=null) {
			return chckbxNewCheckBox.isSelected();
		}
		return false;
	}

	public Food getFood() {
		return food;
	}

	public void setFood(Food food) {
		this.food = food;
	}

}
