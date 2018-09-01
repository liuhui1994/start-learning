package org.business.system.activity.model;

import java.math.BigDecimal;

import javax.persistence.Id;
import javax.persistence.Table;

import org.business.system.activity.em.ActivityPrizeType;
import org.business.system.activity.em.RuleLimitType;
import org.business.system.common.base.model.Entity;

@Table(name="t_system_rule")
public class Rule extends Entity{

	@Id
	private Long id;
	
	private String ruleNmae;   //规则名称
	
	private BigDecimal theOdds;  //中奖概率
	
	private ActivityPrizeType awardType;  //奖励类型
	
	private String prize;     //奖品
	
	private RuleLimitType limitType;  //限制类型
	
	private Long limitCount; //限制数量
	
	private String remark;  //备注

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

	
	public String getPrize() {
		return prize;
	}

	public void setPrize(String prize) {
		this.prize = prize;
	}


	public Long getLimitCount() {
		return limitCount;
	}

	public void setLimitCount(Long limitCount) {
		this.limitCount = limitCount;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public ActivityPrizeType getAwardType() {
		return awardType;
	}

	public void setAwardType(ActivityPrizeType awardType) {
		this.awardType = awardType;
	}

	public RuleLimitType getLimitType() {
		return limitType;
	}

	public void setLimitType(RuleLimitType limitType) {
		this.limitType = limitType;
	}
	
	

}
