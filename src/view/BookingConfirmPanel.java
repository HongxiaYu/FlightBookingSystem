package view;

import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import entity.BookingInfo;
import entity.Customer;
import entity.FirstClassSeat;
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
				BookTicketsPanel msf = new BookTicketsPanel();// to change
				msf.initTickets(tickets);
				jFrame.getContentPane().add(msf, BorderLayout.CENTER);
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
				System.out.println(iResult);
				if (iResult == 0) {
					CommenMethod.getJFrame(btnCanel).setVisible(false);
					FlightBookingApp.getInstanceFlightApp();
				}

			}
		});
		btPanel.add(btnCanel);

	}

	public void initMainPanel() {
		JPanel allTicketsPanel = new JPanel();
		allTicketsPanel.setLayout(null);
		if (tickets != null) {
			int index = 1;
			for (Ticket ticket : tickets) {
				TicketPanel ticketPTemp = new TicketPanel(ticket);
				ticketPTemp.setBorder(new TitledBorder("Ticket " + index));
				ticketPTemp.setBounds(0, 255 * (index - 1), 620, 240);
				allTicketsPanel.add(ticketPTemp);
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

		this.add(allTicketsPanel, BorderLayout.CENTER);
	}

	public static void main(String[] args) {
		JFrame jFrame = new JFrame();

		Customer customer = new Customer("John", "Berg", "FirstClass", 1, "pwno22323", "male");
		FirstClassSeat seat = new FirstClassSeat(2);

		List<Food> menu = new ArrayList<Food>();
		menu.add(new Food(1, "Beef med rice", 56));
		menu.add(new Food(9, "Lamb med bread", 56));
		menu.add(new Food(12, "Red vin", 56));
		menu.add(new Food(14, "Cocola", 56));
		Ticket t1 = new Ticket(customer, seat, menu);

		Ticket t2 = new Ticket(customer, seat, menu);
		Ticket t3 = new Ticket(customer, seat, menu);
		Ticket t4 = new Ticket(customer, seat, menu);
		Ticket t5 = new Ticket(customer, seat, menu);
		Ticket t6 = new Ticket(customer, seat, menu);

		List<Ticket> tickets = new ArrayList<Ticket>();
		tickets.add(t1);
		tickets.add(t2);
		tickets.add(t3);
		tickets.add(t4);
		tickets.add(t5);
		tickets.add(t6);

		BookingConfirmPanel msf = new BookingConfirmPanel(tickets);
		// jFrame.getContentPane().add(msf, BorderLayout.CENTER);

		JScrollPane scrollPane = new JScrollPane(msf);
		scrollPane.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setSize(650, 650);
		scrollPane.setLocation(10, 20);
		jFrame.getContentPane().add(scrollPane);

		jFrame.setSize(650, 650);
		jFrame.setVisible(true);
	}

}
