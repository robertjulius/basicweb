package com.cjs.basicweb.base.model;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public abstract class Trackable implements Serializable {

	private static final long serialVersionUID = -490441473844263342L;

	@Column(name = "create_by", nullable = false)
	private String createBy;
	
	@Column(name = "create_by", nullable = false)
	private Timestamp createDate;

	public String getCreateBy() {
		return createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	public Timestamp getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}

	public String getUpdateBy() {
		return updateBy;
	}

	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}

	public Timestamp getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Timestamp updateDate) {
		this.updateDate = updateDate;
	}

	private String updateBy;
	private Timestamp updateDate;

}
