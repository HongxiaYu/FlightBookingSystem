package view;

import java.awt.EventQueue;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import data.DataLager;

import java.awt.BorderLayout;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class FlightBookingApp {

	private static DataLager DATALAGER = new DataLager();
	private static FlightBookingApp flightBookingApp;
	private static JFrame frame;

	/**
	 * Create the application.
	 */
	public FlightBookingApp() {
		initialize();
		frame.setTitle("AHA Flight Booking System");
		frame.setVisible(true);
	}

	public static FlightBookingApp getInstanceFlightApp() {
		if (flightBookingApp == null) {
			flightBookingApp = new FlightBookingApp();
		}
		if (!frame.isVisible()) {
			frame.setVisible(true);
		}
		return flightBookingApp;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 586, 401);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.NORTH);

		JPanel mainPanel = new ImagePanel("images/airplane.jpg");
		frame.getContentPane().add(mainPanel, BorderLayout.CENTER);

		JButton btnBooking = new JButton("Book tickets");
		btnBooking.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ChooseTicketClassFrame cf = new ChooseTicketClassFrame();
				cf.setSize(300, 180);
				cf.setLocation(300, 400);
				cf.setVisible(true);
			}
		});
		// btnBooking.addActionListener(e -> new BookTickesFrame()); TODO Change to new
		// class
		panel.add(btnBooking);

		JButton btnQuery = new JButton("Querry");
		// btnQuery.addActionListener(e -> new QuerryFrame()); TODO Change to new class
		panel.add(btnQuery);

		JButton btnAdminister = new JButton("Administer");
		// btnAdminister.addActionListener(e -> new AdminiserFrame()); TODO Change to
		// new class
		panel.add(btnAdminister);

	}

	public static DataLager getDataLager() {
		return DATALAGER;
	}

}
