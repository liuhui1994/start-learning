package org.business.system.common.model;

import javax.persistence.Id;
import javax.persistence.Table;

import org.business.system.common.base.model.Entity;
import org.business.system.common.em.MemberState;
import org.business.system.common.em.MemberType;

@Table(name="t_system_member")
public class Member extends Entity {
	
	@Id
	private Long id;
	
	private String memberName;  //会员名称
	
	private String memberPhone; //会员联系方式
	
	private Long parentId; //父级id
	
	private MemberState memberState; //会员状态
	
	private String remark; //备注
	
	private MemberType memberType; //会员类型
	
	private String inviteCode;//邀请码
	
	private String memberNo; //会员编号
	
	private Long userId; //关联用户Id

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getMemberPhone() {
		return memberPhone;
	}

	public void setMemberPhone(String memberPhone) {
		this.memberPhone = memberPhone;
	}

	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	public MemberState getMemberState() {
		return memberState;
	}

	public void setMemberState(MemberState memberState) {
		this.memberState = memberState;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public MemberType getMemberType() {
		return memberType;
	}

	public void setMemberType(MemberType memberType) {
		this.memberType = memberType;
	}

	public String getInviteCode() {
		return inviteCode;
	}

	public void setInviteCode(String inviteCode) {
		this.inviteCode = inviteCode;
	}

	public String getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(String memberNo) {
		this.memberNo = memberNo;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}
	
	

}
