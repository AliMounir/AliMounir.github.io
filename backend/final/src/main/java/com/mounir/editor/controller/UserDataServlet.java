package com.mounir.editor.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mounir.editor.dao.UserDao;
import com.mounir.editor.model.User;

/**
 * Servlet implementation class UserDataServlet
 */
@WebServlet("/register")
public class UserDataServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private UserDao userDao = new UserDao();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserDataServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/EntryForm.xhtml");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int userId = 0;
		
		

		String name = request.getParameter("name");
		String job = request.getParameter("job");
		String address = request.getParameter("address");
		String birthDate = request.getParameter("birthDate");
		String email = request.getParameter("email");
		String number = request.getParameter("number");
		String insta = request.getParameter("insta");
		String github = request.getParameter("github");
		String aboutMe = request.getParameter("aboutMe");

		User user = new User();
		user.setName(name);
		user.setJob(job);
		user.setAddress(address);
		user.setBirthDate(birthDate);
		user.setEmail(email);
		user.setNumber(number);
		user.setInsta(insta);
		user.setGithub(github);
		user.setAboutMe(aboutMe);
		
		try {
			userId = userDao.registerUser(user);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		response.addHeader("Access-Control-Allow-Origin", "*");
		response.setStatus(200);
		PrintWriter pw = response.getWriter();
//		pw.append("Served at: ").append(request.getContextPath());
		pw.print(userId);

	}

}
