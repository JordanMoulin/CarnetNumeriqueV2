import view.AtStart;
import view.ConnexionView;
import control.AjouterAbsenceControl;
import control.AjouterRetardControl;
import control.MainControl;
import control.VisualiserAbsenceControl;
import control.VisualiserRetardControl;

public class PointDentree {

	public static void main(String[] args) {
		MainControl leControleur = new MainControl();
		AjouterRetardControl leControlAjoutRetard = new AjouterRetardControl();
		AjouterAbsenceControl leControlAjoutAbsence = new AjouterAbsenceControl();
		VisualiserRetardControl leControlVisuaRetard = new VisualiserRetardControl();
		VisualiserAbsenceControl leControlVisuaAbsence = new VisualiserAbsenceControl();
		AtStart interfaceGraph = new AtStart(leControleur,leControlAjoutRetard,leControlAjoutAbsence,leControlVisuaRetard,leControlVisuaAbsence);
		leControleur.lienVue(interfaceGraph);
		interfaceGraph.setVisible(true);
	}

}
