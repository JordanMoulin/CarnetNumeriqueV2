package view;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.SwingConstants;

import control.HelpControl;

public class Help extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected HelpControl monControleur;

	public JButton btnHelp1;
	public JButton btnHelp2;
	public JButton btnHelp3;
	public JButton btnHelp4;
	/**
	 * Create the panel.
	 */
	public Help(HelpControl unControleur) {
		this.monControleur=unControleur;
		setLayout(null);
		
		JLabel lblQuellesAides = new JLabel("Quelles aides avez vous besoin ?");
		lblQuellesAides.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblQuellesAides.setBounds(10, 34, 223, 14);
		add(lblQuellesAides);
		
		btnHelp1 = new JButton("comment se connecter/d\u00E9connecter");
		btnHelp1.setHorizontalAlignment(SwingConstants.LEFT);
		btnHelp1.setBounds(41, 66, 259, 23);
		add(btnHelp1);
		btnHelp1.addActionListener(monControleur);
		
		btnHelp2 = new JButton("comment ajouter un ticket d'absence");
		btnHelp2.setHorizontalAlignment(SwingConstants.LEFT);
		btnHelp2.setBounds(41, 100, 259, 23);
		add(btnHelp2);
		btnHelp2.addActionListener(monControleur);
		
		btnHelp3 = new JButton("comment ajouter un ticket de retard");
		btnHelp3.setHorizontalAlignment(SwingConstants.LEFT);
		btnHelp3.setBounds(41, 134, 259, 23);
		add(btnHelp3);
		btnHelp3.addActionListener(monControleur);
		
		btnHelp4 = new JButton("comment visualiser ses tickets");
		btnHelp4.setHorizontalAlignment(SwingConstants.LEFT);
		btnHelp4.setBounds(41, 168, 259, 23);
		add(btnHelp4);
		btnHelp4.addActionListener(monControleur);

	}
}
