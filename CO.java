package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Moussa
 */
public class CO {

	public static Connection com;

	public static void getConnection() {

		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://79.137.84.144/IHM";
			String user = "root";
			String passwd = "moussaleouf";
			com = DriverManager.getConnection(url, user, passwd);
			System.out.println("La connexion  a reussi");
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("La connexion  a echoué");
		}
	}
	// </editor-fold>

}