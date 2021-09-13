package operatore.medico.medico_servlet;

import java.io.IOException;
import java.sql.SQLException;
import org.apache.commons.lang3.RandomStringUtils;

import javax.mail.MessagingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import operatore.operatore_db.OperatoreDB;
import operatore.operatore_model.OperatoreBean;
import email.SendEmail;

/**
 * Servlet implementation class RecuperaCredenzialiServlet
 */
@WebServlet("/RecuperaCredenziali")
public class RecuperaCredenzialiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	OperatoreDB query=new OperatoreDB();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RecuperaCredenzialiServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views_operatore/views_medico/RecuperaCredenziali.jsp");
		dispatcher.forward(request, response);
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		OperatoreBean medico=new OperatoreBean();
	medico.setCod_fiscale(request.getParameter("cod_fiscale"));
	try {
		query.getEmail(medico);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}	
	medico.setPassword(RandomStringUtils.randomAlphanumeric(8));
	try {
		query.modificaPassword(medico, medico.getPassword());
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	System.out.println(medico.getCod_operatore());
	System.out.println(medico.getPassword());
	System.out.println(medico.getEmail());
	String subject="Recupero Credenziali";
	String content= "Queste sono le tue credenziali \n \n "+"Codice Operatore: "+medico.getCod_operatore()+"\n"+"password:"+medico.getPassword();  
	
	try {
		SendEmail.sendMail(medico.getEmail(), subject, content);
		RequestDispatcher dispatcher= request.getRequestDispatcher("/WEB-INF/views_operatore/views_medico/login.jsp");
		dispatcher.forward(request, response);
	} catch (MessagingException e) {
		RequestDispatcher dispatcher= request.getRequestDispatcher("/WEB-INF/views_operatore/views_medico/errorpage.jsp");
		// TODO Auto-generated catch block
		dispatcher.forward(request, response);
		e.printStackTrace();
	}
	
	
	}

}
