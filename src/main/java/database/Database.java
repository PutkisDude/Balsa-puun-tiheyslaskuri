package database;
import java.sql.Connection;
import java.sql.DriverManager;

public class Database {
	
	public static final String URL = "jdbc:sqlite:./balsa.db";

	public static Connection connect() {
		try {
			Class.forName("org.sqlite.JDBC");
			return DriverManager.getConnection(URL);

		} catch (Exception e) {
			throw new RuntimeException("Virhe yhdistäessä tietokantaan.");
		}
	}

}
