package com.cjs.struts2;

import java.util.Map;

import org.slf4j.LoggerFactory;

import com.opensymphony.xwork2.ModelDriven;

public abstract class FormAction<T> extends BaseAction implements
		ModelDriven<T> {

	private static final long serialVersionUID = -3643549719278354411L;

	private Class<T> clazz;

	public FormAction(Class<T> clazz) {
		this.clazz = clazz;
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
