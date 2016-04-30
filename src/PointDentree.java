import view.AtStart;
import control.MainControl;


public class PointDentree {

	public static void main(String[] args) {
		MainControl leControleur = new MainControl();
		AtStart interfaceGraph = new AtStart(leControleur);
		
		leControleur.lienVue(interfaceGraph);
		
		interfaceGraph.setVisible(true);
	}

}
