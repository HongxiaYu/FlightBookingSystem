package entity;

import util.GenericIDNext;

public class Airplane {
	
	private int id;
	private String name;
	private int numberOfFirstCalssSeats;
	private int numberOfEconomyClassSeats;
	
	public Airplane(String name, int numberOfFirstCalssSeats, int numberOfEconomyClassSeats) {
		this.id = GenericIDNext.getAirplaneIDNext();
		this.name = name;
		this.numberOfFirstCalssSeats = numberOfFirstCalssSeats;
		this.numberOfEconomyClassSeats = numberOfEconomyClassSeats;
	}

	public int getId() {
		return id;
	}

	public int getNumberOfFirstCalssSeats() {
		return numberOfFirstCalssSeats;
	}

	public int getNumberOfEconomyClassSeats() {
		return numberOfEconomyClassSeats;
	}
	
	

}
