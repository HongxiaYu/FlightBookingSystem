package entity;

public class Seat extends Flight{

	
	protected static int seatNumber;
	private double seatPrice;
	protected static String seatType;
	private boolean seatStatus;
	
	public Seat(int seatNumber,double seatPrice, String seatType,boolean seatStatus) {
		super(flightId,flightName);
		this.seatNumber=seatNumber;
		this.seatPrice=seatPrice;
		this.seatType=seatType;
		this.seatStatus=seatStatus;
	}

	public int getSeatNumber() {
		return seatNumber;
	}

	public double getSeatPrice() {
		return seatPrice;
	}

	public String getSeatType() {
		return seatType;
	}

	public boolean isseatStatus() {
		return seatStatus;
	}
		
}
	

