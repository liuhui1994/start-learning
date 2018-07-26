package org.business.system.notice.service.impl;

import java.util.List;

import org.business.system.common.base.service.impl.BaseServiceImpl;
import org.business.system.common.em.BooleanType;
import org.business.system.common.em.NoticeState;
import org.business.system.common.exception.CommonErrorException;
import org.business.system.common.model.Notice;
import org.business.system.notice.mapper.NoticeMapper;
import org.business.system.notice.model.dto.NoticeDto;
import org.business.system.notice.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.entity.Example.Criteria;

@Service
public class NoticeServiceImpl extends BaseServiceImpl<Notice, Long> implements NoticeService
//,ITxTransaction
{
	
	@Autowired
	private NoticeMapper noticeMapper;
	

	@Override
    @Transactional
	public Notice findNoticeDetailById(Long id) {
		if(id==1) {
			throw new RuntimeException("测试分布式事务");
		}
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


	@Override
	public List<NoticeDto> getNoticeListByDao(NoticeDto noticeDto) {
		Example example = createaExample(noticeDto);
		return noticeMapper.selectNoticeDtoListByExample(example);
	}
	
	/**
	 * 生成查询的example
	 * @param userModel
	 * @return
	 */
	private Example createaExample(NoticeDto noticeDto){
		Example example = new Example(Notice.class);
        Criteria criteria = example.createCriteria();
		criteria.andEqualTo("status", BooleanType.FALSE);
		if(noticeDto!=null && noticeDto.getSender()!=null && !noticeDto.getSender().isEmpty()){
			criteria.andEqualTo("sender", noticeDto.getSender());
		}
		if(noticeDto!=null && noticeDto.getReceiver()!=null && !noticeDto.getReceiver().isEmpty()){
			criteria.andEqualTo("receiver", noticeDto.getReceiver());
		}
		if(noticeDto!=null && noticeDto.getNoticeType()!=null) {
			criteria.andEqualTo("noticeType", noticeDto.getNoticeType());
		}
		if(noticeDto!=null && noticeDto.getState()!=null) {
			criteria.andEqualTo("state", noticeDto.getState());
		}
		if(noticeDto!=null && noticeDto.getCreateDateStart()!=null) {
			criteria.andGreaterThanOrEqualTo("createDate", noticeDto.getCreateDateStart());
		}
		if(noticeDto!=null && noticeDto.getCreateDateEnd()!=null) {
			criteria.andLessThanOrEqualTo("createDate", noticeDto.getCreateDateEnd());
		}
		return example;
	}


	@Override
	@Transactional
	public void signRead(Long[] ids) {
		if(!ObjectUtils.isEmpty(ids)) {
		   for (Long id : ids) {
			  if(id!=null) {
				  Notice notice = noticeMapper.selectByPrimaryKey(id);	
				  if(notice!=null) {
					updateEntity(notice);  
					notice.setState(NoticeState.TRUE);
					int success = noticeMapper.updateByPrimaryKeySelective(notice);
					if(success<=0) {
						throw new CommonErrorException("00", "编辑失败");
					}
				  }
			  }
		   }
		}
	}

}
