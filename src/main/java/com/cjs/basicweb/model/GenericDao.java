package com.cjs.basicweb.model;

import org.hibernate.Session;

import com.googlecode.s2hibernate.struts2.plugin.util.HibernateSessionFactory;

public abstract class GenericDao {

	protected Session getSession() {
		return HibernateSessionFactory.getSession();
	}
}
