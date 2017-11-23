package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import entity.Flight;
import entity.Ticket;
import util.CommenMethod;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.awt.event.ActionEvent;

public class BookTicketsPanel extends JPanel {

	private JTabbedPane tabbedPanel = new JTabbedPane();
	private List<BookATicketPanel> bookATicketPanels;
	private Flight flight;

	public BookTicketsPanel() {
		initMainPanel(1,null); // need chang
	}

	public BookTicketsPanel(int iSeatTpe, Flight flight) {
		initMainPanel(iSeatTpe, flight);
	}

	public void initMainPanel(int iSeatTpe, Flight flight) {
		this.flight = flight;
		this.setLayout(new BorderLayout());
		String ticket1 = "Ticket 1";
		bookATicketPanels = new ArrayList<BookATicketPanel>();
		BookATicketPanel bookATicketPanel = new BookATicketPanel(iSeatTpe, flight);
		bookATicketPanel.setPanelName(ticket1);
		tabbedPanel.addTab(ticket1, bookATicketPanel);
		addCloseActionToTab(ticket1, bookATicketPanel);
		bookATicketPanels.add(bookATicketPanel);

		JPanel panel = new JPanel();
		panel.setBounds(0, 354, 450, 33);

		JButton btnAddmorecustomer = new JButton("Add a New Ticket");
		panel.add(btnAddmorecustomer);
		btnAddmorecustomer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BookATicketPanel bookATicketPanelTemp = new BookATicketPanel(iSeatTpe, flight);
				String title = "Ticket " + (tabbedPanel.getTabCount() + 1);
				tabbedPanel.addTab(title, bookATicketPanelTemp);
				addCloseActionToTab(title, bookATicketPanelTemp);
				bookATicketPanels.add(bookATicketPanelTemp);
				bookATicketPanelTemp.setPanelName(title);
			}
		});

		btnAddmorecustomer.setSize(40, 10);

		JButton btnNext = new JButton("              Next              ");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame confirmFrame = new JFrame();
				BookingConfirmPanel msf = new BookingConfirmPanel(getTickets());
				confirmFrame.getContentPane().add(msf, BorderLayout.CENTER);
				confirmFrame.setSize(630, 320);
				confirmFrame.setVisible(true);
				CommenMethod.getJFrame(btnNext).setVisible(false);
			}
		});

		panel.add(btnNext);

		this.add(tabbedPanel, BorderLayout.CENTER);
		this.add(panel, BorderLayout.SOUTH);
	}

	// get tickets to do
	public List<Ticket> getTickets() {
		List<Ticket> tickets = new ArrayList<Ticket>();
		for(BookATicketPanel b : bookATicketPanels) {
			if(b.getTicket() == null) {
				JOptionPane.showMessageDialog(CommenMethod.getJFrame(b), 
								"You should choose a seat for " + b.getPanelName()
								+ " first!");
			}else {
				tickets.add(b.getTicket());
			}
		}		
		return tickets;
	}

	// init ticket to do
	public void initTickets(List<Ticket> tickets) {
		tabbedPanel.removeAll();
		bookATicketPanels = new ArrayList<BookATicketPanel>();		
		for(Ticket t : tickets) {
			BookATicketPanel bookATicketPanelTemp = new BookATicketPanel(t.getSeatType(), flight);
			bookATicketPanelTemp.initVale(t);
			String title = "Ticket " + (tabbedPanel.getTabCount() + 1);
			tabbedPanel.addTab(title, bookATicketPanelTemp);
			addCloseActionToTab(title, bookATicketPanelTemp);
			bookATicketPanels.add(bookATicketPanelTemp);
			bookATicketPanelTemp.setPanelName(title);
		}

	}

	private void addCloseActionToTab(String title, BookATicketPanel bookATicketPanelTemp) {
		int index = tabbedPanel.indexOfTab(title);
		JPanel pnlTab = new JPanel(new GridBagLayout());
		pnlTab.setOpaque(false);
		JLabel lblTitle = new JLabel(title);
		JLabel btnClose = new JLabel("    x");
		btnClose.setToolTipText("Delect " + title);
		btnClose.setForeground(Color.red);
		btnClose.setOpaque(false);

		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.weightx = 1;

		pnlTab.add(lblTitle, gbc);

		GridBagConstraints gbc1 = new GridBagConstraints();
		pnlTab.add(btnClose, gbc1);

		tabbedPanel.setTabComponentAt(index, pnlTab);
		
		btnClose.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (bookATicketPanelTemp != null) {
					tabbedPanel.remove(bookATicketPanelTemp);
					bookATicketPanels.removeIf(p->p==bookATicketPanelTemp);
				}
			}
		});
	}

	public class MyCloseActionHandler implements ActionListener {
		public void actionPerformed(ActionEvent evt) {
			Component selected = tabbedPanel.getSelectedComponent();
			if (selected != null) {
				tabbedPanel.remove(selected);
			}
		}
	}

	public static void main(String[] args) {
		JFrame jFrame = new JFrame();
		BookTicketsPanel msf = new BookTicketsPanel(1,null);
		msf.getTickets();
		jFrame.getContentPane().add(msf, BorderLayout.CENTER);
		jFrame.setSize(600, 500);
		jFrame.setVisible(true);
	}

}
