package operatore.medico.medico_db;

import db.Connessione_DB;
import operatore.operatore_model.OperatoreBean;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class MedicoDB {
	
	private Connessione_DB cn= Connessione_DB.getConnessione_DB();
	private String query_login= "SELECT password FROM operatore WHERE cod_operatore=?";
	private String confirmed_login= "SELECT nome, cognome, cod_asp, email, ruolo, cod_fiscale FROM operatore WHERE cod_operatore=?";
	private String modifica_password="UPDATE operatore SET password=? WHERE cod_operatore=?";
	private String get_email="SELECT cod_operatore, email FROM operatore WHERE cod_fiscale=?";
	
	public String login(OperatoreBean medico) throws SQLException {
		String password= new String();
		PreparedStatement ps= cn.getConnection().prepareStatement(query_login);
		ps.setString(1,medico.getCod_operatore());
		
		ResultSet rs=ps.executeQuery();
	
		while(rs.next()) {
			
			password=rs.getString(1);
		}
		ps.close();
		
		return password;
	}
	
	public void confirmLogin(OperatoreBean medico)throws SQLException{
		PreparedStatement ps=cn.getConnection().prepareStatement(confirmed_login);
		ps.setString(1,medico.getCod_operatore());
		
		ResultSet rs=ps.executeQuery();
		
		while(rs.next()) {
			
			medico.setNome(rs.getString(1));
			medico.setCognome(rs.getString(2));
			medico.setCod_asp(rs.getString(3));
			medico.setEmail(rs.getString(4));
			medico.setRuolo(rs.getNString(5));
			medico.setCod_fiscale(rs.getString(6));
		}
		ps.close();
	}
	
	public void modificaPassword(OperatoreBean medico, String newpsw) throws SQLException {
		PreparedStatement ps= cn.getConnection().prepareStatement(modifica_password);
		ps.setString(1, newpsw);
		ps.setString(2, medico.getCod_operatore());
		
		ps.executeUpdate();
		
		ps.close();		
	}
	
	public void getEmail(OperatoreBean medico) throws SQLException {
		PreparedStatement ps= cn.getConnection().prepareStatement(get_email);
		ps.setString(1, medico.getCod_fiscale());
		
		System.out.println(medico.getCod_fiscale());
		
		ResultSet rs= ps.executeQuery();
		
		while (rs.next()) {			
		medico.setCod_operatore(rs.getString(1));
		medico.setEmail(rs.getString(2));
		}
		ps.close();
	}
}