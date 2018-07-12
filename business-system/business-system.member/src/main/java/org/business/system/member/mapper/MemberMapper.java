package org.business.system.member.mapper;

import java.util.List;

import org.business.system.common.configuration.BaseMapper;
import org.business.system.common.model.Member;
import org.business.system.member.model.dto.MemberDto;

import tk.mybatis.mapper.entity.Example;

public interface MemberMapper extends BaseMapper<Member> {
	
	List<MemberDto> selectMemberListByExample(Example example);

}
