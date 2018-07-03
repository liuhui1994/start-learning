package org.business.system.member.controller;


import org.business.system.common.response.ResponseMessage;
import org.business.system.member.model.Member;
import org.business.system.member.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/manager")
public class MemberController {

	@Autowired
	private MemberService  memberService;
	
	@ApiOperation(value="通过Id获取会员详情", notes="通过Id获取会员详情" )
	@ApiImplicitParams({
		@ApiImplicitParam(name="id", value="会员id",required = true,dataType="Long",paramType="path"),
	})
	@RequestMapping(value ="/{id}", method = RequestMethod.GET)
	public ResponseMessage<Member> detail(@PathVariable(name="id") Long id) {
			return ResponseMessage.success(memberService.getMemberDetailById(id));
	}
	
	
	@ApiOperation(value="新增会员", notes="新增会员" )
	@ApiImplicitParams({
		@ApiImplicitParam(name="member", value="会员对象",required = true,dataType="Member",paramType="query"),
	})
	@RequestMapping(value ="/insert", method = RequestMethod.GET)
	public ResponseMessage<Member> insert(@RequestBody Member member) {
			return ResponseMessage.success(memberService.insertMember(member));
	}

}
