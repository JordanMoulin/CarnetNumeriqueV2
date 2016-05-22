package view;

import javax.swing.JLabel;
import javax.swing.JPanel;

import control.VisualiserAbsenceControl;

import javax.swing.JButton;

/**
 * Classe VisualiserAbsence, est une JPanel qui affiche les éléments lorsqu'on veut visualiser les absences
 * @author Erwan
 * @author Jordan
 *
 */
public class VisualiserAbsence extends JPanel {

	protected VisualiserAbsenceControl monControleur;
	private static final long serialVersionUID = 1L;
	public JLabel id;
	public JLabel datedebut;
	public JLabel dateretour;
	public JLabel motif;
	public JLabel login;
	public JLabel nombre;
	public JButton btnTrierA;

	/**
	 * Construction du Panel
	 * @param unControleur {@link VisualiserAbsenceControl}
	 */
	public VisualiserAbsence(VisualiserAbsenceControl unControleur) {
		setLayout(null);
		this.monControleur=unControleur;
		
		id = new JLabel();
		id.setText("ID");
		add(id);
		
		datedebut = new JLabel();
		datedebut.setText("Depuis le");
		add(datedebut);

		dateretour = new JLabel();
		dateretour.setText("Retour le");
		add(dateretour);
		
		motif = new JLabel();
		motif.setText("Motif");
		add(motif);

		login = new JLabel();
		login.setText("Elève");
		add(login);
		
		nombre = new JLabel();
		nombre.setBounds(150, 10, 150, 23);
		add(nombre);
		
		btnTrierA = new JButton("Filtrer par nom");
		btnTrierA.setBounds(310, 11, 120, 23);
		add(btnTrierA);
		btnTrierA.addActionListener(monControleur);
	}
	
	/**
	 * Méthode qui permet de nettoyer l'objet
	 * @return {@link VisualiserAbsence} - Un nouvel objet VisualiserAbsence
	 */
	public VisualiserAbsence clean(){
		return new VisualiserAbsence(monControleur);
	}
}
