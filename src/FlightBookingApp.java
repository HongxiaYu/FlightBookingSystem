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
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.NORTH);
		
		JButton btnBooking = new JButton("Book");
		btnBooking.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel.add(btnBooking);
		
		JButton btnQuery = new JButton("Query");
		panel.add(btnQuery);
		
		JButton btnAdminister = new JButton("Administer");
		panel.add(btnAdminister);
	}
	
	private void bookSeat() {
		int option = JOptionPane.showInternalConfirmDialog(frame,
				"please choose one", "information",
				JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
	}

}
