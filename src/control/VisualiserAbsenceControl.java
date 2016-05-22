package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JLabel;

import object.Absence;
import dataBase.AbsenceBD;
import view.AtStart;

/**
 * Classe VisualiserAbsenceControl, cette classe contrôle toutes les actions effectuées sur la vue VisualiserAbsence
 * @author Erwan
 *
 */
public class VisualiserAbsenceControl implements ActionListener{

	private AtStart vue;
	private AbsenceBD oAbsenceBD;
	
	@Override
	public void actionPerformed(ActionEvent e) {
		//Lorsqu'on clic sur le bouton Trier
		if(e.getSource()==vue.oVisuaAbsence.btnTrierA){
			
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
	 * Méthode qui construit le tableau des tickets d'absences
	 * @param leControleur {@link MainControl}
	 */
	public void appelTableau(MainControl leControleur){
		//récupération de la liste de tickets
		oAbsenceBD = new AbsenceBD();
		List<Absence> lAbsence = oAbsenceBD.recupAbsence(leControleur.connect, leControleur.oUser);

		//hauteur du premier ticket
		int hauteur = 67;
		
		//condition pour savoir si il faut construire pour un admin ou un eleve
		if(!leControleur.oUser.isAdmin()){
			//quelques parametres
			vue.oVisuaAbsence.id.setVisible(false);
			vue.oVisuaAbsence.login.setVisible(false);
			vue.oVisuaAbsence.btnTrierA.setVisible(false);
			vue.oVisuaAbsence.datedebut.setBounds(35, 40, 65, 23);
			vue.oVisuaAbsence.dateretour.setBounds(100, 40, 200, 23);
			vue.oVisuaAbsence.motif.setBounds(215, 40, 400, 23);
			vue.oVisuaAbsence.nombre.setText("Vous avez " + lAbsence.size() + (lAbsence.size() <= 1 ? " absence !" : " absences !"));
			
			//parcours de la liste + construction des JLabel
			for(int i = 0 ; i <lAbsence.size();i++){
				JLabel datedebut = new JLabel();
				datedebut.setName("datedebut "+i);
				datedebut.setText(lAbsence.get(i).getDateDebut());
				datedebut.setBounds(35, hauteur, 65, 23);
				vue.oVisuaAbsence.add(datedebut);
				
				JLabel dateretour = new JLabel();
				dateretour.setName("dateretour "+i);
				dateretour.setText(lAbsence.get(i).getDateRetour() + " à " + lAbsence.get(i).getDateRetourHeure() + "h" + lAbsence.get(i).getDateRetourMinute());
				dateretour.setBounds(100, hauteur, 200, 23);
				vue.oVisuaAbsence.add(dateretour);

				JLabel motif = new JLabel();
				motif.setName("motif "+i);
				motif.setText(lAbsence.get(i).getMotif());
				motif.setBounds(215, hauteur, 400, 23);
				vue.oVisuaAbsence.add(motif);
				
				//saut de ligne
				hauteur = hauteur+20;
			}
		}
		else{
			//quelques parametres
			vue.oVisuaAbsence.id.setBounds(15, 40, 20, 23);
			vue.oVisuaAbsence.datedebut.setBounds(35, 40, 65, 23);
			vue.oVisuaAbsence.dateretour.setBounds(100, 40, 60, 23);
			vue.oVisuaAbsence.motif.setBounds(160, 40, 180, 23);
			vue.oVisuaAbsence.login.setBounds(340, 40, 200, 23);

			//parcours de la liste + construction des JLabel
			for(int i = 0 ; i < lAbsence.size();i++){
				JLabel id = new JLabel();
				id.setName("id "+i);
				id.setText(""+lAbsence.get(i).getId());
				id.setBounds(15, hauteur, 20, 23);
				vue.oVisuaAbsence.add(id);
				
				JLabel datedebut = new JLabel();
				datedebut.setName("datedebut "+i);
				datedebut.setText(lAbsence.get(i).getDateDebut());
				datedebut.setBounds(35, hauteur, 65, 23);
				vue.oVisuaAbsence.add(datedebut);
				
				JLabel dateretour = new JLabel();
				dateretour.setName("duree "+i);
				dateretour.setText(lAbsence.get(i).getDateRetour());
				dateretour.setBounds(100, hauteur, 200, 23);
				vue.oVisuaAbsence.add(dateretour);

				JLabel motif = new JLabel();
				motif.setName("motif "+i);
				motif.setText(lAbsence.get(i).getMotif());
				motif.setBounds(160, hauteur, 180, 23);
				vue.oVisuaAbsence.add(motif);

				JLabel login = new JLabel();
				login.setName("login "+i);
				login.setText(lAbsence.get(i).getUtilisateur().getLogin());
				login.setBounds(340, hauteur, 400, 23);
				vue.oVisuaAbsence.add(login);

				//saut de ligne
				hauteur = hauteur+20;
			}
			
		}
	}
	
}
