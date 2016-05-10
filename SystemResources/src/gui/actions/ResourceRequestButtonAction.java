package gui.actions;

import gui.MainGUI;
import gui.utils.ResourceRequestDialog;

import javax.swing.AbstractAction;

import main.AcademicUnit;

import java.awt.event.ActionEvent;

public class ResourceRequestButtonAction extends AbstractAction{
	
	private MainGUI mainGUI;
	private AcademicUnit au;
	
	public ResourceRequestButtonAction(MainGUI mainGUI, AcademicUnit au) {
		super("Solicitar Recurso");
		this.mainGUI = mainGUI;
		this.au = au;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		ResourceRequestDialog resourceRequestDialog = new ResourceRequestDialog(mainGUI, au);
		resourceRequestDialog.setVisible(true);
	}
}
