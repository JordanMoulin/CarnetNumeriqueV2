package view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;

import com.toedter.components.JSpinField;

import control.AjouterRetardControl;

import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class AjouterRetard extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	protected AjouterRetardControl monControleur;
	public JTextField txtMotifR;
	public JButton btnValiderR;
	public JSpinField minutesR;
	public JButton btnNettoyerR;

	/**
	 * Create the panel.
	 */
	public AjouterRetard(AjouterRetardControl unControleur) {
		this.monControleur=unControleur;
		setLayout(null);
		
		btnValiderR = new JButton("Valider");
		btnValiderR.setBounds(166, 194, 89, 23);
		add(btnValiderR);
		btnValiderR.addActionListener(monControleur);
		
		minutesR = new JSpinField();
		minutesR.setBounds(194, 36, 40, 20);
		minutesR.setMinimum(0);
		minutesR.setMaximum(59);
		add(minutesR);
		
		JLabel lblAbsentLe = new JLabel("Arriv\u00E9(e) avec");
		lblAbsentLe.setBounds(168, 11, 89, 14);
		lblAbsentLe.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblAbsentLe);
		
		JLabel lblHeure = new JLabel("minutes de retard.");
		lblHeure.setBounds(148, 67, 124, 14);
		lblHeure.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblHeure);
		
		txtMotifR = new JTextField();
		txtMotifR.setBounds(114, 121, 191, 36);
		add(txtMotifR);
		txtMotifR.setColumns(10);
		
		JLabel lblMotif = new JLabel("Motif :");
		lblMotif.setBounds(166, 96, 89, 14);
		lblMotif.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblMotif);
		
		btnNettoyerR = new JButton("Nettoyer");
		btnNettoyerR.setBounds(166, 168, 89, 23);
		add(btnNettoyerR);
		btnNettoyerR.addActionListener(monControleur);
	}
	
	public AjouterRetard clean(){
		return new AjouterRetard(monControleur);
	}
}
