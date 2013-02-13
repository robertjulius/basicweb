package com.cjs.basicweb.model.accesspath;

import org.hibernate.Query;

import com.cjs.basicweb.model.GenericDao;
import com.cjs.basicweb.utility.PropertiesConstants;
import com.cjs.core.exception.AppException;

public class AccessPathDao extends GenericDao {

	public int deleteByModule(String moduleId) throws AppException {
		if (moduleId == null || moduleId.trim().isEmpty()) {
			throw new AppException(
					PropertiesConstants.ERROR_CRITERIA_KEY_REQUIRED);
		}

		Query query = session
				.createQuery("delete AccessPath accessPath where accessPath.moduleId = :moduleId");
		query.setString("moduleId", moduleId);

		return query.executeUpdate();
	}

}
