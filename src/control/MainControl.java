package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.Connection;

import javax.swing.JLabel;
import javax.swing.JPanel;

import object.Utilisateur;
import dataBase.AbsenceBD;
import dataBase.ConnexionPostgreSql;
import dataBase.RetardBD;
import dataBase.UtilisateurBD;
import view.AtStart;

public class MainControl implements ActionListener/*, KeyListener*/{

	private AtStart vue;
	
	public Connection connect = ConnexionPostgreSql.getInstance(); //uniquement en local au lycee
	private UtilisateurBD oUserBD;
	public Utilisateur oUser;

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==vue.oConnexionView.btnConnexion){
			oUserBD = new UtilisateurBD();
			if(
				oUserBD.verifUtilisateur(connect, vue.oConnexionView.login.getText(), vue.oConnexionView.password.getText())){  //uniquement en local au lycee
				//vue.oConnexionView.login.getText().equals("admin") && vue.oConnexionView.password.getText().equals("admin")){
				oUser = oUserBD.recupUtilisateur(connect, vue.oConnexionView.login.getText()); //uniquement en local au lycee
				vue.mnAbsence.setEnabled(true);
				vue.mnRetard.setEnabled(true);
				vue.mntmDeconnexion.setEnabled(true);
				vue.lblPseudo.setText(oUser.getPrenom() + " " + oUser.getNom()); //uniquement en local au lycee
				changementPanel(vue.oEmpty);
			}
			else{
				vue.oConnexionView.lblErreur.setVisible(true);
				vue.oConnexionView.password.setText("");
			}
		}
		else if(e.getSource() == vue.retardAjouter){
			vue.oAjoutRetard = vue.oAjoutRetard.clean();
			changementPanel(vue.oAjoutRetard);
		}
		else if(e.getSource()==vue.absenceAjouter){
			vue.oAjoutAbsence = vue.oAjoutAbsence.clean();
			changementPanel(vue.oAjoutAbsence);
		}
		else if(e.getSource()==vue.absenceVisualiser){
			vue.oVisuaAbsence = vue.oVisuaAbsence.clean();
			changementPanel(vue.oVisuaAbsence);
		}
		else if(e.getSource()==vue.retardVisualiser){
			vue.oVisuaRetard = vue.oVisuaRetard.clean();
			changementPanel(vue.oVisuaRetard);
		}
		else if(e.getSource()==vue.mntmAide){
			changementPanel(vue.oHelp);
		}
		else if(e.getSource()==vue.mntmAPropos){
			changementPanel(vue.oInfosAppli);
		}
		else if(e.getSource()==vue.mntmDeconnexion){
			vue.mnAbsence.setEnabled(false);
			vue.mnRetard.setEnabled(false);
			vue.mntmDeconnexion.setEnabled(false);
			vue.oConnexionView = vue.oConnexionView.clean();
			vue.lblPseudo.setText("");
			//oUser = oUser.clean(); //uniquement en local au lycee
			changementPanel(vue.oConnexionView);
		}
	}
	
	public void lienVue(AtStart laVue){
		this.vue=laVue;
	}
	
	public void changementPanel(JPanel nouveauPanel){
		vue.contentPane.remove(vue.contentPane.getComponent(0));
		vue.contentPane.add(nouveauPanel);
		vue.repaint();
		vue.revalidate();
		
	}
	
	
/*
	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getKeyCode()==KeyEvent.VK_ENTER){
		}
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
	}

	@Override
	public void keyTyped(KeyEvent e) {
		if(e.getKeyCode()==KeyEvent.VK_ENTER){
			System.out.print("kjdfbh ");
			if(oUserBD.verifUtilisateur(connect, vue.textField.getText(), vue.textField_1.getText()) vue.oConnexionView.login.getText().equals("admin") && vue.oConnexionView.password.getText().equals("admin")){
				//oUser = oUserBD.recupUtilisateur(connect, vue.lblLogin.getText());
				
				vue.mnAbsence.setEnabled(true);
				vue.mnRetard.setEnabled(true);
				vue.mntmDeconnexion.setEnabled(true);
				vue.contentPane.remove(vue.contentPane.getComponent(0));
				vue.contentPane.add(vue.oEmpty);
				vue.repaint();
			}
			else{
				vue.oConnexionView.password.setText("");
				vue.oConnexionView.login.setText("");
			}
		}
	}*/
}
