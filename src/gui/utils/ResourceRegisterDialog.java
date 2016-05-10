package gui.utils;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeListener;

import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import main.AcademicUnit;
import net.miginfocom.swing.MigLayout;

import resources.*;
import gui.MainGUI;
import gui.actions.*;

public class ResourceRegisterDialog extends JDialog {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static final int NUMBER_TYPE = 4;

	private JTextField resourceID;
	private JComboBox resourceTypes;
	private AcademicUnit au;
	private String[] resourceNameTypes;

	public ResourceRegisterDialog(MainGUI f, AcademicUnit au) {
		super(f, "Cadastro de Recurso");
		this.au = au;
		this.setLocationRelativeTo(null);
		initComponents();
		setSize(300, 130);
		setLocationRelativeTo(f);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}

	public void initComponents() {
		JPanel mainPanel = new JPanel(new MigLayout("", "grow", ""));
		
		resourceNameTypes = new String[NUMBER_TYPE];
		resourceNameTypes[0] = "Sala de Aula";
		resourceNameTypes[1] = "Auditorio";
		resourceNameTypes[2] = "Laboratorio";
		resourceNameTypes[3] = "Projetor";
		
		resourceTypes = new JComboBox(resourceNameTypes);
		
		resourceID = new JTextField();
		resourceID.setColumns(5);
		
		mainPanel.add(new JLabel("ID:"), "split 2");
		mainPanel.add(resourceID, "wrap");
		mainPanel.add(new JLabel("Tipo do Recurso:"), "wrap");
		mainPanel.add(resourceTypes, "wrap");
		
		mainPanel.add(createActionPanel(), "spanx, center");
		setContentPane(mainPanel);
	}
	
	public Component createActionPanel() {
		JPanel panel = new JPanel(new MigLayout());
		JButton closeButton = new JButton(new CancelAction(this));
		JButton resourceRegisterButton = new JButton(new ResourceRegisterAction(this, au));
		
		panel.add(closeButton, "grow");
		panel.add(resourceRegisterButton, "grow");
		
		return panel;
	}
	
	public String getTypeSelected() {
		String type;
		int index = resourceTypes.getSelectedIndex();
		type = (String) resourceTypes.getItemAt(index);
		
		return type;
	}
	
	public int getIDType() {
		
		return Integer.parseInt(resourceID.getText());
	}

}
