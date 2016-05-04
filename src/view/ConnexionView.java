package view;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import control.MainControl;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;

public class ConnexionView extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	protected MainControl monControleur;
	public JButton btnConnexion;
	public JTextField password;
	public JTextField login;
	public JLabel lblErreur;

	/**
	 * Create the panel.
	 */
	public ConnexionView(MainControl unControleur) {
		this.monControleur=unControleur;
		setLayout(null);
		
		btnConnexion = new JButton("Connexion");
		btnConnexion.addActionListener(monControleur);
		//btnConnexion.addKeyListener(monControleur);
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
		
		lblErreur = new JLabel("You Fail !");
		lblErreur.setHorizontalAlignment(SwingConstants.CENTER);
		lblErreur.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblErreur.setForeground(Color.RED);
		lblErreur.setBounds(153, 193, 114, 14);
		add(lblErreur);
		lblErreur.setVisible(false);
	}
	
	public ConnexionView clean(){
		return new ConnexionView(monControleur);
	}
}
