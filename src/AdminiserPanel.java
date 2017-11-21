import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class AdminiserPanel extends JPanel {
	
	private DataLager data;
	private double totalProfit;
;

	/**
	 * Create the panel.
	 */
	public AdminiserPanel(DataLager data) {
		
		this.data = data;
		totalProfit = getTotalProfit();
		
		
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		JPanel panelTop = new JPanel();
		add(panelTop);
		
		JPanel panelMiddle = new JPanel();
		add(panelMiddle);
		
		JLabel lblTotalIncome = new JLabel("Total income " + totalProfit);
		panelMiddle.add(lblTotalIncome);
		
		JPanel panelBottom = new JPanel();
		add(panelBottom);
		
		
	}
	
	private double getTotalProfit() {
		double income = data.getBookingInfos()
				.stream()
				.map(b -> b.getBookingPrice())
				.reduce(0.0, (c, d) -> c + d);
		return 0.3 * income;
	}
	


}
