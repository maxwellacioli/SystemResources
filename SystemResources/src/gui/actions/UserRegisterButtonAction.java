package gui.actions;

import gui.MainGUI;
import gui.utils.UserRegisterDialog;

import javax.swing.AbstractAction;

import main.AcademicUnit;

import java.awt.event.ActionEvent;

public class UserRegisterButtonAction extends AbstractAction{
	
	private MainGUI mainGUI;
	private AcademicUnit au;
	
	public UserRegisterButtonAction(MainGUI mainGUI, AcademicUnit au) {
		super("Cadastrar Usuario");
		this.mainGUI = mainGUI;
		this.au = au;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		UserRegisterDialog userRegisterDialog = new UserRegisterDialog(au); 
		userRegisterDialog.setVisible(true);
	}

}
