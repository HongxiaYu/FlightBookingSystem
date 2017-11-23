package util;

import java.util.Date;

public class GenericNumber {
	private static int FlightIDNext = 0;
	private static int FoodIDNext = 0;
	private static int BookingOrderIDNext = 0;
	private static int SeatIDNext = 0;
	private static int CustomerIDNext = 0;
	private static int AirplaneIDNext = 0;
	

	public static int getFlightIDNext() {
		return ++FlightIDNext;
	}
	public static int getFoodIDNext() {
		return ++FoodIDNext;
	}
	public static int getBookingOrderIDNext() {
		return ++BookingOrderIDNext;
	}
	public static int getSeatIDNext() {
		return ++SeatIDNext;
	}
	public static int getCustomerIDNext() {
		return ++CustomerIDNext;
	}
	public static int getAirplaneIDNext() {
		return ++AirplaneIDNext;
	}	
	
	public static String getOrderNumber() {
		return "HAA" + (new Date()).getTime();
	}	
}
