package dataBase;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import object.Utilisateur;

/**
 * Classe UtilisateurBD, contenant toutes les méthodes en interaction avec la BDD pour l'objet Utilisateur.
 * @author Erwan
 *
 */
public class UtilisateurBD {

	/**
	 * Méthode permettant de récupérer un utilisateur en BDD avec son login
	 * @param maConnection Connection
	 * @param login String
	 * @return {@link Utilisateur} - Un utilisateur récupéré de la BDD
	 */
	public Utilisateur recupUtilisateur(Connection maConnection, String login){
		//Déclaration d'un objet utilisateur
		Utilisateur oUser = null;
		//Requête SQL
		String QUERY_SELECT_ALL = 	"select "
									+ "trim(login) as login, "
									+ "trim(nom) as nom, "
									+ "trim(prenom) as prenom, "
									+ "trim(mdp) as mdp, "
									+ "trim(classe) as classe, "
									+ "categ "
									+ "from ppe4.utilisateur where login='" 
									+ login 
									+ "';";

		try {
			//Execution de la requête
			Statement maRequete = maConnection.createStatement();
			ResultSet curseurResultat = maRequete.executeQuery(QUERY_SELECT_ALL);
			
			//Insertion des éléments provenant du résultat de la requête dans un objet utilisateur
			while(curseurResultat.next()){
				oUser = new Utilisateur(curseurResultat.getString("login"), 
					verifNull(curseurResultat.getString("nom")), 
					verifNull(curseurResultat.getString("prenom")), 
					curseurResultat.getString("mdp"), 
					verifNull(curseurResultat.getString("classe")),
					curseurResultat.getInt("categ"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return oUser;
	}
	
	/**
	 * Méthode permettant de vérifier si un utilisateur existe ou non dans la BDD avec son login et mdp.
	 * @param maConnection Connection
	 * @param login String
	 * @param mdp String
	 * @return boolean - Le résultat de la vérification
	 */
	public boolean verifUtilisateur(Connection maConnection, String login, String mdp){
		//Requête SQL
		String QUERY_SELECT_VERIFY = 	"select * "
										+ "from ppe4.utilisateur where login='"
										+ login
										+ "' and mdp='"
										+ mdp
										+"';";
		
		try {
			//Execution de la requête
			Statement maRequete = maConnection.createStatement();
			ResultSet curseurResultat = maRequete.executeQuery(QUERY_SELECT_VERIFY);
			
			//Si il y a un résultat, cela retourne true, sinon ce sera false
			return curseurResultat.next();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	/*
	public boolean isAdmin(Connection maConnection, String login){
		//Requête SQL
		String QUERY_SELECT_ISADMIN = 	"select categ "
										+ "from ppe4.utilisateur where login='"
										+ login
										+"';";
		
		try {
			//Execution de la requête
			Statement maRequete = maConnection.createStatement();
			ResultSet curseurResultat = maRequete.executeQuery(QUERY_SELECT_ISADMIN);
			
			while(curseurResultat.next()){
				if(curseurResultat.getInt("categ") == 1){
					return true;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}*/
	
	/**
	 * Méthode permettant de vérifier si une chaine est null et retourner une chaine vide si c'est le cas.
	 * @param verif String
	 * @return String - Le résultat de la vérification
	 */
	private String verifNull(String verif){
		if(verif.equals(null)){
			return " ";
		}
		return verif;
	}
	
}
