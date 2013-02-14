package com.cjs.basicweb.modules;

import com.googlecode.s2hibernate.struts2.plugin.util.HibernateSessionFactory;

public abstract class BusinessLogic {

	protected void beginTransaction() {
		HibernateSessionFactory.getSession().getTransaction().begin();
	}

	protected void commit() {
		HibernateSessionFactory.getSession().getTransaction().commit();
	}

	protected void rollback() {
		HibernateSessionFactory.getSession().getTransaction().rollback();
	}
}
