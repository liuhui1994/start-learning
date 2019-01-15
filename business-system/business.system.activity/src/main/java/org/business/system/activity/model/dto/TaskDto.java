package org.business.system.activity.model.dto;

import org.business.system.activity.model.Task;

public class TaskDto extends Task {
	
   private Long userId;
   
   private String selectType;

public Long getUserId() {
	return userId;
}

public void setUserId(Long userId) {
	this.userId = userId;
}

public String getSelectType() {
	return selectType;
}

public void setSelectType(String selectType) {
	this.selectType = selectType;
}


   
   
	
	

}
