package com.cjs.basicweb.model.user;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import com.cjs.basicweb.model.GenericDao;
import com.cjs.basicweb.utility.PropertiesConstants;
import com.cjs.core.User;
import com.cjs.core.exception.AppException;

public class UserDao extends GenericDao<User> {

	public UserDao() {
		super(User.class);
	}

	public User getByUserId(String userId) throws AppException {

		if (userId == null || userId.trim().isEmpty()) {
			throw new AppException(
					PropertiesConstants.ERROR_PRIMARY_KEY_REQUIRED);
		}

		Criteria criteria = getSession().createCriteria(User.class);
		criteria.add(Restrictions.eq("userId", userId).ignoreCase());

		return (User) criteria.uniqueResult();
	}
}
