package com.chrispy.projectone.dao;

public class Linkage {
	
	private final static String dbUrl = System.getenv("CHRISPYPROJECTONEDB_URL");
	private final static String dbUsername = System.getenv("CHRISPYCOMMON_USERNAME");
	private final static String dbPassword = System.getenv("CHRISPYCOMMON_PASSWORD");
	
	public String getDbUrl() {
		return dbUrl;
	}

	public String getDbUsername() {
		return dbUsername;
	}

	public String getDbPassword() {
		return dbPassword;
	}

}
