package gui.actions;

import gui.utils.ResourceRequestDialog;
import gui.utils.ResponsableResquestDialog;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import main.AcademicUnit;

public class InformResponsableAction extends AbstractAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private AcademicUnit au;
	private ResourceRequestDialog resourceRequestDialog;

	public InformResponsableAction(ResourceRequestDialog resourceRequestDialog,
			AcademicUnit au) {
		super("Adicionar Responsável");
		this.resourceRequestDialog = resourceRequestDialog;
		this.au = au;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		ResponsableResquestDialog responsableResquestDialog = new ResponsableResquestDialog(
				resourceRequestDialog, au);
		responsableResquestDialog.setVisible(true);
	}

}
