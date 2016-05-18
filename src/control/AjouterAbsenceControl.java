package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.AtStart;

public class AjouterAbsenceControl implements ActionListener{

	private AtStart vue;
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==vue.oAjoutAbsence.btnNettoyerA){
			vue.oAjoutAbsence.clean();
		}
	}
	

}
