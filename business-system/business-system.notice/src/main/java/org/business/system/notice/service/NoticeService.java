package org.business.system.notice.service;

import org.business.system.common.base.service.BaseService;
import org.business.system.notice.model.Notice;

public interface NoticeService extends BaseService<Notice, Long> {
	
	Notice findNoticeDetailById(Long id);

}
