package gui.actions;

import gui.utils.UserRegisterDialog;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JOptionPane;

import users.DoctorStudent;
import users.GraduateStudent;
import users.MastersStudent;
import users.Researcher;
import users.SystemAdmin;
import users.User;

import main.AcademicUnit;

public class UserRegisterAction extends AbstractAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private AcademicUnit au;
	private UserRegisterDialog userRegisterDialog;
	private User user;

	public UserRegisterAction(UserRegisterDialog userRegisterDialog,
			AcademicUnit au) {
		super("Cadastrar");
		this.userRegisterDialog = userRegisterDialog;
		this.au = au;
		this.user = null;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		try {

			if (userRegisterDialog.getUserName().equals("")
					|| userRegisterDialog.getUserEmail().equals("")) {
				throw new NullPointerException();
			}

			if (userRegisterDialog.getTypeSelected().equals(User.STD_GRAD)) {
				user = new GraduateStudent(userRegisterDialog.getUserID(),
						userRegisterDialog.getUserName(),
						userRegisterDialog.getUserEmail(), User.STD_GRAD);
			} else if (userRegisterDialog.getTypeSelected()
					.equals(User.STD_MES)) {
				user = new MastersStudent(userRegisterDialog.getUserID(),
						userRegisterDialog.getUserName(),
						userRegisterDialog.getUserEmail(), User.STD_MES);

			} else if (userRegisterDialog.getTypeSelected()
					.equals(User.STD_DOC)) {
				user = new DoctorStudent(userRegisterDialog.getUserID(),
						userRegisterDialog.getUserName(),
						userRegisterDialog.getUserEmail(), User.STD_DOC);

			} else if (userRegisterDialog.getTypeSelected()
					.equals(User.USR_ADM)) {
				user = new SystemAdmin(userRegisterDialog.getUserID(),
						userRegisterDialog.getUserName(),
						userRegisterDialog.getUserEmail(), User.USR_ADM);

			} else if (userRegisterDialog.getTypeSelected()
					.equals(User.USR_RES)) {
				user = new Researcher(userRegisterDialog.getUserID(),
						userRegisterDialog.getUserName(),
						userRegisterDialog.getUserEmail(), User.USR_RES);
			}
			au.addUser(user);
			au.report.updateTotalUser();
			userRegisterDialog.dispose();
		} catch (NumberFormatException e1) {
			JOptionPane.showMessageDialog(userRegisterDialog,
					"Digite um Identificador Válido!");
		} catch (NullPointerException e1) {
			JOptionPane.showMessageDialog(userRegisterDialog,
					"Faltou digitar um campo!");
		}
	}

}
