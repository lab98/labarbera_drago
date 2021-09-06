package utente.utente_servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
