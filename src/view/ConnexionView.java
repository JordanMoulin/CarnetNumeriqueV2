package view;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import control.MainControl;

public class ConnexionView extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	protected MainControl monControleur;
	public JButton btnConnexion;
	public JTextField password;
	public JTextField login;

	/**
	 * Create the panel.
	 */
	public ConnexionView(MainControl unControleur) {
		this.monControleur=unControleur;
		setLayout(null);
		
		btnConnexion = new JButton("Connexion");
		btnConnexion.addActionListener(monControleur);
		btnConnexion.addKeyListener(monControleur);
		btnConnexion.setBounds(153, 159, 114, 23);
		add(btnConnexion);
		
		password = new JPasswordField();
		password.setBounds(143, 117, 136, 31);
		add(password);
		password.setColumns(10);
		
		login = new JTextField();
		login.setColumns(10);
		login.setBounds(143, 53, 136, 31);
		add(login);
		
		JLabel lblLogin = new JLabel("Login :");
		lblLogin.setBounds(192, 34, 46, 14);
		add(lblLogin);
		
		JLabel lblMotDePasse = new JLabel("Mot de passe :");
		lblMotDePasse.setBounds(153, 95, 102, 14);
		add(lblMotDePasse);
	}
	
	public ConnexionView clean(){
		return new ConnexionView(monControleur);
	}
}
