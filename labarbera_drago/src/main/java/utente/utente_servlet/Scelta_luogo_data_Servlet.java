package utente.utente_servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Json_converter.ResultSetConverter;
import utente.utente_db.Utente_DB;

/**
 * Servlet implementation class Scelta_luogo_data_Servlet
 */
@WebServlet("/scelta_luogo")
public class Scelta_luogo_data_Servlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	Utente_DB query= new Utente_DB();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Scelta_luogo_data_Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			response.setContentType("application/json");
			PrintWriter out = response.getWriter();
			query.cerca_hub();
			out.print(ResultSetConverter.convert(query.cerca_hub()));
			out.flush();
			out.close();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
