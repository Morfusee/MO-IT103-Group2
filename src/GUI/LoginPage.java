package GUI;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

import javax.swing.*;
import javax.swing.border.*;

import Classes.User;
import GUI.admin.DashboardPage;

public class LoginPage extends JFrame {
	private JTextField usernameField = new JTextField();
	private JPasswordField passwordField = new JPasswordField();
	private JLabel usernameLabel = new JLabel("Username");
	private JLabel passwordLabel = new JLabel("Password");
	private JButton loginButton = new JButton("Login");

	public LoginPage() {

		// Set up the JFrame
		setTitle("MotorPH Portal");
		setSize(400, 200);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);

		// Set up layout with GridBagLayout
		setLayout(new GridBagLayout());

		// Create a JPanel with EmptyBorder for padding
		JPanel mainPanel = new JPanel();
		mainPanel.setBorder(new EmptyBorder(20, 20, 20, 20)); // Adjust the padding values as needed
		mainPanel.setLayout(new GridBagLayout());

		// Set preferred size for JTextField and JLabel
		Dimension labelSize = new Dimension(75, 30);
		Dimension fieldSize = new Dimension(200, 30);

		// Increase font size of JLabels
		Font labelFont = usernameLabel.getFont();
		usernameLabel.setFont(new Font(labelFont.getName(), Font.PLAIN, 14));
		passwordLabel.setFont(new Font(labelFont.getName(), Font.PLAIN, 14));

		// Set preferred size for labels and fields
		usernameLabel.setPreferredSize(labelSize);
		usernameField.setPreferredSize(fieldSize);
		passwordLabel.setPreferredSize(labelSize);
		passwordField.setPreferredSize(fieldSize);

		// Add components to the JPanel with GridBagLayout
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.insets = new Insets(5, 5, 5, 5); // Adjust the insets as needed

		mainPanel.add(usernameLabel, gbc);

		gbc.gridx = 1;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		mainPanel.add(usernameField, gbc);

		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.fill = GridBagConstraints.NONE;
		mainPanel.add(passwordLabel, gbc);

		gbc.gridx = 1;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		mainPanel.add(passwordField, gbc);

		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.gridwidth = 2;
		mainPanel.add(loginButton, gbc);

		// Add the JPanel to the JFrame
		add(mainPanel);

		// Set visible
		setVisible(true);

		// Add ActionListener to the login button
		loginButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					checkLoginCredentials();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});

		// Attach the ActionListener for each field available
		JTextField[] fields = { usernameField, passwordField };
		for (JTextField field : fields) {
			field.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					try {
						checkLoginCredentials();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
			});
		}
	}

	public void checkLoginCredentials() throws IOException {
		// Create a User object with the login credentials
		User userInfo = new User(usernameField.getText(), new String(passwordField.getPassword()));

		// Show dialog if the user credentials provided are incorrect.
		if (userInfo.getLoginStatus().equals(false)) {
			JOptionPane.showMessageDialog(new JFrame(""), "User credentials incorrect.", "Login Failed",
					JOptionPane.ERROR_MESSAGE);
		} else {
			// Close the last page
			dispose();

			// Proceed to the next page once logged in
			/* Create and display the form */
			java.awt.EventQueue.invokeLater(new Runnable() {
				public void run() {
					new DashboardPage().setVisible(true);
				}
			});
		}
	}

}
