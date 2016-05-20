package dataBase;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import object.Absence;
import object.Utilisateur;

/**
 * Classe AbsenceBD, contenant toutes les méthodes en interaction avec la BDD pour l'objet Absence.
 * @author Erwan
 *
 */
public class AbsenceBD {

	/**
	 * Méthode permettant de récupérer tous les tickets d'absence d'un utilisateur
	 * Les admin récupèrent les tickets de tous les élèves
	 * @param maConnection Connection
	 * @param utilisateur {@link Utilisateur}
	 * @return List - La liste d'absence
	 */
	public List<Absence> recupAbsence(Connection maConnection, Utilisateur utilisateur){
		//Déclaration de la liste
		List<Absence> lAbsence= new ArrayList<Absence>();
		ResultSet curseurResultat;
		try {
			//Requête SQL pour un élève
			String QUERY_SELECT_ALL_ELEVE = "select id, "
											+ "datedebut, "
											+ "dateretour, "
											+ "dateretourheure, "
											+ "dateretourminute, "
											+ "trim(motif) as motif "
											+ "from ppe4.retard where idutilisateur=" 
											+ utilisateur.getLogin() 
											+ ";";
			
			//Requête SQL pour un admin
			String QUERY_SELECT_ALL_ADMIN = "select id, "
											+ "datedebut, "
											+ "dateretour, "
											+ "dateretourheure, "
											+ "dateretourminute, "
											+ "trim(motif) as motif, "
											+ "trim(idutilisateur) as idutilisateur "
											+ "from ppe4.retard;";

			Statement maRequete = maConnection.createStatement();
			
			if(utilisateur.isAdmin()){
				//Execution de la requête pour un admin
				curseurResultat = maRequete.executeQuery(QUERY_SELECT_ALL_ADMIN);
				
				while(curseurResultat.next()){
					lAbsence.add(new Absence(curseurResultat.getInt("id"), 
						curseurResultat.getDate("datedebut"), 
						curseurResultat.getDate("dateretour"), 
						curseurResultat.getInt("dateretourheure"), 
						curseurResultat.getInt("dateretourminute"), 
						curseurResultat.getString("motif"), 
						new UtilisateurBD().recupUtilisateur(maConnection, curseurResultat.getString("idutilisateur"))));
				}
			}else{
				//Execution de la requête pour un élève
				curseurResultat = maRequete.executeQuery(QUERY_SELECT_ALL_ELEVE);
			
				while(curseurResultat.next()){
					lAbsence.add(new Absence(curseurResultat.getInt("id"), 
						curseurResultat.getDate("datedebut"), 
						curseurResultat.getDate("dateretour"), 
						curseurResultat.getInt("dateretourheure"), 
						curseurResultat.getInt("dateretourminute"), 
						curseurResultat.getString("motif"), 
						utilisateur));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lAbsence;
	}
	
	/**
	 * Méthode permettant d'insérer un nouveau ticket d'absence dans la BDD
	 * @param maConnection Connection
	 * @param oAbsence {@link Absence}
	 * @return boolean - Ce boolean indique si l'insertion s'est bien déroulée
	 */
	public boolean insertAbsence(Connection maConnection, Absence oAbsence){
		//Requête SQL
			String QUERY_INSERT_NEW = "insert into ppe4.absence (datedebut, dateretour, dateretourheure, dateretourminute, motif, idUtilisateur) "
									+ "values ('" 
									+ oAbsence.getDateDebut()
									+ "', '" 
									+ oAbsence.getDateRetour()
									+ "', '" 
									+ oAbsence.getDateRetourHeure()
									+ "', '" 
									+ oAbsence.getDateRetourMinute()
									+ "', '" 
									+ oAbsence.getMotif() 
									+ "', '" 
									+ oAbsence.getUtilisateur().getLogin()
									+"');";

		try{
			//Execution de la requête
			Statement maRequete = maConnection.createStatement();
			maRequete.executeUpdate(QUERY_INSERT_NEW);
			//L'insertion s'est bien déroulée
			return true;
		} catch (SQLException e){
			e.printStackTrace();
		}
		//L'insertion s'est mal déroulée
		return false;
	}
}
