package entity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import util.GenericNumber;

public  class Flight {
	
	private int flightId;
	private String flightName;
	private Airplane airplane;
	private EconomyClassSeat[] economyClassSetas;
	private FirstClassSeat[] firstClassSeats;
	private String departureTime;
	

	public Flight(String flightName, Airplane airplane, String departureTime) {
		this.flightId=GenericNumber.getFlightIDNext();
		this.flightName=flightName;
		this.airplane = airplane;
		this.departureTime = departureTime;
		this.economyClassSetas = new EconomyClassSeat[airplane.getNumberOfEconomyClassSeats()];
		this.firstClassSeats = new FirstClassSeat[airplane.getNumberOfFirstCalssSeats()];
		makeSeats();
	}
	
	private void makeSeats() {
		for(int i = 0; i < economyClassSetas.length; i++) {
			economyClassSetas[i] = new EconomyClassSeat(i + 1, flightId);
		}
		for(int j = 0; j < firstClassSeats.length; j++) {
			firstClassSeats[j] = new FirstClassSeat(j + 1, flightId);
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


	public List<Seat> getEconomyClassSeats() {
		return new ArrayList<Seat>(Arrays.asList(economyClassSetas));
	}
	
	public boolean avalableSeatsEconomyClass() {
		Optional<Seat>seat = getEconomyClassSeats().stream().filter(s -> s.getSeatStatus()==SeatStatus.EMPTY).findAny();
		return seat.isPresent();
	}


	public List<Seat> getFirstClassSeats() {
		return new ArrayList<Seat>(Arrays.asList(firstClassSeats));
	}
	
	public boolean avalableSeatsFirstClass() {
		Optional<Seat>seat = getFirstClassSeats().stream().filter(s -> s.getSeatStatus()==SeatStatus.EMPTY).findAny();
		return seat.isPresent();
	}
	
	public String getDepartureTime() {
		return departureTime;
	}
	
	public int getNumberOfFirstClassSeats() {
		return firstClassSeats.length;
	}
	
	public int getNumberOfEconomyClassSeats() {
		return economyClassSetas.length;
	}
	
	public String toString() {
		return flightId +" "+ flightName;
	}

	
}
