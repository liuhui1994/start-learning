package org.business.system.activity.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Id;
import javax.persistence.Table;

import org.business.system.activity.em.ActivityState;
import org.business.system.activity.em.ActivityType;
import org.business.system.common.base.model.Entity;

@Table(name="t_system_activity")
public class Activity extends Entity {
	@Id
	private Long id;
	
	private ActivityType activityType;  //活动类型
	
	private String activityName;       //活动名称
	
	private Date limitDateStart;      //限制开始时间
	
	private Date limitDateEnd;       //限制结束时间
	
	private String limitTimeArea;   //限制时间区间
	
	private BigDecimal budget;     //预算
	
	private ActivityState activityState;  //活动状态
	
	private String activityNo;    //活动编号
	
	private String remark;    //备注

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ActivityType getActivityType() {
		return activityType;
	}

	public void setActivityType(ActivityType activityType) {
		this.activityType = activityType;
	}

	public String getActivityName() {
		return activityName;
	}

	public void setActivityName(String activityName) {
		this.activityName = activityName;
	}



	public Date getLimitDateStart() {
		return limitDateStart;
	}

	public void setLimitDateStart(Date limitDateStart) {
		this.limitDateStart = limitDateStart;
	}

	public Date getLimitDateEnd() {
		return limitDateEnd;
	}

	public void setLimitDateEnd(Date limitDateEnd) {
		this.limitDateEnd = limitDateEnd;
	}

	public String getLimitTimeArea() {
		return limitTimeArea;
	}

	public void setLimitTimeArea(String limitTimeArea) {
		this.limitTimeArea = limitTimeArea;
	}

	public BigDecimal getBudget() {
		return budget;
	}

	public void setBudget(BigDecimal budget) {
		this.budget = budget;
	}

	public ActivityState getActivityState() {
		return activityState;
	}

	public void setActivityState(ActivityState activityState) {
		this.activityState = activityState;
	}

	public String getActivityNo() {
		return activityNo;
	}

	public void setActivityNo(String activityNo) {
		this.activityNo = activityNo;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	
	
	
	

}
