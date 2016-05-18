package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.AtStart;

public class AjouterRetardControl implements ActionListener{

	private AtStart vue;
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == vue.oAjoutRetard.btnValiderR){
			System.out.println(vue.oAjoutRetard.txtMotifR.getText()+" "+vue.oAjoutRetard.minutesR.getValue());
		}
		else if(e.getSource()==vue.oAjoutRetard.btnNettoyerR){
			vue.oAjoutRetard = vue.oAjoutRetard.clean();
			vue.contentPane.remove(vue.contentPane.getComponent(0));
			vue.contentPane.add(vue.oAjoutRetard);
			vue.repaint();
			vue.revalidate();
		}
	}

	public void lienVue(AtStart laVue){
		this.vue=laVue;
	}
}
