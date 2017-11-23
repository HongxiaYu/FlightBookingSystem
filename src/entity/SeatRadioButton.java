package entity;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JRadioButton;

import view.FlightBookingApp;

public class SeatRadioButton extends JRadioButton {
	Seat seat;
	
	public SeatRadioButton(Seat seat) {
		super("SEAT " + seat.getSeatNumber() + "           " + seat.getSeatPrice() + "SEK");
		this.seat = seat;
		this.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent event) {
				int state = event.getStateChange();
				if (state == ItemEvent.SELECTED) {
					FlightBookingApp.getDataLager().changeSeatStatus(SeatStatus.ISBOOKING, seat.getId());
				} else if (state == ItemEvent.DESELECTED) {
					FlightBookingApp.getDataLager().changeSeatStatus(SeatStatus.EMPTY, seat.getId());
				}
			}
		});
		
		if (seat.getSeatStatus() != SeatStatus.EMPTY) {
			this.setEnabled(false);
		}
		
	}

	public Seat getSeat() {
		return seat;
	}
	
	
}
