package operatore.operatore_servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import operatore.operatore_model.OperatoreBean;
import operatore.medico.medico_db.MedicoDB;

/**
 * Servlet implementation class MedicoServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MedicoDB query = new MedicoDB();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views_operatore/views_operatore/login.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		OperatoreBean medico= new OperatoreBean();
		medico.setCod_operatore(request.getParameter("cod_operatore"));
		medico.setPassword(request.getParameter("password"));
		try {
			String psw=query.login(medico);
			if(psw.equals(medico.getPassword())) {
				query.confirmLogin(medico);
				if(medico.getRuolo()=="med") {
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views_operatore/views_medico/pagina_personale.jsp");
				dispatcher.forward(request, response);
				}
				else if (medico.getRuolo()=="asp") {
					RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views_operatore/views_asp/pagina_personale.jsp");
					dispatcher.forward(request, response);
				}
				else if (medico.getRuolo()=="adm") {
					RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views_operatore/views_adm/pagina_personale.jsp");
					dispatcher.forward(request, response);
				}
			}
			else {
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views_operatore/views_medico/errore_login.jsp");
				dispatcher.forward(request, response);
			}
		} catch (SQLException | ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		HttpSession session = request.getSession();
		synchronized(session) {
			session.setAttribute("MedicoLog", medico);
		}
		
	}

}
