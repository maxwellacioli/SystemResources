package gui.actions;

import gui.utils.ResourceRegisterDialog;

import javax.swing.AbstractAction;
import javax.swing.JOptionPane;

import resources.Auditorium;
import resources.ClassRoom;
import resources.Laboratory;
import resources.Projector;
import resources.Resource;
import main.AcademicUnit;
import java.awt.event.ActionEvent;

public class ResourceRegisterAction extends AbstractAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private AcademicUnit au;
	private ResourceRegisterDialog resourceRegisterDialog;

	public ResourceRegisterAction(
			ResourceRegisterDialog resourceRegisterDialog, AcademicUnit au) {
		super("Cadastrar");
		this.au = au;
		this.resourceRegisterDialog = resourceRegisterDialog;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		try {
			Resource rsc = null;

			if (resourceRegisterDialog.getTypeSelected().equals("Sala de Aula")) {
				rsc = new ClassRoom(resourceRegisterDialog.getIDType());
			} else if (resourceRegisterDialog.getTypeSelected().equals(
					"Auditório")) {
				rsc = new Auditorium(resourceRegisterDialog.getIDType());
			} else if (resourceRegisterDialog.getTypeSelected().equals(
					"Projetor")) {
				rsc = new Laboratory(resourceRegisterDialog.getIDType());
			} else if (resourceRegisterDialog.getTypeSelected().equals(
					"Laboratório")) {
				rsc = new Projector(resourceRegisterDialog.getIDType());
			}
			au.addResource(rsc);
			resourceRegisterDialog.dispose();
		} catch (NumberFormatException e1) {
			JOptionPane.showMessageDialog(resourceRegisterDialog,
					"Digite um Identificador!");
		}
	}
}
