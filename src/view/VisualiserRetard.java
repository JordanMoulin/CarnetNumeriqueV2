package view;

import javax.swing.JPanel;
import javax.swing.JTable;

public class VisualiserRetard extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable tableR;

	/**
	 * Create the panel.
	 */
	public VisualiserRetard() {
		setLayout(null);
		
		tableR = new JTable();
		tableR.setBounds(221, 105, 1, 1);
		add(tableR);
	}
	
	public VisualiserRetard clean(){
		return new VisualiserRetard();
	}
}
