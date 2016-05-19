package view;

import javax.swing.JPanel;
import javax.swing.JTable;

import control.VisualiserAbsenceControl;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VisualiserAbsence extends JPanel {

	/**
	 * 
	 */
	protected VisualiserAbsenceControl monControleur;
	private static final long serialVersionUID = 1L;
	public JTable tableA;
	public JButton btnTrierA;

	/**
	 * Create the panel.
	 */
	public VisualiserAbsence(VisualiserAbsenceControl unControleur) {
		this.monControleur=unControleur;
		setLayout(null);
		tableA = new JTable();
		tableA.setBounds(249, 95, -119, -78);
		add(tableA);
		
		btnTrierA = new JButton("Trier");
		btnTrierA.setBounds(10, 5, 89, 23);
		add(btnTrierA);
		btnTrierA.addActionListener(monControleur);
	}
	
	public VisualiserAbsence clean(){
		return new VisualiserAbsence(monControleur);
	}
}
