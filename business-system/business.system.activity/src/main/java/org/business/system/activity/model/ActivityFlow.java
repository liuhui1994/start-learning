package org.business.system.activity.model;

import java.util.Date;

import javax.persistence.Table;

@Table(name="t_system_activity_flow")
public class ActivityFlow {
	
	private  Long id ;
	
	private  Long activityId;   //活动ID
	
	private  String activityName;//活动名称
	
	private  String flowType;//流水类型
	
	private  Long userId;//领取用户ID
	
	private String prize;//领取奖品
	
	private Boolean isClaim;//是否领取
	
	private String flowNo;//流水编号
	
	private Date createDate;//创建时间
	
	private Date claimDate;//领取时间
	
	private String prizeType;  //奖品类型

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

	public String getActivityName() {
		return activityName;
	}

	public void setActivityName(String activityName) {
		this.activityName = activityName;
	}

	public String getFlowType() {
		return flowType;
	}

	public void setFlowType(String flowType) {
		this.flowType = flowType;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getPrize() {
		return prize;
	}

	public void setPrize(String prize) {
		this.prize = prize;
	}

	public Boolean getIsClaim() {
		return isClaim;
	}

	public void setIsClaim(Boolean isClaim) {
		this.isClaim = isClaim;
	}

	public String getFlowNo() {
		return flowNo;
	}

	public void setFlowNo(String flowNo) {
		this.flowNo = flowNo;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getClaimDate() {
		return claimDate;
	}

	public void setClaimDate(Date claimDate) {
		this.claimDate = claimDate;
	}

	public String getPrizeType() {
		return prizeType;
	}

	public void setPrizeType(String prizeType) {
		this.prizeType = prizeType;
	}
	
	
	

}
