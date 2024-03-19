package com.softra.controller;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.core.ApplicationContext;

import com.dao.StudentDao;
import com.softra.model.Student;


/**
 * Servlet implementation class StudentRegistrationServlet
 */
public class StudentRegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ServletConfig config = null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentRegistrationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		this.config = config;
		System.out.println("inside init " + config);
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
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 // Read form parameters from index.html
        String name = request.getParameter("fullname");
        int age = Integer.parseInt(request.getParameter("age"));
        String mobileStr = request.getParameter("mobile");
        Long mobile = Long.parseLong(mobileStr);
        String email = request.getParameter("email");
        String address = request.getParameter("address");

        // Create a Student object and set its properties
        Student student = new Student(name, age, mobile,email,address);

        // Store the Student object in the request scope
        request.setAttribute("student", student);

        // Forward the request to the success.jsp page
        request.getRequestDispatcher("/success.jsp").forward(request, response);
        
        ServletContext context = config.getServletContext();
        String jdbcUrl = context.getInitParameter("jdbcUrl");
        String jdbcUsername = context.getInitParameter("jdbcUsername");
        String jdbcPassword = context.getInitParameter("jdbcPassword");
        
        
        System.out.println("MySQL credentials accessed");
        StudentDao studentDao = new StudentDao(jdbcUrl, jdbcUsername, jdbcPassword);
        System.out.println(student.toString());
        studentDao.saveStudent(student);
	}

}

