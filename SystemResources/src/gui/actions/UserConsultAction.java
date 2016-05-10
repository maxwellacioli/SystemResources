package gui.actions;

import gui.utils.UserConsultDialog;
import gui.utils.UserDialog;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.JOptionPane;

import users.User;

import main.AcademicUnit;

public class UserConsultAction extends AbstractAction {

	/**
	 * 
	 */

	private UserConsultDialog userConsultDialog;
	private AcademicUnit au;
	private User user;

	private static final long serialVersionUID = 1L;

	public UserConsultAction(UserConsultDialog userConsultDialog,
			AcademicUnit au) {
		super("Consultar");
		this.userConsultDialog = userConsultDialog;
		this.au = au;
		this.user = null;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		userConsultDialog
				.setUser(au.userConsult(userConsultDialog.getUserID()));

		user = userConsultDialog.getUser();

		try {
			UserDialog userDialog = new UserDialog(user);
			userDialog.setVisible(true);
		} catch (NullPointerException e1) {
			JOptionPane.showMessageDialog(userConsultDialog,
					"Usuário não encontrado!");
		}
	}

}
