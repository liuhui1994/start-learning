package org.business.system.common.base.model;

import java.util.Date;

import org.business.system.common.em.BooleanType;

public class Entity {
	
	
	private Date createDate;
	
	private Date modifyDate;
	
	private BooleanType status;
	
	private String creator;
	
	private String modifier;



	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getModifyDate() {
		return modifyDate;
	}

	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}

	

	public BooleanType getStatus() {
		return status;
	}

	public void setStatus(BooleanType status) {
		this.status = status;
	}

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public String getModifier() {
		return modifier;
	}

	public void setModifier(String modifier) {
		this.modifier = modifier;
	}
	
	
	

}
