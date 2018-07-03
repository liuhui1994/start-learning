package org.business.system.member.service.impl;

import java.util.Date;

import org.business.system.common.base.service.impl.BaseServiceImpl;
import org.business.system.common.cloud.user.UserCloudService;
import org.business.system.common.em.BooleanType;
import org.business.system.common.exception.CommonErrorException;
import org.business.system.common.util.PatternUtils;
import org.business.system.member.em.MemberState;
import org.business.system.member.em.MemberType;
import org.business.system.member.mapper.MemberMapper;
import org.business.system.member.model.Member;
import org.business.system.member.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

@Service
public class MemberServiceImpl extends BaseServiceImpl<Member, Long> implements MemberService {
	
	@Autowired
	private MemberMapper  memberMapper;
	
	@Autowired
	private UserCloudService  userCloudService;

	@Override
	public Member getMemberDetailById(Long id) {
		return memberMapper.selectByPrimaryKey(id);
	}

	@Override
	@Transactional
	public Member insertMember(Member member) {
		Member newMember = new Member();
		String mobile = member.getMemberPhone();
        if(!ObjectUtils.isEmpty(mobile)) {
        	if(!PatternUtils.validateMobile(mobile)){
        		throw new CommonErrorException("01", "手机号不合法");
        	}
        	newMember.setMemberPhone(mobile);
        }else {
        	throw new CommonErrorException("01", "手机号不能为空");
        }
        
        newMember.setCreateDate(new Date());
        newMember.setModifyDate(new Date());
        newMember.setCreator("admin");
        newMember.setModifier("admin");
        newMember.setInviteCode("123123123"); //随机生成会员邀请码
        newMember.setMemberName(mobile);
        newMember.setMemberNo("");
        newMember.setMemberState(MemberState.OPEN);
        newMember.setMemberType(MemberType.OPEN);
        newMember.setStatus(BooleanType.FALSE);
//        newMember.setUserId();
        
		return null;
	}

}
