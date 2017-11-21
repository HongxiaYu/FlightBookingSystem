package entity;

public class FirstClassSeat extends Seat{
	
	private double seatPrice;
	
	public FirstClassSeat(int seatNumber, double seatPrice) {
		super(seatNumber);
		this.seatPrice=seatPrice;
	}

	public FirstClassSeat(int seatNumber) {
		super(seatNumber);
		this.seatPrice=20000;
	}

	public double getSeatPrice() {
		return seatPrice;
	}
	
	public void setSeatPrice(double seatPrice) {
		this.seatPrice = seatPrice;
	}	
		
}
	

