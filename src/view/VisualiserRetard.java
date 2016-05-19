package view;

import javax.swing.JPanel;
import javax.swing.JTable;

import control.VisualiserRetardControl;
import javax.swing.JButton;

public class VisualiserRetard extends JPanel {

	/**
	 * 
	 */
	protected VisualiserRetardControl monControleur;
	private static final long serialVersionUID = 1L;
	public JTable tableR;
	public JButton btnTrierR;

	/**
	 * Create the panel.
	 */
	public VisualiserRetard(VisualiserRetardControl unControleur) {
		setLayout(null);
		this.monControleur=unControleur;
		tableR = new JTable();
		tableR.setBounds(85, 64, 182, 100);
		add(tableR);
		
		btnTrierR = new JButton("Trier");
		btnTrierR.setBounds(10, 11, 89, 23);
		add(btnTrierR);
		btnTrierR.addActionListener(monControleur);
	}
	
	public VisualiserRetard clean(){
		return new VisualiserRetard(monControleur);
	}
}
