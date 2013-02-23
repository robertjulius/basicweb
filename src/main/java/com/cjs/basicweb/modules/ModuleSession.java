package com.cjs.basicweb.modules;

import java.io.Serializable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ModuleSession implements Serializable {

	private static final long serialVersionUID = -8512026160335854664L;

	private Map<String, Object> map;

	private String moduleId;
	private String moduleName;

	public ModuleSession() {
		map = new ConcurrentHashMap<String, Object>();
	}

	public void clear() {
		map.clear();
	}

	public Object get(String key) {
		return map.get(key);
	}

	public String getModuleId() {
		return moduleId;
	}

	public String getModuleName() {
		return moduleName;
	}

	public void put(String key, Object value) {
		map.put(key, value);
	}

	public void setModuleId(String moduleId) {
		this.moduleId = moduleId;
	}

	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}
}
