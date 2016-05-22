package view.helps;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JTextPane;

import java.awt.Font;

import javax.swing.JLabel;

import control.HelpControl;
import javax.swing.JButton;

/**
 * Classe HelpAbsence, est une JPanel qui affiche les différentes aides pour cette application.
 * @author Jordan
 *
 */
public class HelpAbsence extends JPanel {

	private static final long serialVersionUID = 1L;
	protected HelpControl monControleur;
	public JButton btnRetourA;

	/**
	 * Construction du Panel
	 * @param unControleur {@link HelpControl}
	 */
	public HelpAbsence(HelpControl unControleur) {
		this.monControleur=unControleur;
		setLayout(null);
		
		JTextPane txtpnAjouterUneAbsence = new JTextPane();
		txtpnAjouterUneAbsence.setEditable(false);
		txtpnAjouterUneAbsence.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtpnAjouterUneAbsence.setText("Ajouter une absence :\r\n\r\n    - Cliquez sur l'onglet Absence en \r\n       haut \u00E0 gauche.\r\n    - Puis cliquer sur \"Ajouter\"\r\n    - Rentrez les informations voulu : \r\n        - pour les deux champs de date \r\n           cliquez sur l'ic\u00F4ne de calendrier \r\n           et choisissez une date.\r\n        - pour le temps, cliquez sur les \r\n           fl\u00E8ches pour choisir les heures \r\n           et minutes voulus.\r\n    - Cliquez sur Valider");
		txtpnAjouterUneAbsence.setBounds(10, 11, 223, 208);
		add(txtpnAjouterUneAbsence);
		
		JLabel lblImgAbsence = new JLabel(new ImageIcon(".\\img\\absence1.png"));
		lblImgAbsence.setBounds(245, 21, 195, 96);
		add(lblImgAbsence);
		
		btnRetourA = new JButton("Retour");
		btnRetourA.setBounds(341, 196, 89, 23);
		add(btnRetourA);
		btnRetourA.addActionListener(monControleur);

	}
}
