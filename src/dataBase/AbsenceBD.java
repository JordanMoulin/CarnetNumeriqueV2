package dataBase;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import object.Absence;
import object.Utilisateur;

public class AbsenceBD {
	public List<Absence> recupAbsence(Connection maConnection, Utilisateur utilisateur){
		List<Absence> lAbsence= new ArrayList<Absence>();
		try {
			String QUERY_SELECT_ALL = 	"select id, "
										+ "dateDebut, "
										+ "dateRetour, "
										+ "trim(motif) as motif, "
										+ "from ppe4.retard where idUtilisateur=" 
										+ utilisateur.getId() 
										+ ";";
			
			Statement maRequete = maConnection.createStatement();
			ResultSet curseurResultat = maRequete.executeQuery(QUERY_SELECT_ALL);
			
			while(curseurResultat.next()){
				lAbsence.add(new Absence(curseurResultat.getInt("id"), 
						curseurResultat.getDate("dateDebut"), 
						curseurResultat.getDate("dateRetour"), 
						curseurResultat.getString("motif"), 
						utilisateur));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lAbsence;
	}
	
	public boolean insertAbsence(Connection maConnection, Absence oAbsence){
		try{
			String QUERY_INSERT_NEW = 	"insert into ppe4.absence (dateDebut, dateRetour, motif, idUtilisateur) "
										+ "values ('" 
										+ oAbsence.getDateDebut()
										+ "', '" 
										+ oAbsence.getDateRetour()
										+ "', '" 
										+ oAbsence.getMotif() 
										+ "', '" 
										+ oAbsence.getUtilisateur().getId()
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
