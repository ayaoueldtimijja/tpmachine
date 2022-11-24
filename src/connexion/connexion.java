package connexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class connexion {

	private static String username = "root";
	private static String password = "";
	private static String url = "jdbc:mysql://localhost:3306/stock";
	private static Connection connection;

	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(url, username, password);
		} catch (ClassNotFoundException e) {
			System.out.println("impossible de charger le driver");
		} catch (SQLException e) {
			System.out.println("impossible d'etablir la connexion");
		}
	}

	public static Connection getConnection() {
		return connection;
	}
}
