package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connessione_DB {
	private static Connessione_DB connessione_db = null;
	private String URL="jdbc:mysql://localhost:3306/labarbera_drago?useLegacyDatetimeCode=false&serverTimezone=Europe/Rome";
	private Connection connection = null;
	
	private Connessione_DB() throws SQLException{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.connection = DriverManager.getConnection(URL,"root", "ciaociao@99");
	}
	
	public static Connessione_DB getConnessione_DB(){
		if(connessione_db==null) {
			synchronized(Connessione_DB.class) {
				if(connessione_db==null) {
					try {
						connessione_db= new Connessione_DB();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		
		}
		return connessione_db;
	}

	public Connection getConnection() {
		return connection;
	}
	
	
	
}

