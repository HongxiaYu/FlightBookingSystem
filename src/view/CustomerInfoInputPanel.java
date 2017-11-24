package view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;

import entity.Customer;

import entity.Seat;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;

public class CustomerInfoInputPanel extends JPanel {

	JTextField fntextField = new JTextField();
	JTextField sntextField = new JTextField();
	JTextField pntextField = new JTextField();
	JComboBox  gcomboBox = new JComboBox();

	public CustomerInfoInputPanel() {
		setLayout(null);
		initPanel();
		this.setSize(400, 200);
	}

	private void initPanel() {
		JLabel lblFirstname = new JLabel("FirstName");
		lblFirstname.setBounds(10, 16, 80, 24);
		add(lblFirstname);

		fntextField.setBounds(90, 16, 225, 24);
		add(fntextField);

		JLabel lblNewLabel = new JLabel("Surname");
		lblNewLabel.setBounds(10, 51, 80, 24);
		add(lblNewLabel);

		sntextField.setBounds(90, 51, 225, 24);
		add(sntextField);

		JLabel lblPassportno = new JLabel("PassportNO.");
		lblPassportno.setBounds(10, 86, 80, 24);
		add(lblPassportno);

		pntextField.setBounds(90, 86, 225, 24);
		add(pntextField);

		JLabel lblGender = new JLabel("Gender");
		lblGender.setBounds(10, 124, 70, 14);
		add(lblGender);

		gcomboBox.setBounds(90, 121, 225, 24);
		add(gcomboBox);
		gcomboBox.addItem("Choose A Gender");
		gcomboBox.addItem("Female");
		gcomboBox.addItem("Male");
		gcomboBox.addItem("Other");

		gcomboBox.setVisible(true);



	}

	public void setEditable(boolean isEditable) {
		fntextField.setEditable(isEditable);
		sntextField.setEditable(isEditable);
		pntextField.setEditable(isEditable);
		gcomboBox.setEditable(isEditable);
	}

	public void setCustomerValue(Customer customer) {
		fntextField.setText(customer.getFirstName());
		sntextField.setText(customer.getLastName());
		pntextField.setText(customer.getPassportNo());
		gcomboBox.setSelectedItem(customer.getGender());
	}

	
	public Customer getCustomer() {
		
		Customer customer = new Customer(fntextField.getText(),sntextField.getText(),pntextField.getText(),gcomboBox.getSelectedItem().toString());
		return customer;
	}
	

	public void initCustomer(Customer customer){

		JLabel lblFirstname = new JLabel(fntextField.getText());
		JLabel lblNewLabel = new JLabel( fntextField.getText());
		JLabel lblGender = new JLabel(gcomboBox.getSelectedItem().toString());
		lblFirstname.setVisible(true);
		lblNewLabel.setVisible(true);
		lblGender.setVisible(true);

}
		
		
		
public static void main(String[] args) {
	JFrame jFrame = new JFrame();
	CustomerInfoInputPanel msf = new CustomerInfoInputPanel();
	jFrame.getContentPane().add(msf, BorderLayout.CENTER);
	jFrame.setSize(400, 300);
	jFrame.setVisible(true);
	
	
}
}
