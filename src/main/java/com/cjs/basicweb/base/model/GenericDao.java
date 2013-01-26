package com.cjs.basicweb.base.model;

public interface GenericDao<T> {

	public void create(T t);

	public void delete(Object id);

	public T getDetail(Object id);

	public void update(T t);
}
