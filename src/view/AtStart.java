package view;
import control.*;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;

public class AtStart extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public JPanel contentPane;
	public JPanel panel;
	
	protected MainControl monControleur;
	
	public JTextField textField_1;
	public JTextField textField;
	
	public JButton btnConnexion;
	
	public JMenu mnRetard;
	public JMenu mnAbsence;
	public JMenu mnAide;
	
	public JMenuItem retardVisualiser;
	public JMenuItem retardAjouter;
	public JMenuItem absenceVisualiser;
	public JMenuItem absenceAjouter;
	public JMenuItem mntmAPropos;
	public JMenuItem mntmAide;
	public JMenuItem mntmFermer;
	
	public JLabel lblLogin;
	public JLabel lblMotDePasse;
	

	/**
	 * Create the frame.
	 */
	public AtStart(MainControl unControleur) {
		this.monControleur=unControleur;
		
		setTitle("Carnet Num\u00E9rique");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnAbsence = new JMenu("Absence");
		mnAbsence.setEnabled(false);
		menuBar.add(mnAbsence);
		
		absenceVisualiser = new JMenuItem("Visualiser");
		retardAjouter.addActionListener(monControleur);
		mnAbsence.add(absenceVisualiser);
		
		absenceAjouter = new JMenuItem("Ajouter");
		retardAjouter.addActionListener(monControleur);
		mnAbsence.add(absenceAjouter);
		
		mnRetard = new JMenu("Retard");
		mnRetard.setEnabled(false);
		menuBar.add(mnRetard);
		
		retardVisualiser = new JMenuItem("Visualiser");
		retardAjouter.addActionListener(monControleur);
		mnRetard.add(retardVisualiser);
		
		retardAjouter = new JMenuItem("Ajouter");
		retardAjouter.addActionListener(monControleur);
		mnRetard.add(retardAjouter);
		
		mnAide = new JMenu("?");
		menuBar.add(mnAide);
		
		mntmAPropos = new JMenuItem("A propos");
		retardAjouter.addActionListener(monControleur);
		mnAide.add(mntmAPropos);
		
		mntmAide = new JMenuItem("Aide");
		retardAjouter.addActionListener(monControleur);
		mnAide.add(mntmAide);
		
		mntmFermer = new JMenuItem("D\u00E9connexion");
		retardAjouter.addActionListener(monControleur);
		mntmFermer.setEnabled(false);
		menuBar.add(mntmFermer);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		btnConnexion = new JButton("Connexion");
		btnConnexion.addActionListener(monControleur);
		btnConnexion.setBounds(153, 159, 114, 23);
		panel.add(btnConnexion);
		
		textField_1 = new JTextField();
		textField_1.setBounds(143, 117, 136, 31);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(143, 53, 136, 31);
		panel.add(textField);
		
		lblLogin = new JLabel("Login :");
		lblLogin.setBounds(192, 34, 46, 14);
		panel.add(lblLogin);
		
		lblMotDePasse = new JLabel("Mot de passe :");
		lblMotDePasse.setBounds(153, 95, 102, 14);
		panel.add(lblMotDePasse);
	}
}
