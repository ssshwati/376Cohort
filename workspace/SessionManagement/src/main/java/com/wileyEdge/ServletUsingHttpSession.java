package com.wileyEdge;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ServletUsingHttpSession
 */
public class ServletUsingHttpSession extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletUsingHttpSession() {
		System.out.println("inside constructor");
		System.out.println(getServletConfig());
	}

	@Override
	public void init() throws ServletException {
		System.out.println("inside init");
		System.out.println(getServletConfig());
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession(true);
		String name = request.getParameter("attrib_name");
		String value = request.getParameter("attrib_value");
		String remove = request.getParameter("attrib_remove");
		if (name != null && name.length() > 0 && (value != null) && value.length() > 0) {
			if (session != null) {
				session.setAttribute(name, value);
			}

		}
		out.println("<HTML>");
		out.println("<HEAD><TITLE>Session Attributes with HttpSession</TITLE></HEAD>");
		out.println("<BODY>");
		out.println("<H1>OnLine Shopping</H1>");

		out.println("Enter item and quantity of your order : ");
		// create a HTML Form
		String url = "/SessionManagement/session";
		out.println("<FORM ACTION=" + "'" + url + "'" + " " + "METHOD=GET" + " >");
		out.println("Item: ");
		out.println("<INPUT TYPE=\"text\" SIZE=\"10\" NAME=\"attrib_name\">");
		out.println("Quantity: ");
		out.println("<INPUT TYPE=\"text\" SIZE=\"10\" NAME=\"attrib_value\">");
		// out.println("<BR><INPUT TYPE=\"checkbox\" NAME=\"attrib_remove\">Remove");
		out.println("<INPUT TYPE=\"submit\" NAME=\"update\" VALUE=\"Purchase\">");
		out.println("</FORM>");

		out.println("<HR>");
		out.println("Your shopping cart list : ");

		if (session != null) {
			Enumeration e = session.getAttributeNames();
			while (e.hasMoreElements()) {
				String att_name = (String) e.nextElement();
				String att_value = (String) session.getAttribute(att_name);
				out.println("<BR><B>Item:</B> ");
				out.println(att_name);
				out.println("<B>Quantity: </B>");
				out.println(att_value);
			}
		} else {
			out.println("<BR><B>Name:</B> ");
			out.println(name);
			out.println("<B>Value: </B>");
			out.println(value);
		}

		out.println("</BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}
}
