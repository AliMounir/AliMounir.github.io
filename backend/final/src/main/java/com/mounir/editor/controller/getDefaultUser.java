package com.mounir.editor.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.mounir.editor.dao.UserDao;
import com.mounir.editor.model.User;

/**
 * Servlet implementation class getUsers
 */
@WebServlet("/getDefaultUser")
public class getDefaultUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		UserDao dao = new UserDao();
		
		User defaultUser = dao.getDefaultUser();
		
		
		response.addHeader("Access-Control-Allow-Origin", "*");
		response.setStatus(200);
		PrintWriter pw = response.getWriter();
		pw.print(new Gson().toJson(defaultUser));
	}


}
