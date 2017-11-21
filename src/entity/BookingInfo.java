package entity;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BookingInfo {
	private int bookingID;
	private Customer customer;
	private Date date;
	private int numberOfBookings;
	private ArrayList<Ticket>tickets;
	
	public BookingInfo(int bookingID, Customer customer, Date date, int numberOfBookings, ArrayList<Ticket> tickets) {
		super();
		this.bookingID = bookingID;
		this.customer = customer;
		this.date = date;
		this.numberOfBookings = numberOfBookings;
		this.tickets = tickets;
	}

	public int getBookingID() {
		return bookingID;
	}
	
	public Customer getCustomer() {
		return customer;
	}

	public Date getDate() {
		return date;
	}

	public int getNumberOfBookings() {
		return numberOfBookings;
	}

	public ArrayList<Ticket> getTickets() {
		return tickets;
	}
	
	public double getBookingPrice() {
		double price = 0.0;
		for(Ticket t: tickets) {
			price += t.getTicketPrice();
		}
		return price;
	}
	

	
}
