package view;

import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.TitledBorder;

import entity.Seat;
import entity.SeatRadioButton;
import entity.SeatStatus;
import util.CommenMethod;

import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.List;

public class SeatSelectPanel extends JPanel {
	
	private int iType;
	private List<SeatRadioButton>  seatRadioButtons;


	public SeatSelectPanel(int itype) {
		this.iType = itype;
		initMainPanel();
	}

	public void initMainPanel() {
		setLayout(new BorderLayout());

		JPanel panel_1 = new JPanel();
		add(panel_1, BorderLayout.NORTH);

		JPanel seatPanel = new JPanel();

		JPanel panel = new JPanel();
		add(panel, BorderLayout.CENTER);

		panel.add(seatPanel);

		initSeatPanel(seatPanel);

		JPanel panel_2 = new JPanel();
		add(panel_2, BorderLayout.SOUTH);
	}

	public void initSeatPanel(JPanel seatPanel) {
		seatPanel.removeAll();
		ButtonGroup buttonGroup = new ButtonGroup();
		seatRadioButtons = new ArrayList<SeatRadioButton>();
		List<Seat> seats = FlightBookingApp.getDataLager().getSeats(iType);
		seatPanel.setLayout(new BoxLayout(seatPanel, BoxLayout.Y_AXIS));
		seatPanel.setBorder(new TitledBorder("Choose A Seat"));
		for (Seat seat : seats) {
			SeatRadioButton rdbtnSeat = new SeatRadioButton(seat);
			rdbtnSeat.setAlignmentX(Component.LEFT_ALIGNMENT);
			seatPanel.add(rdbtnSeat);
			buttonGroup.add(rdbtnSeat);
			seatRadioButtons.add(rdbtnSeat);
		}		
		
	}
	
	public void initSelectedSeat(Seat seat) {
		for(SeatRadioButton r : seatRadioButtons) {
			if(r.getSeat().getId() == seat.getId()) {
				r.setSelected(true);
			}
		}
	}
	
	public Seat getSelectedSeat() {
		
		seatRadioButtons.stream().forEach(s -> System.out.println(s.isSelected()));
		SeatRadioButton stemp  =  seatRadioButtons.stream().filter(s-> s.isSelected()).findFirst().get();
		
		if(stemp!=null) {
			return stemp.getSeat();
		}		
		return null;				
	}

	public static void main(String[] args) {
		JFrame jFrame = new JFrame();
		SeatSelectPanel msf = new SeatSelectPanel(1);
		msf.getSelectedSeat();
		jFrame.getContentPane().add(msf, BorderLayout.CENTER);
		jFrame.setSize(300, 400);
		jFrame.setVisible(true);

	}

}
