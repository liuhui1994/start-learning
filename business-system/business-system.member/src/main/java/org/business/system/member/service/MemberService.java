package org.business.system.member.service;

import java.util.List;

import org.business.system.common.base.service.BaseService;
import org.business.system.member.model.Member;
import org.business.system.member.model.dto.MemberDto;

public interface MemberService extends BaseService<Member, Long> {
	
	/**
	 * 获取会员详情
	 * @param id
	 * @return
	 */
	public Member getMemberDetailById(Long id);
	
	/**
	 * 新增会员
	 * @param member
	 * @return
	 */
	public Member insertMember(Member member);
	
	
	/**
	 * 通过dto获取会员列表
	 * @param memberDto
	 * @return
	 */
	public List<MemberDto> getMemberListByDto(MemberDto memberDto);
	
	/**
	 * 修改会员信息
	 * @param uptMmeber
	 * @return
	 */
	public Member updateMember(Member uptMmeber);

}
