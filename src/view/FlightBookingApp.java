package view;

import java.awt.EventQueue;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import data.DataLager;
import util.CommenMethod;

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
		flightBookingApp = this;
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
		frame.setBounds(CommenMethod.FRAME_LOCATION_X, CommenMethod.FRAME_LOCATION_Y, 586, 401);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.NORTH);

		JPanel mainPanel = new ImagePanel("images/airplane.jpg");
		frame.getContentPane().add(mainPanel, BorderLayout.CENTER);

		JButton btnBooking = new JButton("Book tickets");
		btnBooking.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ChooseTicketClassFrame cf = new ChooseTicketClassFrame();
				cf.setSize(320, 260);
				cf.setLocation(CommenMethod.FRAME_LOCATION_X+10, CommenMethod.FRAME_LOCATION_Y+10);
				cf.setVisible(true);
//				frame.setVisible(false);
			}
		});
		
		panel.add(btnBooking);

		JButton btnQuery = new JButton("Querry");
		btnQuery.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				QuerryFrame qf = new QuerryFrame(DATALAGER);
				qf.setSize(600, 600);
				qf.setLocation(300, 400);
				qf.setVisible(true);
			}
		});
		panel.add(btnQuery);

		JButton btnAdminister = new JButton("Administer");
		btnAdminister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JPanel logIn = new LogInPanel();
				int i = JOptionPane.showConfirmDialog(null,
						logIn, "Log in", JOptionPane.OK_CANCEL_OPTION);
				
				if(i == JOptionPane.OK_OPTION) {
				
					AdminiserFrame af = new AdminiserFrame(DATALAGER);
					af.setSize(300, 180);
					af.setLocation(300, 400);
					af.setVisible(true);
				}
			}
		}); 
		panel.add(btnAdminister);

	}

	public static DataLager getDataLager() {
		return DATALAGER;
	}

}
