package view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import com.toedter.calendar.JDateChooser;
import com.toedter.components.JSpinField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Retard extends JPanel {
	private JTextField textField;

	/**
	 * Create the panel.
	 */
	public Retard() {
		setLayout(null);
		
		JButton btnValider = new JButton("Valider");
		btnValider.setBounds(166, 194, 89, 23);
		add(btnValider);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(168, 36, 87, 20);
		add(dateChooser);
		
		JSpinField heures = new JSpinField();
		heures.setValue(8);
		heures.setMinimum(8);
		heures.setMaximum(18);
		heures.setBounds(168, 92, 47, 20);
		add(heures);
		
		JSpinField minutes = new JSpinField();
		minutes.setMinimum(0);
		minutes.setMaximum(59);
		minutes.setBounds(214, 92, 40, 20);
		add(minutes);
		
		JLabel lblAbsentLe = new JLabel("Arriv\u00E9(e) le :");
		lblAbsentLe.setHorizontalAlignment(SwingConstants.CENTER);
		lblAbsentLe.setBounds(168, 11, 89, 14);
		add(lblAbsentLe);
		
		JLabel label = new JLabel("\u00E0");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(168, 67, 89, 14);
		add(label);
		
		textField = new JTextField();
		textField.setBounds(113, 148, 191, 36);
		add(textField);
		textField.setColumns(10);
		
		JLabel lblMotif = new JLabel("Motif :");
		lblMotif.setHorizontalAlignment(SwingConstants.CENTER);
		lblMotif.setBounds(168, 123, 89, 14);
		add(lblMotif);
	}
}
