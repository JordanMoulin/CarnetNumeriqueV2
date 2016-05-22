package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.AtStart;

public class HelpControl implements ActionListener {
	
	private AtStart vue;
	private MainControl controleurPrin;
	
	public HelpControl(MainControl leControleur){
		this.controleurPrin=leControleur;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()== vue.oHelp.btnHelp1){
			controleurPrin.changementPanel(vue.oHelpConnexion);
		}
		else if(e.getSource()== vue.oHelp.btnHelp2){
			controleurPrin.changementPanel(vue.oHelpAbsence);
		}
		else if(e.getSource()== vue.oHelp.btnHelp3){
			controleurPrin.changementPanel(vue.oHelpRetard);
		}
		else if(e.getSource()== vue.oHelp.btnHelp4){
			controleurPrin.changementPanel(vue.oHelpVisualiser);
		}
		else if(e.getSource()==vue.oHelp.btnRetour){
			if(vue.lblPseudo.getText()!=""){
				controleurPrin.changementPanel(vue.oEmpty);
			}
			else{
				controleurPrin.changementPanel(vue.oConnexionView);
			}
		}
		else if(e.getSource()== vue.oHelpConnexion.btnRetourC){
			controleurPrin.changementPanel(vue.oHelp);
		}
		else if(e.getSource()== vue.oHelpAbsence.btnRetourA){
			controleurPrin.changementPanel(vue.oHelp);
		}
		else if(e.getSource()== vue.oHelpRetard.btnRetourR){
			controleurPrin.changementPanel(vue.oHelp);
		}
		else if(e.getSource()== vue.oHelpVisualiser.btnRetourV){
			controleurPrin.changementPanel(vue.oHelp);
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
