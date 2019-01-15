package org.business.system.member.service.impl;

import java.util.List;

import org.business.system.common.base.service.DefaultService;
import org.business.system.common.base.service.impl.BaseServiceImpl;
import org.business.system.common.cloud.user.UserCloudService;
import org.business.system.common.em.BooleanType;
import org.business.system.common.em.MemberState;
import org.business.system.common.em.MemberType;
import org.business.system.common.exception.CommonErrorException;
import org.business.system.common.model.Member;
import org.business.system.common.model.dto.UserModelDto;
import org.business.system.common.response.ResponseMessage;
import org.business.system.common.util.PatternUtils;
import org.business.system.common.util.RandomUtils;
import org.business.system.member.mapper.MemberMapper;
import org.business.system.member.model.dto.MemberDto;
import org.business.system.member.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.entity.Example.Criteria;

@Service
public class MemberServiceImpl extends BaseServiceImpl<Member, Long> implements MemberService,DefaultService {
	
	@Autowired
	private MemberMapper  memberMapper;
	
	@Autowired
	private UserCloudService  userCloudService;

	@Override
	public Member getMemberDetailById(Long id) {
		return memberMapper.selectByPrimaryKey(id);
	}
	
	/**
	 * 生成查询的example
	 * @param userModel
	 * @return
	 */
	private Example createaExample(MemberDto memberDto){
		Example example = new Example(Member.class);
        Criteria criteria = example.createCriteria();
        
		criteria.andCondition("a.status=", BooleanType.FALSE.name());
		return example;
	}

	@Override
	@Transactional
	public Member insertMember(Member member) {
		Member newMember = new Member();
		String mobile = member.getMemberPhone();
		String memberName = member.getMemberName();
        if(!ObjectUtils.isEmpty(mobile)) {
        	if(!PatternUtils.validateMobile(mobile)){
        		throw new CommonErrorException("01", "手机号不合法");
        	}
        	newMember.setMemberPhone(mobile);
        }else {
        	throw new CommonErrorException("01", "手机号不能为空");
        }
        if(!ObjectUtils.isEmpty(memberName)) {
        	newMember.setMemberName(memberName);
        }else {
        	newMember.setMemberName(mobile);
        }
        insertEntity(newMember);
        String code = RandomUtils.generateString(8);
        
        //判断当前邀请码是否存在   
		if(getMemberDetailByCode(code)!=null) {
			throw new CommonErrorException("03", "当前邀请码已存在");
		}

        newMember.setInviteCode(code); //随机生成会员邀请码
        newMember.setMemberNo("1255");
        newMember.setMemberState(MemberState.OPEN);
        newMember.setMemberType(MemberType.OPEN);
 
        int success = memberMapper.insertUseGeneratedKeys(newMember);
        if(success<=0) {
        	throw  new CommonErrorException("00", "新增失败");
        }
        UserModelDto  userModel = new UserModelDto();
        userModel.setPhone(mobile);
        ResponseMessage<UserModelDto> resultModel = userCloudService.register(userModel);
        if(resultModel==null || !resultModel.getCode().equals("200")) {
        	throw  new CommonErrorException("00", resultModel.getMessage());
        }
        Long userId = resultModel.getData().getId();
        newMember.setUserId(userId);
        success = memberMapper.updateByPrimaryKeySelective(newMember);
        if(success<=0) {
        	throw  new CommonErrorException("00", "修改失败");
        }
		return newMember;
	}

	@Override
	public List<MemberDto> getMemberListByDto(MemberDto memberDto) {
		Example example  = createaExample(memberDto);
		return memberMapper.selectMemberListByExample(example);
	}

	@Override
	@Transactional
	public Member updateMember(Member uptMmeber) {
        if(uptMmeber==null || uptMmeber.getId()==null) {
        	throw new CommonErrorException("00", "会员唯一标识必须携带");
        }
        Long memberId  = uptMmeber.getId();
        Member member = memberMapper.selectByPrimaryKey(memberId);
        String memberName = uptMmeber.getMemberName();
        String memberPhone = uptMmeber.getMemberPhone();
        String remark = uptMmeber.getRemark();
        if(!ObjectUtils.isEmpty(memberName)) {
          member.setMemberName(memberName);
        }
        if(!ObjectUtils.isEmpty(memberPhone)) {
        	member.setMemberPhone(memberPhone);
        }
        if(!ObjectUtils.isEmpty(remark)) {
        	member.setRemark(remark);
        }
        int success = memberMapper.updateByPrimaryKeySelective(member);
        if(success<=0) {
        	throw new CommonErrorException("00", "修改失败");
        }
		return member;
	}

	@Override
	public Member getMemberDetailByCode(String code) {
		if(ObjectUtils.isEmpty(code)) {
			throw new CommonErrorException("01", "邀请码不能为空");
		}
		Example example = new Example(Member.class);
        Criteria criteria = example.createCriteria();
        criteria.andEqualTo("inviteCode", code);
        List<Member> memberList = memberMapper.selectByExample(example);
        if(memberList==null || memberList.isEmpty()) {
        	return null;
        }
    	return memberList.get(0);
	}

}
