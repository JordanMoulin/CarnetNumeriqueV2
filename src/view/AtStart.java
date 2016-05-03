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
	
	protected MainControl monControleur;
	public ConnexionView cp;
	
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
		absenceVisualiser.addActionListener(monControleur);
		mnAbsence.add(absenceVisualiser);
		
		absenceAjouter = new JMenuItem("Ajouter");
		absenceAjouter.addActionListener(monControleur);
		mnAbsence.add(absenceAjouter);
		
		mnRetard = new JMenu("Retard");
		mnRetard.setEnabled(false);
		menuBar.add(mnRetard);
		
		retardVisualiser = new JMenuItem("Visualiser");
		retardVisualiser.addActionListener(monControleur);
		mnRetard.add(retardVisualiser);
		
		retardAjouter = new JMenuItem("Ajouter");
		retardAjouter.addActionListener(monControleur);
		mnRetard.add(retardAjouter);
		
		mnAide = new JMenu("?");
		menuBar.add(mnAide);
		
		mntmAPropos = new JMenuItem("A propos");
		mntmAPropos.addActionListener(monControleur);
		mnAide.add(mntmAPropos);
		
		mntmAide = new JMenuItem("Aide");
		mntmAide.addActionListener(monControleur);
		mnAide.add(mntmAide);
		
		mntmFermer = new JMenuItem("D\u00E9connexion");
		mntmFermer.addActionListener(monControleur);
		mntmFermer.setEnabled(false);
		menuBar.add(mntmFermer);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		cp = new ConnexionView(monControleur);
		cp.setName("jgv");
		contentPane.add(cp,BorderLayout.CENTER);
	}
}
