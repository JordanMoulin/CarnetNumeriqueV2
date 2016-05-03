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
import view.ConnexionView;
import view.RetardView;

public class MainControl implements ActionListener{

	private AtStart vue;
	
	//private Connection connect = ConnexionPostgreSql.getInstance();
	private UtilisateurBD oUserBD;
	private AbsenceBD oAbsenceBD;
	private RetardBD oRetardBD;
	private Utilisateur oUser;
	
	
	public MainControl(){
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==vue.cp.btnConnexion){
			if(/*oUserBD.verifUtilisateur(connect, vue.textField.getText(), vue.textField_1.getText())*/ vue.cp.textField.getText().equals("admin") && vue.cp.textField_1.getText().equals("admin")){
				//oUser = oUserBD.recupUtilisateur(connect, vue.lblLogin.getText());
				
				vue.mnAbsence.setEnabled(true);
				vue.mnRetard.setEnabled(true);
				vue.mntmFermer.setEnabled(true);
				//System.out.println(.getName());
				vue.contentPane.remove(vue.contentPane.getComponent(0));
				vue.repaint();
			}
			else{
				vue.cp.textField.setText("");
				vue.cp.textField_1.setText("");
			}
		}
		else if(e.getSource() == vue.retardAjouter){
			vue.contentPane.remove(vue.contentPane.getComponent(0));
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
