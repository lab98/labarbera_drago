package utente.utente_db;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import javax.naming.NamingException;

import db.Connessione_DB;
import utente.utente_model.UtenteBean;

public class Utente_DB {
	//private Connessione_DB cn = new Connessione_DB();
	private Connessione_DB cn= Connessione_DB.getConnessione_DB(); 
	private String query_hub = "SELECT * FROM hub";
	private String query_prenotazione_dati_utente = "INSERT "
			+ "    INTO utente (cod_fiscale,num_tessera,nome,cognome,sesso,data_nascita,residenza,cittadinanza,email,telefono,cellulare)"
			+ "    VALUES (?,?,?,?,?,?,?,?,?,?,?);";
	private String query_verifica_cf= "SELECT cod_fiscale FROM utente WHERE cod_fiscale=?";
	private String query_verifica_nt= "SELECT num_tessera FROM utente WHERE num_tessera=?";
	private String query_verifica_orari=" SELECT ora from prenotazione, hub where prenotazione.cod_hub=hub.cod_hub and data_prenotazione=? and nome_hub=? group by ora having count(*)>2";
	private ResultSet risultato_query_verifica_orari;
	private ResultSet risultato_query_verifica_nt;
	private ResultSet risultato_query_verifica_cf;
	private int risultato_query_prenotazione_dati_utente;
	private ResultSet risultato_query_hub;
	
	public ResultSet cerca_hub() throws SQLException {
		PreparedStatement statement2 = cn.getConnection().prepareStatement(query_hub);
		risultato_query_hub=statement2.executeQuery();
		//risultato_query_hub.close();
		//statement2.close();
		//cn.getConnection().close();
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
		//statement.close();
		//cn.getConnection().close();
		return risultato_query_prenotazione_dati_utente;
	}
	
	public ResultSet verifica_cf(String cf) throws SQLException {
		PreparedStatement statement3 = cn.getConnection().prepareStatement(query_verifica_cf);
		statement3.setString(1, cf);
		risultato_query_verifica_cf=statement3.executeQuery();
		//statement3.close();
		return risultato_query_verifica_cf;
	}
	public ResultSet verifica_nt(String nt) throws SQLException {
		PreparedStatement statement4 = cn.getConnection().prepareStatement(query_verifica_nt);
		statement4.setString(1, nt);
		risultato_query_verifica_nt= statement4.executeQuery();
		//statement4.close();
		return risultato_query_verifica_nt;
	}
	public ResultSet verifica_orari(Date data, String nome) throws SQLException {
		PreparedStatement statement= cn.getConnection().prepareStatement(query_verifica_orari);
		long secs= data.getTime();
		statement.setDate(1, new java.sql.Date(secs));
		statement.setString(2, nome);
		risultato_query_verifica_orari=statement.executeQuery();
		return risultato_query_verifica_orari;
	}
}
