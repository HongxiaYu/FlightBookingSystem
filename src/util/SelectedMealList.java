package util;

import java.util.ArrayList;
import java.util.List;

import entity.Food;

public class SelectedMealList {
	private List<Food> selectedFoods = new ArrayList<Food>();
	private int customerID = 0;
	private int seatID = 0;

	public SelectedMealList(int customerID, int seatID) {
		this.customerID = customerID;
		this.seatID = seatID;
	}

	public void clear() {
		selectedFoods.clear();
	};

	public void add(Food food) {
		selectedFoods.add(food);
	};

	public double getMealTotalPrice() {
		double totalPrice = 0;
		for (Food food : selectedFoods) {
			totalPrice = totalPrice + food.getFoodPrice();
		}
		return totalPrice;
	}

	public List<Food> getSelectedFoods() {
		return selectedFoods;
	}

	public void setSelectedFoods(List<Food> selectedFoods) {
		this.selectedFoods = selectedFoods;
	}

	public int getCustomerID() {
		return customerID;
	}

	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}

	public int getSeatID() {
		return seatID;
	}

	public void setSeatID(int seatID) {
		this.seatID = seatID;
	}
}
