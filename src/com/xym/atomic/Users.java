package com.xym.atomic;

/**
 *desc
 *
 *@author xym
 *@create 2017-04-27-16:48
 */
public class Users {

	private String username;
	private String password;

	public Users(String username, String password) {
		this.username = username;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Users{" + "username='" + username + '\'' + ", password='" + password + '\'' + '}';
	}
}
