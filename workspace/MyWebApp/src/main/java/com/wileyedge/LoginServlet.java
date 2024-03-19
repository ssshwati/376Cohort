package com.wileyedge;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */

/*
 * http://localhost:8080/MyWebApp/login
 */

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        System.out.println("login servlet constructor");
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
//	public void init(ServletConfig config) throws ServletException {
//        System.out.println("login servlet init()");
//	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("login servlet doGet");
        doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("login servlet doPost");
        String uname = request.getParameter("uname");
        String password = request.getParameter("pwd");
		PrintWriter out = response.getWriter();
		ServletConfig config = getServletConfig();
//		config.setAttribute("myname","shweta");
    	HttpSession session = request.getSession(true);
        if(uname.equals(password)) {
//        	out.println("<html>");
//    		out.println("<body>");
//    		out.println("<h2>login success</h2>");
//        	out.println("</html>");
//    		out.println("</body>");
        	session.setAttribute("uname",uname);
        	RequestDispatcher rd = request.getRequestDispatcher("success.jsp");
//    		rd.forward(request, response);
//    		System.out.println("success request forwarded");
    		rd.include(request, response);
    		out.println("success request included");
        }else {
//        	out.println("<html>");
//    		out.println("<body>");
//    		out.println("<h2>invalid credentials</h2>");
//        	out.println("</html>");
//    		out.println("</body>");
        	RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
    		rd.forward(request, response);
    		System.out.println("error request forwarded");
    		rd.include(request, response);
    		out.println("error request included");
        }
	}
}
