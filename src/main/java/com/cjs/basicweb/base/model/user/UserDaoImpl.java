package com.cjs.basicweb.base.model.user;

import com.cjs.basicweb.base.model.GenericDao;
import com.cjs.core.User;

public class UserDaoImpl extends GenericDao<UserImpl> implements UserDao {

	@Override
	public User getDetail(Object username) {
		User user = null;
		user = (User) session
				.createQuery(
						"from UserImpl where LOWER(username) = LOWER('"
								+ username + "')").list().get(0);
		return user;
	}
}
