package entity;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import util.GenericNumber;

public class BookingInfo {
	private int bookingID;
	private Customer customer;
	private Date date;
	private String numberOfBookings;
	private List<Ticket>tickets;
	

	public BookingInfo(List<Ticket> tickets) {
		this.bookingID = GenericNumber.getBookingOrderIDNext();
		this.date = new Date();
		this.numberOfBookings = GenericNumber.getOrderNumber();
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

	public String getNumberOfBookings() {
		return numberOfBookings;
	}

	public List<Ticket> getTickets() {
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
