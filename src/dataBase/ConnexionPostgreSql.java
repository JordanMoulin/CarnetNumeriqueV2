package dataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Classe ConnexionPostgreSql, cette classe permet la connection à la BDD.
 * 
 * @author Erwan
 *
 */
public class ConnexionPostgreSql {

	private static String url = "jdbc:postgresql://bfwh5lnnksp2f01-postgresql.services.clever-cloud.com:5432/bfwh5lnnksp2f01";
	// en cas de connection en local au lycée :
	private static String urlLocal = "jdbc:postgresql://bfwh5lnnksp2f01-postgresql.services.clever-cloud.com:5432/bfwh5lnnksp2f01";
	private static String user = "udbhxxv1o1wqhmzabwm0";
	private static String passwd = "aiqAKms8v1SbCjwjuyoz";
	private static Connection connect = null;

	/**
	 * La méthode de connexion
	 * 
	 * @return Connection - La connexion
	 */
	public static Connection getInstance() {
		if (connect == null) {
			try {
				connect = DriverManager.getConnection(url, user, passwd);
			} catch (SQLException e) {
				try {
					connect = DriverManager.getConnection(urlLocal, user, passwd);
				} catch (SQLException f) {
					e.printStackTrace();
				}
			}
		}
		return connect;
	}
}
