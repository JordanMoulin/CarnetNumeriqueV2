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
		txtpnFdfdf.setText("Cette application a été réalisée par Erwan Agnelet & Jordan Moulin en deuxième année de BTS SIO au lycée André Malraux à Allonnes 72700.\r\n");
		txtpnFdfdf.setBounds(10, 114, 430, 43);
		txtpnFdfdf.setEditable(false);
		add(txtpnFdfdf);
		
		btnRetourI = new JButton("Retour");
		btnRetourI.setBounds(341, 196, 89, 23);
		add(btnRetourI);
		btnRetourI.addActionListener(monControleur);
	}

}
