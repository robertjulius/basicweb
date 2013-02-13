package com.cjs.basicweb.model;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;

import com.cjs.basicweb.utility.PropertiesConstants;
import com.cjs.core.exception.AppException;
import com.cjs.core.exception.UserException;

public abstract class FormBean implements Serializable {

	private static final long serialVersionUID = 1L;

	public <T> void assignFromEntity(String prefix, T entity)
			throws AppException {
		HashMap<String, Object> hashMap = toHashMap(prefix, entity);
		fromHashMap(hashMap);
	}

	public <T> void assignFromEntity(T entity) throws AppException {
		assignFromEntity(null, entity);
	}

	public <T> void assignToEntity(String prefix, T entity) {

		Class<?> clazz = entity.getClass();
		System.out.println(clazz.getName());
	}

	public <T> void assignToEntity(T entity) {
		assignToEntity(null, entity);
	}

	public void validate() throws AppException, UserException {
		
	}

	private void fromHashMap(HashMap<String, Object> hashMap)
			throws AppException {
		try {
			Method[] methods = this.getClass().getMethods();
			for (Method method : methods) {
				if (method.getName().startsWith("set")) {
					if (method.getParameterTypes().length != 1) {
						throw new AppException(
								PropertiesConstants.ERROR_REFLECTION);
					}

					String name = method.getName().substring(3, 4)
							.toLowerCase()
							+ method.getName().substring(4);

					if (hashMap.containsKey(name)) {
						Object value = hashMap.get(name);
						if (value != null
								&& !method.getParameterTypes()[0]
										.isAssignableFrom(value.getClass())) {
							throw new AppException(
									PropertiesConstants.ERROR_REFLECTION);
						}
						method.invoke(this, value);
					}
				}
			}
		} catch (IllegalAccessException e) {
			throw new AppException(e);
		} catch (IllegalArgumentException e) {
			throw new AppException(e);
		} catch (InvocationTargetException e) {
			throw new AppException(e);
		}
	}
	
	private <T> HashMap<String, Object> toHashMap(String prefix, T entity)
			throws AppException {
		try {
			HashMap<String, Object> hashMap = new HashMap<>();
			Method[] methods = entity.getClass().getMethods();
			for (Method method : methods) {
				if (method.getName().startsWith("get")) {
					if (method.getParameterTypes().length != 0) {
						throw new AppException(
								PropertiesConstants.ERROR_REFLECTION);
					}

					Object value = method.invoke(entity);
					String name = prefix + method.getName().substring(3);
					hashMap.put(name, value);
				}
			}
			return hashMap;
		} catch (IllegalAccessException e) {
			throw new AppException(e);
		} catch (IllegalArgumentException e) {
			throw new AppException(e);
		} catch (InvocationTargetException e) {
			throw new AppException(e);
		}
	}
}
