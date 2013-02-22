package com.cjs.basicweb.modules;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.googlecode.s2hibernate.struts2.plugin.util.HibernateSessionFactory;

public abstract class BusinessLogic {

	protected void beginTransaction() throws HibernateException {
		HibernateSessionFactory.getSession().getTransaction().begin();
	}

	protected void commit() throws HibernateException {
		HibernateSessionFactory.getSession().getTransaction().commit();
	}

	protected Session getSession() throws HibernateException {
		return HibernateSessionFactory.getSession();
	}

	protected void rollback() throws HibernateException {
		HibernateSessionFactory.getSession().getTransaction().rollback();
	}
}
