package view;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.SwingConstants;

import control.HelpControl;

/**
 * Classe Help, est une JPanel qui affiche les différentes aides pour cette application.
 * @author Jordan
 *
 */
public class Help extends JPanel {

	private static final long serialVersionUID = 1L;
	protected HelpControl monControleur;
	public JButton btnHelp1;
	public JButton btnHelp2;
	public JButton btnHelp3;
	public JButton btnHelp4;
	public JButton btnRetour;
	
	/**
	 * Construction du Panel
	 * @param unControleur {@link HelpControl}
	 */
	public Help(HelpControl unControleur) {
		this.monControleur=unControleur;
		setLayout(null);
		
		JLabel lblQuellesAides = new JLabel("Quelle aide avez vous besoin ?");
		lblQuellesAides.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblQuellesAides.setBounds(10, 34, 223, 14);
		add(lblQuellesAides);
		
		btnHelp1 = new JButton("Comment se connecter/déconnecter");
		btnHelp1.setHorizontalAlignment(SwingConstants.LEFT);
		btnHelp1.setBounds(41, 66, 259, 23);
		add(btnHelp1);
		btnHelp1.addActionListener(monControleur);
		
		btnHelp2 = new JButton("Comment ajouter un ticket d'absence");
		btnHelp2.setHorizontalAlignment(SwingConstants.LEFT);
		btnHelp2.setBounds(41, 100, 259, 23);
		add(btnHelp2);
		btnHelp2.addActionListener(monControleur);
		
		btnHelp3 = new JButton("Comment ajouter un ticket de retard");
		btnHelp3.setHorizontalAlignment(SwingConstants.LEFT);
		btnHelp3.setBounds(41, 134, 259, 23);
		add(btnHelp3);
		btnHelp3.addActionListener(monControleur);
		
		btnHelp4 = new JButton("Comment visualiser ses tickets");
		btnHelp4.setHorizontalAlignment(SwingConstants.LEFT);
		btnHelp4.setBounds(41, 168, 259, 23);
		add(btnHelp4);
		btnHelp4.addActionListener(monControleur);
		
		btnRetour = new JButton("Retour");
		btnRetour.setBounds(341, 196, 89, 23);
		add(btnRetour);
		btnRetour.addActionListener(monControleur);
	}
}
