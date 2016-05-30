package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.JPanel;

import object.Utilisateur;
import dataBase.ConnexionPostgreSql;
import dataBase.UtilisateurBD;
import view.AtStart;

/**
 * Classe MainControl, cette classe contrôle toutes les actions effectuées sur les vues AtStart, ConnexionView et Empty
 * On contrôle aussi les changements de Panel depuis ce contrôleur
 * @author Erwan
 * @author Jordan
 *
 */
public class MainControl implements ActionListener/*, KeyListener*/{

	private AtStart vue;
	public Connection connect = ConnexionPostgreSql.getInstance();
	private UtilisateurBD oUserBD;
	public Utilisateur oUser;

	@Override
	public void actionPerformed(ActionEvent e) {
		//Lorsqu'on clic sur le bouton de connexion
		if(e.getSource()==vue.oConnexionView.btnConnexion){
			oUserBD = new UtilisateurBD();
			
			//Si la connexion est acceptée (utilisateur dans la BDD avec bon login/mdp
			if(oUserBD.verifUtilisateur(connect, vue.oConnexionView.login.getText(), vue.oConnexionView.password.getText())){ 
				//on récupère toutes ses informations
				oUser = oUserBD.recupUtilisateur(connect, vue.oConnexionView.login.getText()); 
				
				//on active quelques boutons
				vue.mnAbsence.setEnabled(true);
				vue.mnRetard.setEnabled(true);
				vue.mntmDeconnexion.setEnabled(true);
				
				//si c'est un admin, l'interface change légèrement
				if(oUser.isAdmin()){
					vue.retardAjouter.setVisible(false);
					vue.absenceAjouter.setVisible(false);
					vue.absenceVisualiser.setText("Visualiser pour tous les élèves");
					vue.retardVisualiser.setText("Visualiser pour tous les élèves");
				}else{
					vue.retardAjouter.setVisible(true);
					vue.absenceAjouter.setVisible(true);
					vue.absenceVisualiser.setText("Visualiser");
					vue.retardVisualiser.setText("Visualiser");
					
				}
				
				//affichage de son Prenom NOM en haut à droite
				vue.lblPseudo.setText(" " + oUser.getPrenom().replaceFirst(".",(oUser.getPrenom().charAt(0)+"").toUpperCase()) + " " + oUser.getNom().toUpperCase() + " ");
				vue.oEmpty.lblBienvenue.setText("Bienvenue "+vue.lblPseudo.getText()+".");
				
				//on enleve la page de connexion
				changementPanel(vue.oEmpty);
			}
			//sinon on affiche une erreur
			else{
				vue.oConnexionView.lblErreur.setText("Les identifiants ne sont pas corrects !");
				vue.oConnexionView.lblErreur.setVisible(true);
				vue.oConnexionView.password.setText("");
			}
		}
		//Lorsqu'on clic sur le bouton Ajouter du menu Retard
		else if(e.getSource() == vue.retardAjouter){
			vue.oAjoutRetard = vue.oAjoutRetard.clean();
			changementPanel(vue.oAjoutRetard);
		}
		//Lorsqu'on clic sur le bouton Ajouter du menu Absence
		else if(e.getSource()==vue.absenceAjouter){
			vue.oAjoutAbsence = vue.oAjoutAbsence.clean();
			changementPanel(vue.oAjoutAbsence);
		}
		//Lorsqu'on clic sur le bouton Visualiser du menu Absence
		else if(e.getSource()==vue.absenceVisualiser){
			vue.oVisuaAbsence = vue.oVisuaAbsence.clean();
			changementPanel(vue.oVisuaAbsence);
			//construction du tableau des tickets
			vue.controlVisuaAbsence.lienControleur(this);;
			vue.controlVisuaAbsence.appelTableau("");
		}
		//Lorsqu'on clic sur le bouton Visualiser du menu Retard
		else if(e.getSource()==vue.retardVisualiser){
			vue.oVisuaRetard = vue.oVisuaRetard.clean();
			changementPanel(vue.oVisuaRetard);
			//construction du tableau des tickets
			vue.controlVisuaRetard.lienControleur(this);
			vue.controlVisuaRetard.appelTableau("");
		}
		//Lorsqu'on clic sur le bouton Aide du menu ?
		else if(e.getSource()==vue.mntmAide){
			changementPanel(vue.oHelp);
		}
		//Lorsqu'on clic sur le bouton A Propos du menu ?
		else if(e.getSource()==vue.mntmAPropos){
			changementPanel(vue.oInfosAppli);
		}
		//Lorsqu'on clic sur le Déconnexion dans la barre des menus
		else if(e.getSource()==vue.mntmDeconnexion){
			vue.mnAbsence.setEnabled(false);
			vue.mnRetard.setEnabled(false);
			vue.mntmDeconnexion.setEnabled(false);
			//nettoyages...
			vue.oConnexionView = vue.oConnexionView.clean();
			vue.lblPseudo.setText("");
			oUser = oUser.clean();
			changementPanel(vue.oConnexionView);
		}
	}
	
	/**
	 * Méthode permettant de lier ce controleur à la vue AtStart
	 * @param laVue {@link AtStart}
	 */
	public void lienVue(AtStart laVue){
		this.vue=laVue;
	}
	
	/**
	 * Cette méthode permet de changer de Panel, 
	 * quelque soit le panel précedent/suivant
	 * @param nouveauPanel JPanel
	 */
	public void changementPanel(JPanel nouveauPanel){
		//On enleve celui en cours
		vue.contentPane.remove(vue.contentPane.getComponent(0));
		//on ajoute le nouveau
		vue.contentPane.add(nouveauPanel);
		vue.repaint();
		vue.revalidate();
	}
	
	
/*
 *  //La suite est un projet d'écoute de la touche Entrée pour la page de connexion (sans succès)
 * 
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
