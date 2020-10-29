package serv;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import classes.Login;
import datachange.LoginData;

/**
 * Servlet implementation class LoginServ
 */
@WebServlet("/LoginServ")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private LoginData loginData ;
	
	
	public void init() {
		loginData = new LoginData();
	}

    /**
     * Default constructor. 
     */
    public LoginServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		Object username = session.getAttribute("uname");
		if(username != null)
			request.setAttribute("uname", username);
		    getServletContext().getRequestDispatcher("/confirmLogin.jsp").include(request, response);
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String user = request.getParameter("uname");
		String pass = request.getParameter("pword");
		Login login = new Login();
		login.setUsername(user);
		login.setPassword(pass);
		
		try {
			if (loginData.validate(login)) {
				HttpSession session = request.getSession();
				session.setAttribute("username",user);
				response.sendRedirect("confirmLogin.jsp");
			} else {
				HttpSession session = request.getSession();
				//session.setAttribute("user", username);
				response.sendRedirect("login.jsp");
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		doGet(request, response);
	}

		
		
	

}
