package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JLabel;

import object.Retard;
import dataBase.RetardBD;
import view.AtStart;

/**
 * Classe VisualiserRetardControl, cette classe contrôle toutes les actions effectuées sur la vue VisualiserAbsence
 * @author Erwan
 *
 */
public class VisualiserRetardControl implements ActionListener {

	private AtStart vue;
	private RetardBD oRetardBD;

	@Override
	public void actionPerformed(ActionEvent e) {
		//Lorsqu'on clic sur le bouton Trier
		if(e.getSource()==vue.oVisuaRetard.btnTrierR){
			
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
	 * Méthode qui construit le tableau des tickets des retards
	 * @param leControleur {@link MainControl}
	 */
	public void appelTableau(MainControl leControleur){
		//récupération de la liste de tickets
		oRetardBD = new RetardBD();
		List<Retard> lRetard = oRetardBD.recupRetard(leControleur.connect, leControleur.oUser);

		//hauteur du premier ticket
		int hauteur = 67;

		//condition pour savoir si il faut construire pour un admin ou un eleve
		if(!leControleur.oUser.isAdmin()){
			//quelques parametres
			vue.oVisuaRetard.id.setVisible(false);
			vue.oVisuaRetard.login.setVisible(false);
			vue.oVisuaRetard.btnTrierR.setVisible(false);
			vue.oVisuaRetard.dater.setBounds(65, 40, 65, 23);
			vue.oVisuaRetard.duree.setBounds(150, 40, 60, 23);
			vue.oVisuaRetard.motif.setBounds(230, 40, 400, 23);
			vue.oVisuaRetard.nombre.setText("Vous avez " + lRetard.size() + (lRetard.size() <= 1 ? " retard !" : " retards !"));

			//parcours de la liste + construction des JLabel
			for(int i = 0 ; i <lRetard.size();i++){
				JLabel date = new JLabel();
				date.setName("date "+i);
				date.setText(lRetard.get(i).getDater());
				date.setBounds(65, hauteur, 65, 23);
				vue.oVisuaRetard.add(date);
				
				JLabel duree = new JLabel();
				duree.setName("duree "+i);
				duree.setText(lRetard.get(i).getDuree() + " min.");
				duree.setBounds(150, hauteur, 60, 23);
				vue.oVisuaRetard.add(duree);

				JLabel motif = new JLabel();
				motif.setName("motif "+i);
				motif.setText(lRetard.get(i).getMotif());
				motif.setBounds(230, hauteur, 400, 23);
				vue.oVisuaRetard.add(motif);

				//saut de ligne
				hauteur = hauteur+20;
			}
		}
		else{
			//quelques parametres
			vue.oVisuaRetard.id.setBounds(15, 40, 20, 23);
			vue.oVisuaRetard.dater.setBounds(35, 40, 65, 23);
			vue.oVisuaRetard.duree.setBounds(100, 40, 60, 23);
			vue.oVisuaRetard.motif.setBounds(160, 40, 180, 23);
			vue.oVisuaRetard.login.setBounds(340, 40, 200, 23);

			//parcours de la liste + construction des JLabel
			for(int i = 0 ; i < lRetard.size();i++){
				JLabel id = new JLabel();
				id.setName("id "+i);
				id.setText(""+lRetard.get(i).getId());
				id.setBounds(15, hauteur, 89, 23);
				vue.oVisuaRetard.add(id);
				
				JLabel date = new JLabel();
				date.setName("date "+i);
				date.setText(lRetard.get(i).getDater());
				date.setBounds(35, hauteur, 89, 23);
				vue.oVisuaRetard.add(date);
				
				JLabel duree = new JLabel();
				duree.setName("duree "+i);
				duree.setText(lRetard.get(i).getDuree() + " min.");
				duree.setBounds(100, hauteur, 89, 23);
				vue.oVisuaRetard.add(duree);

				JLabel motif = new JLabel();
				motif.setName("motif "+i);
				motif.setText(lRetard.get(i).getMotif());
				motif.setBounds(160, hauteur, 89, 23);
				vue.oVisuaRetard.add(motif);

				JLabel login = new JLabel();
				login.setName("login "+i);
				login.setText(lRetard.get(i).getUtilisateur().getLogin());
				login.setBounds(340, hauteur, 89, 23);
				vue.oVisuaRetard.add(login);

				//saut de ligne
				hauteur = hauteur+20;
			}
			
		}
	}
	
}
