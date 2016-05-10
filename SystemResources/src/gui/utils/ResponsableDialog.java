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

import activities.Activitie;

import net.miginfocom.swing.MigLayout;

public class ResponsableDialog extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private ResourceConsultDialog resourceConsultDialog;

	private JLabel responsableID;
	private JLabel responsableName;
	private JLabel responsableEmail;
	private JList<String> participantsList;
	private JList<String> activitiesHistorical;
	private String[] participantsNames;
	private String[] activitiesHistoricalNames;

	public ResponsableDialog(ResourceConsultDialog resourceConsultDialog) {
		super();
		this.resourceConsultDialog = resourceConsultDialog;

		initComponents();
		setSize(350, 400);
		setLocationRelativeTo(resourceConsultDialog);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}

	private void initComponents() {
		JPanel mainPanel = new JPanel(new MigLayout("", "grow", ""));

		responsableID = new JLabel(Integer.toString(resourceConsultDialog
				.getResource().getUserResponsable().getUserID()));
		responsableName = new JLabel(resourceConsultDialog.getResource()
				.getUserResponsable().getName());
		responsableEmail = new JLabel(resourceConsultDialog.getResource()
				.getUserResponsable().getEmail());

		mainPanel.add(new JLabel("ID Responsavel"));
		mainPanel.add(responsableID, "wrap");
		mainPanel.add(new JLabel("Nome Responsavel"));
		mainPanel.add(responsableName, "wrap");
		mainPanel.add(new JLabel("Email Responsavel"));
		mainPanel.add(responsableEmail, "wrap");

		MainGUI.addSeparator(mainPanel, "Participantes");
		mainPanel.add(createParticipantsJList(), "spanx, wrap");

		MainGUI.addSeparator(mainPanel, "Historico de Atividades");
		mainPanel.add(createActivitieHistoricalJList(), "spanx, wrap");

		mainPanel.add(new JSeparator(), "spanx, gapleft rel, growx,wrap");

		JButton cancelButton = new JButton(new CancelAction(this));
		mainPanel.add(cancelButton, "spanx, align center");
		setContentPane(mainPanel);
	}

	private Component createParticipantsJList() {

		participantsNames = new String[resourceConsultDialog.getResource()
				.getActivitie().getParcipantsList().size()];

		for (int i = 0; i < participantsNames.length; i++) {
			participantsNames[i] = resourceConsultDialog.getResource()
					.getActivitie().getParcipantsList().get(i).getName();
		}

		participantsList = new JList<String>(participantsNames);

		JScrollPane parcipantsL = new JScrollPane(participantsList);
		parcipantsL.setPreferredSize(new Dimension(340, 150));

		return parcipantsL;
	}

	private Component createActivitieHistoricalJList() {

		activitiesHistoricalNames = new String[resourceConsultDialog
				.getResource().getActivitiesHistorical().size()];

		for (int i = 0; i < activitiesHistoricalNames.length; i++) {
			activitiesHistoricalNames[i] = resourceConsultDialog.getResource()
					.getActivitiesHistorical().get(i).getTittle();
			
		}

		activitiesHistorical = new JList<String>(activitiesHistoricalNames);

		JScrollPane activitiesL = new JScrollPane(activitiesHistorical);
		activitiesL.setPreferredSize(new Dimension(340, 150));

		return activitiesL;
	}
}
