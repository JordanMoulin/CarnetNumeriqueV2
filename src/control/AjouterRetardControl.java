package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import object.Retard;
import dataBase.RetardBD;
import view.AtStart;

/**
 * Classe AjouterRetardControl, cette classe contrôle toutes les actions effectuées sur la vue AjouterRetard
 * @author Erwan
 * @author Jordan
 *
 */
public class AjouterRetardControl implements ActionListener{

	private MainControl controleurPrin;
	private AtStart vue;
	private Retard oRetard;
	private RetardBD oRetardBD;
	
	/**
	 * Constructeur de la classe, permet quelques initialisations
	 * @param leControleur {@link MainControl}
	 */
	public AjouterRetardControl(MainControl leControleur) {
		this.controleurPrin=leControleur;
		oRetardBD = new RetardBD();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//Lorsqu'on clic sur le bouton Valider
		if(e.getSource() == vue.oAjoutRetard.btnValiderR){
			//Si un des champs est vide, Affichage d'une erreur
			if( vue.oAjoutRetard.minutesR.getValue()==0 ||
				vue.oAjoutRetard.txtMotifR.getText().equals(""))
			{
				JOptionPane.showMessageDialog(vue.oAjoutRetard, "Votre ticket de retard est incomplet !");
			}
			//sinon création d'un objet Retard puis insertion de celui-ci en BDD
			else{
				oRetard = new Retard(vue.oAjoutRetard.minutesR.getValue(), vue.oAjoutRetard.txtMotifR.getText(), controleurPrin.oUser);
				oRetardBD.insertRetard(controleurPrin.connect, oRetard);
				JOptionPane.showMessageDialog(vue.oAjoutRetard, "Votre ticket de retard a été ajouté !");
				vue.oAjoutRetard = vue.oAjoutRetard.clean();
				controleurPrin.changementPanel(vue.oAjoutRetard);
			}
		}
		//Lorsqu'on clic sur le bouton Nettoyer
		else if(e.getSource()==vue.oAjoutRetard.btnNettoyerR){
			vue.oAjoutRetard = vue.oAjoutRetard.clean();
			controleurPrin.changementPanel(vue.oAjoutRetard);
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
