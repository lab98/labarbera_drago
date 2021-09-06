package utente.utente_db;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.NamingException;

import db.Connessione_DB;
import utente.utente_model.UtenteBean;

public class Utente_DB {
	//private Connessione_DB cn = new Connessione_DB();
	private Connessione_DB cn= Connessione_DB.getConnessione_DB(); 
	private String query_hub = "SELECT * FROM hub GROUP BY citta ";
	private String query_prenotazione_dati_utente = "INSERT "
			+ "    INTO utente (cod_fiscale,num_tessera,nome,cognome,sesso,data_nascita,residenza,cittadinanza,email,telefono,cellulare)"
			+ "    VALUES (?,?,?,?,?,?,?,?,?,?,?);";
	private int risultato_query_prenotazione_dati_utente;
	private ResultSet risultato_query_hub;
	
	public ResultSet cerca_hub() throws SQLException {
		PreparedStatement statement = cn.getConnection().prepareStatement(query_hub);
		risultato_query_hub=statement.executeQuery();
		statement.close();
		return risultato_query_hub;
	}
	
	public int prenotazione_dati_utente(UtenteBean utente) throws SQLException, NamingException {
		PreparedStatement statement = cn.getConnection().prepareStatement(query_prenotazione_dati_utente);
			
		//PreparedStatement statement = cn.startConnection().prepareStatement(query_prenotazione_dati_utente);
		statement.setString(1, utente.getCod_fiscale());
		statement.setString(2, utente.getNum_tessera());
		statement.setString(3, utente.getNome());
		statement.setString(4, utente.getCognome());
		statement.setString(5, utente.getSesso());
		long secs= utente.getData_nascita().getTime();
		statement.setDate(6, new java.sql.Date(secs));
		statement.setString(7, utente.getResidenza());
		statement.setString(8, utente.getCittadinanza());
		statement.setString(9, utente.getEmail());
		statement.setString(10, utente.getTelefono());
		statement.setString(11, utente.getCellulare());
		risultato_query_prenotazione_dati_utente=statement.executeUpdate();
		statement.close();
		//cn.getConnection().close();
		return risultato_query_prenotazione_dati_utente;
	}
}
