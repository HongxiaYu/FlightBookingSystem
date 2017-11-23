package view;

import java.awt.BorderLayout;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

public class BookATicketPanel extends JPanel {

	public BookATicketPanel(int itype) {
		initMainPanel(itype);
	}

	public void initMainPanel(int itype) {
		this.setLayout(null);
		SeatSelectPanel seatSelectPanel = new SeatSelectPanel(itype);
		seatSelectPanel.setSize(313, 180);
		seatSelectPanel.setLocation(0, 0);
		seatSelectPanel.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));

		MealPanel mealSelectPanel = new MealPanel(itype);
		mealSelectPanel.setBorder(new TitledBorder("Choose Meal"));
		mealSelectPanel.setSize(264, 341);
		mealSelectPanel.setLocation(323, 0);

		CustomerInfoInputPanel customerInfoPanel = new CustomerInfoInputPanel();
		customerInfoPanel.setSize(313, 150);
		customerInfoPanel.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
		customerInfoPanel.setLocation(0, 191);
		this.add(seatSelectPanel);
		this.add(customerInfoPanel);
		this.add(mealSelectPanel);
		this.setSize(597, 372);

	}

	public static void main(String[] args) {
		JFrame jFrame = new JFrame();
		BookATicketPanel msf = new BookATicketPanel(1);
		jFrame.getContentPane().add(msf, BorderLayout.CENTER);
		jFrame.setSize(400, 500);
		jFrame.setVisible(true);
	}
}
