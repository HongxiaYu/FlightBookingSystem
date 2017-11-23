package entity;

import util.GenericNumber;

public abstract class Seat {
	private int seatNumber;
	private double seatPrice;
	private SeatStatus seatStatus;
	private int id;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Seat(int seatNumber) {
		this.seatNumber=seatNumber;
		this.seatStatus=SeatStatus.EMPTY;	
		this.id = GenericNumber.getSeatIDNext();
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
	
	public abstract String getSeatName();
		
}
	
