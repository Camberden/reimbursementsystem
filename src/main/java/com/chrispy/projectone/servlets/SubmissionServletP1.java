package com.chrispy.projectone.servlets;

import java.io.IOException;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.chrispy.projectone.dao.ReimbursementDao;
import com.chrispy.projectone.dao.ReimbursementDaoImpl;
import com.chrispy.projectone.models.Reimbursement;
import com.chrispy.projectone.models.User;

@SuppressWarnings("serial")
public class SubmissionServletP1 extends HttpServlet {
		
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		
		ReimbursementDao rDao = new ReimbursementDaoImpl();
		LocalDateTime now = LocalDateTime.now();
		java.sql.Timestamp sqlNow = java.sql.Timestamp.valueOf(now);
		
		String amountClaim = req.getParameter("amountConfirm");
		String typeClaim = req.getParameter("typeConfirm");
		int amountClaimInt = Integer.parseInt(amountClaim);
		int typeClaimInt = Integer.parseInt(typeClaim);
		
		HttpSession session = req.getSession(true);
		System.out.println(session.getAttribute("currentUser"));
		User sessionUser = (User) session.getAttribute("currentUser");
		
		System.out.println(sessionUser);
		System.out.println(sessionUser.getFirstName());
		System.out.println(sessionUser.getUsername());
		System.out.println(sessionUser.getUserId());
		System.out.println(sessionUser.getEmail());
				
		Reimbursement rei = new Reimbursement(amountClaimInt, sqlNow, sessionUser.getUserId() , 10, typeClaimInt);
		
		rDao.submitReimbursementRequest(rei);
		
		res.sendRedirect("http://localhost:9001/Projectone/html/userdashboard.html");	
	}
}

//super();
//this.amount = amount;
//this.submissionDate = submissionDate;
//this.author = author;
//this.statusId = statusId;
//this.typeId = typeId;