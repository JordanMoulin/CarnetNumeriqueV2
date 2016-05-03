package view;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import control.MainControl;

public class ConnexionView extends JPanel {
	protected MainControl monControleur;
	public JButton btnConnexion;
	public JTextField textField_1;
	public JTextField textField;
	public JLabel lblLogin;
	public JLabel lblMotDePasse;

	/**
	 * Create the panel.
	 */
	public ConnexionView(MainControl unControleur) {
		this.monControleur=unControleur;
		setLayout(null);
		
		btnConnexion = new JButton("Connexion");
		btnConnexion.addActionListener(monControleur);
		btnConnexion.setBounds(153, 159, 114, 23);
		add(btnConnexion);
		
		textField_1 = new JTextField();
		textField_1.setBounds(143, 117, 136, 31);
		add(textField_1);
		textField_1.setColumns(10);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(143, 53, 136, 31);
		add(textField);
		
		lblLogin = new JLabel("Login :");
		lblLogin.setBounds(192, 34, 46, 14);
		add(lblLogin);
		
		lblMotDePasse = new JLabel("Mot de passe :");
		lblMotDePasse.setBounds(153, 95, 102, 14);
		add(lblMotDePasse);

	}
}
