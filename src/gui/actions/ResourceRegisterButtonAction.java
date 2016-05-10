package gui.actions;

import gui.MainGUI;
import gui.utils.ResourceRegisterDialog;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.JFrame;

import main.AcademicUnit;

public class ResourceRegisterButtonAction extends AbstractAction {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private AcademicUnit au;
	private MainGUI frame;
	
	public ResourceRegisterButtonAction(MainGUI frame, AcademicUnit au) {
		super("Cadastrar Recurso");
		this.frame = frame;
		this.au = au;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		ResourceRegisterDialog resourceRegisterDialog = new ResourceRegisterDialog(frame, au);
		resourceRegisterDialog.setVisible(true);
	}

	

}
