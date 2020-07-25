package com.chrispy.projectone.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.chrispy.projectone.models.User;

@SuppressWarnings("serial")
public class HtmlBlockServletP1 extends HttpServlet {
	
	private HttpSession session;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		
		session = req.getSession();
		User sessionUser = (User) session.getAttribute("currentUser");
		
		
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		out.println("<html><head><meta charset=\"UTF-8\">\n" + 
				"<title>ERS Session User</title></head><body>");
		
		if(sessionUser != null) {
			out.println("Below is the Session User Info:");
			
			out.println("<h1> \t Session User Username: " + sessionUser.getUsername() + "</h1>");
			out.println("<h3> Session User ID:  " + sessionUser.getUserId() + "</h3><br>");
			out.println("<b> Session User First Name:  " + sessionUser.getFirstName() + "</hb><br>");
			out.println("<b> \t Session User Last Name: " + sessionUser.getLastName() + "</b><br>");
			out.println("<b> \t Session User Email: " + sessionUser.getEmail() + "</b><br>");
			
		} else {
			out.println("No User Currently logged into Session!");
//			res.sendRedirect("http://localhost:9001/Projectone/html/index.html");
			
		}
		out.println("</body></html>");
	}
	
}