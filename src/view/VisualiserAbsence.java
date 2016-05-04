package view;

import javax.swing.JPanel;
import javax.swing.JTable;

public class VisualiserAbsence extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable tableA;

	/**
	 * Create the panel.
	 */
	public VisualiserAbsence() {
		
		tableA = new JTable();
		add(tableA);

	}

}
