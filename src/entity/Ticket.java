package entity;

import java.util.List;

public class Ticket {
	
	private int id;
	private Customer customer;
	private Seat seat;
	private List<Food> foods;
	
	public Ticket(Customer customer, Seat seat, List<Food> foods) {
		// ToDo add id form GeneralIDNext
		this.customer = customer;
		this.seat = seat;
		this.foods = foods;
	}
	
	public Ticket(Customer customer, Seat seat) {
		this(customer, seat, null);
	}

	public int getTicketId() {
		return id;
	}

	public Customer getCustomer() {
		return customer;
	}

	public Seat getSeat() {
		return seat;
	}

	public List<Food> getFoods() {
		return foods;
	}
	
	public int getSeatType() {
		if(seat instanceof FirstClassSeat) {
			return 1;
		}
		return 2;
	}
	
	public double getFoodsPrice() {
		double foodsPrice = 0;
		if(foods != null) {
			for(Food f : foods) {
				foodsPrice = foodsPrice+f.getFoodPrice();
			}
		}
		return foodsPrice;
	}
	
	public double getTicketPrice() {
		return seat.getSeatPrice() + getFoodsPrice();
	}
	
	public String toString() {
		return null;
//		return customer +" seatNumber: "+ seat.getSeatNumber() +" Meal: "+ food.getFoodName() +" Total price: " + getTicketPrice();
	}
	
}
