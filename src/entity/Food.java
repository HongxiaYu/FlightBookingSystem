package entity;

import util.GenericNumber;

public class Food{

	private int itemNumber;
	private String foodName;
	private double foodPrice;
	private int id;
	
	
	public Food(int itemNumber,String foodName,double foodPrice) {		
		this.itemNumber=itemNumber;
		this.foodName=foodName;
		this.foodPrice=foodPrice;
		id = GenericNumber.getFoodIDNext();		
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setItemNumber(int itemNumber) {
		this.itemNumber = itemNumber;
	}



	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}



	public void setFoodPrice(double foodPrice) {
		this.foodPrice = foodPrice;
	}



	public int getItemNumber() {
		return itemNumber;		
	}


	
	public String getFoodName() {
		return 	foodName;
	}


	public double getFoodPrice() {
		return foodPrice;		
	}
}
