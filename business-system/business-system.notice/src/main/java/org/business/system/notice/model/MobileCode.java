package org.business.system.notice.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Id;
import javax.persistence.Table;

import org.business.system.common.base.model.Entity;
import org.business.system.common.em.BooleanType;
import org.business.system.common.em.BusinessType;

@Table(name="t_system_mobile_code")
public class MobileCode extends Entity implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	private Long id;

	private String code;   //验证码
	
	private String mobile; //发送手机号
	
	private Date expireDate; //有效时间
	
	private BooleanType isValidate; //是否验证
	
	private BusinessType businessType;//发送业务类型

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	public BooleanType getIsValidate() {
		return isValidate;
	}

	public void setIsValidate(BooleanType isValidate) {
		this.isValidate = isValidate;
	}

	public BusinessType getBusinessType() {
		return businessType;
	}

	public void setBusinessType(BusinessType businessType) {
		this.businessType = businessType;
	}


	
	
}
