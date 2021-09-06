package medico.medico_db;

import db.Connessione_DB;
import medico.medico_model.MedicoBean;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class MedicoDB {
	
	private Connessione_DB cn= Connessione_DB.getConnessione_DB();
	private String query_login= "SELECT password FROM operatore WHERE cod_operatore=?";
	private String confirmed_login= "SELECT nome, cognome, cod_asp, email, ruolo FROM operatore WHERE cod_operatore=?";
	private String modifica_password="UPDATE operatore SET password=? WHERE cod_operatore=?";
	
	public String login(MedicoBean medico) throws SQLException {
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
	
	public void confirm_login(MedicoBean medico)throws SQLException{
		PreparedStatement ps=cn.getConnection().prepareStatement(confirmed_login);
		ps.setString(1,medico.getCod_operatore());
		
		ResultSet rs=ps.executeQuery();
		
		while(rs.next()) {
			
			medico.setNome(rs.getString(1));
			medico.setCognome(rs.getString(2));
			medico.setCod_asp(rs.getString(3));
			medico.setEmail(rs.getString(4));
			medico.setRuolo(rs.getNString(5));
		}
		ps.close();
	}
	
	public void modifica_password(MedicoBean medico, String newpsw) throws SQLException {
		PreparedStatement ps= cn.getConnection().prepareStatement(modifica_password);
		ps.setString(1, newpsw);
		ps.setString(2, medico.getCod_operatore());
		
		ps.executeUpdate();
		
		ps.close();
		
		
		
	}

}
