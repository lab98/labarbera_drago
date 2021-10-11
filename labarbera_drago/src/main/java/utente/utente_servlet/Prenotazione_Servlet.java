package utente.utente_servlet;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;

import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import utente.utente_db.Utente_DB;
import utente.utente_model.UtenteBean;

/**
 * Servlet implementation class Registrazione_Servlet
 */
@WebServlet("/prenotazione_vaccino")
public class Prenotazione_Servlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private Utente_DB query= new Utente_DB();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Prenotazione_Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		boolean a = Pattern.matches("^[a-zA-Z]{6}[0-9]{2}[a-zA-Z][0-9]{2}[a-zA-Z][0-9]{3}[a-zA-Z]$", request.getParameter("cod_fiscale"));
		boolean b = Pattern.matches("[0-9]{8}", request.getParameter("num_tessera"));
		if(a && b) {
			try {
				ResultSet cf=query.verifica_cf(request.getParameter("cod_fiscale"));
				if(!cf.next()){
					cf.close();
					ResultSet nt= query.verifica_nt(request.getParameter("num_tessera"));
						if(!nt.next()) {
						nt.close();
						UtenteBean utente= new UtenteBean();
						utente.setCod_fiscale(request.getParameter("cod_fiscale"));
						utente.setNum_tessera(request.getParameter("num_tessera"));
						utente.setNome(request.getParameter("nome"));
						utente.setCognome(request.getParameter("cognome"));
						utente.setSesso(request.getParameter("sesso"));
						try {
							Date data =  new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("data_nascita"));
							utente.setData_nascita(data);
						} catch (ParseException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}  
						
						utente.setResidenza(request.getParameter("residenza"));
						utente.setCittadinanza(request.getParameter("cittadinanza"));
						utente.setEmail(request.getParameter("email"));
						utente.setTelefono(request.getParameter("telefono"));
						utente.setCellulare(request.getParameter("cellulare"));
						//try {
							//query.prenotazione_dati_utente(utente);  spostare
							RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views_utente/scelta_luogodata.jsp");
							dispatcher.forward(request, response);
						/*} catch (SQLException e) {
							// TODO Auto-generated catch block
							request.setAttribute("errore", "Si è verificato un errore durante la registrazione dei dati, riprovare!");
							e.printStackTrace();
							RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views_utente/prenotazione_errore.jsp");
							dispatcher.forward(request, response); 
						} catch (NamingException e) {
							// TODO Auto-generated catch block
							request.setAttribute("errore", "Si è verificato un errore durante la registrazione dei dati, riprovare!");
							e.printStackTrace();
							RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views_utente/prenotazione_errore.jsp");
							dispatcher.forward(request, response);
						}*/
					}
					else {
						//Controllare se  il numero di tessera sanitaria è stato inserito correttamente! é gia presente un altro utente con questo numero
						request.setAttribute("errore", "Controllare se  il numero di tessera sanitaria è stato inserito correttamente! E' gia presente una prenotazione con questo numero di tessera!");
						RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views_utente/prenotazione_errore.jsp");
						dispatcher.forward(request, response);
					}
				}
				else {
					//Controllare se il codice fiscale è stato inserito correttamente! é già presente una prenotazione con questo codice fiscale;
					request.setAttribute("errore", "Controllare se il codice fiscale è stato inserito correttamente! E' già presente una prenotazione con questo codice fiscale!");
					RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views_utente/prenotazione_errore.jsp");
					dispatcher.forward(request, response);
				}
						
			}			
			 catch (SQLException e) {
				// TODO Auto-generated catch block
				request.setAttribute("errore", "Si è verificato un errore durante la registrazione dei dati, riprovare!");
				e.printStackTrace();
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views_utente/prenotazione_errore.jsp");
				dispatcher.forward(request, response);
			}
		}
		else {
			//stampare che i campi obbligatori cod_fiscale e/o num_tessera non rispettano il formato consentito
			request.setAttribute("errore", "I campi codice fiscale e/o numero tessera sanitaria non rispettano il formato consentito! Riprovare!");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views_utente/prenotazione_errore.jsp");
			dispatcher.forward(request, response);
			// I campi cf e num_tessera non rispettano il formato
		}
		
	}
}
