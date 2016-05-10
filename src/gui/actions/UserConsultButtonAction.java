package gui.actions;

import gui.MainGUI;
import gui.utils.UserConsultDialog;

import javax.swing.AbstractAction;

import main.AcademicUnit;

import java.awt.event.ActionEvent;

public class UserConsultButtonAction extends AbstractAction{
	
	private MainGUI mainGUI;
	private AcademicUnit au;
	
	public UserConsultButtonAction(MainGUI mainGUI, AcademicUnit au) {
		super("Consultar Usuario");
		this.mainGUI = mainGUI;
		this.au = au;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		UserConsultDialog userConsultDialog = new UserConsultDialog(au);
		userConsultDialog.setVisible(true);
	}

}
