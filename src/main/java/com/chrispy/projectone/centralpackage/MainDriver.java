package com.chrispy.projectone.centralpackage;

import java.util.List;

import org.apache.log4j.Logger;

import com.chrispy.projectone.dao.ReimbursementDao;
import com.chrispy.projectone.dao.ReimbursementDaoImpl;
import com.chrispy.projectone.dao.UserDao;
import com.chrispy.projectone.dao.UserDaoImpl;
import com.chrispy.projectone.models.Reimbursement;
import com.chrispy.projectone.models.User;

public class MainDriver implements Scannable {
	
	static UserDao uDao = new UserDaoImpl();
	static ReimbursementDao rDao = new ReimbursementDaoImpl();

	final static Logger logger = Logger.getLogger(MainDriver.class);

	public static void main(String[] args) {
		
	
		User u = new User();
		
		ReimbursementDao rDao = new ReimbursementDaoImpl();
	
		List<Reimbursement> rList = rDao.selectAllReimbursementsByName(u.getUserId());
		
		System.out.println(rList);
	} 
}