import java.util.ArrayList;
import java.util.List;

import entity.BookingInfo;
import entity.Customer;
import entity.EconomyClassSeat;
import entity.Flight;
import entity.Food;
import entity.FirstClassSeat;

public class DataLager {
	
	private List<Food> foods = new ArrayList<Food>();
	private List<Flight> flights = new ArrayList<Flight>();
	private List<FirstClassSeat> firstClassSeats = new ArrayList<FirstClassSeat>();
	private List<EconomyClassSeat> economySeats = new ArrayList<EconomyClassSeat>();
	private List<Customer> customers = new ArrayList<Customer>();
	private List<BookingInfo> bookingInfos = new ArrayList<BookingInfo>();
	
	
	//load data from XML
	private void initData() {
		
	}
	
	public static List<Food> getFirstClassMenu(){
		List<Food> menu = new ArrayList<Food>();
		menu.add(new Food(1,"Beef med rice", 56));
		menu.add(new Food(2,"Chicken med rice", 86));
		menu.add(new Food(3,"Lamb med rice", 56));
		menu.add(new Food(4,"Beef med potatoes", 86));
		menu.add(new Food(5,"Chicken med potatoes", 56));
		menu.add(new Food(6,"Lamb med potatoes", 86));
		menu.add(new Food(7,"Beef med bread", 56));
		menu.add(new Food(8,"Chicken med bread", 56));
		menu.add(new Food(9,"Lamb med bread", 56));
		menu.add(new Food(10,"Cocola", 56));
		menu.add(new Food(11,"Vit Vin", 56));
		menu.add(new Food(12,"Red vin", 56));
		menu.add(new Food(13,"Cocola", 56));
		menu.add(new Food(14,"Cocola", 56));		
		return menu;
	}
	
	public static List<Food> getEconomyClassMenu(){
		List<Food> menu = new ArrayList<Food>();
		menu.add(new Food(1,"Beef med rice", 56));
		menu.add(new Food(2,"Chicken med rice", 86));
		menu.add(new Food(3,"Lamb med rice", 56));
		menu.add(new Food(4,"Beef med potatoes", 86));
		menu.add(new Food(5,"Chicken med potatoes", 56));
		menu.add(new Food(6,"Lamb med potatoes", 86));
		menu.add(new Food(7,"Beef med bread", 56));
		menu.add(new Food(8,"Chicken med bread", 56));
		menu.add(new Food(9,"Lamb med bread", 56));
		menu.add(new Food(10,"Cocola", 56));
		menu.add(new Food(11,"Vit Vin", 56));
		menu.add(new Food(12,"Red vin", 56));
		
		return menu;
	}	
	
	
	public Food getFoodByID(int id) {
		return (Food)foods.stream().filter(food->food.getItemNumber()==id);
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


	public List<FirstClassSeat> getFirstClassSeats() {
		return firstClassSeats;
	}

	public void setFirstClassSeats(List<FirstClassSeat> firstClassSeats) {
		this.firstClassSeats = firstClassSeats;
	}

	public List<EconomyClassSeat> getEconomySeats() {
		return economySeats;
	}

	public void setEconomySeats(List<EconomyClassSeat> economySeats) {
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

	public static void main(String[] args) {

	}
	

}
