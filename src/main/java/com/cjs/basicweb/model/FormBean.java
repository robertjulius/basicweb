package com.cjs.basicweb.model;

import java.io.Serializable;

import javax.persistence.Entity;

public abstract class FormBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	public Entity assignToEntity(Entity entity) {
		return assignToEntity(null, entity);
	}
	
	public Entity assignToEntity(String prefix, Entity entity) {
		/*
		 * TODO
		 */
		return null;
	}

}
