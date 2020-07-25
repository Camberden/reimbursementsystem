package com.chrispy.projectone.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class CentralServlet extends HttpServlet {
	
	
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		
			System.out.println("in doPost");
			RequestHelperServletP1.process(req, res);
			
			}
	
}
