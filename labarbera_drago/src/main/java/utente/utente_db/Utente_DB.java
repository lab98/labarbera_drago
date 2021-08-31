package utente.utente_db;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import db.Connessione_DB;
import utente.utente_model.UtenteBean;

public class Utente_DB {
	private Connessione_DB cn = Connessione_DB.getConnessione_DB();
	private String query_prenotazione_dati_utente = "INSERT "
			+ "    INTO utente (cod_fiscale,num_tessera,nome,cognome,sesso,data_nascita,residenza,cittadinanza,email,telefono,cellulare)"
			+ "    VALUES (?,?,?,?,?,?,?,?,?,?,?);";
	public int risultato_query_prenotazione_dati_utente;
	
	public int prenotazione_dati_utente(UtenteBean utente) throws SQLException {
		PreparedStatement statement = cn.getConnection().prepareStatement(query_prenotazione_dati_utente);
		statement.setString(1, utente.getCod_fiscale());
		statement.setString(2, utente.getNum_tessera());
		statement.setString(3, utente.getNome());
		statement.setString(4, utente.getCognome());
		statement.setString(5, utente.getSesso());
		statement.setDate(6, utente.getData_nascita());
		statement.setString(7, utente.getResidenza());
		statement.setString(8, utente.getCittadinanza());
		statement.setString(9, utente.getEmail());
		statement.setString(10, utente.getTelefono());
		statement.setString(11, utente.getCellulare());
		risultato_query_prenotazione_dati_utente=statement.executeUpdate();
		statement.close();
		cn.getConnection().close();
		return risultato_query_prenotazione_dati_utente;
	}
}
