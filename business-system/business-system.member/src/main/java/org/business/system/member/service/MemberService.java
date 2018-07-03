package org.business.system.member.service;

import org.business.system.common.base.service.BaseService;
import org.business.system.member.model.Member;

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

}
