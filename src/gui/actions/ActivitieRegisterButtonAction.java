package gui.actions;

import gui.utils.ActivitieRegisterDialog;
import gui.utils.ResourceRequestDialog;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import main.AcademicUnit;

public class ActivitieRegisterButtonAction extends AbstractAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private AcademicUnit au;
	private ResourceRequestDialog resourceRequestDialog;
	
	public ActivitieRegisterButtonAction(ResourceRequestDialog resourceRequestDialog, AcademicUnit au) {
		super("Adicionar Atividade");
		this.resourceRequestDialog = resourceRequestDialog;
		this.au = au;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		ActivitieRegisterDialog activitieRegisterDialog = new ActivitieRegisterDialog(resourceRequestDialog, au);
		activitieRegisterDialog.setVisible(true);
	}

}
