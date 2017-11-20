import java.awt.EventQueue;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.BorderLayout;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class FlightBookingApp {

	private JFrame frame;


	/**
	 * Create the application.
	 */
	public FlightBookingApp() {
		initialize();
		frame.setVisible(true);
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

		JButton btnBooking = new JButton("Book tickets");
		//		btnBooking.addActionListener(e -> new BookTickesFrame()); TODO Change to new class
		panel.add(btnBooking);

		JButton btnQuery = new JButton("Querry");
		//		btnQuery.addActionListener(e -> new QuerryFrame()); TODO Change to new class
		panel.add(btnQuery);

		JButton btnAdminister = new JButton("Administer");
		//		btnAdminister.addActionListener(e -> new AdminiserFrame()); TODO Change to new class
		panel.add(btnAdminister);
		
		JPanel panel_1 = new ImagePanel("images/airplane.jpg");
		frame.getContentPane().add(panel_1, BorderLayout.CENTER);


	}



}
