package view;

import javax.swing.JPanel;
import javax.swing.JTextPane;
import java.awt.Font;

public class InfosApplication extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public InfosApplication() {
		setLayout(null);
		
		JTextPane txtpnFdfdf = new JTextPane();
		txtpnFdfdf.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		txtpnFdfdf.setText("Cette application a \u00E9tait r\u00E9alis\u00E9 par Erwan Agnelet & Jordan Moulin en deuxi\u00E8me ann\u00E9e de BTS SIO au lyc\u00E9e Andr\u00E9 Malraux \u00E0 Allonnes 72700.\r\n");
		txtpnFdfdf.setBounds(10, 114, 430, 43);
		add(txtpnFdfdf);

	}

}
