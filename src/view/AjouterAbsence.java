package view;

import javax.swing.JPanel;

import com.toedter.calendar.JDateChooser;

import javax.swing.JLabel;

import com.toedter.components.JSpinField;

import control.AjouterAbsenceControl;
import control.MainControl;

import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JTextField;

public class AjouterAbsence extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	protected AjouterAbsenceControl monControleur;
	public JTextField txtMotifA;
	public JDateChooser dateA;
	public JDateChooser dateRetourA;
	public JSpinField heuresA;
	public JSpinField minutesA;
	public JButton btnValiderA;
	public JButton btnNettoyerA;

	/**
	 * Create the panel.
	 */
	public AjouterAbsence(AjouterAbsenceControl unControleur) {
		this.monControleur=unControleur;
		setLayout(null);
		
		dateA = new JDateChooser();
		dateA.setBounds(113, 11, 87, 20);
		add(dateA);
		
		JLabel lblAbsentLe = new JLabel("Absent(e) le :");
		lblAbsentLe.setBounds(23, 11, 87, 14);
		add(lblAbsentLe);
		
		JLabel lblRentre = new JLabel("Rentr\u00E9(e) le :");
		lblRentre.setBounds(25, 56, 96, 14);
		add(lblRentre);
		
		dateRetourA = new JDateChooser();
		dateRetourA.setBounds(113, 56, 87, 20);
		add(dateRetourA);
		
		heuresA = new JSpinField();
		heuresA.setValue(8);
		heuresA.setMinimum(8);
		heuresA.setMaximum(18);
		heuresA.setBounds(113, 97, 47, 20);
		add(heuresA);
		
		minutesA = new JSpinField();
		minutesA.setMinimum(0);
		minutesA.setMaximum(59);
		minutesA.setBounds(159, 97, 40, 20);
		add(minutesA);
		
		JLabel lblHeure = new JLabel("\u00E0");
		lblHeure.setHorizontalAlignment(SwingConstants.CENTER);
		lblHeure.setBounds(10, 97, 89, 14);
		add(lblHeure);
		
		btnValiderA = new JButton("Valider");
		btnValiderA.setBounds(95, 208, 89, 23);
		add(btnValiderA);
		btnValiderA.addActionListener(monControleur);
		
		txtMotifA = new JTextField();
		txtMotifA.setColumns(10);
		txtMotifA.setBounds(105, 128, 191, 36);
		add(txtMotifA);
		
		JLabel lblMotif = new JLabel("Motif :");
		lblMotif.setHorizontalAlignment(SwingConstants.CENTER);
		lblMotif.setBounds(10, 139, 89, 14);
		add(lblMotif);
		
		btnNettoyerA = new JButton("Nettoyer");
		btnNettoyerA.setBounds(95, 179, 89, 23);
		add(btnNettoyerA);
		btnNettoyerA.addActionListener(monControleur);
	}
	
	public AjouterAbsence clean(){
		return new AjouterAbsence(monControleur);
	}
}
