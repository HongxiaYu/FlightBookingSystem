
public class DataLager {
	private static int FlightIDNext = 0;
	private static int FoodIDNext = 0;
	private static int BookingOrderIDNext = 0;
	private static int SeatIDNext = 0;
	private static int CustomerIDNext = 0;
	private static int AirplaneIDNext = 0;
	
	
	//load data from XML
	private void initData() {
		
	}
	
	public static int getFlightIDNext() {
		return FlightIDNext;
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
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(getSeatIDNext());
		System.out.println(getSeatIDNext());
		System.out.println(getSeatIDNext());
		System.out.println(getSeatIDNext());
	}
	

}
