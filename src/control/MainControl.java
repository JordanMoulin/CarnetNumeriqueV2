package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import object.Utilisateur;
import dataBase.AbsenceBD;
import dataBase.ConnexionPostgreSql;
import dataBase.RetardBD;
import dataBase.UtilisateurBD;
import view.AtStart;
import view.RetardView;

public class MainControl implements ActionListener{

	private AtStart vue;
	//private Connection connect = ConnexionPostgreSql.getInstance();
	private UtilisateurBD oUserBD;
	private AbsenceBD oAbsenceBD;
	private RetardBD oRetardBD;
	private Utilisateur oUser;
	
	
	public MainControl(){
		/*ConnexionView connView = new ConnexionView();
		vue.contentPane.add(connView);*/
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==vue.btnConnexion){
			if(/*oUserBD.verifUtilisateur(connect, vue.textField.getText(), vue.textField_1.getText())*/ vue.textField.getText().equals("admin") && vue.textField_1.getText().equals("admin")){
				//oUser = oUserBD.recupUtilisateur(connect, vue.lblLogin.getText());
				
				vue.mnAbsence.setEnabled(true);
				vue.mnRetard.setEnabled(true);
				vue.mntmFermer.setEnabled(true);
				vue.contentPane.remove(vue.panel);
				vue.repaint();
			}
			else{
				vue.textField.setText("");
				vue.textField_1.setText("");
			}
		}
		else if(e.getSource() == vue.retardAjouter){
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
