package entity;

public class Ticket {
	
	private int id;
	private Customer customer;
	private Seat seat;
	private Food food;
	
	public Ticket(Customer customer, Seat seat, Food food) {
		// ToDo add id form GeneralIDNext
		this.customer = customer;
		this.seat = seat;
		this.food = food;
	}
	
	public Ticket(Customer customer, Seat seat) {
		this(customer, seat, new Food(0, "No food orderd", 0.0));
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

	public Food getFood() {
		return food;
	}
	
	public double getTicketPrice() {
		return seat.getSeatPrice() + food.getFoodPrice();
	}
	
	public String toString() {
		return customer +" seatNumber: "+ seat.getSeatNumber() +" Meal: "+ food.getFoodName() +" Total price: " + getTicketPrice();
	}
	
}
