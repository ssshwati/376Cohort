package com.wileyedge;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Servlet2
 */
public class Servlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ServletConfig config;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet2() {
        super();

    }
    
    /**
	 * @see Servlet#init(ServletConfig)
	 */
//	public void init(ServletConfig config) throws ServletException {
//		this.config=config;
//	}
	
	@Override
	public void init() throws ServletException {
		System.out.println(" inside new init " + this.getServletConfig().toString());
	}

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
		String fname = request.getParameter("firstName");
		PrintWriter out = response.getWriter();
		String nickname = (String) request.getAttribute("nickName");
//		ServletContext context = config.getServletContext();
		ServletContext context = getServletConfig().getServletContext();
		String lastname = context.getInitParameter("lastname");
		System.out.println(" inside servlet 2 "+lastname);
//		ServletConfig config = getServletConfig();
//		String middlename = (String) config.getInitParameter("middlename");
		String middlename = (String) getServletConfig().getInitParameter("middlename");
		System.out.println(" inside servlet 2 "+middlename);
		out.println("<h2>Welcome "+fname+ " " + nickname +"</h2>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
