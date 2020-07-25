package com.chrispy.projectone.dao;

import java.util.List;

import com.chrispy.projectone.models.Reimbursement;

public interface ReimbursementDao {
	
	public void submitReimbursementRequest(Reimbursement request);
	
	public List<Reimbursement> selectAllReimbursements();

//	List<Reimbursement> selectAllReimbursementsByName(String username);

	List<Reimbursement> selectAllReimbursementsByStatus(int status);

	List<Reimbursement> selectAllReimbursementsByName(int authorid);

	void updateReimbursementStatus(int statusUpdate, int reimbursementID);

}
