package operatore.medico.medico_servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import operatore.medico.medico_db.MedicoDB;
import operatore.operatore_model.OperatoreBean;

/**
 * Servlet implementation class ModificaPasswordServlet
 */
@WebServlet("/ModificaPassword")
public class ModificaPasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	MedicoDB query= new MedicoDB();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModificaPasswordServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views_operatore/views_medico/modifica_password.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		
		OperatoreBean medico=(OperatoreBean) session.getAttribute("MedicoLog");
		try {
			String oldpsw=query.login(medico);
			
			if( oldpsw.equals(request.getParameter("oldpsw"))){
				query.modificaPassword(medico, request.getParameter("newpsw"));
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views_operatore/views_medico/pagina_personale.jsp");
				dispatcher.forward(request, response);
				}
			else {
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views_operatore/views_medico/modifica_password.jsp");
				dispatcher.forward(request, response);
			}
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
