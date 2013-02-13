package com.cjs.basicweb.model;

import org.hibernate.Session;

import com.googlecode.s2hibernate.struts2.plugin.annotations.SessionTarget;

public abstract class GenericDao {

	@SessionTarget
	protected Session session;
}
