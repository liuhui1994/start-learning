package org.business.system.activity.model.dto;

import java.util.Date;

import org.business.system.activity.model.ActivityClaimStatistics;

public class ActivityAwardDto {
	
	private Long activityId;
	
	private Long ruleId;
	
	private Long userId;
	
	private Date createDateStart;
	
	private Date createDateEnd;
	
	private String userIdEnc;
	
	private String code; //状态码
	
	private String message; //异常信息
	
	private String prize; //奖品
	
	private ActivityClaimStatistics  activityClaimStatistics;
	
	public Long getActivityId() {
		return activityId;
	}


	public void setActivityId(Long activityId) {
		this.activityId = activityId;
	}


	public String getUserIdEnc() {
		return userIdEnc;
	}


	public void setUserIdEnc(String userIdEnc) {
		this.userIdEnc = userIdEnc;
	}


	public String getCode() {
		return code;
	}


	public void setCode(String code) {
		this.code = code;
	}


	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
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


	public Date getCreateDateStart() {
		return createDateStart;
	}


	public void setCreateDateStart(Date createDateStart) {
		this.createDateStart = createDateStart;
	}


	public Date getCreateDateEnd() {
		return createDateEnd;
	}


	public void setCreateDateEnd(Date createDateEnd) {
		this.createDateEnd = createDateEnd;
	}


	public String getPrize() {
		return prize;
	}


	public void setPrize(String prize) {
		this.prize = prize;
	}


	public ActivityClaimStatistics getActivityClaimStatistics() {
		return activityClaimStatistics;
	}


	public void setActivityClaimStatistics(ActivityClaimStatistics activityClaimStatistics) {
		this.activityClaimStatistics = activityClaimStatistics;
	}



	
	

}
