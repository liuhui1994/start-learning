package org.business.system.notice.service.impl;

import org.business.system.common.base.service.impl.BaseServiceImpl;
import org.business.system.notice.mapper.NoticeMapper;
import org.business.system.notice.model.Notice;
import org.business.system.notice.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NoticeServiceImpl extends BaseServiceImpl<Notice, Long> implements NoticeService{
	
	@Autowired
	private NoticeMapper noticeMapper;

	@Override
	public Notice findNoticeDetailById(Long id) {
//		Notice notice  = new Notice();
//		notice.setNoticeType(1);
//		notice.setBusinessNo("123");
//		notice.setNoticeTitle("123");
//		notice.setNoticeDesc("asd");
//		notice.setNoticeUrl("www.baidu.com");
//		notice.setState(1);
//		notice.setCreateDate(new Date());
//		notice.setModifyDate(new Date());
//		notice.setStatus(1);
//		notice.setCreator("liuhui");
//		notice.setModifier("liuhui");
//		notice.setSender("asd");
//		notice.setReceiver("312312");
//		noticeMapper.insertSelective(notice);
//		noticeMapper.insert(notice);
		return noticeMapper.selectByPrimaryKey(id);
	}

}
