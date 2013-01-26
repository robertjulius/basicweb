package com.cjs.basicweb.base.model.user;

import com.cjs.core.User;

public class UserDaoDummy implements UserDao {

	public void create(User t) {
		// TODO Auto-generated method stub

	}

	public void delete(Object id) {
		// TODO Auto-generated method stub

	}

	public User getDetail(Object id) {
		User user = new UserImpl();
		user.setUserId("robertjulius");
		user.setPassword("1234");
		user.setUsername("Robert Julius");
		return user;
	}

	public void update(User t) {
		// TODO Auto-generated method stub

	}
}
