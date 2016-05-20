package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import object.Retard;
import dataBase.RetardBD;
import view.AtStart;

public class AjouterRetardControl implements ActionListener{

	private MainControl controleurPrin;
	private AtStart vue;
	private Retard oRetard;
	private RetardBD oRetardBD;
	
	public AjouterRetardControl(MainControl leControleur) {
		this.controleurPrin=leControleur;
		oRetardBD = new RetardBD();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == vue.oAjoutRetard.btnValiderR){
			if( vue.oAjoutRetard.minutesR.getValue()==0 ||
					vue.oAjoutRetard.txtMotifR.getText().equals("")){
				System.out.print("Votre ticket de retard est incomplet !");
			}
			else{
				oRetard = new Retard(vue.oAjoutRetard.minutesR.getValue(), vue.oAjoutRetard.txtMotifR.getText(), controleurPrin.oUser);
				oRetardBD.insertRetard(controleurPrin.connect, oRetard);
			}
		}
		else if(e.getSource()==vue.oAjoutRetard.btnNettoyerR){
			vue.oAjoutRetard = vue.oAjoutRetard.clean();
			controleurPrin.changementPanel(vue.oAjoutRetard);
		}
	}

	public void lienVue(AtStart laVue){
		this.vue=laVue;
	}
}
