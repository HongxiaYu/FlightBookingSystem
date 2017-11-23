package view;

import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import entity.Customer;
import entity.FirstClassSeat;
import entity.Food;
import entity.Seat;
import entity.Ticket;

public class BookATicketPanel extends JPanel {
	SeatSelectPanel seatSelectPanel;
	MealPanel mealSelectPanel;
	CustomerInfoInputPanel customerInfoPanel;
	private String panelName;

	public BookATicketPanel(int itype) {
		initMainPanel(itype);
	}

	public void initMainPanel(int itype) {
		this.setLayout(null);
		seatSelectPanel = new SeatSelectPanel(itype);
		seatSelectPanel.setSize(313, 180);
		seatSelectPanel.setLocation(0, 0);
		seatSelectPanel.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));

		mealSelectPanel = new MealPanel(itype);		
		mealSelectPanel.setBorder(new TitledBorder("Choose Meal"));
		mealSelectPanel.setSize(264, 341);
		mealSelectPanel.setLocation(323, 0);

		customerInfoPanel = new CustomerInfoInputPanel();
		customerInfoPanel.setSize(313, 150);
		customerInfoPanel.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
		customerInfoPanel.setLocation(0, 191);
		this.add(seatSelectPanel);
		this.add(customerInfoPanel);
		this.add(mealSelectPanel);
		this.setSize(597, 372);
	}
	
	public void initVale(Ticket t) {
		mealSelectPanel.initSelectedValue(t.getFoods());
		seatSelectPanel.initSelectedSeat(t.getSeat());
//		customerInfoPanel.init();
	}
	
	public Ticket getTicket() {		
		Customer customer = new Customer("John", "Berg", "FirstClass", 1, "pwno22323", "male");
		Seat seat = seatSelectPanel.getSelectedSeat();
		System.out.println(seat);
		if(seat == null) {//
			return null;
		}
		List<Food> menu = mealSelectPanel.getSelectedFoods();
		Ticket t1 = new Ticket(customer, seat, menu);		
		return t1;
	}	

	public String getPanelName() {
		return panelName;
	}

	public void setPanelName(String panelName) {
		this.panelName = panelName;
	}

	public static void main(String[] args) {
		JFrame jFrame = new JFrame();
		BookATicketPanel msf = new BookATicketPanel(1);
		jFrame.getContentPane().add(msf, BorderLayout.CENTER);
		jFrame.setSize(400, 500);
		jFrame.setVisible(true);
	}
}
