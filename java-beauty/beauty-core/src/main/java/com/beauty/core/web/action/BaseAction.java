package com.beauty.core.web.action;

import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.util.ServletContextAware;

import com.opensymphony.xwork2.ActionSupport;

public abstract class BaseAction extends ActionSupport implements SessionAware, ServletRequestAware,
		ServletResponseAware, ServletContextAware {

	private static final long serialVersionUID = -8585859009406975516L;

	@SuppressWarnings("rawtypes")
	protected Map session;

	protected HttpServletRequest request;

	protected HttpServletResponse response;

	protected ServletContext servletContext;

	protected static final String FORWARDJSP = "forwardJsp";

	protected String forwardJsp;

	@SuppressWarnings("rawtypes")
	public void setSession(Map session) {
		this.session = session;
	}

	public String getForwardJsp() {
		return forwardJsp;
	}

	public void setForwardJsp(String forwardJsp) {
		this.forwardJsp = forwardJsp;
	}

	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
	}

	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}

	public void setServletContext(ServletContext servletContext) {
		this.servletContext = servletContext;
	}

}
