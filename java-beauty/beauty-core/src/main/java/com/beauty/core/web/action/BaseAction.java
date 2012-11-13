package com.beauty.core.web.action;

import com.opensymphony.xwork2.ActionSupport;

public class BaseAction extends ActionSupport {

	private static final long serialVersionUID = -8585859009406975516L;
	
	protected static final String FORWARDJSP = "forwardJsp";
	
	protected String forwardJsp;

	public String getForwardJsp() {
		return forwardJsp;
	}

	public void setForwardJsp(String forwardJsp) {
		this.forwardJsp = forwardJsp;
	}
	
}
