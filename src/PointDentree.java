import view.AtStart;
import control.AjouterAbsenceControl;
import control.AjouterRetardControl;
import control.MainControl;
import control.VisualiserAbsenceControl;
import control.VisualiserRetardControl;

/**
 * Classe PointDentree, cette classe permet de lancer les controleurs ainsi que les vues et leurs liaisons
 * @author Erwan
 * @author Jordan
 *
 */
public class PointDentree {

	/**
	 * Méthode main, première méthode appelée lors du lancement de l'application.
	 * @param args String[]
	 */
	public static void main(String[] args) {
		//Déclaration des contrôleurs
		MainControl leControleur = new MainControl();
		AjouterRetardControl leControlAjoutRetard = new AjouterRetardControl(leControleur);
		AjouterAbsenceControl leControlAjoutAbsence = new AjouterAbsenceControl(leControleur);
		VisualiserRetardControl leControlVisuaRetard = new VisualiserRetardControl();
		VisualiserAbsenceControl leControlVisuaAbsence = new VisualiserAbsenceControl();
		
		//Déclaration de l'interface graphique
		AtStart interfaceGraph = new AtStart(leControleur,leControlAjoutRetard,leControlAjoutAbsence,leControlVisuaRetard,leControlVisuaAbsence);
		
		//liaison entre Vue et Contrôleur
		leControleur.lienVue(interfaceGraph);
		leControlAjoutRetard.lienVue(interfaceGraph);
		leControlAjoutAbsence.lienVue(interfaceGraph);
		leControlVisuaRetard.lienVue(interfaceGraph);
		leControlVisuaAbsence.lienVue(interfaceGraph);
		
		//lancement de l'appli
		interfaceGraph.setVisible(true);
	}

}
