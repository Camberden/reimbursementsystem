package com.chrispy.projectone.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.chrispy.projectone.models.Reimbursement;

public class ReimbursementDaoImpl implements ReimbursementDao {
	
	// STATIC INITIALIZER FOR PSQL
	static {
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	final static Logger logger = Logger.getLogger(ReimbursementDaoImpl.class);

	
	
	@Override
	public void submitReimbursementRequest(Reimbursement request) {
		
		LocalDateTime now = LocalDateTime.now();
		java.sql.Timestamp sqlNow = java.sql.Timestamp.valueOf(now);
		
		Linkage l = new Linkage();
		try {
			Connection conn = DriverManager.getConnection(l.getDbUrl(), l.getDbUsername(), l.getDbPassword());
			String sql = "INSERT INTO ers_reimbursement(reimb_amount, reimb_submitted, reimb_author, reimb_status_id, reimb_type_id) VALUES (?, ?, ?, ?, ?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			
			ps.setInt(1, request.getAmount());
			ps.setObject(2, sqlNow);
			ps.setInt(3, request.getAuthor());		// THIS NEEDS TO REFERENCE THE SESSION USER
			ps.setInt(4, request.getStatusId()); 	// THIS NEEDS TO REFERENCE THE SESSION USER
			ps.setInt(5, request.getTypeId());		// THIS NEEDS TO REFERENCE THE SESSION USER
			
//			ps.executeUpdate();
			ps.execute();
			
		
		} catch(SQLException e) {
			logger.info("SQLException @ submitReimbursementRequest");
			e.printStackTrace();
		}
	}

	@Override
	public void updateReimbursementStatus(int statusUpdate, int reimbursementID) {
		Linkage l = new Linkage();
		Connection conn;
		try {
			conn = DriverManager.getConnection(l.getDbUrl(), l.getDbUsername(), l.getDbPassword());
			String sql = "UPDATE ers_reimbursement SET reimb_status_id = ? WHERE reimb_id = ? ";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, statusUpdate);
			ps.setInt(2, reimbursementID);
			ps.execute();
			
		} catch (SQLException e) {
			logger.info("SQLException @ updateReimbursementStatus");
			e.printStackTrace();
		}
	}
	
	
	@Override
	public List<Reimbursement> selectAllReimbursementsByStatus(int status) {
		Linkage l = new Linkage();
		List<Reimbursement> rList = new ArrayList<>();
		Connection conn;
		try {
			conn = DriverManager.getConnection(l.getDbUrl(), l.getDbUsername(), l.getDbPassword());
			String sql = "SELECT * FROM ers_reimbursement WHERE reimb_status_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			
			ps.setInt(1, status);
			ResultSet rs = ps.executeQuery();			
			
			while(rs.next()) {
				rList.add(new Reimbursement(rs.getInt(1), rs.getInt(2), rs.getTimestamp(3), rs.getInt(4), rs.getInt(5), rs.getInt(6)));
			}
			
		} catch (SQLException e) {
			logger.info("SQLException @ selectAllReimbursementsByStatus");
			e.printStackTrace();

		}
		return rList;

	}
	
	
	
	@Override
	public List<Reimbursement> selectAllReimbursements() {
		Linkage l = new Linkage();
		List<Reimbursement> rList = new ArrayList<>();
		Connection conn;
		try {
			conn = DriverManager.getConnection(l.getDbUrl(), l.getDbUsername(), l.getDbPassword());
			String sql = "SELECT * FROM ers_reimbursement";
			Statement s = conn.createStatement();
			
			ResultSet rs = s.executeQuery(sql);			
			
			while(rs.next()) {
				rList.add(new Reimbursement(rs.getInt(1), rs.getInt(2), rs.getTimestamp(3), rs.getInt(4), rs.getInt(5), rs.getInt(6)));
				// (int amount, Timestamp now, int author, int statusId, int typeId) 
			}
			
		} catch (SQLException e) {
			logger.info("SQLException @ selectAllReimbursements");
			e.printStackTrace();

		}
		return rList;

	}
	
	@Override
	public List<Reimbursement> selectAllReimbursementsByName(int authorid) {
		Linkage l = new Linkage();
		List<Reimbursement> rList = new ArrayList<>();
		Connection conn;
		try {
			conn = DriverManager.getConnection(l.getDbUrl(), l.getDbUsername(), l.getDbPassword());
			String sql = "SELECT * FROM ers_reimbursement WHERE reimb_author = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			
			ps.setInt(1, authorid);
			ResultSet rs = ps.executeQuery();			
			
			while(rs.next()) {
				rList.add(new Reimbursement(rs.getInt(1), rs.getInt(2), rs.getTimestamp(3), rs.getInt(4), rs.getInt(5), rs.getInt(6)));
			}
			
		} catch (SQLException e) {
			logger.info("SQLException @ selectAllReimbursementsByName");
			e.printStackTrace();

		}
		return rList;

	}
	
}
