package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.Connection;

import javax.swing.JLabel;

import object.Utilisateur;
import dataBase.AbsenceBD;
import dataBase.ConnexionPostgreSql;
import dataBase.RetardBD;
import dataBase.UtilisateurBD;
import view.AtStart;
import view.ConnexionView;
import view.AjouterRetard;

public class MainControl implements ActionListener, KeyListener{

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
		if(e.getSource()==vue.oConnexionView.btnConnexion){
			oUserBD = new UtilisateurBD();
			if(
				//oUserBD.verifUtilisateur(connect, vue.oConnexionView.login.getText(), vue.oConnexionView.password.getText())){ 
				vue.oConnexionView.login.getText().equals("admin") && vue.oConnexionView.password.getText().equals("admin")){
				//oUser = oUserBD.recupUtilisateur(connect, vue.oConnexionView.login.getText());
				vue.mnAbsence.setEnabled(true);
				vue.mnRetard.setEnabled(true);
				vue.mntmDeconnexion.setEnabled(true);
				vue.lblPseudo.setText(vue.oConnexionView.login.getText());
				vue.contentPane.remove(vue.contentPane.getComponent(0));
				vue.contentPane.add(vue.oEmpty);
				vue.repaint();
			}
			else{
				vue.oConnexionView.password.setText("");
				vue.oConnexionView.login.setText("");
			}
		}
		else if(e.getSource() == vue.retardAjouter){
			vue.contentPane.remove(vue.contentPane.getComponent(0));
			vue.contentPane.add(vue.oRetardView);
			vue.repaint();
	        vue.revalidate();
		}
		else if(e.getSource()==vue.mntmDeconnexion){
			vue.mnAbsence.setEnabled(false);
			vue.mnRetard.setEnabled(false);
			vue.mntmDeconnexion.setEnabled(false);
			vue.oConnexionView = vue.oConnexionView.clean();
			vue.lblPseudo.setText("");
			vue.contentPane.remove(vue.contentPane.getComponent(0));
			vue.contentPane.add(vue.oConnexionView);
			vue.repaint();
	        vue.revalidate();
		}
		else if(e.getSource()==vue.absenceAjouter){
			vue.contentPane.remove(vue.contentPane.getComponent(0));
			vue.oAbsenceView = vue.oAbsenceView.clean();
			vue.contentPane.add(vue.oAbsenceView);
			vue.repaint();
	        vue.revalidate();
		}
	}
	
	public void lienVue(AtStart laVue){
		this.vue=laVue;
	}

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
			if(/*oUserBD.verifUtilisateur(connect, vue.textField.getText(), vue.textField_1.getText())*/ vue.oConnexionView.login.getText().equals("admin") && vue.oConnexionView.password.getText().equals("admin")){
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
		
	}

}