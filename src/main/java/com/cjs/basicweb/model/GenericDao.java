package com.cjs.basicweb.model;

import org.hibernate.Session;

import com.googlecode.s2hibernate.struts2.plugin.util.HibernateSessionFactory;

public abstract class GenericDao<T> {

	private Class<T> clazz;

	public GenericDao(Class<T> clazz) {
		this.clazz = clazz;
	}

	public T get(String primaryKey) {
		@SuppressWarnings("unchecked")
		T load = (T) getSession().get(clazz, primaryKey);
		return load;
	}

	public T load(String primaryKey) {
		@SuppressWarnings("unchecked")
		T load = (T) getSession().load(clazz, primaryKey);
		return load;
	}

	public void save(T entity) {
		getSession().save(entity);
	}

	protected Session getSession() {
		return HibernateSessionFactory.getSession();
	}
}
