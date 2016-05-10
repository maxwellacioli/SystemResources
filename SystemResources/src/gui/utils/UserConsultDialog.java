package gui.utils;

import gui.actions.CancelAction;
import gui.actions.UserConsultAction;

import java.awt.Component;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import users.User;

import main.AcademicUnit;
import net.miginfocom.swing.MigLayout;

public class UserConsultDialog extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private AcademicUnit au;
	private JTextField userID;
	private User user;

	public UserConsultDialog(AcademicUnit au) {
		super();
		this.au = au;
		this.user = null;

		initComponents();
		setSize(220, 80);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}

	private void initComponents() {
		JPanel mainPanel = new JPanel(new MigLayout("", "grow", ""));

		userID = new JTextField();
		userID.setColumns(5);

		mainPanel.add(new JLabel("ID Usuario"));
		mainPanel.add(userID, "spanx, wrap");

		mainPanel.add(createActionsButton(), "spanx, align center");
		setContentPane(mainPanel);

	}

	private Component createActionsButton() {
		JPanel panel = new JPanel(new MigLayout());

		JButton cancelActionButton = new JButton(new CancelAction(this));
		JButton userConsultAction = new JButton(new UserConsultAction(this, au));

		panel.add(cancelActionButton);
		panel.add(userConsultAction, "wrap");

		return panel;
	}

	public int getUserID() {

		return Integer.parseInt(userID.getText());

	}

	public void setUser(User user) {
		this.user = user;
	}

	public User getUser() {
		return this.user;
	}

}
