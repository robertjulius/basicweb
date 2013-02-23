package com.cjs.basicweb.modules;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.cjs.core.exception.AppException;
import com.googlecode.s2hibernate.struts2.plugin.util.HibernateSessionFactory;

public abstract class BusinessLogic {

	protected void beginTransaction() throws AppException {
		try {
			HibernateSessionFactory.getSession().getTransaction().begin();
		} catch (HibernateException e) {
			throw new AppException(e);
		}
	}

	protected void commit() throws AppException {
		try {
			HibernateSessionFactory.getSession().getTransaction().commit();
		} catch (HibernateException e) {
			throw new AppException(e);
		}
	}

	protected Session getSession() throws AppException {
		try {
			return HibernateSessionFactory.getSession();
		} catch (HibernateException e) {
			throw new AppException(e);
		}
	}

	protected void rollback() throws AppException {
		try {
			HibernateSessionFactory.getSession().getTransaction().rollback();
		} catch (HibernateException e) {
			throw new AppException(e);
		}
	}
}
