package org.business.system.common.base.model;

import java.util.Date;

import org.business.system.common.em.BooleanType;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Entity {
	
	
	private Date createDate;
	
	private Date modifyDate;
	
	@JsonIgnore
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
