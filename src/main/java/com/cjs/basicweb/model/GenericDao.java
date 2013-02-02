package com.cjs.basicweb.model;

import javax.transaction.Transaction;

import org.hibernate.Session;

import com.googlecode.s2hibernate.struts2.plugin.annotations.SessionTarget;
import com.googlecode.s2hibernate.struts2.plugin.annotations.TransactionTarget;

public abstract class GenericDao<T> {

	@SessionTarget
	protected Session session;
	
	@TransactionTarget
	protected Transaction transaction;
}
