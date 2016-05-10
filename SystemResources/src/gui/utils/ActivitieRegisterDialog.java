package gui.utils;

import gui.MainGUI;
import gui.actions.ActivitieRegisterAction;
import gui.actions.CancelAction;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;

import main.AcademicUnit;
import net.miginfocom.swing.MigLayout;

public class ActivitieRegisterDialog extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static final String ACT_TYPE1 = "Aula Tradicional";
	public static final String ACT_TYPE2 = "Apresentacao";
	public static final String ACT_TYPE3 = "Laboratorio";

	private AcademicUnit au;
	private ResourceRequestDialog resourceRequestDialog;

	private JComboBox activitieType;
	private JTextField activitieTittle;
	private JTextField activitieDescription;
	private JButton addParticipantsButton;
	private JButton addSupportMaterialButton;

	private String[] activitieTypeName;

	public ActivitieRegisterDialog(ResourceRequestDialog resourceRequestDialog,
			AcademicUnit au) {
		super();
		this.resourceRequestDialog = resourceRequestDialog;
		this.au = au;

		initComponents();
		setSize(400, 250);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}

	private void initComponents() {
		JPanel mainPanel = new JPanel(new MigLayout("", "grow", ""));

		activitieTypeName = new String[3];
		activitieTypeName[0] = ACT_TYPE1;
		activitieTypeName[1] = ACT_TYPE2;
		activitieTypeName[2] = ACT_TYPE3;

		activitieType = new JComboBox(activitieTypeName);
		activitieTittle = new JTextField();
		activitieTittle.setColumns(20);
		activitieDescription = new JTextField();
		activitieDescription.setColumns(20);

		// TODO criar action botao abaixo
		addParticipantsButton = new JButton("Adicionar Participantes");
		// TODO criar action botao abaixo
		addSupportMaterialButton = new JButton("Adicionar Material de Apoio");

		mainPanel.add(new JLabel("Tipo da Atividade"));
		mainPanel.add(activitieType, "wrap");
		mainPanel.add(new JLabel("Titulo"));
		mainPanel.add(activitieTittle, "wrap");
		mainPanel.add(new JLabel("Descrição"));
		mainPanel.add(activitieDescription, "wrap");

		MainGUI.addSeparator(mainPanel, "Participantes");
		mainPanel.add(addParticipantsButton, "spanx, wrap");

		MainGUI.addSeparator(mainPanel, "Materias de Apoio");
		mainPanel.add(addSupportMaterialButton, "spanx, wrap");

		mainPanel.add(new JSeparator(), "spanx, gapleft rel, growx,wrap");

		JButton cancelAction = new JButton(new CancelAction(this));
		// TODO criar action botao abaixo
		JButton activitieRegisterButton = new JButton(
				new ActivitieRegisterAction(this, resourceRequestDialog, au));

		mainPanel.add(cancelAction, "grow");
		mainPanel.add(activitieRegisterButton, "grow");

		setContentPane(mainPanel);
	}

	public String getTypeActivitieSelected() {
		String type;
		int index = activitieType.getSelectedIndex();
		type = (String) activitieType.getItemAt(index);

		return type;
	}
	
	public String getActivitieTittle() {
		return activitieTittle.getText();
	}
	
	public String getActivitieDescription() {
		return activitieDescription.getText();
	}

}
