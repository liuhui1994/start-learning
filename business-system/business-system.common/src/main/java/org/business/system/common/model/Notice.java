package org.business.system.common.model;

import javax.persistence.Id;
import javax.persistence.Table;

import org.business.system.common.base.model.Entity;
import org.business.system.common.em.NoticeState;
import org.business.system.common.em.NoticeType;

@Table(name="t_system_notice")
public class Notice extends Entity{

	@Id
	private Long id;
	
	private NoticeType noticeType;
	
	private String businessNo;
	
	private String noticeTitle;
	
	private String noticeDesc;
	
	private String noticeUrl;
	
	private NoticeState state;
	
	private String sender;
	
	private String receiver;
	


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	public NoticeType getNoticeType() {
		return noticeType;
	}

	public void setNoticeType(NoticeType noticeType) {
		this.noticeType = noticeType;
	}

	public String getBusinessNo() {
		return businessNo;
	}

	public void setBusinessNo(String businessNo) {
		this.businessNo = businessNo;
	}

	public String getNoticeTitle() {
		return noticeTitle;
	}

	public void setNoticeTitle(String noticeTitle) {
		this.noticeTitle = noticeTitle;
	}

	public String getNoticeDesc() {
		return noticeDesc;
	}

	public void setNoticeDesc(String noticeDesc) {
		this.noticeDesc = noticeDesc;
	}

	public String getNoticeUrl() {
		return noticeUrl;
	}

	public void setNoticeUrl(String noticeUrl) {
		this.noticeUrl = noticeUrl;
	}



	public NoticeState getState() {
		return state;
	}

	public void setState(NoticeState state) {
		this.state = state;
	}

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public String getReceiver() {
		return receiver;
	}

	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}

	
	
	
}
