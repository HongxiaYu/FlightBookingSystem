package entity;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JRadioButton;

import view.FlightBookingApp;

public class SeatRadioButton extends JRadioButton {
	
	Seat seat;
	SeatRadioButton seatRadioButton;
	public SeatRadioButton(Seat seat) {
		super("SEAT " + seat.getSeatNumber() + "           " + seat.getSeatPrice() + "SEK");
		this.seat = seat;
		seatRadioButton = this;
		this.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent event) {
				int state = event.getStateChange();
				if (state == ItemEvent.SELECTED) {
//					FlightBookingApp.getDataLager().changeSeatStatus(SeatStatus.ISBOOKING, seat);
					seat.setSeatStatus(SeatStatus.ISBOOKING);
//					seatRadioButton.setEnabled(false);
				} else if (state == ItemEvent.DESELECTED) {
					seat.setSeatStatus(SeatStatus.EMPTY);
					seatRadioButton.setEnabled(true);
//					FlightBookingApp.getDataLager().changeSeatStatus(SeatStatus.EMPTY, seat);
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
