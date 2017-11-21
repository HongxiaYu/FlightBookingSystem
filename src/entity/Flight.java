package entity;

import java.util.ArrayList;

import util.GenericIDNext;

public  class Flight {
	
	private int flightId;
	private String flightName;
	private Airplane airplane;
	private EconomyClassSeat[] economyClassSetas;
	private FirstClassSeat[] firstClassSeats;
	

	public Flight(String flightName, Airplane airplane) {
		this.flightId=GenericIDNext.getFlightIDNext();
		this.flightName=flightName;
		this.airplane = airplane;
		this.economyClassSetas = new EconomyClassSeat[airplane.getNumberOfEconomyClassSeats()];
		this.firstClassSeats = new FirstClassSeat[airplane.getNumberOfFirstCalssSeats()];
		makeSeats();
	}
	
	private void makeSeats() {
		for(int i = 0; i < economyClassSetas.length; i++) {
			economyClassSetas[i] = new EconomyClassSeat(i + 1);
		}
		for(int j = 0; j < firstClassSeats.length; j++) {
			firstClassSeats[j] = new FirstClassSeat(j + 1);
		}
	}
	
	public int getFlightId() {
		return flightId;
	}


	public String getFlightName() {
		return flightName;
	}


	public Airplane getAirplane() {
		return airplane;
	}


	public EconomyClassSeat[] getEconomyClassSetas() {
		return economyClassSetas;
	}


	public FirstClassSeat[] getFirstClassSeats() {
		return firstClassSeats;
	}
	
	public String toString() {
		return flightId +" "+ flightName;
	}

	
}
