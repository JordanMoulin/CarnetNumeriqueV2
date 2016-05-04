package view;

import javax.swing.JPanel;
import javax.swing.JTable;

import control.VisualiserRetardControl;

public class VisualiserRetard extends JPanel {

	/**
	 * 
	 */
	protected VisualiserRetardControl monControleur;
	private static final long serialVersionUID = 1L;
	private JTable tableR;

	/**
	 * Create the panel.
	 */
	public VisualiserRetard(VisualiserRetardControl unControleur) {
		setLayout(null);
		this.monControleur=unControleur;
		tableR = new JTable();
		tableR.setBounds(221, 105, 1, 1);
		add(tableR);
	}
	
	public VisualiserRetard clean(){
		return new VisualiserRetard(monControleur);
	}
}
