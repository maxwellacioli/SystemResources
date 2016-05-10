package gui.actions;

import gui.MainGUI;
import gui.utils.ReportDialog;

import javax.swing.AbstractAction;

import main.AcademicUnit;

import java.awt.event.ActionEvent;

public class reportButtonAction extends AbstractAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private MainGUI mainGUI;
	private AcademicUnit au;
	
	public reportButtonAction(MainGUI mainGUI, AcademicUnit au) {
		super("Gerar Relatorio");
		this.mainGUI = mainGUI;
		this.au = au;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		ReportDialog reportDialog = new ReportDialog(au);
		reportDialog.setVisible(true);
		mainGUI.dispose();
	}

}
