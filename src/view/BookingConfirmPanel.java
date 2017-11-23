package view;

import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import entity.BookingInfo;
import entity.Customer;
import entity.FirstClassSeat;
import entity.Flight;
import entity.Food;
import entity.Ticket;
import util.CommenMethod;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BookingConfirmPanel extends JPanel {

	private List<Ticket> tickets = new ArrayList<Ticket>();

	public BookingConfirmPanel(List<Ticket> tickets) {

		this.tickets = tickets;
		this.setLayout(new BorderLayout());
		initMainPanel();

		JPanel btPanel = new JPanel();
		this.add(btPanel, BorderLayout.SOUTH);
		JButton btnModify = new JButton("Modify");
		btnModify.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame jFrame = new JFrame();
				Flight flight = FlightBookingApp.getDataLager().getFlyghtById(tickets.get(0).getSeat().getFlightId());
				BookTicketsPanel msf = new BookTicketsPanel(tickets.get(0).getSeatType(), flight);// to
				
				msf.initTickets(tickets);																					// change
				jFrame.getContentPane().add(msf, BorderLayout.CENTER);				
				JFrame fatherFrame = CommenMethod.getJFrame(btnModify);
				jFrame.setLocation((int)fatherFrame.getLocation().getX() + 10, (int)fatherFrame.getLocation().getY() + 10);
				fatherFrame.setVisible(false);
				jFrame.setSize(600, 500);
				jFrame.setVisible(true);
				
			}
		});
		btPanel.add(btnModify);

		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BookingInfo bi = new BookingInfo(tickets);
				FlightBookingApp.getDataLager().addABooking(bi);
				CommenMethod.getJFrame(btnOk).setVisible(false);
				JOptionPane.showMessageDialog(CommenMethod.getJFrame(btnOk),
						"Congratulation! You have succeeded  book " + tickets.size()
								+ " tickets. Your booking number is " + bi.getNumberOfBookings()
								+ ". You can use it to query your tickets!");
				FlightBookingApp.getInstanceFlightApp();

			}
		});
		btPanel.add(btnOk);

		JButton btnCanel = new JButton("Canel");
		btnCanel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int iResult = JOptionPane.showConfirmDialog(CommenMethod.getJFrame(btnOk),
						"Are you sure to give up this booking?");
				if (iResult == 0) {
					CommenMethod.getJFrame(btnCanel).setVisible(false);
					FlightBookingApp.getInstanceFlightApp();
				}

			}
		});
		btPanel.add(btnCanel);

	}

	public void initMainPanel() {
		JTabbedPane tabbedPanel = new JTabbedPane();
		if (tickets != null) {
			int index = 1;

			for (Ticket ticket : tickets) {

				TicketPanel ticketPTemp = new TicketPanel(ticket);
				tabbedPanel.addTab("Ticket " + index, ticketPTemp);
				index++;
			}
		}
		// JScrollPane scrollPane = new JScrollPane(allTicketsPanel);
		// scrollPane.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
		// scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		// scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		// scrollPane.setSize(650, 650);
		// scrollPane.setLocation(10, 20);
		// this.add(scrollPane);

		this.add(tabbedPanel, BorderLayout.CENTER);
	}

	public static void main(String[] args) {
		JFrame jFrame = new JFrame();

		Customer customer = new Customer("John", "Berg", "FirstClass", 1, "pwno22323", "male");
		Customer customer2 = new Customer("John22", "Berg", "FirstClass", 1, "pwno223213", "male");
		Customer customer3 = new Customer("John33", "Berg", "FirstClass", 1, "pwno223123", "male");
		Customer customer4 = new Customer("John44", "Berg", "FirstClass", 1, "pwno223rte", "male");
		Customer customer5 = new Customer("John55", "Berg", "FirstClass", 1, "pwno223453", "male");

		FirstClassSeat seat = new FirstClassSeat(1, 1);
		FirstClassSeat seat2 = new FirstClassSeat(2, 1);
		FirstClassSeat seat3 = new FirstClassSeat(3, 1);
		FirstClassSeat seat4 = new FirstClassSeat(4, 1);
		FirstClassSeat seat5 = new FirstClassSeat(5, 1);

		List<Food> menu = new ArrayList<Food>();
		menu.add(new Food(1, "Beef med rice", 56));
		menu.add(new Food(9, "Lamb med bread", 56));
		menu.add(new Food(12, "Red vin", 56));
		menu.add(new Food(14, "Cocola", 56));

		List<Food> menu2 = new ArrayList<Food>();
		menu2.add(new Food(1, "Chicken med rice", 56));
		menu2.add(new Food(9, "Lamb med bread", 56));
		menu2.add(new Food(12, "Red vin", 56));
		menu2.add(new Food(14, "Sprite", 56));

		List<Food> menu3 = new ArrayList<Food>();
		menu3.add(new Food(1, "Chicken med rice", 56));
		menu3.add(new Food(9, "Lamb med bread", 56));
		menu3.add(new Food(12, "House vin", 56));
		menu3.add(new Food(14, "Finda", 56));

		Ticket t1 = new Ticket(customer, seat, menu3);
		Ticket t2 = new Ticket(customer2, seat2, menu);
		Ticket t3 = new Ticket(customer3, seat3, menu2);
		Ticket t4 = new Ticket(customer4, seat4, menu3);
		Ticket t5 = new Ticket(customer5, seat5, menu);

		List<Ticket> tickets = new ArrayList<Ticket>();
		tickets.add(t1);
		tickets.add(t2);
		tickets.add(t3);
		tickets.add(t4);
		tickets.add(t5);

		BookingConfirmPanel msf = new BookingConfirmPanel(tickets);
		jFrame.getContentPane().add(msf, BorderLayout.CENTER);

		// JScrollPane scrollPane = new JScrollPane(msf);
		// scrollPane.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
		// scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		// scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		// scrollPane.setSize(650, 650);
		// scrollPane.setLocation(10, 20);
		// jFrame.getContentPane().add(scrollPane);

		jFrame.setSize(650, 350);
		jFrame.setVisible(true);
	}

}
