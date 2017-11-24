package view;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import data.DataLager;

public class AdminiserFrame extends JFrame {
	
	private DataLager data;
	private double totalProfit;

	public AdminiserFrame(DataLager data) {
		
		this.data = data;
		totalProfit = getTotalProfit();
		
		JPanel base = new JPanel();
		add(base);
		
		base.setLayout(new BoxLayout(base, BoxLayout.Y_AXIS));
		
		JPanel panelTop = new JPanel();
		base.add(panelTop);
		
		JLabel lblTotalIncome = new JLabel("Total income " + totalProfit);
		panelTop.add(lblTotalIncome);
		
		JPanel panelBottom = new JPanel();
		base.add(panelBottom);
		
	}
	
	private double getTotalProfit() {
		double income = data.getBookingInfos()
				.stream()
				.map(b -> b.getBookingPrice())
				.reduce(0.0, (c, d) -> c + d);
		return 0.3 * income;
	}
	


}

