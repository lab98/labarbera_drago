package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.DriverManager;



/*public class Connessione_DB {
	private Context ctx= null;
	private DataSource ds=null;
	private Connection connection=null;
	private PreparedStatement ps=null;
	private ResultSet rs=null;
	
	public Connection startConnection() throws NamingException, SQLException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		ctx= new InitialContext();
		ds=(DataSource) this.ctx.lookup("java:comp/env/jdbc/labarbera_drago");
		return connection = this.ds.getConnection();
	}
	
	public void closeConnection() throws SQLException{
		if(rs!=null)
			this.rs.close();
		
		ps.close();
		connection.close();
	}
}

*//* QUESTO è QUELLO CON IL DRIVEMANAGER
 * 
 * 
 */ public class Connessione_DB {
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

 

