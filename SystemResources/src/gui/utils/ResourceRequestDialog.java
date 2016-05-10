package gui.utils;

import java.awt.Component;

import gui.MainGUI;
import gui.actions.CancelAction;
import gui.actions.InformResponsableAction;
import gui.actions.RequestAction;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;

import activities.Activitie;

import users.User;

import net.miginfocom.swing.MigLayout;

import main.AcademicUnit;

public class ResourceRequestDialog extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private MainGUI mainGUI;
	private AcademicUnit au;

	private JTextField resourceID;
	private JTextField beginDate;
	private JTextField beginMonth;
	private JTextField beginYear;
	private JTextField beginHour;
	private JTextField beginMin;
	private JTextField endDate;
	private JTextField endMonth;
	private JTextField endYear;
	private JTextField endHour;
	private JTextField endMin;
	private JButton responsableButton;
	
	private User responsable;
	private Activitie activite;

	public ResourceRequestDialog(MainGUI mainGUI, AcademicUnit au) {
		super();
		this.mainGUI = mainGUI;
		this.au = au;
		this.responsable = null;
		this.activite = null;

		initComponents();
		setSize(300, 340);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}

	private void initComponents() {
		JPanel mainPanel = new JPanel(new MigLayout("", "grow", ""));

		resourceID = new JTextField();
		resourceID.setColumns(5);

		beginDate = new JTextField();
		beginDate.setColumns(2);

		beginMonth = new JTextField();
		beginMonth.setColumns(2);

		beginYear = new JTextField();
		beginYear.setColumns(2);

		beginHour = new JTextField();
		beginHour.setColumns(2);

		beginMin = new JTextField();
		beginMin.setColumns(2);

		endDate = new JTextField();
		endDate.setColumns(2);

		endMonth = new JTextField();
		endMonth.setColumns(2);

		endYear = new JTextField();
		endYear.setColumns(2);

		endHour = new JTextField();
		endHour.setColumns(2);

		endMin = new JTextField();
		endMin.setColumns(2);


		mainPanel.add(new JLabel("ID do Recurso"), "split 2");
		mainPanel.add(resourceID, "wrap");

		MainGUI.addSeparator(mainPanel, "Data");
		mainPanel.add(createBeginDate(), "wrap");
		mainPanel.add(createEndDate(), "wrap");

		MainGUI.addSeparator(mainPanel, "Hora");
		mainPanel.add(createBeginTime(), "wrap");
		mainPanel.add(createEndTime(), "wrap");

		MainGUI.addSeparator(mainPanel, "Responsável");
		
		responsableButton = new JButton(new InformResponsableAction(this, au));
		mainPanel.add(responsableButton, "spanx, center, wrap");

		mainPanel.add(new JSeparator(), "spanx, gapleft rel, growx,wrap");
		mainPanel.add(createActionsPanel(), "spanx, align center");

		setContentPane(mainPanel);
	}

	public int getResourceID() {
		return Integer.parseInt(resourceID.getText());
	}

	public int getBeginDate() {
		return Integer.parseInt(beginDate.getText());
	}

	public int getBeginMonth() {
		return Integer.parseInt(beginMonth.getText());
	}

	public int getBeginYear() {
		return Integer.parseInt(beginYear.getText());
	}

	public int getBeginHour() {
		return Integer.parseInt(beginHour.getText());
	}

	public int getBeginMin() {
		return Integer.parseInt(beginMin.getText());
	}

	public int getEndDate() {
		return Integer.parseInt(endDate.getText());
	}

	public int getEndMonth() {
		return Integer.parseInt(endMonth.getText());
	}

	public int getEndYear() {
		return Integer.parseInt(endYear.getText());
	}

	public int getEndHour() {
		return Integer.parseInt(endHour.getText());
	}

	public int getEndMin() {
		return Integer.parseInt(endMin.getText());
	}

	private Component createActionsPanel() {
		JPanel panel = new JPanel(new MigLayout());

		JButton cancelAction = new JButton(new CancelAction(this));

		JButton resquestAction = new JButton(new RequestAction(this, au));
		panel.add(cancelAction);
		panel.add(resquestAction);

		return panel;
	}

	private Component createBeginDate() {
		JPanel panel = new JPanel(new MigLayout());

		panel.add(new JLabel("Data Inicio"));
		panel.add(beginDate);
		panel.add(new JLabel("/"));
		panel.add(beginMonth);
		panel.add(new JLabel("/"));
		panel.add(beginYear);

		return panel;
	}

	private Component createEndDate() {
		JPanel panel = new JPanel(new MigLayout());

		panel.add(new JLabel("Data Termino"));
		panel.add(endDate);
		panel.add(new JLabel("/"));
		panel.add(endMonth);
		panel.add(new JLabel("/"));
		panel.add(endYear);

		return panel;
	}

	private Component createBeginTime() {
		JPanel panel = new JPanel(new MigLayout());

		panel.add(new JLabel("Hora Inicio"));
		panel.add(beginHour);
		panel.add(new JLabel("h"));
		panel.add(beginMin);
		panel.add(new JLabel("min"));

		return panel;
	}

	private Component createEndTime() {
		JPanel panel = new JPanel(new MigLayout());

		panel.add(new JLabel("Hora Termino"));
		panel.add(endHour);
		panel.add(new JLabel("h"));
		panel.add(endMin);
		panel.add(new JLabel("min"));

		return panel;
	}
	
	public void setRespInformResponsableEnableAction (User resp) {
		responsable = resp;
	}

	public User getResponsable() {
		return responsable;
	}
	
	public void setActivitieResource(Activitie act) {
		activite = act;
	}
	
	public Activitie getActitvieResource() {
		return activite;
	}
	
}
