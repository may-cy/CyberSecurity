package serv;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import classes.Registeration;
import datachange.RegisterationData;


/**
 * Servlet implementation class RegisterationServlets
 */
@WebServlet("/RegisterationServlets")
public class RegisterationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	
	  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterationServlet() {
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
		
		String first = request.getParameter("fname");
		String last = request.getParameter("lname");
		String email = request.getParameter("email");
		String username = request.getParameter("uname");
		String password = request.getParameter("pword");
		
		Registeration registeration = new Registeration(first, last, email, username, password);
		RegisterationData data = new RegisterationData() ;
		data.insertData(registeration);
		
		
		response.sendRedirect("confirmRegisteration.jsp");
	}

}
