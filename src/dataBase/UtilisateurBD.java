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
			
			Statement maRequete = maConnection.createStatement();
			ResultSet curseurResultat = maRequete.executeQuery(QUERY_SELECT_ALL);
			
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
	
	public boolean verifUtilisateur(Connection maConnection, String login, String mdp){
		
		String QUERY_SELECT_VERIFY = 	"select * "
										+ "from ppe4.utilisateur where login='"
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
	
	public boolean isAdmin(Connection maConnection, String login){

		String QUERY_SELECT_ISADMIN = 	"select categ "
										+ "from ppe4.utilisateur where login='"
										+ login
										+"';";
		
		Statement maRequete;
		try {
			maRequete = maConnection.createStatement();
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
	}
	
	private String verifNull(String verif){
		if(verif.equals(null)){
			return " ";
		}
		return verif;
	}
	
}
