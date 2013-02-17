package com.cjs.basicweb.modules;

import org.hibernate.Session;

import com.googlecode.s2hibernate.struts2.plugin.util.HibernateSessionFactory;

public abstract class BusinessLogic {

	protected void beginTransaction() {
		HibernateSessionFactory.getSession().getTransaction().begin();
	}

	protected void commit() {
		HibernateSessionFactory.getSession().getTransaction().commit();
	}

	protected Session getSession() {
		return HibernateSessionFactory.getSession();
	}

	protected void rollback() {
		HibernateSessionFactory.getSession().getTransaction().rollback();
	}
}
