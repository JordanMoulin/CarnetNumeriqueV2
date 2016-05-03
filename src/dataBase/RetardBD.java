package dataBase;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import object.Retard;
import object.Utilisateur;

public class RetardBD {

	public List<Retard> recupRetard(Connection maConnection, Utilisateur utilisateur){
		List<Retard> lRetard= new ArrayList<Retard>();
		try {
			String QUERY_SELECT_ALL = 	"select id, "
										+ "dater, "
										+ "duree, "
										+ "trim(motif) as motif, "
										+ "from ppe4.retard where idUtilisateur=" 
										+ utilisateur.getId() 
										+ ";";
			
			Statement maRequete = maConnection.createStatement();
			ResultSet curseurResultat = maRequete.executeQuery(QUERY_SELECT_ALL);
			
			while(curseurResultat.next()){
				lRetard.add(new Retard(curseurResultat.getInt("id"), 
						curseurResultat.getDate("dater"),
						curseurResultat.getTime("duree"), 
						curseurResultat.getString("motif"), 
						utilisateur));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lRetard;
	}
	
	public boolean insertRetard(Connection maConnection, Retard oRetard){
		try{
			String QUERY_INSERT_NEW = 	"insert into ppe4.retard (date, duree, motif, idUtilisateur) "
									+ "values ('"
									+ new Date()
									+ "', '" 
									+ oRetard.getDuree() 
									+ "', '" 
									+ oRetard.getMotif() 
									+ "', '" 
									+ oRetard.getUtilisateur().getId()
									+"');";

			Statement maRequete = maConnection.createStatement();
			maRequete.executeUpdate(QUERY_INSERT_NEW);
			return true;
		} catch (SQLException e){
			e.printStackTrace();
		}
		return false;
	}
	
}
