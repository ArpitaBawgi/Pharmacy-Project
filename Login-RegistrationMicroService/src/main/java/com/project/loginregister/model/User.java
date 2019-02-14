package com.project.loginregister.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "userlist")
public class User {

	@Id
	private String emailId;
	//private String userID;
	private String userName;
	private String password;

	public User() {

	}

	public User( String emailId, String userName, String password) {
		super();
		//this.userID = userID;
		this.userName = userName;
		this.password = password;
		this.emailId=emailId;
	}

	@Override
	public String toString() {
		return "User [ userName=" + userName + ", password=" + password + ",emailId="+emailId+"]";
	}

	/*public String getUserID() {
		return userID;
	}*/

	/*public void setUserID(String userID) {
		this.userID = userID;
	}*/

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

}

