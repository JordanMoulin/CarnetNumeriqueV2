package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Application extends JFrame {

	private static JPanel contentPane;
	private JTextField textField_1;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Application frame = new Application();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Application() {
		setTitle("Carnet Num\u00E9rique");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnAbsence = new JMenu("Absence");
		mnAbsence.setEnabled(false);
		menuBar.add(mnAbsence);
		
		JMenuItem absenceVisualiser = new JMenuItem("Visualiser");
		mnAbsence.add(absenceVisualiser);
		
		JMenuItem absenceAjouter = new JMenuItem("Ajouter");
		mnAbsence.add(absenceAjouter);
		
		JMenu mnRetard = new JMenu("Retard");
		mnRetard.setEnabled(false);
		menuBar.add(mnRetard);
		
		JMenuItem retardVisualiser = new JMenuItem("Visualiser");
		mnRetard.add(retardVisualiser);
		
		JMenuItem retardAjouter = new JMenuItem("Ajouter");
		mnRetard.add(retardAjouter);
		retardAjouter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Retard test = new Retard();
				contentPane.add(test);
				repaint();
		        revalidate();
			}
		});
		
		JMenu mnAide = new JMenu("?");
		menuBar.add(mnAide);
		
		JMenuItem mntmAPropos = new JMenuItem("A propos");
		mnAide.add(mntmAPropos);
		
		JMenuItem mntmAide = new JMenuItem("Aide");
		mnAide.add(mntmAide);
		
		JMenuItem mntmFermer = new JMenuItem("fermer");
		menuBar.add(mntmFermer);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JButton btnConnexion = new JButton("Connexion");
		btnConnexion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mnAbsence.setEnabled(true);
				mnRetard.setEnabled(true);
				contentPane.remove(panel);
				repaint();
			}
		});
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
		
		JLabel lblLogin = new JLabel("Login :");
		lblLogin.setBounds(192, 34, 46, 14);
		panel.add(lblLogin);
		
		JLabel lblMotDePasse = new JLabel("Mot de passe :");
		lblMotDePasse.setBounds(153, 95, 102, 14);
		panel.add(lblMotDePasse);
	}
}
