package view;
import control.*;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JLabel;

import view.helps.HelpAbsence;
import view.helps.HelpConnexion;
import view.helps.HelpRetard;
import view.helps.HelpVisualiser;

/**
 * Classe AtStart, est une JFrame qui affiche la fenêtre principale et qui relie tous les JPanel
 * @author Jordan
 *
 */
public class AtStart extends JFrame {

	private static final long serialVersionUID = 1L;
	
	protected MainControl monControleur;
	protected AjouterRetardControl controlAjoutRetard;
	protected AjouterAbsenceControl controlAjoutAbsence;
	protected HelpControl controlHelp;
	
	public VisualiserRetardControl controlVisuaRetard;
	public VisualiserAbsenceControl controlVisuaAbsence;
	public JPanel contentPane;
	public ConnexionView oConnexionView;
	public AjouterRetard oAjoutRetard;
	public Empty oEmpty;
	public AjouterAbsence oAjoutAbsence;
	public VisualiserAbsence oVisuaAbsence;
	public VisualiserRetard oVisuaRetard;
	public Help oHelp;
	public InfosApplication oInfosAppli;
	public HelpConnexion oHelpConnexion;
	public HelpAbsence oHelpAbsence;
	public HelpRetard oHelpRetard;
	public HelpVisualiser oHelpVisualiser;
	
	public JMenu mnRetard;
	public JMenu mnAbsence;
	public JMenu mnAide;
	
	public JLabel lblPseudo;
	
	public JMenuItem retardVisualiser;
	public JMenuItem retardAjouter;
	public JMenuItem absenceVisualiser;
	public JMenuItem absenceAjouter;
	public JMenuItem mntmAPropos;
	public JMenuItem mntmAide;
	public JMenuItem mntmDeconnexion;
	

	/**
	 * Construction de la JFrame
	 * @param unControleur {@link MainControl}
	 * @param unControlAjoutRetard {@link AjouterRetardControl}
	 * @param unControlAjoutAbsence {@link AjouterAbsenceControl}
	 * @param unControlVisuaRetard {@link VisualiserRetardControl}
	 * @param unControlVisuaAbsence {@link VisualiserAbsenceControl}
	 * @param unControlHelp {@link HelpControl}
	 */
	public AtStart(MainControl unControleur, AjouterRetardControl unControlAjoutRetard, AjouterAbsenceControl unControlAjoutAbsence, VisualiserRetardControl unControlVisuaRetard,
			VisualiserAbsenceControl unControlVisuaAbsence, HelpControl unControlHelp) {
		this.setResizable(false);
		this.monControleur=unControleur;
		this.controlAjoutRetard=unControlAjoutRetard;
		this.controlAjoutAbsence=unControlAjoutAbsence;
		this.controlVisuaRetard=unControlVisuaRetard;
		this.controlVisuaAbsence=unControlVisuaAbsence;
		this.controlHelp=unControlHelp;
		oAjoutRetard = new AjouterRetard(controlAjoutRetard);
		oEmpty = new Empty();
		oAjoutAbsence = new AjouterAbsence(controlAjoutAbsence);
		oVisuaAbsence = new VisualiserAbsence(controlVisuaAbsence);
		oVisuaRetard = new VisualiserRetard(controlVisuaRetard);
		oHelp = new Help(controlHelp);
		oInfosAppli = new InfosApplication(controlHelp);
		oHelpConnexion = new HelpConnexion(controlHelp);
		oHelpAbsence = new HelpAbsence(controlHelp);
		oHelpRetard = new HelpRetard(controlHelp);
		oHelpVisualiser = new HelpVisualiser(controlHelp);
		
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
		
		mntmDeconnexion = new JMenuItem("Déconnexion");
		mntmDeconnexion.addActionListener(monControleur);
		mntmDeconnexion.setEnabled(false);
		menuBar.add(mntmDeconnexion);
		
		lblPseudo = new JLabel("");
		menuBar.add(lblPseudo);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		oConnexionView = new ConnexionView(monControleur);
		contentPane.add(oConnexionView,BorderLayout.CENTER);
		
		this.setIconImage(new ImageIcon("img/ic_launcher.png").getImage());
	}
}
