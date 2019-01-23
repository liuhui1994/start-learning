package org.business.system.common.base.service;

import java.util.Date;

import org.business.system.common.base.model.Entity;
import org.business.system.common.em.BooleanType;


public interface DefaultService {
	
	default void insertEntity(Entity entity) {
//		entity.setCreateDate(new Date());
//		entity.setCreator("admin");
//		entity.setModifier("admin");
//		entity.setModifyDate(new Date());
//		entity.setStatus(BooleanType.FALSE);
	}
	
	
	
	default void updateEntity(Entity entity) {
//		entity.setModifier("admin");
//		entity.setModifyDate(new Date());
	}

}
