package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.AtStart;

/**
 * Classe VisualiserRetardControl, cette classe contrôle toutes les actions effectuées sur la vue VisualiserAbsence
 * @author Erwan
 *
 */
public class VisualiserRetardControl implements ActionListener {

	private AtStart vue;
	
	@Override
	public void actionPerformed(ActionEvent e) {
		//Lorsqu'on clic sur le bouton Trier
		if(e.getSource()==vue.oVisuaRetard.btnTrierR){
			
		}
	}
	
	/**
	 * Méthode permettant de lier ce controleur à la vue AtStart
	 * @param laVue {@link AtStart}
	 */
	public void lienVue(AtStart laVue){
		this.vue=laVue;
	}
}
