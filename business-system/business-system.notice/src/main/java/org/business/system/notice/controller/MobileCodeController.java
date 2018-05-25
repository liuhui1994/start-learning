package org.business.system.notice.controller;

import org.business.system.notice.model.Notice;
import org.business.system.notice.service.MobileCodeService;
import org.business.system.notice.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;


@RestController
@RequestMapping("/notice")
//@Api(tags="{API}")
public class MobileCodeController {
	
	@Autowired
    private NoticeService noticeService;
	
	@Autowired
	private MobileCodeService mobileCodeService;
    
    

	
	
	@ApiOperation(value="消息推送", notes="推送notice对象" )
	@ApiImplicitParams({
		@ApiImplicitParam(name="notice", value="notice实体",required = true,dataType="Notice")
	})
	@RequestMapping(value ="/push", method = RequestMethod.POST)
	public String sendMessage(Notice notice) {
		noticeService.insertEntity(notice);
		noticeService.saveSelective(notice);
		return "seccess";
	}
	
	
	@ApiOperation(value="验证码验证", notes="验证码验证" )
	@ApiImplicitParams({
		@ApiImplicitParam(name="mobile", value="手机号",required = true,dataType="String"),
		@ApiImplicitParam(name="code", value="验证码",required = true,dataType="String"),
		@ApiImplicitParam(name="businessType", value="验证业务类型",required = true,dataType="String")
	})
	@RequestMapping(value ="/validate", method = RequestMethod.POST)
	public String validateCode(String mobile,String code,String businessType) {
		
	
		return null;
	}
	
}
