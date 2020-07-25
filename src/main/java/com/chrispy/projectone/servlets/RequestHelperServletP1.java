package com.chrispy.projectone.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RequestHelperServletP1 {
	
	public static void process (HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		
		if (req.getRequestURI().equals("/Projectone/displayUsersReimbursements.json")) {
			UserController.getUserByStatus(req, res);
		} else if (req.getRequestURI().equals("/Projectone/checkAllPendings.json")) {
			PendingsController.getPendings(req, res);
		} else if (req.getRequestURI().equals("/Projectone/checkAllApprovals.json")) {
			ApprovalsController.getApprovals(req, res);
		} else if (req.getRequestURI().equals("/Projectone/checkAllDenials.json")) {
			DenialsController.getDenials(req, res);
		}
	}
}