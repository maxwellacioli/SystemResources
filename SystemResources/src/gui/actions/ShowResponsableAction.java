package gui.actions;

import gui.utils.ResourceConsultDialog;
import gui.utils.ResponsableDialog;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

public class ShowResponsableAction extends AbstractAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private ResourceConsultDialog resourceConsultDialog;
	
	public ShowResponsableAction(ResourceConsultDialog resourceConsultDialog) {
		super("Exibir Responsável");
		this.resourceConsultDialog = resourceConsultDialog;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		ResponsableDialog responsableDialog = new ResponsableDialog(resourceConsultDialog);
		responsableDialog.setVisible(true);
	}

}
