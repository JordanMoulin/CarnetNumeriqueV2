package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.AjouterRetard;
import view.AtStart;

public class AjouterRetardControl implements ActionListener{

	private AtStart vue;
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == vue.oAjoutRetard.btnValiderR){
			System.out.println("me dit pas que t'es vide");
		}
		
	}
}
