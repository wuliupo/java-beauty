package com.beauty.system.bean;

import com.beauty.system.bean.base.BaseUser;



public class User extends BaseUser {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public User () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public User (java.lang.Integer id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public User (
		java.lang.Integer id,
		java.lang.String name) {

		super (
			id,
			name);
	}

/*[CONSTRUCTOR MARKER END]*/


}