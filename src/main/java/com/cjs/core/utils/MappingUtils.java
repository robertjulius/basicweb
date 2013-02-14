package com.cjs.core.utils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.cjs.basicweb.utility.PropertiesConstants;
import com.cjs.core.exception.AppException;

public class MappingUtils {

	public static <T> T mapToPojo(Map<String, Object> map, Class<T> clazz)
			throws AppException {
		try {
			T newInstance = clazz.newInstance();
			mapToPojo(map, newInstance);
			return newInstance;
		} catch (InstantiationException e) {
			throw new AppException(e);
		} catch (IllegalAccessException e) {
			throw new AppException(e);
		}
	}

	public static <T> void mapToPojo(Map<String, Object> map, T pojo)
			throws AppException {
		try {
			Method[] methods = pojo.getClass().getMethods();
			for (Method method : methods) {
				if (method.getName().startsWith("set")) {
					if (method.getParameterTypes().length != 1) {
						throw new AppException(
								PropertiesConstants.ERROR_REFLECTION);
					}

					String name = method.getName().substring(3, 4)
							.toLowerCase()
							+ method.getName().substring(4);

					if (map.containsKey(name)) {
						Object value = map.get(name);
						if (value != null
								&& !method.getParameterTypes()[0]
										.isAssignableFrom(value.getClass())) {
							throw new AppException(
									PropertiesConstants.ERROR_REFLECTION);
						}
						method.invoke(pojo, value);
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

	public static Map<String, Object> pojoToMap(Object pojo)
			throws AppException {
		try {
			Map<String, Object> map = new HashMap<>();
			Method[] methods = pojo.getClass().getMethods();
			for (Method method : methods) {
				if (method.getName().startsWith("get")) {
					if (method.getParameterTypes().length != 0) {
						throw new AppException(
								PropertiesConstants.ERROR_REFLECTION);
					}

					Object value = method.invoke(pojo);
					String name = method.getName().substring(3, 4)
							.toLowerCase()
							+ method.getName().substring(4);
					map.put(name, value);
				}
			}
			return map;
		} catch (IllegalAccessException e) {
			throw new AppException(e);
		} catch (IllegalArgumentException e) {
			throw new AppException(e);
		} catch (InvocationTargetException e) {
			throw new AppException(e);
		}
	}

	public static List<Map<String, Object>> resultSetToMap(ResultSet resultSet)
			throws AppException, SQLException {

		List<Map<String, Object>> result = new ArrayList<>();
		List<String> columnNames = new ArrayList<>();

		ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
		int count = resultSetMetaData.getColumnCount();
		for (int i = 0; i < count; ++i) {
			columnNames.add(resultSetMetaData.getColumnName(i));
		}

		while (resultSet.next()) {
			Map<String, Object> map = new HashMap<>();
			for (String columnName : columnNames) {
				map.put(columnName, resultSet.getObject(columnName));
			}
			result.add(map);
		}
		return result;
	}

	public static <T> List<T> resultSetToPojo(ResultSet resultSet,
			Class<T> clazz) throws AppException, SQLException {
		List<T> pojos = new ArrayList<>();
		List<Map<String, Object>> maps = resultSetToMap(resultSet);
		for (Map<String, Object> map : maps) {
			T pojo = mapToPojo(map, clazz);
			pojos.add(pojo);
		}
		return pojos;
	}
}
