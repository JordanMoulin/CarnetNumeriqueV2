package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.util.Locale;

import object.Absence;
import dataBase.AbsenceBD;
import view.AtStart;

public class AjouterAbsenceControl implements ActionListener{

	private MainControl controleurPrin;
	private AtStart vue;
	private Absence oAbsence;
	private AbsenceBD oAbsenceBD;
	
	public AjouterAbsenceControl(MainControl leControleur) {
		this.controleurPrin = leControleur;
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == vue.oAjoutAbsence.btnValiderA){
			oAbsence = new Absence(vue.oAjoutAbsence.dateA.getDate(), vue.oAjoutAbsence.dateRetourA.getDate(), vue.oAjoutAbsence.heuresA.getValue(), vue.oAjoutAbsence.minutesA.getValue(), vue.oAjoutAbsence.txtMotifA.getText(), controleurPrin.oUser);
			//oAbsenceBD.insertAbsence(controleurPrin.connect, oAbsence); //uniquement en local au lycee
			
		}
		else if(e.getSource()==vue.oAjoutAbsence.btnNettoyerA){
			vue.oAjoutAbsence = vue.oAjoutAbsence.clean();
			controleurPrin.changementPanel(vue.oAjoutAbsence);
		}
	}
	public void lienVue(AtStart laVue){
		this.vue=laVue;
	}
}
