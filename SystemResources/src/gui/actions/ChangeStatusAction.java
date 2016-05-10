package gui.actions;

import gui.utils.ResourceConsultDialog;
import gui.utils.ResourceDialog;

import java.awt.event.ActionEvent;
import java.io.IOException;

import javax.swing.AbstractAction;

import resources.Resource;
import users.Researcher;

public class ChangeStatusAction extends AbstractAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private ResourceConsultDialog resourceConsultDialog;
	private ResourceDialog resourceDialog;

	public ChangeStatusAction(ResourceDialog resourceDialog, ResourceConsultDialog resourceConsultDialog) {
		this.resourceDialog = resourceDialog;
		this.resourceConsultDialog = resourceConsultDialog;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		try {
			if (resourceConsultDialog.getResource().getStatusAllocation()
					.equals(Resource.ALLOCATION)) {
				resourceConsultDialog.getResource().setStatusAllocation(
						Resource.ALLOCATED);
			} else if (resourceConsultDialog.getResource()
					.getStatusAllocation().equals(Resource.ALLOCATED)) {
				resourceConsultDialog.getResource().setStatusAllocation(
						Resource.PROGRESS);
			} else if (resourceConsultDialog.getResource()
					.getStatusAllocation().equals(Resource.PROGRESS)) {
				resourceConsultDialog.getResource().setStatusAllocation(
						Resource.COMPLETED);
			} else if (resourceConsultDialog.getResource()
					.getStatusAllocation().equals(Resource.COMPLETED)) {
				resourceConsultDialog.getResource().setStatusAllocation(
						Resource.DISPONIBLE);
			}
			resourceDialog.dispose();
		} catch (Exception e1) {

		}
	}
}
