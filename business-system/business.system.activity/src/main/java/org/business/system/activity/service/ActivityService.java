package org.business.system.activity.service;

import java.util.List;

import org.business.system.activity.model.ActiveityRule;
import org.business.system.activity.model.Activity;
import org.business.system.common.base.service.BaseService;

public interface ActivityService  extends BaseService<Activity, Long>{
	
	/**
	 * 获取活动详情
	 * @param id
	 * @return
	 */
	public Activity getActivityById(Long id);
	
	/**
	 * 获取活动列表
	 * @param activity
	 * @return
	 */
	public List<Activity>  getActivityList(Activity activity);
	
	/**
	 * 新增活动
	 * @param activity
	 * @return
	 */
	public Activity insertActivity(Activity activity);
	
	/**
	 * 编辑活动
	 * @param activity
	 * @return
	 */
	public Activity updateActivity(Activity activity);
	
	/**
	 * 活动奖励
	 */
	public void activityAward();
	
	/**
	 * 绑定活动规则
	 * @param activeityRuleList
	 * @return
	 */
	public int bindRule(Long activityId,List<Long> ruleId);

}
