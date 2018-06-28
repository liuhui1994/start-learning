package org.business.system.notice.model.dto;

import java.util.Date;

import org.business.system.common.model.Notice;

public class NoticeDto extends Notice{
	
	private Date createDateStart;
	
	private Date createDateEnd;

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
	
	

}
