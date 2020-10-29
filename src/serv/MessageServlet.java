package serv;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import classes.Message;
import datachange.MessageData;

/**
 * Servlet implementation class MessageServlet
 */
@WebServlet("/MessageServlet")
public class MessageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MessageServlet() {
        super();
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
		    getServletContext().getRequestDispatcher("/confirmMessageSent.jsp").include(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username = request.getParameter("uname");
		String sendname = request.getParameter("stname");
		String mesg = request.getParameter("meg");
		
		Message  message = new Message(username, sendname, mesg);
		MessageData messageData = new MessageData();
		messageData.insertData(message);
		
//		HttpSession session = request.getSession();
//		session.setAttribute("username",username);
//		response.sendRedirect("newMessageSent.jsp");
		
		doGet(request, response);
		
		response.sendRedirect("confirmMessageSent.jsp");
		
	}

}
