package com.chrispy.projectone.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import org.apache.log4j.Logger;

import com.chrispy.projectone.centralpackage.Scannable;
import com.chrispy.projectone.models.User;

public class UserDaoImpl implements UserDao, Scannable {
	
	static {
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	final static Logger logger = Logger.getLogger(UserDaoImpl.class);


	@Override
	public boolean verifyUserCredentials(String username, String password) {
		
			Linkage l = new Linkage();
		
				boolean result = false;
				try {
					Connection conn = DriverManager.getConnection(l.getDbUrl(), l.getDbUsername(), l.getDbPassword());
					String sql = "SELECT ers_username, ers_password FROM ers_users where ers_username = ? AND ers_password = ?";
					
					PreparedStatement ps = conn.prepareStatement(sql);
					ps.setString(1, username);
					ps.setString(2, password);
					
					ResultSet rs = ps.executeQuery();			
					
					while(rs.next()) {
						
						if (username.equals(rs.getString("ers_username")) && password.equals(rs.getString("ers_password"))) {
								result = true;
//			                    System.out.println("Logged in!");
			                    break;
			                    
			                
			                } else {
			                    System.out.println("Password did not match username!");
			                    System.out.println("Username not within the database");
			                    break;
			                }
					}
			                } catch (SQLException e) {
			        			logger.info("SQLException @ verifyUserCredentials");
			        			e.printStackTrace();
			        		}
			        		return result;
			        	}

	
	
	@Override
	public void registerUser(User user) {
		
		Linkage l = new Linkage();
		try {
			Connection conn = DriverManager.getConnection(l.getDbUrl(), l.getDbUsername(), l.getDbPassword());
			String sql = "INSERT INTO ers_users(ers_username, ers_password, user_first_name, user_last_name, user_email, user_role_id) VALUES (?, ?, ?, ?, ?, ?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());
			ps.setString(3, user.getFirstName());
			ps.setString(4, user.getLastName());
			ps.setString(5, user.getEmail());
			ps.setInt(6, 100);
			ps.execute();
			
		
		} catch(SQLException e) {
			logger.info("SQLException @ registerUser");
			e.printStackTrace();
		}
	}



	public boolean getRole(String username, String password) {
		
		Linkage l = new Linkage();
		
		boolean result = false;
		try {
			Connection conn = DriverManager.getConnection(l.getDbUrl(), l.getDbUsername(), l.getDbPassword());
			String sql = "SELECT user_role_id FROM ers_users WHERE ers_username = ? AND ers_password = ?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			
			ResultSet rs = ps.executeQuery();			
			
			while(rs.next()) {
				
				int oof = rs.getInt(1);
				
				if (oof == 100) {
					result = false;
	                System.out.println("Identified as User");
	                break;
				} else if (oof == 200) {
					result = true;
                    System.out.println("Identified as Admin");
				}
			}
	                } catch (SQLException e) {
	        			logger.info("SQLException @ verifyUserCredentials");
	        			e.printStackTrace();
	                }
		
		return result;
	}






	public User getUser(String username, String password) {
	
		Linkage l = new Linkage();
		User newUser = new User();
		
		
		try {
			Connection conn = DriverManager.getConnection(l.getDbUrl(), l.getDbUsername(), l.getDbPassword());
			String sql = "SELECT * FROM ers_users WHERE ers_username = ? AND ers_password = ?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			
			ResultSet rs = ps.executeQuery();			
			
			while(rs.next()) {
				// DOING A SATURDAY ADDITION OF SETUSERID
				newUser.setUserId(rs.getInt(1));
				newUser.setUsername(rs.getString(2));
				newUser.setPassword(rs.getString(3));
				newUser.setFirstName(rs.getString(4));
				newUser.setLastName(rs.getString(5));
				newUser.setEmail(rs.getString(6));
				newUser.setRoleId(rs.getInt(7));
				
				
				
			}
	                } catch (SQLException e) {
	        			logger.info("SQLException @ getUser");
	        			e.printStackTrace();
	                }
		
		return newUser;
	}
	
	
	public List<String> getUserAsList(String username, String password) {
		
		Linkage l = new Linkage();
		List<String> newUserAsList = new LinkedList<>();
		
		
		try {
			Connection conn = DriverManager.getConnection(l.getDbUrl(), l.getDbUsername(), l.getDbPassword());
			String sql = "SELECT * FROM ers_users WHERE ers_username = ? AND ers_password = ?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			
			ResultSet rs = ps.executeQuery();			
			
			while(rs.next()) {
				newUserAsList.add(rs.getString(2));
				newUserAsList.add(rs.getString(3));
				newUserAsList.add(rs.getString(4));
				newUserAsList.add(rs.getString(5));
				newUserAsList.add(rs.getString(6));
				Integer intintint = rs.getInt(7);
				newUserAsList.add(intintint.toString());
				
			}
	                } catch (SQLException e) {
	        			logger.info("SQLException @ getUserAsList");
	        			e.printStackTrace();
	                }
		
		return newUserAsList;
	}


	
	
	
	
	
	
	
	
	
	
	
	
	public User translateUser(List<String> listString) {
		
		User testUser = new User(listString.get(0), listString.get(1), listString.get(2),
				listString.get(3), listString.get(4), Integer.parseInt(listString.get(5)));
		
		return testUser;
		
	}

	
	
	
	
	
	
//private String username;
//private String password;
//private String firstName;
//private String lastName;
//private String email;
//private int roleId;

}