package utente.utente_model;


import java.io.Serializable;
import java.sql.Date;

public class UtenteBean implements Serializable  {
	
	public UtenteBean() {}
	
	private String cod_fiscale;
	private String num_tessera;
	private String nome;
	private String cognome;
	private String sesso;
	private Date data_nascita;
	private String residenza;
	private String cittadinanza;
	private String email;
	private String telefono;
	private String cellulare;
	
	public String getNum_tessera() {
		return num_tessera;
	}
	public void setNum_tessera(String num_tessera) {
		this.num_tessera = num_tessera;
	}
	public String getCod_fiscale() {
		return cod_fiscale;
	}
	public void setCod_fiscale(String cod_fiscale) {
		this.cod_fiscale = cod_fiscale;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Date getData_nascita() {
		return data_nascita;
	}
	public void setData_nascita(Date data_nascita) {
		this.data_nascita = data_nascita;
	}
	public String getResidenza() {
		return residenza;
	}
	public void setResidenza(String residenza) {
		this.residenza = residenza;
	}
	public String getCittadinanza() {
		return cittadinanza;
	}
	public void setCittadinanza(String cittadinanza) {
		this.cittadinanza = cittadinanza;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getCellulare() {
		return cellulare;
	}
	public void setCellulare(String cellulare) {
		this.cellulare = cellulare;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public String getSesso() {
		return sesso;
	}
	public void setSesso(String sesso) {
		this.sesso = sesso;
	}
	
}
