package com.chrispy.projectone.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@SuppressWarnings("serial")
public class LogoutServletP1 extends HttpServlet {
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		 
        HttpSession session=req.getSession();  
		session.invalidate();
		res.sendRedirect("http://localhost:9001/Projectone/html/index.html");		
	}
}

