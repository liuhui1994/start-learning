package org.business.system.notice.service;

import java.util.List;

import org.business.system.common.base.service.BaseService;
import org.business.system.common.model.Notice;
import org.business.system.notice.model.dto.NoticeDto;

public interface NoticeService extends BaseService<Notice, Long> {
	
	public Notice findNoticeDetailById(Long id);
	
	/**
	 * 通过dto查询消息列表
	 * @param noticeDto
	 * @return
	 */
	public List<NoticeDto> getNoticeListByDao(NoticeDto noticeDto);
	
	/**
	 * 标记消息已读
	 * @param ids
	 */
	public void signRead(Long ids[]);

}
