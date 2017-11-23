package view;

import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.TitledBorder;

import entity.Seat;
import entity.SeatStatus;
import util.CommenMethod;

import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.List;

public class SeatSelectPanel extends JPanel {

	public SeatSelectPanel(int itype) {
		initMainPanel(itype);
	}

	public void initMainPanel(int itype) {
		setLayout(new BorderLayout());

		JPanel panel_1 = new JPanel();
		add(panel_1, BorderLayout.NORTH);

		JPanel seatPanel = new JPanel();

		JPanel panel = new JPanel();
		add(panel, BorderLayout.CENTER);

		panel.add(seatPanel);

		initSeatPanel(seatPanel, itype);

		JPanel panel_2 = new JPanel();
		add(panel_2, BorderLayout.SOUTH);
	}

	public void initSeatPanel(JPanel seatPanel, int itype) {
		seatPanel.removeAll();		
		List<Seat> seats = FlightBookingApp.getDataLager().getSeats(itype);
		ButtonGroup buttonGroup = new ButtonGroup();
		seatPanel.setLayout(new BoxLayout(seatPanel, BoxLayout.Y_AXIS));
		seatPanel.setBorder(new TitledBorder("Choose A Seat"));
		for (Seat seat : seats) {
			JRadioButton rdbtnSeat = new JRadioButton(
					"SEAT " + seat.getSeatNumber() + "           " + seat.getSeatPrice() + "SEK");
			rdbtnSeat.addItemListener(new ItemListener() {

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
				rdbtnSeat.setEnabled(false);
			}
			rdbtnSeat.setAlignmentX(Component.LEFT_ALIGNMENT);
			seatPanel.add(rdbtnSeat);
			buttonGroup.add(rdbtnSeat);
		}
	}

	// public void initEconomySeatPanel(JPanel economyClassSeatPanel, ButtonGroup
	// buttonGroup) {
	// economyClassSeatPanel.setLayout(new BoxLayout(economyClassSeatPanel,
	// BoxLayout.Y_AXIS));
	// economyClassSeatPanel.setBorder(new TitledBorder("Choose Seat"));
	//
	// JRadioButton rdbtnSeat = new JRadioButton("SEAT 6 5 000SEK");
	// rdbtnSeat.setAlignmentX(Component.CENTER_ALIGNMENT);
	// economyClassSeatPanel.add(rdbtnSeat);
	// buttonGroup.add(rdbtnSeat);
	//
	// JRadioButton rdbtnSeat_1 = new JRadioButton("SEAT 7 5 000SEK");
	// rdbtnSeat_1.setAlignmentX(Component.CENTER_ALIGNMENT);
	// economyClassSeatPanel.add(rdbtnSeat_1);
	// buttonGroup.add(rdbtnSeat_1);
	//
	// JRadioButton rdbtnSeat_2 = new JRadioButton("SEAT 8 5 000SEK");
	// rdbtnSeat_2.setAlignmentX(Component.CENTER_ALIGNMENT);
	// economyClassSeatPanel.add(rdbtnSeat_2);
	// buttonGroup.add(rdbtnSeat_2);
	//
	// JRadioButton rdbtnSeat_3 = new JRadioButton("SEAT 9 5 000SEK");
	// rdbtnSeat_3.setAlignmentX(Component.CENTER_ALIGNMENT);
	// economyClassSeatPanel.add(rdbtnSeat_3);
	// buttonGroup.add(rdbtnSeat_3);
	//
	// JRadioButton rdbtnSeat_4 = new JRadioButton("SEAT 10 5 000SEK");
	// rdbtnSeat_4.setAlignmentX(Component.CENTER_ALIGNMENT);
	// economyClassSeatPanel.add(rdbtnSeat_4);
	// buttonGroup.add(rdbtnSeat_4);
	// }

	public static void main(String[] args) {
		JFrame jFrame = new JFrame();
		SeatSelectPanel msf = new SeatSelectPanel(1);
		jFrame.getContentPane().add(msf, BorderLayout.CENTER);
		jFrame.setSize(300, 400);
		jFrame.setVisible(true);

	}

}
