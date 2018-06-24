package org.business.system.activity.service;

import java.util.List;

import org.business.system.activity.model.Activity;
import org.business.system.common.base.service.BaseService;

public interface ActivityService  extends BaseService<Activity, Long>{
	
	public Activity getActivityById(Long id);
	
	public List<Activity>  getActivityList(Activity activity);
	
	public void activityAward();

}
