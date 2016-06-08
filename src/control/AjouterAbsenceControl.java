package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JOptionPane;

import object.Absence;
import dataBase.AbsenceBD;
import view.AtStart;

/**
 * Classe AjouterAbsenceControl, cette classe contrôle toutes les actions effectuées sur la vue AjouterAbsence
 * @author Erwan
 * @author Jordan
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
				JOptionPane.showMessageDialog(vue.oAjoutAbsence, "Votre ticket d'absence est incomplet !");
			}
			//sinon création d'un objet Retard 
			else{
				oAbsence = new Absence(vue.oAjoutAbsence.dateA.getDate(), vue.oAjoutAbsence.dateRetourA.getDate(), vue.oAjoutAbsence.heuresA.getValue(), vue.oAjoutAbsence.minutesA.getValue(), vue.oAjoutAbsence.txtMotifA.getText(), controleurPrin.oUser);
				Date retour = vue.oAjoutAbsence.dateRetourA.getDate();
				Date absence = vue.oAjoutAbsence.dateA.getDate();
				
				//Vérification entre la date d'absence et de retour puis insertion de celui-ci en BDD
				if(retour.after(absence)){
					oAbsenceBD.insertAbsence(controleurPrin.connect, oAbsence);
					JOptionPane.showMessageDialog(vue.oAjoutAbsence, "Votre ticket d'absence a été ajouté !");
					vue.oAjoutAbsence = vue.oAjoutAbsence.clean();
					controleurPrin.changementPanel(vue.oAjoutAbsence);
				}
				else {
					JOptionPane.showMessageDialog(vue.oAjoutAbsence, "Votre ticket d'absence est incorrect !");
				}
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
