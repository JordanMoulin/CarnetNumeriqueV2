package dataBase;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import object.Utilisateur;

public class UtilisateurBD {

	public Utilisateur recupUtilisateur(Connection maConnection, String login){
		Utilisateur oUser = null;
		try {
			String QUERY_SELECT_ALL = 	"select id, "
										+ "trim(login) as login, "
										+ "trim(nom) as nom, "
										+ "trim(prenom) as prenom, "
										+ "trim(mdp) as mdp, "
										+ "trim(classe) as classe, "
										+ "idCateg "
										+ "from utilisateur where login='" 
										+ login 
										+ "';";
			
			Statement maRequete = maConnection.createStatement();
			ResultSet curseurResultat = maRequete.executeQuery(QUERY_SELECT_ALL);
			
			while(curseurResultat.next()){
				oUser = new Utilisateur(curseurResultat.getInt("id"), 
						curseurResultat.getString("login"), 
						curseurResultat.getString("nom"), 
						curseurResultat.getString("prenom"), 
						curseurResultat.getString("mdp"), 
						curseurResultat.getString("classe"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return oUser;
	}
	
	public Boolean verifUtilisateur(Connection maConnection, String login, String mdp){
		
		String QUERY_SELECT_VERIFY = 	"select * "
										+ "from utilisateur where login='"
										+ login
										+ "' and mdp='"
										+ mdp
										+"';";
		
		Statement maRequete;
		try {
			maRequete = maConnection.createStatement();
			ResultSet curseurResultat = maRequete.executeQuery(QUERY_SELECT_VERIFY);
			
			return curseurResultat.next();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
}
