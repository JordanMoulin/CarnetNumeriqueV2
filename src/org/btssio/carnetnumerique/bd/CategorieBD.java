package org.btssio.carnetnumerique.bd;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.btssio.carnetnumerique.object.Categorie;

public class CategorieBD {
	
	public Categorie recupCategorie(Connection maConnection, int id){
		Categorie categ = null;
		try {
			String QUERY_SELECT_ALL = "select id, trim(libelle) as libelle from categorie where id=" + id + ";";
			
			Statement maRequete = maConnection.createStatement();
			ResultSet curseurResultat = maRequete.executeQuery(QUERY_SELECT_ALL);
			
			while(curseurResultat.next()){
				categ = new Categorie(curseurResultat.getInt("id"),curseurResultat.getString("libelle"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return categ;
	}
	
}
