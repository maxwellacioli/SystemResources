package gui.utils;

import java.awt.Component;

import gui.MainGUI;
import gui.actions.CancelAction;
import gui.actions.ChangeStatusAction;
import gui.actions.ShowResponsableAction;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;

import resources.Resource;

import net.miginfocom.swing.MigLayout;

import main.AcademicUnit;

public class ResourceDialog extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static final String REQ_ALLO = "Confirmar Solicitacao";
	public static final String CONF_ALLO = "Confirmar Alocacao";
	public static final String COMP_ALLO = "Concluir Alocacao";
	public static final String DISP_ALLO = "Colocar a  Disposicao";
	public static final String CG_ST = "Mudar Status";

	private ResourceConsultDialog resourceConsultDialog;
	private AcademicUnit au;

	private JLabel idLabel;
	private JLabel typeLabel;
	private JLabel statusLabel;
	private JButton changeStatus;
	private JButton showResponsable;

	public ResourceDialog(ResourceConsultDialog resourceConsultDialog,
			AcademicUnit au) {
		this.resourceConsultDialog = resourceConsultDialog;
		this.au = au;

		initComponents();
		setSize(400, 250);
		setLocationRelativeTo(resourceConsultDialog);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}

	private void initComponents() {
		JPanel mainPanel = new JPanel(new MigLayout("", "grow", ""));

		idLabel = new JLabel(Integer.toString(resourceConsultDialog
				.getResourceID()));
		typeLabel = new JLabel(resourceConsultDialog.getResource()
				.getTypeName());
		statusLabel = new JLabel(resourceConsultDialog.getResource()
				.getStatusAllocation());

		showResponsable = new JButton(new ShowResponsableAction(
				resourceConsultDialog));

		MainGUI.addSeparator(mainPanel, "Informacoes do Recurso");
		mainPanel.add(new JLabel("ID do Recurso"));
		mainPanel.add(idLabel, "wrap");
		mainPanel.add(new JLabel("Tipo do Recurso"));
		mainPanel.add(typeLabel, "wrap");
		mainPanel.add(new JLabel("Status do Recurso"));
		mainPanel.add(statusLabel, "wrap");

		MainGUI.addSeparator(mainPanel, "Alterar Status");
		mainPanel.add(createChangeStatusButton(), "wrap");

		MainGUI.addSeparator(mainPanel, "Responsavel");
		mainPanel.add(showResponsable, "wrap");

		verifyStatus();

		JPanel cancelPanel = new JPanel(new MigLayout());
		JButton CancelButton = new JButton(new CancelAction(this));
		cancelPanel.add(CancelButton);

		mainPanel.add(new JSeparator(), "spanx, gapleft rel, growx,wrap");
		mainPanel.add(cancelPanel, "spanx, align center");
		setContentPane(mainPanel);
	}

	private Component createChangeStatusButton() {

		String nameButton = null;

		if (resourceConsultDialog.getResource().getStatusAllocation()
				.equals(Resource.DISPONIBLE)) {
			nameButton = CG_ST;
		} else if (resourceConsultDialog.getResource().getStatusAllocation()
				.equals(Resource.ALLOCATION)) {
			nameButton = REQ_ALLO;
		} else if (resourceConsultDialog.getResource().getStatusAllocation()
				.equals(Resource.ALLOCATED)) {
			nameButton = CONF_ALLO;
		} else if (resourceConsultDialog.getResource().getStatusAllocation()
				.equals(Resource.PROGRESS)) {
			nameButton = COMP_ALLO;
		} else if (resourceConsultDialog.getResource().getStatusAllocation()
				.equals(Resource.COMPLETED)) {
			nameButton = DISP_ALLO;
		}

		changeStatus = new JButton(nameButton);
		changeStatus.addActionListener(new ChangeStatusAction(this,
				resourceConsultDialog));
		return changeStatus;
	}

	public void verifyStatus() {
		if (resourceConsultDialog.getResource().getStatusAllocation()
				.equals(Resource.DISPONIBLE)) {
			changeStatus.setEnabled(false);
			showResponsable.setEnabled(false);
		} else if (resourceConsultDialog.getUserTypde().equals("Usuario")
				&& !resourceConsultDialog.getResource().getStatusAllocation()
						.equals(Resource.ALLOCATED)) {
			changeStatus.setEnabled(false);
		}
	}
}
