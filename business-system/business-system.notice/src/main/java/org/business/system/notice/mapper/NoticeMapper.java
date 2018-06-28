package org.business.system.notice.mapper;

import java.util.List;

import org.business.system.common.configuration.BaseMapper;
import org.business.system.common.model.Notice;
import org.business.system.notice.model.dto.NoticeDto;

import tk.mybatis.mapper.entity.Example;

public interface NoticeMapper extends BaseMapper<Notice> {
	
	public List<NoticeDto> selectNoticeDtoListByExample(Example example);

}
