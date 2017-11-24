package entity;

import util.GenericNumber;

public abstract class Seat {
	private int seatNumber;
	private double seatPrice;
	private SeatStatus seatStatus;
	private int id;
	private int flightId;	


	public Seat(int seatNumber, int flightId) {
		this.seatNumber=seatNumber;
		this.flightId = flightId;
		this.seatStatus=SeatStatus.EMPTY;	
		this.id = GenericNumber.getSeatIDNext();
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}	
	

	public int getSeatNumber() {
		return seatNumber;
	}

	public double getSeatPrice() {
		return seatPrice;
	}

	public SeatStatus getSeatStatus() {
		return seatStatus;
	}

	public void setSeatStatus(SeatStatus seatStatus) {
		this.seatStatus = seatStatus;
	}

	public void setSeatNumber(int seatNumber) {
		this.seatNumber = seatNumber;
	}

	public void setSeatPrice(double seatPrice) {
		this.seatPrice = seatPrice;
	}
	

	public int getFlightId() {
		return flightId;
	}

	public void setFlightId(int flightId) {
		this.flightId = flightId;
	}

	public abstract String getSeatName();
		
}
	
