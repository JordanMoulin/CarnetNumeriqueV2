package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.AtStart;
import view.RetardView;

public class MainControl implements ActionListener{

	private AtStart vue;
	
	public MainControl(){
		/*ConnexionView connView = new ConnexionView();
		vue.contentPane.add(connView);*/
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==vue.btnConnexion){
			vue.mnAbsence.setEnabled(true);
			vue.mnRetard.setEnabled(true);
			vue.contentPane.remove(vue.panel);
			vue.repaint();
		}
		else if(e.getSource()==vue.retardAjouter){
			RetardView test = new RetardView();
			vue.contentPane.add(test);
			vue.repaint();
	        vue.revalidate();
		}
		else if(e.getSource()==vue.mntmFermer){
			
		}
	}
	
	public void lienVue(AtStart laVue){
		this.vue=laVue;
	}

}
