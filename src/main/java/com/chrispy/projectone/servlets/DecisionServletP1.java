package com.chrispy.projectone.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.chrispy.projectone.dao.ReimbursementDao;
import com.chrispy.projectone.dao.ReimbursementDaoImpl;
import com.chrispy.projectone.models.User;

@SuppressWarnings("serial")
public class DecisionServletP1 extends HttpServlet {
	
	private HttpSession session;

		protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
			
			session = req.getSession();
			User sessionUser = (User) session.getAttribute("currentUser");
			System.out.println(sessionUser);
			
			try {
				if (sessionUser.getRoleId() == 200) {
				
					ReimbursementDao rDao = new ReimbursementDaoImpl();
					
					String reimbursementIdentifier = req.getParameter("reimbursementIdentfier");
					String statusUpdate = req.getParameter("statusUpdate");
					
					int reimbursementIdentifierInt = Integer.parseInt(reimbursementIdentifier);
					int statusUpdateInt = Integer.parseInt(statusUpdate);
					
					rDao.updateReimbursementStatus(statusUpdateInt, reimbursementIdentifierInt);
					
					res.sendRedirect("http://localhost:9001/Projectone/html/managerdashboard.html");	
				
					
					
				} else {
					res.sendRedirect("http://localhost:9001/Projectone/html/index.html");
				}
			} catch (NullPointerException e) {
				e.printStackTrace();
				res.sendRedirect("http://localhost:9001/Projectone/html/index.html");
			}

	}

}