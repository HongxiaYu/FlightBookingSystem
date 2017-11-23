package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JRadioButton;
import javax.swing.border.TitledBorder;

import util.CommenMethod;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ChooseTicketClassFrame extends JFrame {

	public ChooseTicketClassFrame() {

		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);

		JRadioButton rdbtnNewRadioButton = new JRadioButton("First Class Seat");
		panel.add(rdbtnNewRadioButton);

		JRadioButton rdbtnEconomySeat = new JRadioButton("Economy Seat");
		panel.add(rdbtnEconomySeat);

		JLabel lblNewLabel = new JLabel("   ");
		getContentPane().add(lblNewLabel, BorderLayout.NORTH);

		JPanel panel_1 = new JPanel();
		getContentPane().add(panel_1, BorderLayout.SOUTH);
		panel.setBorder(new TitledBorder("Choose Ticket Type"));

		ButtonGroup bg = new ButtonGroup();
		bg.add(rdbtnNewRadioButton);
		bg.add(rdbtnEconomySeat);

		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FlightBookingApp.getInstanceFlightApp();
				CommenMethod.getJFrame(btnNewButton_1).setVisible(false);

			}
		});
		panel_1.add(btnNewButton_1);

		JButton btnNewButton = new JButton("OK");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int iSeatType = 0;

				if (rdbtnNewRadioButton.isSelected()) {
					iSeatType = 1;
				}

				if (rdbtnEconomySeat.isSelected()) {
					iSeatType = 2;
				}

				if (iSeatType == 0) {
					JOptionPane.showMessageDialog(CommenMethod.getJFrame(btnNewButton),
							"You need choose a seat type! ");
				} else {
					JFrame jFrame = new JFrame();
					BookTicketsPanel msf = new BookTicketsPanel(iSeatType);
					jFrame.getContentPane().add(msf, BorderLayout.CENTER);
					jFrame.setSize(600, 500);
					jFrame.setVisible(true);
					CommenMethod.getJFrame(btnNewButton).setVisible(false);
				}
			}
		});
		panel_1.add(btnNewButton);
	}

	public static void main(String[] args) {
		ChooseTicketClassFrame cf = new ChooseTicketClassFrame();
		cf.setSize(300, 180);
		cf.setLocation(300, 400);
		cf.setVisible(true);

	}

}
