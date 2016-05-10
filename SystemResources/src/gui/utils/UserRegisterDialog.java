package gui.utils;

import gui.MainGUI;
import gui.actions.CancelAction;
import gui.actions.UserRegisterAction;

import java.awt.Component;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import users.User;

import main.AcademicUnit;
import net.miginfocom.swing.MigLayout;

public class UserRegisterDialog extends JDialog{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static final int USR_QUANT = 5;
	
	private AcademicUnit au;
	
	private JTextField userID;
	private JTextField userName;
	private JTextField userEmail;
	private String[] userTypeName;
	private JComboBox userType;

	public UserRegisterDialog(AcademicUnit au) {
		super();
		this.au = au;
		
		initComponents();
		setSize(500, 180);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}

	private void initComponents() {
		JPanel mainPanel = new JPanel(new MigLayout("", "grow", "[][][][center]"));
		
		userID = new JTextField();
		userID.setColumns(5);
		userName = new JTextField();
		userName.setColumns(20);
		userEmail = new JTextField();
		userEmail.setColumns(30);
		
		userTypeName = new String[USR_QUANT];
		
		userTypeName[0] = User.STD_GRAD;
		userTypeName[1] = User.STD_MES;
		userTypeName[2] = User.STD_DOC;
		userTypeName[3] = User.USR_ADM;
		userTypeName[4] = User.USR_RES;
		
		userType = new JComboBox(userTypeName);
		
		mainPanel.add(new JLabel("ID Usuario"));
		mainPanel.add(userID, "wrap");
		mainPanel.add(new JLabel("Nome Usuario"));
		mainPanel.add(userName, "wrap");
		mainPanel.add(new JLabel("Email Usuario"));
		mainPanel.add(userEmail, "wrap");
		mainPanel.add(new JLabel("Tipo do Usuario"), "wrap");
		mainPanel.add(userType, "wrap");
		
		mainPanel.add(createActionsPanel(), "spanx, align center");
		setContentPane(mainPanel);
	}

	private Component createActionsPanel() {
		JPanel panel = new JPanel(new MigLayout());
		
		JButton cancelActionButton = new JButton(new CancelAction(this));
		JButton userRegisterButton = new JButton(new UserRegisterAction(this, au));
		
		panel.add(cancelActionButton);
		panel.add(userRegisterButton, "wrap");
		
		return panel;
	}
	
	public int getUserID() {
		return Integer.parseInt(userID.getText());
	}
	
	public String getUserName() {
		return userName.getText();
	}
	
	public String getUserEmail() {
		return userEmail.getText();
	}
	
	public String getTypeSelected() {
		String type;
		int index = userType.getSelectedIndex();
		type = (String) userType.getItemAt(index);
		
		return type;
	}
}
