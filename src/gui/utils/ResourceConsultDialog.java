package gui.utils;

import java.awt.Component;

import gui.MainGUI;
import gui.actions.CancelAction;
import gui.actions.ResourceConsultAction;
import gui.actions.ResourceRegisterAction;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import resources.Resource;


import net.miginfocom.swing.MigLayout;

import main.AcademicUnit;

public class ResourceConsultDialog extends JDialog{
	
	public static final String ADM = "Administrador";
	public static final String USR = "Usuario";
	
	private AcademicUnit au;
	private JTextField resourceID;
	private JComboBox userType;
	private String[] userTypeName;
	private Resource rs;
	
	public ResourceConsultDialog(MainGUI f, AcademicUnit au) {
		super(f, "Consulta de Recurso");
		this.au = au;
		this.rs = null;
		initComponents();
		setSize(300, 145);
		setLocationRelativeTo(f);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}

	private void initComponents() {
		JPanel mainPanel = new JPanel(new MigLayout("", "grow", ""));
		
		userTypeName = new String[2];
		userTypeName[0] = ADM;
		userTypeName[1] = USR;
		
		resourceID = new JTextField();
		resourceID.setColumns(10);
		userType = new JComboBox(userTypeName);
		
		mainPanel.add(new JLabel("ID do Recurso:"));
		mainPanel.add(resourceID, "wrap");
		MainGUI.addSeparator(mainPanel, "Tipo de Permissao");
		mainPanel.add(new JLabel("Tipo do Usuario:"), "wrap");
		mainPanel.add(userType, "wrap");
		mainPanel.add(createActionPanel(), "spanx, center");
		setContentPane(mainPanel);
	}
	
	public Component createActionPanel() {
		JPanel panel = new JPanel(new MigLayout());
		JButton closeButton = new JButton(new CancelAction(this));
		JButton resourceConsultButton = new JButton(new ResourceConsultAction(this, au));
		
		panel.add(closeButton);
		panel.add(resourceConsultButton, "wrap");
		
		return panel;
	}
	
	public int getResourceID() {
		return Integer.parseInt(resourceID.getText());
	}
	
	public String getUserTypde() {
		String type;
		int index = userType.getSelectedIndex();
		type = (String) userType.getItemAt(index);
		
		return type;
	}
	
	public Resource getResource() {
		return rs;
	}
	
	public void setResource(Resource rs) {
		this.rs = rs;
	}
	
}
