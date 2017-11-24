package data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import entity.Airplane;
import entity.BookingInfo;
import entity.Customer;
import entity.Flight;
import entity.FlightStatus;
import entity.Food;
import entity.Seat;
import entity.SeatStatus;

public class DataLager {

	// Test comment

	private List<Food> foods = new ArrayList<Food>();
	private List<Flight> flights = new ArrayList<Flight>();
	private List<Airplane> airplanes = new ArrayList<Airplane>();
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

		Airplane a1 = new Airplane("First", 5, 5);
		airplanes.add(a1);
		Airplane a2 = new Airplane("Second", 5, 5);
		airplanes.add(a2);
		Airplane a3 = new Airplane("Third", 5, 5);
		airplanes.add(a3);

		Flight f1 = new Flight("To Oslo", a1, "14:00");
		Flight f2 = new Flight("To London", a2, "16:00");
		Flight f3 = new Flight("To Berlin", a3, "18:00");

		addFlight(f1);
		addFlight(f2);
		addFlight(f3);

	}

	public List<Airplane> getAirplanes() {
		return airplanes;
	}

	public void setAirplanes(List<Airplane> airplanes) {
		this.airplanes = airplanes;
	}

	public List<Flight> getBookingFlights() {
		List<Flight> readyFlights = new ArrayList<Flight>();
		for (Flight f : readyFlights) {
			f.checkFlightIsReady();
			if (f.getFlightStatus() == FlightStatus.BOOKING) {
				readyFlights.add(f);
			}
		}
		return flights;
	}

	public List<Seat> getSeats(int iType, Flight flightIn) {
		Flight flight = null;
		Optional<Flight> fli = flights.stream().filter(f -> f.equals(flightIn)).findAny();
		if (fli.isPresent()) {
			flight = fli.get();
			if (flight.getFlightStatus() == FlightStatus.BOOKING) {
				switch (iType) {
				case 1:
					return flight.getFirstClassSeats();
				case 2:
					return flight.getEconomyClassSeats();
				default:
					return null;
				}
			}else {
				return null;
			}
		} else {
			return null;
		}
	}

	// public void removeFlight(int iAirplaneId) {
	// flights.removeIf(p->p.getAirplane().getId()==iAirplaneId);
	// }

	public List<Food> getFirstClassMenu() {
		List<Food> menu = new ArrayList<Food>();	
		menu.add(new Food(1, "Toast skagen", 98));
		menu.add(new Food(2, "Laxtartar", 86));
		menu.add(new Food(3, "Fisk och skaldjursgryta", 156));
		menu.add(new Food(4, "Ryggbiff med potatispure", 186));
		menu.add(new Food(5, "Wallenbergare", 156));
		menu.add(new Food(6, "Spaghetti alla carbonara", 186));
		menu.add(new Food(7, "Oxsvansgryta", 156));
		menu.add(new Food(8, "Oxfile med potatisgratäng", 156));
		menu.add(new Food(9, "Grillad vårkyckling", 156));
		menu.add(new Food(10, "Cocola", 56));
		menu.add(new Food(11, "Vit Vin", 56));
		menu.add(new Food(12, "Red vin", 56));
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

	public Flight getFlyghtById(int flightId) {
		return flights.stream().filter(f -> f.getFlightId() == flightId).findFirst().get();
	}

	public Flight getFlyghtByAirplane(int airplaneId) {
		for(Flight f: flights) {
			if(f.getAirplane().getId() == airplaneId && f.getFlightStatus() != FlightStatus.FINISHED) {
				return f;
			}
		}
		return null;
		
	}

}
