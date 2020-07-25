package com.chrispy.projectone.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.chrispy.projectone.dao.UserDaoImpl;
import com.chrispy.projectone.models.User;

@SuppressWarnings("serial")
//@WebServlet("/sessionlogon")
public class SessionServletP1 extends HttpServlet {
	
	Logger logger = Logger.getLogger(SessionServletP1.class);
	User staticSessionUser;
	
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		
		UserDaoImpl uDao = new UserDaoImpl();
		
		String username = req.getParameter("usernameConfirm");
		String password = req.getParameter("passwordConfirm");
		
		HttpSession session = req.getSession();
		User sessionUser = uDao.getUser(username, password);
		staticSessionUser = sessionUser;
		

		
		boolean logon = uDao.verifyUserCredentials(username, password);
		boolean status = uDao.getRole(username, password);
		
		if (logon && status) {
			session.setAttribute("currentUser", sessionUser);
			System.out.println("Logged in to manager!");
			logger.info(username + " logged in as manager!");
			res.sendRedirect("http://localhost:9001/Projectone/html/managerdashboard.html");		

		} else if (logon && status == false) {
			session.setAttribute("currentUser", sessionUser);
			System.out.println("Logged in to user");
			logger.info(username + " logged in as user!");
			res.sendRedirect("http://localhost:9001/Projectone/html/userdashboard.html");
			
		} else {
			logger.info(username + ": log on failure!");
			res.sendRedirect("http://localhost:9001/Projectone/html/index.html");
		}
		
	}
}
