package org.business.system.member.controller;


import java.util.List;

import org.business.system.common.model.Member;
import org.business.system.common.response.ResponseMessage;
import org.business.system.member.model.dto.MemberDto;
import org.business.system.member.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

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
	
	@ApiOperation(value="通过邀请码获取会员详情", notes="通过邀请码获取会员详情" )
	@ApiImplicitParams({
		@ApiImplicitParam(name="code", value="会员邀请码",required = true,dataType="Long",paramType="path"),
	})
	@RequestMapping(value ="/detail/{code}", method = RequestMethod.GET)
	public ResponseMessage<Member> detailByCode(@PathVariable(name="code") String code) {
			return ResponseMessage.success(memberService.getMemberDetailByCode(code));
	}
	
	
	@ApiOperation(value="新增会员", notes="新增会员" )
	@ApiImplicitParams({
		@ApiImplicitParam(name="member", value="会员对象",required = true,dataType="Member"),
	})
	@RequestMapping(value ="/insert", method = RequestMethod.POST)
	public ResponseMessage<Member> insertMember(@RequestBody Member member) {
			return ResponseMessage.success(memberService.insertMember(member));
	}
	
	@ApiOperation(value="修改会员信息", notes="修改会员信息" )
	@ApiImplicitParams({
		@ApiImplicitParam(name="member", value="会员对象",required = true,dataType="Member"),
	})
	@RequestMapping(value ="/update", method = RequestMethod.POST)
	public ResponseMessage<Member> updateMember(@RequestBody Member member) {
			return ResponseMessage.success(memberService.updateMember(member));
	}
	
	@ApiOperation(value="会员列表", notes="会员列表" )
	@ApiImplicitParams({
        @ApiImplicitParam(name = "memberDto", value = "会员查询对象", required = false, dataType = "MemberDto"),
        @ApiImplicitParam(name = "pageNum", value = "第几页", required = true, dataType = "Integer",paramType = "query"),
        @ApiImplicitParam(name = "pageSize", value = "每页数量", required = false, dataType = "Integer",paramType = "query"),
        @ApiImplicitParam(name = "orderBy", value = "排序", required = false, dataType = "String",paramType = "query"),
	})
	@RequestMapping(value ="/list", method = RequestMethod.POST)
	public ResponseMessage<PageInfo<MemberDto>> memberList(
    		@RequestBody MemberDto memberDto,
		    @RequestParam(name="pageNum") Integer pageNum,
		    @RequestParam(name="pageSize",defaultValue="10") Integer pageSize,
		    @RequestParam(name="orderBy",defaultValue="a.create_date") String orderBy
			) {
		PageHelper.startPage(pageNum, pageSize, orderBy);
		List<MemberDto> memberDtoLiist = memberService.getMemberListByDto(memberDto);
		PageInfo<MemberDto> pageInfo = new PageInfo<MemberDto>(memberDtoLiist);
		return ResponseMessage.success(pageInfo);
	}

}
