package com.cjs.basicweb.testhibernate;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.googlecode.s2hibernate.struts2.plugin.annotations.SessionTarget;
import com.googlecode.s2hibernate.struts2.plugin.annotations.TransactionTarget;
import com.opensymphony.xwork2.ActionSupport;

public class TestHibernateAction extends ActionSupport {

	private static final long serialVersionUID = 7984761719326443248L;

	@SessionTarget
	Session session;

	@TransactionTarget
	Transaction transaction;

}
