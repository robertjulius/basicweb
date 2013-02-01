package com.cjs.basicweb.applets;

import java.util.TreeMap;


public class Privilege {
    private String id;
    private String name;
    private String parentId;
    private String action;
    private TreeMap<String, Privilege> childs;
    
    public Privilege(String id, String name, String parentId, String action) {
    	this.id = id;
    	this.name = name;
    	this.parentId = parentId;
    	this.action = action;
    	this.childs = new TreeMap<String, Privilege>();
    }
    
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}
	
	public void addChild(Privilege privilege) {
		childs.put(privilege.getId(), privilege);
	}

	public TreeMap<String, Privilege> getChilds() {
		return childs;
	}
	
	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	@Override
	public String toString() {
		return getName();
	}
}
