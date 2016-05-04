package view;

import javax.swing.JPanel;
import javax.swing.JTable;

import control.VisualiserAbsenceControl;

public class VisualiserAbsence extends JPanel {

	/**
	 * 
	 */
	protected VisualiserAbsenceControl monControleur;
	private static final long serialVersionUID = 1L;
	private JTable tableA;

	/**
	 * Create the panel.
	 */
	public VisualiserAbsence(VisualiserAbsenceControl unControleur) {
		this.monControleur=unControleur;
		tableA = new JTable();
		add(tableA);

	}
	
	public VisualiserAbsence clean(){
		return new VisualiserAbsence(monControleur);
	}
}
