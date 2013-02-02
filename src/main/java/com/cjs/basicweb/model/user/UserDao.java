package com.cjs.basicweb.model.user;

import java.util.List;

import com.cjs.basicweb.model.GenericDao;
import com.cjs.basicweb.utility.PropertiesConstants;
import com.cjs.core.User;
import com.cjs.core.exception.AppException;

public class UserDao extends GenericDao<SimpleUser> {

	public User getDetail(String userId) throws AppException {
		User user = null;

		@SuppressWarnings("unchecked")
		List<User> users = session.createQuery(
				"from SimpleUser where LOWER(user_id) = LOWER('" + userId
						+ "')").list();

		if (users.size() > 1) {
			throw new AppException(
					PropertiesConstants.ERROR_INCONSISTENT_DATABASE);
		} else if (!users.isEmpty()) {
			user = users.get(0);
		}

		return user;
	}
}
