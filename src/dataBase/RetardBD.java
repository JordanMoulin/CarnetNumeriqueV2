package dataBase;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import object.Retard;
import object.Utilisateur;

/**
 * Classe RetardBD, contenant toutes les méthodes en interaction avec la BDD pour l'objet Retard.
 * @author Erwan
 *
 */
public class RetardBD {

	/**
	 * Méthode permettant de récupérer tous les tickets de retard d'un utilisateur
	 * Les admin récupèrent les tickets de tous les élèves
	 * @param maConnection Connection
	 * @param utilisateur {@link Utilisateur}
	 * @return List - La liste de retard
	 */
	public List<Retard> recupRetard(Connection maConnection, Utilisateur utilisateur){
		//Déclaration de la liste
		List<Retard> lRetard= new ArrayList<Retard>();
		ResultSet curseurResultat;
		try {
			//Requête SQL pour un élève
			String QUERY_SELECT_ALL_ELEVE = "select id, "
											+ "dater, "
											+ "duree, "
											+ "trim(motif) as motif "
											+ "from ppe4.retard where idutilisateur='" 
											+ utilisateur.getLogin() 
											+ "';";
			
			//Requête SQL pour un admin
			String QUERY_SELECT_ALL_ADMIN = "select id, "
											+ "dater, "
											+ "duree, "
											+ "trim(motif) as motif, "
											+ "trim(idutilisateur) as idutilisateur "
											+ "from ppe4.retard;";
			
			Statement maRequete = maConnection.createStatement();
			
			if(utilisateur.isAdmin()){
				//Execution de la requête pour un admin
				curseurResultat = maRequete.executeQuery(QUERY_SELECT_ALL_ADMIN);

				while(curseurResultat.next()){
					lRetard.add(new Retard(curseurResultat.getInt("id"), 
							curseurResultat.getDate("dater"),
							curseurResultat.getInt("duree"), 
							curseurResultat.getString("motif"), 
							new UtilisateurBD().recupUtilisateur(maConnection, curseurResultat.getString("idutilisateur"))));
				}
			}else{
				//Execution de la requête pour un élève
				curseurResultat = maRequete.executeQuery(QUERY_SELECT_ALL_ELEVE);
				
				while(curseurResultat.next()){
					lRetard.add(new Retard(curseurResultat.getInt("id"), 
							curseurResultat.getDate("dater"),
							curseurResultat.getInt("duree"), 
							curseurResultat.getString("motif"), 
							utilisateur));
				}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lRetard;
	}
	
	/**
	 * Méthode permettant de récupérer tous les tickets de retard d'un utilisateur en fonction du filtre
	 * @param maConnection Connection
	 * @param option String
	 * @return List - La liste de retard
	 */
	public List<Retard> filtreRetard(Connection maConnection, String option){
		//Déclaration de la liste
		List<Retard> lRetard= new ArrayList<Retard>();
		ResultSet curseurResultat;
		try {
			//Requête SQL pour le filtrage
			String QUERY_SELECT_ALL_ADMIN = "select id, "
											+ "dater, "
											+ "duree, "
											+ "trim(motif) as motif, "
											+ "trim(idutilisateur) as idutilisateur "
											+ "from ppe4.retard a "
											+ "inner join ppe4.utilisateur b on a.idutilisateur=b.login "
											+ "where b.nom='"
											+ option.toLowerCase()
											+ "';";
			
			Statement maRequete = maConnection.createStatement();
			
			//Execution de la requête pour un admin
			curseurResultat = maRequete.executeQuery(QUERY_SELECT_ALL_ADMIN);

			while(curseurResultat.next()){
				lRetard.add(new Retard(curseurResultat.getInt("id"), 
					curseurResultat.getDate("dater"),
					curseurResultat.getInt("duree"), 
					curseurResultat.getString("motif"), 
					new UtilisateurBD().recupUtilisateur(maConnection, curseurResultat.getString("idutilisateur"))));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lRetard;
	}
	
	/**
	 * Méthode permettant d'insérer un nouveau ticket de retard dans la BDD
	 * @param maConnection Connection
	 * @param oRetard {@link Retard}
	 * @return boolean - Ce boolean indique si l'insertion s'est bien déroulée
	 */
	public boolean insertRetard(Connection maConnection, Retard oRetard){
		//Requête SQL
		String QUERY_INSERT_NEW = 	"insert into ppe4.retard (dater, duree, motif, idUtilisateur) "
								+ "values ('"
								+ new Date()
								+ "', '" 
								+ oRetard.getDuree() 
								+ "', '" 
								+ oRetard.getMotif() 
								+ "', '" 
								+ oRetard.getUtilisateur().getLogin()
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
