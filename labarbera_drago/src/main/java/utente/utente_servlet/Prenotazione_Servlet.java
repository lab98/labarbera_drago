package utente.utente_servlet;

import java.io.IOException;
import java.sql.SQLException;

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
	Utente_DB query= new Utente_DB();
       
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
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views_utente/prenotazione_vaccino.jsp");
		dispatcher.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UtenteBean utente= new UtenteBean();
		utente.setCod_fiscale(request.getParameter("cod_fiscale"));
		utente.setCod_fiscale(request.getParameter("num_tessera"));
		utente.setCod_fiscale(request.getParameter("nome"));
		utente.setCod_fiscale(request.getParameter("cognome"));
		utente.setCod_fiscale(request.getParameter("sesso"));
		utente.setCod_fiscale(request.getParameter("data_nascita"));
		utente.setCod_fiscale(request.getParameter("residenza"));
		utente.setCod_fiscale(request.getParameter("cittadinanza"));
		utente.setCod_fiscale(request.getParameter("email"));
		utente.setCod_fiscale(request.getParameter("telefono"));
		utente.setCod_fiscale(request.getParameter("cellulare"));
		try {
			if(query.prenotazione_dati_utente(utente)==0) {
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views_utente/prenotazione_errore.jsp");
				dispatcher.forward(request, response);
			}
			else {
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views_utente/scelta_luogodata.jsp");
				dispatcher.forward(request, response);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
