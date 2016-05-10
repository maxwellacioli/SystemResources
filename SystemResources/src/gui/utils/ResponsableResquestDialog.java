package gui.utils;

import java.awt.Component;

import gui.MainGUI;
import gui.actions.ActivitieRegisterButtonAction;
import gui.actions.CancelAction;
import gui.actions.InformResponsableAction;
import gui.actions.InformResponsableEnableAction;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;

import users.User;

import main.AcademicUnit;
import net.miginfocom.swing.MigLayout;

public class ResponsableResquestDialog extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private AcademicUnit au;
	private ResourceRequestDialog resourceRequestDialog;
	private User resp;

	private JTextField responsableID;
	private JButton activitieButton;

	public ResponsableResquestDialog(
			ResourceRequestDialog resourceRequestDialog, AcademicUnit au) {
		super();
		this.resourceRequestDialog = resourceRequestDialog;
		this.au = au;
		this.resp = null;

		initComponents();
		setSize(300, 150);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}

	private void initComponents() {
		JPanel mainPanel = new JPanel(new MigLayout("", "grow", ""));

		responsableID = new JTextField();
		responsableID.setColumns(10);

		activitieButton = new JButton(new ActivitieRegisterButtonAction(resourceRequestDialog, au));

		mainPanel.add(new JLabel("ID do Responsavel"));
		mainPanel.add(responsableID, "wrap");

		MainGUI.addSeparator(mainPanel, "Atividade");
		mainPanel.add(activitieButton, "spanx, center, wrap");

		mainPanel.add(new JSeparator(), "spanx, gapleft rel, growx,wrap");
		mainPanel.add(createActionsButton(), "spanx, center, wrap");
		setContentPane(mainPanel);
	}

	private Component createActionsButton() {
		JPanel panel = new JPanel(new MigLayout());

		JButton cancelButton = new JButton(new CancelAction(this));
		JButton informResponsableButton = new JButton(
				new InformResponsableEnableAction(this, resourceRequestDialog,
						au));

		panel.add(cancelButton);
		panel.add(informResponsableButton);

		return panel;
	}

	public User getResponsable() {
		return resp = au.userConsult(Integer.parseInt(responsableID.getText()));
	}
}
