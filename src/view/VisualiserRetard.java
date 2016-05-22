package view;

import javax.swing.JLabel;
import javax.swing.JPanel;

import control.VisualiserRetardControl;

import javax.swing.JButton;

/**
 * Classe VisualiserRetard, est une JPanel qui affiche les éléments lorsqu'on veut visualiser les retard
 * @author Erwan
 * @author Jordan
 *
 */
public class VisualiserRetard extends JPanel {

	protected VisualiserRetardControl monControleur;
	private static final long serialVersionUID = 1L;
	public JLabel id;
	public JLabel dater;
	public JLabel duree;
	public JLabel motif;
	public JLabel login;
	public JLabel nombre;
	public JButton btnTrierR;

	/**
	 * Construction du Panel
	 * @param unControleur {@link VisualiserRetardControl}
	 */
	public VisualiserRetard(VisualiserRetardControl unControleur) {
		setLayout(null);
		this.monControleur=unControleur;

		id = new JLabel();
		id.setText("ID");
		add(id);
		
		dater = new JLabel();
		dater.setText("Date");
		add(dater);

		duree = new JLabel();
		duree.setText("Durée");
		add(duree);
		
		motif = new JLabel();
		motif.setText("Motif");
		add(motif);

		login = new JLabel();
		login.setText("Elève");
		add(login);
		
		nombre = new JLabel();
		nombre.setBounds(150, 10, 150, 23);
		add(nombre);
		
		btnTrierR = new JButton("Filtrer par nom");
		btnTrierR.setBounds(310, 11, 120, 23);
		add(btnTrierR);
		btnTrierR.addActionListener(monControleur);
	}

	/**
	 * Méthode qui permet de nettoyer l'objet
	 * @return {@link VisualiserRetard} - Un nouvel objet VisualiserRetard
	 */
	public VisualiserRetard clean(){
		return new VisualiserRetard(monControleur);
	}
}
