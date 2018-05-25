package org.business.system.notice.model;

import java.util.Date;

import javax.persistence.Table;

import org.business.system.common.base.model.Entity;

@Table(name="t_system_mobile_code")
public class MobileCode extends Entity{

	private String code;   //验证码
	
	private String mobile; //发送手机号
	
	private Date expireDate; //有效时间
	
	private String isValidate; //是否验证
	
	private String businessType;//发送业务类型

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public Date getExpireDate() {
		return expireDate;
	}

	public void setExpireDate(Date expireDate) {
		this.expireDate = expireDate;
	}

	public String getIsValidate() {
		return isValidate;
	}

	public void setIsValidate(String isValidate) {
		this.isValidate = isValidate;
	}

	public String getBusinessType() {
		return businessType;
	}

	public void setBusinessType(String businessType) {
		this.businessType = businessType;
	}
	
	
}
