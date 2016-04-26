package vues;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JTable;
import javax.swing.JProgressBar;
import com.toedter.calendar.JCalendar;
import com.toedter.components.JSpinField;

public class Windows extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Windows frame = new Windows();
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
	public Windows() {
		setTitle("MVC");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnDivision = new JMenu("Absence");
		menuBar.add(mnDivision);
		
		JMenuItem mntmVisualiser = new JMenuItem("Visualiser");
		mnDivision.add(mntmVisualiser);
		
		JMenuItem mntmAjouter = new JMenuItem("Ajouter");
		mnDivision.add(mntmAjouter);
		
		JMenu mnRetard = new JMenu("Retard");
		menuBar.add(mnRetard);
		
		JMenuItem menuItem = new JMenuItem("Visualiser");
		mnRetard.add(menuItem);
		
		JMenuItem menuItem_2 = new JMenuItem("Ajouter");
		mnRetard.add(menuItem_2);
		
		JMenuItem mntmFermer = new JMenuItem("fermer");
		menuBar.add(mntmFermer);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
	}

}
