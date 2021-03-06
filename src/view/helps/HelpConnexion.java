package view.helps;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JTextPane;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JButton;

import control.HelpControl;

/**
 * Classe HelpConnexion, est une JPanel qui affiche les différentes aides pour cette application.
 * @author Jordan
 *
 */
public class HelpConnexion extends JPanel {

	private static final long serialVersionUID = 1L;
	protected HelpControl monControleur;
	public JButton btnRetourC;

	/**
	 * Construction du Panel
	 * @param unControleur {@link HelpControl}
	 */
	public HelpConnexion(HelpControl unControleur) {
		this.monControleur=unControleur;
		setLayout(null);
		
		JTextPane txtpnCommentSeConnecter = new JTextPane();
		txtpnCommentSeConnecter.setEditable(false);
		txtpnCommentSeConnecter.setText("Comment se connecter :\r\n\r\n     - Vous devez entrer votre login \r\n        qui est composé de la première \r\n        lettre de votre prénom suivi de \r\n        votre nom de famille.\r\n     - Le mot de passe vous a été \r\n        communiqué et il n'est pas \r\n        possible de le changer.\r\n-----------------------------------\r\nComment se déconnecter :\r\n\r\n     - Cliquez sur le bouton déconnexion en haut.\r\n");
		txtpnCommentSeConnecter.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtpnCommentSeConnecter.setBounds(10, 11, 223, 216);
		add(txtpnCommentSeConnecter);
		
		JLabel lblImgLogin = new JLabel(new ImageIcon(".\\img\\connexion.png"));
		lblImgLogin.setBounds(254, 89, 160, 60);
		add(lblImgLogin);
		
		JTextPane txtpnExemple = new JTextPane();
		txtpnExemple.setText("Exemple pour une \r\npersonne d\u00E9nomm\u00E9e \r\nJohn Smith :");
		txtpnExemple.setBounds(262, 11, 152, 49);
		add(txtpnExemple);
		
		btnRetourC = new JButton("Retour");
		btnRetourC.setBounds(341, 196, 89, 23);
		add(btnRetourC);
		btnRetourC.addActionListener(monControleur);
	}
}
