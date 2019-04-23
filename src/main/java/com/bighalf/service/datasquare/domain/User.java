package com.bighalf.service.datasquare.domain;

import java.util.HashMap;

/**
 * @author Tao Zhong
 *
 *         Jun 16, 2015
 */
public class User {
	private String userId;
	private HashMap<String, String> userAccessToken;
	
	/*
	 * 
	 * A HashMap to put all the Data Square of this user.
	 * 
	 * @param Integer is Data Square ID
	 */
	private HashMap<String, DataSquare> dataSquare = new HashMap<String, DataSquare>();

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public HashMap<String, String> getUserAccessToken() {
		return userAccessToken;
	}

	public void setUserAccessToken(HashMap<String, String> userAccessToken) {
		this.userAccessToken = userAccessToken;
	}

	public HashMap<String, DataSquare> getDataSquare() {
		return dataSquare;
	}

	public void setDataSquare(HashMap<String, DataSquare> dataSquare) {
		this.dataSquare = dataSquare;
	}

}
