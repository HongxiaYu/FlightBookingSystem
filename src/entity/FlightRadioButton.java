package entity;



import javax.swing.JRadioButton;


public class FlightRadioButton  extends JRadioButton  {
	Flight flight;
	public FlightRadioButton(Flight flight_) {
		super(flight_.getFlightName() + "    " + flight_.getDepartureTime());
		this.flight = flight_;
	}
	public Flight getFlight() {
		return flight;
	}
	public void setFlight(Flight flight) {
		this.flight = flight;
	}
	
	

}
