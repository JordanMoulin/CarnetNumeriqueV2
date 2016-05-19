package dataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnexionPostgreSql {
	
	private static String url = "jdbc:postgresql://bts.bts-malraux72.net:62543/eagnelet";
	private static String user = "e.agnelet";
	private static String passwd = "pr55rc";
	private static Connection connect = null;
	
	public static Connection getInstance(){
		if(connect == null){
			try {
				connect = DriverManager.getConnection(url, user, passwd);
				} 
			catch (SQLException e)  
			{
				e.printStackTrace();
			}
		}
		 return connect;
		}
}
