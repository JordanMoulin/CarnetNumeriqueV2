package view.helps;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.JLabel;

import control.HelpControl;

import java.awt.Font;
import javax.swing.JButton;

/**
 * Classe HelpRetard, est une JPanel qui affiche les différentes aides pour cette application.
 * @author Jordan
 *
 */
public class HelpRetard extends JPanel {

	private static final long serialVersionUID = 1L;
	protected HelpControl monControleur;
	public JButton btnRetourR;

	/**
	 * Construction du Panel
	 * @param unControleur {@link HelpControl}
	 */
	public HelpRetard(HelpControl unControleur) {
		this.monControleur=unControleur;
		setLayout(null);
		
		JTextPane txtpnAjouterUnRetard = new JTextPane();
		txtpnAjouterUnRetard.setEditable(false);
		txtpnAjouterUnRetard.setText("Ajouter un retard :\r\n\r\n    - Cliquez sur l'onglet \"Retard\" en \r\n       haut \u00E0 gauche.\r\n    - Puis cliquer sur \"Ajouter\".\r\n    - Rentrez les informations voulu : \r\n        - pour le temps, cliquez sur les \r\n           fl\u00E8ches pour choisir les heures \r\n           et minutes voulus.\r\n    - Cliquez sur Valider");
		txtpnAjouterUnRetard.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtpnAjouterUnRetard.setBounds(10, 11, 223, 208);
		add(txtpnAjouterUnRetard);
		
		JLabel lblNewLabel = new JLabel(new ImageIcon(".\\img\\retard1.png"));
		lblNewLabel.setBounds(243, 24, 195, 89);
		add(lblNewLabel);
		
		btnRetourR = new JButton("Retour");
		btnRetourR.setBounds(341, 196, 89, 23);
		add(btnRetourR);
		btnRetourR.addActionListener(monControleur);

	}
}
