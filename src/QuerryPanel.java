import javax.swing.JPanel;
import javax.swing.JTextArea;

import java.awt.BorderLayout;
import java.awt.TextArea;

import javax.swing.JTextPane;

import entity.BookingInfo;
import entity.Customer;
import entity.FirstClassSeat;
import entity.Flight;
import entity.Seat;
import entity.SeatStatus;
import entity.Ticket;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.awt.event.ActionEvent;

public class QuerryPanel extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextArea textArea;
	private DataLager data;

	/**
	 * Create the panel.
	 */
	public QuerryPanel(DataLager data) {
		
		this.data = data;
		
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		JPanel panelNorth = new JPanel();
		add(panelNorth);
		
		JLabel lblCustomerName = new JLabel("Customer id");
		panelNorth.add(lblCustomerName);
		
		textField = new JTextField();
		panelNorth.add(textField);
		textField.setColumns(10);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new CusomerSearchButtonListener());
		panelNorth.add(btnSearch);
		
		JPanel panelMiddle = new JPanel();
		add(panelMiddle);
		
		JLabel lblFlightName = new JLabel("Flight id");
		panelMiddle.add(lblFlightName);
		
		textField_1 = new JTextField();
		panelMiddle.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnSearch_1 = new JButton("Search");
		btnSearch_1.addActionListener(new FlightSerachButtonListener());
		panelMiddle.add(btnSearch_1);
		
		textArea = new JTextArea();
		add(textArea);

	}
	
	class CusomerSearchButtonListener implements ActionListener{
		
		
		@Override
		public void actionPerformed(ActionEvent e) {
			
			textArea.setText("");
			StringBuilder output = new StringBuilder();
			
			int id = Integer.parseInt(textField.getText());
		
			Optional<Customer> cus = data.getCustomers()
			.stream()
			.filter(c -> (c.getId() == id))
			.findAny();
			
			if(cus.isPresent()) {
				
				Customer customer = cus.get();
				
				List<BookingInfo>bookings = data.getBookingInfos()
						.stream()
						.filter(b ->(b.getCustomer().equals(customer)))
						.collect(Collectors.toList());
				
				if(!bookings.isEmpty()) {
					
					output.append(customer);
					output.append("\n");
					
					for(BookingInfo booking: bookings) {
						for(Ticket ticket: booking.getTickets()) {
							output.append(ticket);
							output.append("\n");
						}
					}
					
				}
				
			}
			
			textArea.append(output.toString());
			
		}
		
	}
	
	class FlightSerachButtonListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			textArea.setText("");
			StringBuilder output = new StringBuilder();
			
			int id = Integer.parseInt(textField_1.getText());
			

			Optional<Flight> fl = data.getFlights().stream()
					.filter(f -> f.getFlightId() == id)
					.findAny();
			
			if(fl.isPresent()) {
				
				Flight flight = fl.get();
				
				output.append("FirstClass seats\n");
				
				output.append(addSeats(flight.getFirstClassSeats()));
				output.append(addSeats(flight.getEconomyClassSeats()));
				
			}
		
			textArea.setText(output.toString());
		}
		
		private String addSeats(Seat[] seats) {
			
			StringBuilder output = new StringBuilder();
			
			for(int i = 0; i < seats.length; i++) {
				output.append(seats[i].getSeatNumber());
				if(seats[i].getSeatStatus() == SeatStatus.BOOKED) {
					output.append("Booked\n");
				}
				else {
					output.append(seats[i].getSeatPrice());
					output.append("\n");
				}
			}
			
			return output.toString();
		}
	}

}
