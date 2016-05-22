package view;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextPane;

import control.HelpControl;

import java.awt.Font;

/**
 * Classe InfosApplication, est une JPanel qui affiche les éléments à propos de cette application et des developpeurs
 * @author Jordan
 *
 */
public class InfosApplication extends JPanel {

	private static final long serialVersionUID = 1L;
	protected HelpControl monControleur;
	
	public JButton btnRetourI;

	/**
	 * Construction du Panel
	 * @param unControleur - {@link HelpControl}
	 */
	public InfosApplication(HelpControl unControleur) {
		this.monControleur=unControleur;
		setLayout(null);
		
		JTextPane txtpnFdfdf = new JTextPane();
		txtpnFdfdf.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		txtpnFdfdf.setText("    Dans le cadre PPE4, cette application a été réalisée par Erwan Agnelet & Jordan Moulin en deuxième année de BTS SIO au lycée André Malraux à Allonnes 72700.\r\n\r\n"
				+ "    Dépot Github : github.com/JordanMoulin/CarnetNumeriqueV2\r\n\r\n"
				+ "    Adresse de contact : erwan.agnelet@bts-malraux.net\r\n"
				+ "                                  jordan.moulin@bts-malraux.net");
		txtpnFdfdf.setBounds(10, 14, 410, 173);
		txtpnFdfdf.setEditable(false);
		add(txtpnFdfdf);
		
		btnRetourI = new JButton("Retour");
		btnRetourI.setBounds(341, 196, 89, 23);
		add(btnRetourI);
		btnRetourI.addActionListener(monControleur);
	}

}
