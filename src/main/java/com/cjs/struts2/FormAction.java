package com.cjs.struts2;

import java.util.Map;

import org.slf4j.LoggerFactory;

import com.cjs.basicweb.model.FormBean;
import com.cjs.basicweb.utility.PropertiesConstants;
import com.cjs.core.exception.AppException;
import com.opensymphony.xwork2.ModelDriven;

public abstract class FormAction<T> extends BaseAction implements
		ModelDriven<T> {

	private static final long serialVersionUID = -3643549719278354411L;

	private Class<T> clazz;

	public FormAction(Class<T> clazz) throws AppException {
		if (FormBean.class.isAssignableFrom(clazz)) {
			this.clazz = clazz;
		} else {
			throw new AppException(PropertiesConstants.ERROR_CREATE_FORM_BEAN);
		}
	}

	public final T getForm() {
		return getModel();
	}

	@Override
	public final T getModel() {

		T formBean = getFromModuleSession(clazz);

		if (formBean == null) {
			try {
				formBean = clazz.newInstance();
				getModuleSession().put(clazz.getName(), formBean);
				Map<String, Object> moduleSession = getModuleSession();
				System.out.println(moduleSession);
			} catch (InstantiationException e) {
				LoggerFactory.getLogger(getClass()).error(e.getMessage(), e);
			} catch (IllegalAccessException e) {
				LoggerFactory.getLogger(getClass()).error(e.getMessage(), e);
			}
		}

		return formBean;
	}

	private T getFromModuleSession(Class<T> clazz) {
		Object object = getModuleSession().get(clazz.getName());

		@SuppressWarnings("unchecked")
		T t = (T) object;
		return t;
	}
}
