package gui.actions;

import gui.utils.ResourceRequestDialog;
import gui.utils.ResponsableResquestDialog;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import users.User;

import main.AcademicUnit;

public class InformResponsableEnableAction extends AbstractAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ResourceRequestDialog resourceRequestDialog;
	private ResponsableResquestDialog responsableResquestDialog;
	private AcademicUnit au;
	
	public InformResponsableEnableAction (ResponsableResquestDialog responsableResquestDialog, ResourceRequestDialog resourceRequestDialog, AcademicUnit au) {
		super("OK");
		this.resourceRequestDialog = resourceRequestDialog;
		this.responsableResquestDialog = responsableResquestDialog;
		this.au = au;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		resourceRequestDialog.setRespInformResponsableEnableAction(responsableResquestDialog.getResponsable());
		responsableResquestDialog.dispose();
	}

}
