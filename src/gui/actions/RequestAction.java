package gui.actions;

import gui.utils.ResourceRequestDialog;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.JOptionPane;

import main.AcademicUnit;

import resources.Resource;

public class RequestAction extends AbstractAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Resource resource;
	ResourceRequestDialog resourceRequestDialog;
	private AcademicUnit au;

	public RequestAction(ResourceRequestDialog resourceRequestDialog,
			AcademicUnit au) {
		super("Solicitar");
		this.au = au;
		this.resourceRequestDialog = resourceRequestDialog;
		this.resource = null;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		resource = au.resourceConsult(resourceRequestDialog.getResourceID());

		try {
			if (!resource.getStatusAllocation().equals(Resource.DISPONIBLE)
					|| (resourceRequestDialog.getResponsable() == null)) {
				throw new Exception();
			}

			au.updateResourse(resourceRequestDialog.getResourceID(),
					resourceRequestDialog.getBeginYear(),
					resourceRequestDialog.getBeginMonth(),
					resourceRequestDialog.getBeginDate(),
					resourceRequestDialog.getBeginHour(),
					resourceRequestDialog.getBeginMin(),
					resourceRequestDialog.getEndYear(),
					resourceRequestDialog.getEndMonth(),
					resourceRequestDialog.getEndDate(),
					resourceRequestDialog.getEndHour(),
					resourceRequestDialog.getEndMin(),
					resourceRequestDialog.getResponsable(),
					resourceRequestDialog.getActitvieResource(),
					Resource.ALLOCATION);
			resourceRequestDialog.dispose();

		} catch (Exception e1) {
			JOptionPane.showMessageDialog(resourceRequestDialog,
					"Alocação não permitida!");
		}

	}
}
