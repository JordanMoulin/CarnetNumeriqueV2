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
		txtpnCommentSeConnecter.setText("Comment se connecter :\r\n\r\n     - Vous devez rentrer votre login \r\n        qui est compos\u00E9 de la premi\u00E8re \r\n        lettre de votre pr\u00E9nom suivi de \r\n        votre nom de famille.\r\n     - Le mot de passe vous a \u00E9tais \r\n        communiquer et il n'est pas \r\n        possible de le changer.\r\n-----------------------------------\r\nComment se d\u00E9connecter :\r\n\r\n     - Cliquer sur le bouton deconnexion en haut.\r\n");
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
