package com.cjs.basicweb.modules;

import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.Transaction;

import com.cjs.basicweb.utility.PropertiesConstants;
import com.cjs.core.exception.AppException;
import com.googlecode.s2hibernate.struts2.plugin.annotations.TransactionTarget;

public abstract class BusinessLogic {

	@TransactionTarget
	private Transaction transaction;

	public void commit() throws AppException {
		try {
			transaction.commit();
		} catch (SecurityException | IllegalStateException | RollbackException
				| HeuristicMixedException | HeuristicRollbackException
				| SystemException e) {
			try {
				transaction.rollback();
			} catch (IllegalStateException | SystemException e1) {
				throw new AppException(
						PropertiesConstants.ERROR_ROLLBACK_BUSINESS_LOGIC);
			}
			throw new AppException(
					PropertiesConstants.ERROR_COMMIT_BUSINESS_LOGIC);
		}
	}
}
