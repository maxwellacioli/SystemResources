package gui.utils;

import java.awt.Component;
import java.awt.Dimension;

import gui.MainGUI;
import gui.actions.CancelAction;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;

import users.User;

import net.miginfocom.swing.MigLayout;

public class UserDialog extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private User user;

	private JLabel userID;
	private JLabel userName;
	private JLabel userEmail;
	private JList<String> resourcesAllocatedList;
	private JList<String> activitiesHistorical;
	private String[] resourcesNames;
	private String[] activitiesHistoricalNames;

	public UserDialog(User user) {
		super();
		this.user = user;

		initComponents();
		setSize(400, 400);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}

	private void initComponents() {
		JPanel mainPanel = new JPanel(new MigLayout("", "grow", ""));

		userID = new JLabel(Integer.toString(user.getUserID()));
		userName = new JLabel(user.getName());
		userEmail = new JLabel(user.getEmail());

		mainPanel.add(new JLabel("ID Usuario:"));
		mainPanel.add(userID, "wrap");
		mainPanel.add(new JLabel("Nome Usuario:"));
		mainPanel.add(userName, "wrap");
		mainPanel.add(new JLabel("Email Usuario:"));
		mainPanel.add(userEmail, "wrap");

		MainGUI.addSeparator(mainPanel, "Recursos Alocados");
		mainPanel.add(createResourcesHistoricalJList(), "spanx, wrap");

		MainGUI.addSeparator(mainPanel, "Historico de Atividades");
		mainPanel.add(createActivitieHistoricalJList(), "spanx, wrap");

		mainPanel.add(new JSeparator(), "spanx, gapleft rel, growx,wrap");

		JButton cancelButton = new JButton(new CancelAction(this));
		mainPanel.add(cancelButton, "spanx, align center");
		setContentPane(mainPanel);
	}

	private Component createResourcesHistoricalJList() {
		resourcesNames = new String[user.getResourcesAllocated().size()];

		for (int i = 0; i < resourcesNames.length; i++) {
			resourcesNames[i] = user.getResourcesAllocated().get(i)
					.getTypeName();
		}

		resourcesAllocatedList = new JList<String>(resourcesNames);

		JScrollPane resourceHistoricalName = new JScrollPane(
				resourcesAllocatedList);
		resourceHistoricalName.setPreferredSize(new Dimension(390, 100));

		return resourceHistoricalName;
	}

	private Component createActivitieHistoricalJList() {

		activitiesHistoricalNames = new String[user
				.getActivitiesParticipantes().size()];

		for (int i = 0; i < activitiesHistoricalNames.length; i++) {
			activitiesHistoricalNames[i] = user.getActivitiesParticipantes()
					.get(i).getTittle();
		}

		activitiesHistorical = new JList<String>(activitiesHistoricalNames);

		JScrollPane activitiesHistoricalName = new JScrollPane(
				activitiesHistorical);
		activitiesHistoricalName.setPreferredSize(new Dimension(390, 100));

		return activitiesHistoricalName;
	}

}
