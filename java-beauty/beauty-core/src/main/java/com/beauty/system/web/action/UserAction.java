package com.beauty.system.web.action;

import com.beauty.core.web.action.BaseAction;

public class UserAction extends BaseAction {

	private static final long serialVersionUID = -607559614395366701L;

	private String username;
	
	private String password;

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
	
	public String login()
	{
		System.out.println(this.getUsername());
		System.out.println(this.getPassword());
		return SUCCESS;
	}
	
}
