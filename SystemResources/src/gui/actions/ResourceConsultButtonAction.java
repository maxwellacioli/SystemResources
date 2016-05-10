package gui.actions;

import gui.MainGUI;
import gui.utils.ResourceConsultDialog;

import javax.swing.AbstractAction;

import main.AcademicUnit;

import java.awt.event.ActionEvent;

public class ResourceConsultButtonAction extends AbstractAction{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private AcademicUnit au;
	private MainGUI frame;
	
	public ResourceConsultButtonAction(MainGUI frame, AcademicUnit au) {
		super( "Consultar Recurso");
		this.frame = frame;
		this.au = au;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		ResourceConsultDialog resourceConsultDialog = new ResourceConsultDialog(frame, au);
		resourceConsultDialog.setVisible(true);
	}
}
