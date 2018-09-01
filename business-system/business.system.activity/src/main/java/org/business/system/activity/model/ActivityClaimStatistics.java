package org.business.system.activity.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Table;

@Table(name="t_system_activity_claim_statistics")
public class ActivityClaimStatistics {
	
	private Long id;
	
	private Long activityId;
	
	private Long ruleId;
	
	private Long userId;
	
	private Long claimNum;
	
	private Long claimNumByDay;
	
	private Long claimNumByWeek;
	
	private Long claimNumByHour;
	
	private Long claimNumByYear;
	
	private BigDecimal  claimAmount;
	
	private Date createDate;

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

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getClaimNum() {
		return claimNum;
	}

	public void setClaimNum(Long claimNum) {
		this.claimNum = claimNum;
	}

	public Long getClaimNumByDay() {
		return claimNumByDay;
	}

	public void setClaimNumByDay(Long claimNumByDay) {
		this.claimNumByDay = claimNumByDay;
	}

	public Long getClaimNumByWeek() {
		return claimNumByWeek;
	}

	public void setClaimNumByWeek(Long claimNumByWeek) {
		this.claimNumByWeek = claimNumByWeek;
	}

	public Long getClaimNumByHour() {
		return claimNumByHour;
	}

	public void setClaimNumByHour(Long claimNumByHour) {
		this.claimNumByHour = claimNumByHour;
	}

	public Long getClaimNumByYear() {
		return claimNumByYear;
	}

	public void setClaimNumByYear(Long claimNumByYear) {
		this.claimNumByYear = claimNumByYear;
	}

	public BigDecimal getClaimAmount() {
		return claimAmount;
	}

	public void setClaimAmount(BigDecimal claimAmount) {
		this.claimAmount = claimAmount;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	
	
	
	
	
	
	
	
	

}
