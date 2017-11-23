package entity;

public class FirstClassSeat extends Seat{
	
	private double seatPrice;
	private String seatName;
	
	public String getSeatName() {
		return seatName;
	}

	public void setSeatName(String seatName) {
		this.seatName = seatName;
	}

	public FirstClassSeat(int seatNumber, double seatPrice) {
		super(seatNumber);
		this.seatPrice=seatPrice;
		this.seatName = "First Class Seat " + seatNumber;
	}

	public FirstClassSeat(int seatNumber) {
		super(seatNumber);
		this.seatPrice=20000;
		this.seatName = "First Class Seat " + seatNumber;
	}

	public double getSeatPrice() {
		return seatPrice;
	}

	public void setSeatPrice(double seatPrice) {
		this.seatPrice = seatPrice;
	}
	
		
}
	

