package entity;

public class EconomyClassSeat extends Seat{
	
	private double seatPrice;
	
	public EconomyClassSeat(int seatNumber, double seatPrice) {
		super(seatNumber);
		this.seatPrice=seatPrice;
	}

	public EconomyClassSeat(int seatNumber) {
		super(seatNumber);
		this.seatPrice=5000;
	}

	public double getSeatPrice() {
		return seatPrice;
	}
	
	public void setSeatPrice(double seatPrice) {
		this.seatPrice = seatPrice;
	}
		
}
	

