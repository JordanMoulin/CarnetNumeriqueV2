package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.util.Locale;

import view.AtStart;

public class AjouterAbsenceControl implements ActionListener{

	private AtStart vue;
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == vue.oAjoutAbsence.btnValiderA){
			DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT, Locale.FRANCE);
			System.out.println(vue.oAjoutAbsence.txtMotifA.getText()+" "+df.format(vue.oAjoutAbsence.dateA.getDate())+" "+df.format(vue.oAjoutAbsence.dateRetourA.getDate())+" "+
					vue.oAjoutAbsence.heuresA.getValue()+" "+vue.oAjoutAbsence.minutesA.getValue());
		}
		else if(e.getSource()==vue.oAjoutAbsence.btnNettoyerA){
			vue.oAjoutAbsence = vue.oAjoutAbsence.clean();
			vue.contentPane.remove(vue.contentPane.getComponent(0));
			vue.contentPane.add(vue.oAjoutAbsence);
			vue.repaint();
			vue.revalidate();
		}
	}
	public void lienVue(AtStart laVue){
		this.vue=laVue;
	}
}
