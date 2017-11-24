package entity;

import view.FlightBookingApp;

public class AirplaneRunnable implements Runnable {

	Airplane airplane;
	String destination;

	public AirplaneRunnable(Airplane airplane, String destination) {
		this.airplane = airplane;
		this.destination = destination;
	}

	public void run() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e1) {
			
			e1.printStackTrace();
		}
		while (true) {
			try {
				Flight f = FlightBookingApp.getDataLager().getFlyghtByAirplane(airplane.getId());
				f.checkFlightIsReady();
				if (f.getFlightStatus() != FlightStatus.READY) {
					Thread.sleep(3000);
					continue;
				}
				f.setFlightStatus(FlightStatus.FLYING);
				System.out.println(airplane.getName() + "  " + destination + "is for Take-off ....");
				Thread.sleep(3000);
				System.out.println(airplane.getName() + "  " + destination + " is on the way ....");
				Thread.sleep(60000);
				System.out.println(airplane.getName() + "  " + destination + " is landing ....");
				Thread.sleep(3000);
				System.out.println(airplane.getName() + "  " + destination + " is refueling ....");
				Thread.sleep(3000);
				System.out.println(airplane.getName() + " create a new flight " + " to " + destination + "....");

				f.setFlightStatus(FlightStatus.FINISHED);
				Flight f_new = new Flight(f.getFlightName(), airplane, f.getDepartureTime());
				FlightBookingApp.getDataLager().addFlight(f_new);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

}
