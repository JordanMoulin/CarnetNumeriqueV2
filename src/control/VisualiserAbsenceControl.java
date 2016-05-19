package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.AtStart;

public class VisualiserAbsenceControl implements ActionListener{

	private AtStart vue;
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==vue.oVisuaAbsence.btnTrierA){
			
		}
	}
	public void lienVue(AtStart laVue){
		this.vue=laVue;
	}
}
