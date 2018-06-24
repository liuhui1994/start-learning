package org.business.system.activity.model;

import java.math.BigDecimal;

import javax.persistence.Id;
import javax.persistence.Table;

import org.business.system.common.base.model.Entity;

@Table(name="t_system_rule")
public class Rule extends Entity{

	@Id
	private Long id;
	
	private String ruleNmae;
	
	private BigDecimal theOdds;
	
	private String awardType;
	
	private String prize;
	
	private String limitType;
	
	private String limitCount;
	
	private String remark;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRuleNmae() {
		return ruleNmae;
	}

	public void setRuleNmae(String ruleNmae) {
		this.ruleNmae = ruleNmae;
	}

	public BigDecimal getTheOdds() {
		return theOdds;
	}

	public void setTheOdds(BigDecimal theOdds) {
		this.theOdds = theOdds;
	}

	public String getAwardType() {
		return awardType;
	}

	public void setAwardType(String awardType) {
		this.awardType = awardType;
	}

	public String getPrize() {
		return prize;
	}

	public void setPrize(String prize) {
		this.prize = prize;
	}

	public String getLimitType() {
		return limitType;
	}

	public void setLimitType(String limitType) {
		this.limitType = limitType;
	}



	public String getLimitCount() {
		return limitCount;
	}

	public void setLimitCount(String limitCount) {
		this.limitCount = limitCount;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	

}
