package gui.actions;

import gui.utils.ActivitieRegisterDialog;
import gui.utils.ResourceRequestDialog;

import javax.swing.AbstractAction;

import activities.Activitie;
import activities.LaboratoryClass;
import activities.Presentation;
import activities.TradictionalClass;

import users.Researcher;

import main.AcademicUnit;

import java.awt.event.ActionEvent;

public class ActivitieRegisterAction extends AbstractAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private AcademicUnit au;
	private ResourceRequestDialog resourceRequestDialog;
	private ActivitieRegisterDialog activitieRegisterDialog;

	private Activitie activitie;

	public ActivitieRegisterAction(
			ActivitieRegisterDialog activitieRegisterDialog,
			ResourceRequestDialog resourceRequestDialog, AcademicUnit au) {
		super("Registrar Atividade");
		this.resourceRequestDialog = resourceRequestDialog;
		this.au = au;
		this.activitieRegisterDialog = activitieRegisterDialog;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (activitieRegisterDialog.getTypeActivitieSelected().equals(
				"Aula Tradicional")) {
			activitie = new TradictionalClass(
					activitieRegisterDialog.getActivitieTittle(),
					activitieRegisterDialog.getActivitieDescription());
		} else if (activitieRegisterDialog.getTypeActivitieSelected().equals(
				"Apresentação")) {
			activitie = new Presentation(activitieRegisterDialog.getActivitieTittle(),
					activitieRegisterDialog.getActivitieDescription());
		} else if (activitieRegisterDialog.getTypeActivitieSelected().equals(
				"Laboratório")) {
			activitie = new LaboratoryClass(activitieRegisterDialog.getActivitieTittle(),
					activitieRegisterDialog.getActivitieDescription());
		}

		resourceRequestDialog.setActivitieResource(activitie);
		activitieRegisterDialog.dispose();
	}

}
