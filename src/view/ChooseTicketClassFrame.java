package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JRadioButton;
import javax.swing.border.TitledBorder;


import entity.Flight;
import entity.FlightRadioButton;
import util.CommenMethod;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.BoxLayout;

public class ChooseTicketClassFrame extends JFrame {

	List<FlightRadioButton> flightRadioButtons;
	ButtonGroup bg2 = new ButtonGroup();

	public ChooseTicketClassFrame() {

		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);

		JLabel lblNewLabel = new JLabel("   ");
		getContentPane().add(lblNewLabel, BorderLayout.NORTH);

		ButtonGroup bg = new ButtonGroup();
		panel.setLayout(new BorderLayout());

		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder("Choose A Flight"));
		panel_3.setLayout(new BoxLayout(panel_3, BoxLayout.Y_AXIS));
		panel_3.setAlignmentX(Component.LEFT_ALIGNMENT);
		panel_3.setPreferredSize(new Dimension(300, 300));

		initFlight(panel_3);
		panel.add(panel_3, BorderLayout.CENTER);

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder("Choose Ticket Type"));
		panel.add(panel_2, BorderLayout.SOUTH);

		JRadioButton rdbtnEconomySeat = new JRadioButton("Economy Seat");
		panel_2.add(rdbtnEconomySeat);
		panel_2.setAlignmentX(Component.LEFT_ALIGNMENT);
		bg.add(rdbtnEconomySeat);

		JRadioButton rdbtnNewRadioButton = new JRadioButton("First Class Seat");
		panel_2.add(rdbtnNewRadioButton);
		bg.add(rdbtnNewRadioButton);

		JPanel panel_1 = new JPanel();
		getContentPane().add(panel_1, BorderLayout.SOUTH);
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FlightBookingApp.getInstanceFlightApp();

				CommenMethod.getJFrame(btnNewButton_1).setVisible(false);
			}
		});
		panel_1.add(btnNewButton_1);

		JButton btnNewButton = new JButton("OK");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FlightRadioButton fl = flightRadioButtons.stream().filter(f -> f.isSelected()).findFirst().get();
				if (fl == null) {
					JOptionPane.showMessageDialog(CommenMethod.getJFrame(btnNewButton),
							"You need choose a flyght! ");
					return;
				}

				int iSeatType = 0;

				if (rdbtnNewRadioButton.isSelected()) {
					iSeatType = 1;
					if(!fl.getFlight().avalableSeatsFirstClass()) {
						JOptionPane.showMessageDialog(CommenMethod.getJFrame(btnNewButton),
								"First Class is fully booked! There is avalable seats in Economy Class");
						return;
					}
				}

				if (rdbtnEconomySeat.isSelected()) {
					iSeatType = 2;
					if(!fl.getFlight().avalableSeatsEconomyClass()) {
						JOptionPane.showMessageDialog(CommenMethod.getJFrame(btnNewButton),
								"Economy Class is fully booked! There is avalable seats in First Class");
						return;
					}
				}

				if (iSeatType == 0) {
					JOptionPane.showMessageDialog(CommenMethod.getJFrame(btnNewButton),
							"You need choose a seat type! ");
					return;
				}

				JFrame jFrame = new JFrame();
				BookTicketsPanel msf = new BookTicketsPanel(iSeatType, fl.getFlight());
				jFrame.getContentPane().add(msf, BorderLayout.CENTER);
				jFrame.setSize(600, 500);
				JFrame fatherFrame = CommenMethod.getJFrame(btnNewButton);
				jFrame.setLocation((int) fatherFrame.getLocation().getX() + 10,
						(int) fatherFrame.getLocation().getY() + 10);
				fatherFrame.setVisible(false);

				jFrame.setVisible(true);

			}
		});
		panel_1.add(btnNewButton);

	}
	
	private void initFlight(JPanel panel_3) {
		flightRadioButtons = new ArrayList<FlightRadioButton>();
		List<Flight> flights = FlightBookingApp.getDataLager().getBookingFlights();
		for (Flight f : flights) {
			if(f.avalableSeatsFirstClass() || f.avalableSeatsEconomyClass()) {
			FlightRadioButton frb = new FlightRadioButton(f);
			frb.setAlignmentX(Component.LEFT_ALIGNMENT);
			panel_3.add(frb);
			flightRadioButtons.add(frb);
			bg2.add(frb);
			}
		}
	}

	public static void main(String[] args) {
		ChooseTicketClassFrame cf = new ChooseTicketClassFrame();
		cf.setSize(300, 180);
		cf.setLocation(300, 400);
		cf.setVisible(true);

	}

}
