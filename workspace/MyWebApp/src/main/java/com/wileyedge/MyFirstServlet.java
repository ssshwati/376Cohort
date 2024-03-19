package com.wileyedge;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MyFirstServlet
 */

/*
 * http://localhost:8080/MyWebApp/hello
 */

public class MyFirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MyFirstServlet() {
		System.out.println("inside myServlet constructor");
	}

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	 
	 /*
	public void init(ServletConfig config) throws ServletException {
		System.out.println("inside init method of myServlet");
	}
	*/

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		System.out.println("inside destroy method of myServlet");
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("inside doGet method of myServlet");
		PrintWriter out = response.getWriter();
//		String value = request.getParameter("name");
//		out.print("hello from the server welcome "+value);
//		out.println("<html>");
//		out.println("<body>");
//		out.println("<h2>login page</h2>");
//		out.println("<form action='login' method = 'post' >");
//		out.println("Enter Username : <input type='text' name='uname'/><br>");
//		out.println("<br>Enter Password : <input type='password' name='pwd'/><br>");
//		out.println("<input type='submit' value='signIn'/>");
//		out.println("</form>");
//		out.println("</body>");
//		out.println("</html>");
		request.setAttribute("myname", "shwati");
		ServletContext context=getServletConfig().getServletContext();
		context.setAttribute("myname","kaju");
		System.out.println("forwarding request to html");RequestDispatcher rd = request.getRequestDispatcher("loginForm.jsp");
		rd.forward(request, response);		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("inside doPost method of myServlet");
		doGet(request, response);
	}

}