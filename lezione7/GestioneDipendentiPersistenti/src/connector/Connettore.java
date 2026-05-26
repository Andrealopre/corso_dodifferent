package connector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Connettore {
	private final String URLDB= "jdbc:mysql://localhost:3306/db_dipendenti"; 
	private final String USERDBMS= "root";
	private final String PWDDBMS = "root";
	
	private final String DRIVER = "com.mysql.cj.jdbc.Driver";
	private Connection conn = null;
	private static Connettore instance = null;
	
	private Connettore() {
		
	}
	
	public static Connettore getInstance() {
		if(instance == null) {
			instance = new Connettore();
		}
		return instance;
	}
	
	public Connection apriConnessione() {
		try {
			Class.forName(DRIVER);
			conn = DriverManager.getConnection(URLDB, USERDBMS, PWDDBMS);
			return conn;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
}
