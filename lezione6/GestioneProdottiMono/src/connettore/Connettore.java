package connettore;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*
 * La classe connettore avrà solamente il metodo apriConnessione
 * è buona norma aprire e chiudere subito la connessione, con il metodo close(), chiamato dall'oggetto
 * connection
 * */

public class Connettore {
	private final String URLDB= "jdbc:mysql://localhost:3306/prodotti_db"; 
	private final String USERDBMS= "root";
	private final String PWDDBMS = "root";
	//il driver è il conoscitore del dialetto del dbms scelto
	//con il file driver.class mi assicuro che java conosca il dialetto del dbms scelto
	private final String DRIVER = "com.mysql.cj.jdbc.Driver";
	private Connection conn = null;
	
	public Connection apriConnessione() {
		try {
			Class.forName(DRIVER); //da imparare a memoria
			conn = DriverManager.getConnection(URLDB, USERDBMS, PWDDBMS);
			return conn;
		}catch (ClassNotFoundException e) {
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return conn;
	}
}
