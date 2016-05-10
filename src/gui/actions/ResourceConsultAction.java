package gui.actions;

import gui.utils.ResourceConsultDialog;
import gui.utils.ResourceDialog;
import gui.utils.ResourceRegisterDialog;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.JOptionPane;

import resources.Resource;

import main.AcademicUnit;

public class ResourceConsultAction extends AbstractAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private AcademicUnit au;
	private ResourceConsultDialog resourceConsultDialog;
	Resource rs;

	public ResourceConsultAction(ResourceConsultDialog resourceConsultDialog,
			AcademicUnit au) {
		super("Consultar");
		this.au = au;
		this.resourceConsultDialog = resourceConsultDialog;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		rs = au.resourceConsult(resourceConsultDialog.getResourceID());
		resourceConsultDialog.setResource(rs);
		try {
			if (rs != null) {
				ResourceDialog resourceDialog = new ResourceDialog(
						resourceConsultDialog, au);
				resourceDialog.setVisible(true);
			} else {
				throw new NullPointerException();
			}
		} catch (NullPointerException e1) {
			JOptionPane.showMessageDialog(resourceConsultDialog,
					"Recurso não encontrado!");
		}
	}

}