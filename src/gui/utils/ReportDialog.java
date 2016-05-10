package gui.utils;

import gui.actions.CancelAction;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import net.miginfocom.swing.MigLayout;

import main.AcademicUnit;
import main.Report;

public class ReportDialog extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private AcademicUnit au;

	private JLabel userTotal;
	private JLabel resourcesProcess;
	private JLabel resourcesAllocated;
	private JLabel resourcesPregress;
	private JLabel resourcesCompleted;
	private JLabel allocationTotal;
	private JLabel traditionalClassTotal;
	private JLabel presentationTotal;
	private JLabel laboratoryTotal;

	public ReportDialog(AcademicUnit au) {
		super();
		this.au = au;

		initComponents();
		setSize(600, 210);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}

	private void initComponents() {
		JPanel mainPanel = new JPanel(new MigLayout("", "grow", ""));

		userTotal = new JLabel();
		resourcesProcess = new JLabel();
		resourcesAllocated = new JLabel();
		resourcesPregress = new JLabel();
		resourcesCompleted = new JLabel();
		allocationTotal = new JLabel();
		traditionalClassTotal = new JLabel();
		presentationTotal = new JLabel();
		laboratoryTotal = new JLabel();

		mainPanel.add(new JLabel("Numero de Usuarios:"));
		mainPanel.add(userTotal, "wrap");
		mainPanel.add(new JLabel("Recursos em processo de alocacao:"));
		mainPanel.add(resourcesProcess, "wrap");
		mainPanel.add(new JLabel("Recursos alocados:"));
		mainPanel.add(resourcesAllocated, "wrap");
		mainPanel.add(new JLabel("Recursos em andamento:"));
		mainPanel.add(resourcesPregress, "wrap");
		mainPanel.add(new JLabel("Recursos concluidos:"));
		mainPanel.add(resourcesCompleted, "wrap");
		mainPanel.add(new JLabel("Numero de aulas tradicionais:"));
		mainPanel.add(allocationTotal, "wrap");
		mainPanel.add(new JLabel("Numero de atividades de lab:"));
		mainPanel.add(presentationTotal, "wrap");
		mainPanel.add(new JLabel("Numero de apresentensacoes:"));
		mainPanel.add(laboratoryTotal, "wrap");

		JButton cancelAction = new JButton(new CancelAction(this));
		mainPanel.add(cancelAction, "spanx, center");
		setContentPane(mainPanel);
	}

	public void fillFields() {

	}

}
