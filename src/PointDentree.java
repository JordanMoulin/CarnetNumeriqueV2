import view.AtStart;
import control.AjouterAbsenceControl;
import control.AjouterRetardControl;
import control.MainControl;
import control.VisualiserAbsenceControl;
import control.VisualiserRetardControl;

public class PointDentree {

	public static void main(String[] args) {
		//Déclaration des contrôleurs
		MainControl leControleur = new MainControl();
		AjouterRetardControl leControlAjoutRetard = new AjouterRetardControl();
		AjouterAbsenceControl leControlAjoutAbsence = new AjouterAbsenceControl();
		VisualiserRetardControl leControlVisuaRetard = new VisualiserRetardControl();
		VisualiserAbsenceControl leControlVisuaAbsence = new VisualiserAbsenceControl();
		
		//Déclaration de l'interface graphique
		AtStart interfaceGraph = new AtStart(leControleur,leControlAjoutRetard,leControlAjoutAbsence,leControlVisuaRetard,leControlVisuaAbsence);
		
		//liaison entre Vue et Contrôleur
		leControleur.lienVue(interfaceGraph);
		leControlAjoutRetard.lienVue(interfaceGraph);
		leControlAjoutAbsence.lienVue(interfaceGraph);
		
		//lancement de l'appli
		interfaceGraph.setVisible(true);
	}

}
