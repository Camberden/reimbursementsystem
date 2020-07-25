package com.chrispy.projectone.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chrispy.projectone.dao.ReimbursementDao;
import com.chrispy.projectone.dao.ReimbursementDaoImpl;
import com.chrispy.projectone.models.Reimbursement;
import com.fasterxml.jackson.databind.ObjectMapper;

@SuppressWarnings("serial")
public class ManagerServletP1 extends HttpServlet {
	
	ReimbursementDao rDao = new ReimbursementDaoImpl();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		
		// MAYBE DO A FOR LOOP TO RETRIEVE EACH REIMBURSEMENT WITHIN THE LIST
		// by default the ContentType of a response is text/html
		// res.setContentType("application/json");
		
		List<Reimbursement> theListOfReimbursements = rDao.selectAllReimbursements();
		System.out.println(theListOfReimbursements);

		res.getWriter().write(new ObjectMapper().writeValueAsString(theListOfReimbursements));
		System.out.println("Getting all reimbursements for the manager.");
		
		res.setContentType("application/json");
		
	
		
	}
}


