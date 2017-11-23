package view;

import javax.swing.JPanel;

import entity.Customer;
import entity.FirstClassSeat;
import entity.Food;
import entity.Ticket;

import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JScrollPane;

public class TicketPanel extends JPanel {

	private Ticket ticket;

	public TicketPanel(Ticket ticket) {
		setLayout(null);
		this.ticket = ticket;
		initMainPanel();
	}

	private void initMainPanel() {
		JLabel lblSeat = new JLabel("Seat:");
		lblSeat.setBounds(20, 27, 46, 14);
		add(lblSeat);

		JLabel lblNewLabel = new JLabel();
		lblNewLabel.setText(ticket.getSeat().getSeatName());
		lblNewLabel.setBounds(90, 27, 182, 14);
		add(lblNewLabel);

		CustomerInfoInputPanel customerInfoPanel = new CustomerInfoInputPanel();
		customerInfoPanel.setCustomerValue(ticket.getCustomer());
		customerInfoPanel.setSize(324, 150);
		customerInfoPanel.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
		customerInfoPanel.setLocation(10, 66);
		customerInfoPanel.setEditable(false);

		this.add(customerInfoPanel);

		MealPanel mealSelectPanel = new MealPanel(ticket);

		JScrollPane scrollPane = new JScrollPane(mealSelectPanel);
		scrollPane.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setSize(264, 195);
		scrollPane.setLocation(344, 20);
		this.add(scrollPane);

	}

	public static void main(String[] args) {
		JFrame jFrame = new JFrame();
		// String firstName,String lastName,String classType,int customerId, String
		// passportNo, String gender
		Customer customer = new Customer("John", "Berg", "FirstClass", 1, "pwno22323", "male");
		FirstClassSeat seat = new FirstClassSeat(2);

		List<Food> menu = new ArrayList<Food>();
		menu.add(new Food(1, "Beef med rice", 56));
		menu.add(new Food(9, "Lamb med bread", 56));
		menu.add(new Food(12, "Red vin", 56));
		menu.add(new Food(14, "Cocola", 56));
		menu.add(new Food(1, "Beef med rice", 56));
		menu.add(new Food(9, "Lamb med bread", 56));
		menu.add(new Food(12, "Red vin", 56));
		menu.add(new Food(14, "Cocola", 56));
		menu.add(new Food(1, "Beef med rice", 56));
		menu.add(new Food(9, "Lamb med bread", 56));
		menu.add(new Food(12, "Red vin", 56));
		menu.add(new Food(14, "Cocola", 56));

		TicketPanel msf = new TicketPanel(new Ticket(customer, seat, menu));
		jFrame.getContentPane().add(msf, BorderLayout.CENTER);
		jFrame.setSize(640, 320);
		jFrame.setVisible(true);

	}
}
