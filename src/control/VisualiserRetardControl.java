package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.AtStart;

public class VisualiserRetardControl implements ActionListener {

	private AtStart vue;
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==vue.oVisuaRetard.btnTrierR){
			
		}
	}
	public void lienVue(AtStart laVue){
		this.vue=laVue;
	}
}
