package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import object.Absence;
import dataBase.AbsenceBD;
import view.AtStart;

/**
 * Classe AjouterAbsenceControl, cette classe contrôle toutes les actions effectuées sur la vue AjouterAbsence
 * @author Erwan
 *
 */
public class AjouterAbsenceControl implements ActionListener{

	private MainControl controleurPrin;
	private AtStart vue;
	private Absence oAbsence;
	private AbsenceBD oAbsenceBD;

	/**
	 * Constructeur de la classe, permet quelques initialisations
	 * @param leControleur {@link MainControl}
	 */
	public AjouterAbsenceControl(MainControl leControleur) {
		this.controleurPrin = leControleur;
		oAbsenceBD = new AbsenceBD();
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		//Lorsqu'on clic sur le bouton Valider
		if(e.getSource() == vue.oAjoutAbsence.btnValiderA){
			//Si un des champs est vide, Affichage d'une erreur
			if( vue.oAjoutAbsence.dateA.getDate()==null ||
				vue.oAjoutAbsence.dateRetourA.getDate()==null ||
				vue.oAjoutAbsence.txtMotifA.getText().equals(""))
			{
				System.out.print("Votre ticket d'absence est incomplet !");
			}
			//sinon création d'un objet Retard puis insertion de celui-ci en BDD
			else{
				oAbsence = new Absence(vue.oAjoutAbsence.dateA.getDate(), vue.oAjoutAbsence.dateRetourA.getDate(), vue.oAjoutAbsence.heuresA.getValue(), vue.oAjoutAbsence.minutesA.getValue(), vue.oAjoutAbsence.txtMotifA.getText(), controleurPrin.oUser);
				oAbsenceBD.insertAbsence(controleurPrin.connect, oAbsence);
			}
		}
		//Lorsqu'on clic sur le bouton Nettoyer
		else if(e.getSource()==vue.oAjoutAbsence.btnNettoyerA){
			vue.oAjoutAbsence = vue.oAjoutAbsence.clean();
			controleurPrin.changementPanel(vue.oAjoutAbsence);
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
