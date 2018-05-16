package org.business.system.common.base.service;

import java.util.Date;

import org.business.system.common.base.model.Entity;

public interface DefaultService {
	
	default void insertEntity(Entity entity) {
		entity.setCreateDate(new Date());
		entity.setCreator("");
		entity.setModifier("");
		entity.setModifyDate(new Date());
		entity.setStatus(0);
	}
	
	
	
	default void updateEntity(Entity entity) {
		entity.setModifier("");
		entity.setModifyDate(new Date());
	}

}
