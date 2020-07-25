package com.chrispy.projectone.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chrispy.projectone.dao.ReimbursementDao;
import com.chrispy.projectone.dao.ReimbursementDaoImpl;
import com.chrispy.projectone.dao.UserDao;
import com.chrispy.projectone.dao.UserDaoImpl;
import com.chrispy.projectone.models.Reimbursement;
//import com.chrispy.projectone.models.User;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ApprovalsController {
	
	UserDao uDao = new UserDaoImpl();
	
	public static void getApprovals(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
	
		ReimbursementDao rDao = new ReimbursementDaoImpl();
		
//		User user = (User) req.getSession().getAttribute("currentUser");
		List<Reimbursement> rList = rDao.selectAllReimbursementsByStatus(30);
		
		System.out.println(rList);
		res.setContentType("application/json");
		res.getWriter().write(new ObjectMapper().writeValueAsString(rList));
		System.out.println("Within ApprovalsController; writing list as JSON");
		
		
	}
}