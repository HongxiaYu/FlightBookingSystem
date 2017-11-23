package view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;

import entity.Customer;

import java.awt.BorderLayout;
import javax.swing.JComboBox;
import javax.swing.JFrame;

public class CustomerInfoInputPanel extends JPanel {

	JTextField fntextField = new JTextField();
	JTextField sntextField = new JTextField();
	JTextField pntextField = new JTextField();
	JComboBox gcomboBox = new JComboBox();

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

		JLabel lblNewLabel_1 = new JLabel("Gender");
		lblNewLabel_1.setBounds(10, 124, 70, 14);
		add(lblNewLabel_1);

		gcomboBox.setBounds(90, 121, 225, 24);
		add(gcomboBox);
	}

	public void setEditable(boolean isEditable) {
		fntextField.setEditable(isEditable);
		sntextField.setEditable(isEditable);
		pntextField.setEditable(isEditable);
		gcomboBox.setEditable(isEditable);
	}

	public void setCustomerValue(Customer custermer) {
		fntextField.setText(custermer.getFirstName());
		sntextField.setText(custermer.getLastName());
		pntextField.setText(custermer.getPassportNo());
		gcomboBox.setSelectedItem(custermer.getGender());
	}

	public static void main(String[] args) {
		JFrame jFrame = new JFrame();
		CustomerInfoInputPanel msf = new CustomerInfoInputPanel();
		jFrame.getContentPane().add(msf, BorderLayout.CENTER);
		jFrame.setSize(400, 300);
		jFrame.setVisible(true);

	}
}
