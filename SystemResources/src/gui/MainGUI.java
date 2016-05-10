package gui;

import gui.actions.CancelAction;
import gui.actions.ResourceConsultButtonAction;
import gui.actions.ResourceRegisterButtonAction;
import gui.actions.ResourceRequestButtonAction;
import gui.actions.UserConsultButtonAction;
import gui.actions.UserRegisterAction;
import gui.actions.UserRegisterButtonAction;
import gui.actions.reportButtonAction;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;

import main.AcademicUnit;
import net.miginfocom.swing.MigLayout;

public class MainGUI extends JFrame {

	private static final long serialVersionUID = 1L;

	private JButton resourceRegister;
	private JButton resourceConsult;
	private JButton userRegister;
	private JButton userConsult;
	private JButton resourceRequest;
	private JButton report;

	private AcademicUnit au;

	public MainGUI(AcademicUnit au) {
		super("Unidade Academica");
		this.au = au;

		initComponents();

		setSize(600, 200);
		this.setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}

	private void initComponents() {

		JPanel mainPanel = new JPanel(new MigLayout("", "grow", ""));
		JButton closeButton = new JButton(new CancelAction(this));

		resourceRegister = new JButton(new ResourceRegisterButtonAction(this,
				au));
		resourceConsult = new JButton(new ResourceConsultButtonAction(this, au));
		resourceRequest = new JButton(new ResourceRequestButtonAction(this, au));
		userRegister = new JButton(new UserRegisterButtonAction(this, au));
		userConsult = new JButton(new UserConsultButtonAction(this, au));
		report = new JButton(new reportButtonAction(this, au));

		addSeparator(mainPanel, "Recursos");
		mainPanel.add(resourceRegister);
		mainPanel.add(resourceConsult);
		mainPanel.add(resourceRequest, "wrap");

		addSeparator(mainPanel, "Usuarios");
		mainPanel.add(userRegister);
		mainPanel.add(userConsult, "wrap");
		
		addSeparator(mainPanel, "Relatorio");
		mainPanel.add(report, "spanx, grow");

		mainPanel.add(new JSeparator(), "spanx, gapleft rel, growx,wrap");
		mainPanel.add(closeButton, "spanx, align center");

		this.add(mainPanel);

	}

	public static void addSeparator(JPanel panel, String text) {

		if (!(panel.getLayout() instanceof MigLayout))
			return;

		JLabel l = new JLabel(text);

		panel.add(l, "gapbottom 1, span, split 2, aligny center");
		panel.add(new JSeparator(), "spanx, gapleft rel, growx,wrap");
	}

	public static void main(String[] args) {
		AcademicUnit au = new AcademicUnit();
		new MainGUI(au);
	}
}
