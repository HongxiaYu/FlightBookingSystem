import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FlightBookingApp {

	private JFrame frame;

	/**
	 * Create the application.
	 */
	public FlightBookingApp() {
		initialize();
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
	}
	
	

}
