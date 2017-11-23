package view;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class LogInPanel extends JPanel{

	public LogInPanel() {
		
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		JPanel first = new JPanel();
		
		JLabel nameLabel = new JLabel("User name");
		first.add(nameLabel);
		
		JTextField nameField = new JTextField(20);
		first.add(nameField);
	
		add(first);
		
		JPanel second = new JPanel();
		
		JLabel passwordLabel = new JLabel("Password");
		second.add(passwordLabel);
		
		JTextField passwordField = new JTextField(20);
		second.add(passwordField);
		
		add(second);
		
		setVisible(true);
	}
}
