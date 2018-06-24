package org.business.system.activity.model;

import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="t_system_activity_rule")
public class ActiveityRule {

	@Id
	private Long id;
	
	private Long activityId; 
	
    private Long ruleId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getActivityId() {
		return activityId;
	}

	public void setActivityId(Long activityId) {
		this.activityId = activityId;
	}

	public Long getRuleId() {
		return ruleId;
	}

	public void setRuleId(Long ruleId) {
		this.ruleId = ruleId;
	}
    
    
}
