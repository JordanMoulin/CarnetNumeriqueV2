package view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

/**
 * Classe Empty, est une JPanel qui affiche l'écran d'accueil une fois connecté
 * @author Jordan
 *
 */
public class Empty extends JPanel {

	private static final long serialVersionUID = 1L;
	public JLabel lblBienvenue;

	/**
	 * Construction du Panel
	 */
	public Empty() {
		setLayout(null);
		
		lblBienvenue = new JLabel("");
		lblBienvenue.setHorizontalAlignment(SwingConstants.CENTER);
		lblBienvenue.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblBienvenue.setBounds(10, 44, 420, 129);
		add(lblBienvenue);

	}
}
