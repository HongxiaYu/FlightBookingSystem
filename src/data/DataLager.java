package data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import entity.Airplane;
import entity.BookingInfo;
import entity.Customer;
import entity.EconomyClassSeat;
import entity.Flight;
import entity.Food;
import entity.Seat;
import entity.SeatStatus;
import entity.FirstClassSeat;

public class DataLager {

	//Test comment
	
	private List<Food> foods = new ArrayList<Food>();
	private List<Flight> flights = new ArrayList<Flight>();
	private List<Seat> firstClassSeats = new ArrayList<Seat>();
	private List<Seat> economySeats = new ArrayList<Seat>();
	private List<Seat> seats = new ArrayList<Seat>();
	private List<Customer> customers = new ArrayList<Customer>();
	private List<BookingInfo> bookingInfos = new ArrayList<BookingInfo>();
	
	public DataLager() {
		initData();
	}

	// load data from XML
	private void initData() {
		
		// not needed anymore?? 
		
//		FirstClassSeat fcs = new FirstClassSeat(1);
//		FirstClassSeat fcs2 = new FirstClassSeat(1);
//		FirstClassSeat fcs3 = new FirstClassSeat(1);
//		FirstClassSeat fcs4 = new FirstClassSeat(1);
//		FirstClassSeat fcs5 = new FirstClassSeat(1);
//
//		EconomyClassSeat ecs6 = new EconomyClassSeat(6);
//		EconomyClassSeat ecs7 = new EconomyClassSeat(7);
//		EconomyClassSeat ecs8 = new EconomyClassSeat(8);
//		EconomyClassSeat ecs9 = new EconomyClassSeat(9);
//		EconomyClassSeat ecs10 = new EconomyClassSeat(10);
//
//		firstClassSeats.add(fcs);
//		firstClassSeats.add(fcs2);
//		firstClassSeats.add(fcs3);
//		firstClassSeats.add(fcs4);
//		firstClassSeats.add(fcs5);
//
//		economySeats.add(ecs6);
//		economySeats.add(ecs7);
//		economySeats.add(ecs8);
//		economySeats.add(ecs9);
//		economySeats.add(ecs10);
		
	
		Airplane a1 = new Airplane("First", 5, 5);
		
		Flight f1 = new Flight("To Oslo", a1, "14:00");
		Flight f2 = new Flight("To London", a1, "16:00");
		Flight f3 = new Flight("To Berlin", a1, "18:00");
		
		addFlight(f1);
		addFlight(f2);
		addFlight(f3);
		

	}

	public List<Seat> getSeats(int iType, Flight flightIn) {
		Flight flight = null;
		Optional<Flight> fli= flights.stream().filter(f -> f.equals(flightIn)).findAny();
		if(fli.isPresent()) {
			flight = fli.get();

			System.out.println(iType);
			switch (iType) {
			case 1:
				return flight.getFirstClassSeats();
			case 2:
				return flight.getEconomyClassSeats();
			default:
				return null;
			}
		}
		else {
			return null;
		}
	}
	
	public void changeSeatStatus(SeatStatus seatStatus, int seatID) {
		seats.stream().filter(s->s.getId()==seatID).forEach(s -> s.setSeatStatus(seatStatus));
	}
	
//	public Seat getSeatByID(int seatID) {
//		Seat seat = firstClassSeats.stream().filter(t->t.getId()==seatID).findFirst();		
//		if(seat == null) {
//			seat = economySeats.stream().filter(t->t.getId()==seatID).findFirst();
//		}
//		return seat;
//	}

	public List<Food> getFirstClassMenu() {
		List<Food> menu = new ArrayList<Food>();
		menu.add(new Food(1, "Beef med rice", 56));
		menu.add(new Food(2, "Chicken med rice", 86));
		menu.add(new Food(3, "Lamb med rice", 56));
		menu.add(new Food(4, "Beef med potatoes", 86));
		menu.add(new Food(5, "Chicken med potatoes", 56));
		menu.add(new Food(6, "Lamb med potatoes", 86));
		menu.add(new Food(7, "Beef med bread", 56));
		menu.add(new Food(8, "Chicken med bread", 56));
		menu.add(new Food(9, "Lamb med bread", 56));
		menu.add(new Food(10, "Cocola", 56));
		menu.add(new Food(11, "Vit Vin", 56));
		menu.add(new Food(12, "Red vin", 56));
		menu.add(new Food(13, "Cocola", 56));
		menu.add(new Food(14, "Cocola", 56));
		return menu;
	}

	public List<Food> getEconomyClassMenu() {
		List<Food> menu = new ArrayList<Food>();
		menu.add(new Food(1, "Beef med rice", 56));
		menu.add(new Food(2, "Chicken med rice", 86));
		menu.add(new Food(3, "Lamb med rice", 56));
		menu.add(new Food(4, "Beef med potatoes", 86));
		menu.add(new Food(5, "Chicken med potatoes", 56));
		menu.add(new Food(6, "Lamb med potatoes", 86));
		menu.add(new Food(7, "Beef med bread", 56));
		menu.add(new Food(8, "Chicken med bread", 56));
		menu.add(new Food(9, "Lamb med bread", 56));
		menu.add(new Food(10, "Cocola", 56));
		menu.add(new Food(11, "Vit Vin", 56));
		menu.add(new Food(12, "Red vin", 56));

		return menu;
	}

	public Food getFoodByID(int id) {
		return (Food) foods.stream().filter(food -> food.getItemNumber() == id);
	}

	public List<Food> getFoods() {
		return foods;
	}

	public void setFoods(List<Food> foods) {
		this.foods = foods;
	}

	public List<Flight> getFlights() {
		return flights;
	}

	public void setFlights(List<Flight> flights) {
		this.flights = flights;
	}

	public List<Seat> getFirstClassSeats() {
		return firstClassSeats;
	}

	public void setFirstClassSeats(List<Seat> firstClassSeats) {
		this.firstClassSeats = firstClassSeats;
	}

	public List<Seat> getEconomySeats() {
		return economySeats;
	}

	public void setEconomySeats(List<Seat> economySeats) {
		this.economySeats = economySeats;
	}

	public List<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}

	public List<BookingInfo> getBookingInfos() {
		return bookingInfos;
	}

	public void setBookingInfos(List<BookingInfo> bookingInfos) {
		this.bookingInfos = bookingInfos;
	}

	public void addABooking(BookingInfo bookingInfo) {
		bookingInfos.add(bookingInfo);
	}

	public BookingInfo getBookingByNumber(String strNumber) {
		List<BookingInfo> sBookingInfos = bookingInfos.stream().filter(p -> p.getNumberOfBookings().equals(strNumber))
				.collect(Collectors.toList());
		if (sBookingInfos != null && sBookingInfos.size() != 0) {
			return sBookingInfos.get(0);
		}
		return null;

	}
	
	public void addFlight(Flight newFlight) {
		firstClassSeats.addAll(newFlight.getFirstClassSeats());
		seats.addAll(newFlight.getFirstClassSeats());
		economySeats.addAll(newFlight.getEconomyClassSeats());
		seats.addAll(newFlight.getEconomyClassSeats());
		flights.add(newFlight);
	}

	public static void main(String[] args) {

	}

}
