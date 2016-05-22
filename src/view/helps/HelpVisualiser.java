package view.helps;

import javax.swing.JPanel;
import javax.swing.JTextPane;

import control.HelpControl;

import java.awt.Font;
import javax.swing.JButton;

public class HelpVisualiser extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected HelpControl monControleur;
	
	public JButton btnRetourV;

	/**
	 * Create the panel.
	 */
	public HelpVisualiser(HelpControl unControleur) {
		this.monControleur=unControleur;
		setLayout(null);
		
		JTextPane txtpnVisualiserUnBillet = new JTextPane();
		txtpnVisualiserUnBillet.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtpnVisualiserUnBillet.setText("Visualiser un billet  :\r\n\r\n    - Choisissez quel type de billet,\r\n       onglet \"Absence\" ou \"Retard\".\r\n    - Puis cliquer sur \"Visualiser\".\r\n    - Vos billets apparaissent. ");
		txtpnVisualiserUnBillet.setEditable(false);
		txtpnVisualiserUnBillet.setBounds(10, 11, 223, 208);
		add(txtpnVisualiserUnBillet);
		
		btnRetourV = new JButton("Retour");
		btnRetourV.setBounds(341, 196, 89, 23);
		add(btnRetourV);
		btnRetourV.addActionListener(monControleur);

	}

}
