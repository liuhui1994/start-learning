package org.business.system.notice.controller;

import org.business.system.common.base.controller.BaseControlelr;
import org.business.system.common.response.CodeMessage;
import org.business.system.common.response.ResponseMessage;
import org.business.system.notice.ecception.ValidateCodeException;
import org.business.system.notice.model.MobileCode;
import org.business.system.notice.service.MobileCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;


@RestController
@RequestMapping("/mobile")
//@Api(tags="{API}")
public class MobileCodeController  extends BaseControlelr{
	
	
	@Autowired
	private MobileCodeService mobileCodeService;

	
	@ApiOperation(value="验证码验证", notes="验证码验证" )
	@ApiImplicitParams({
		@ApiImplicitParam(name="mobile", value="手机号",required = true,dataType="String",paramType="query"),
		@ApiImplicitParam(name="code", value="验证码",required = true,dataType="String",paramType="query"),
		@ApiImplicitParam(name="businessType", value="验证业务类型",required = true,dataType="String",paramType="query")
	})
	@RequestMapping(value ="/validate", method = RequestMethod.GET)
	public ResponseMessage<MobileCode> validateCode(
			@RequestParam(name="mobile",required = true) String mobile,
			@RequestParam(name="code",required = true) String code,
			@RequestParam(name="businessType",required = true) String businessType) {
	    try {
			mobileCodeService.validateCode(mobile, code, businessType);		
			return ResponseMessage.success();
		} catch (ValidateCodeException e) {
			return ResponseMessage.error(new CodeMessage(e.getCode(),e.getMessgae()));
		}
	}
	
	
	@ApiOperation(value="发送短信验证码", notes="发送短信验证码" )
	@ApiImplicitParams({
		@ApiImplicitParam(name="mobile", value="手机号",required = true,dataType="String",paramType="query"),
		@ApiImplicitParam(name="businessType", value="验证业务类型",required = true,dataType="String",paramType="query")
	})
	@RequestMapping(value ="/sendCode", method = RequestMethod.GET)
	public ResponseMessage<MobileCode> validateCode(
			@RequestParam(name="mobile",required = true) String mobile,
			@RequestParam(name="businessType",required = true) String businessType) {
	    try {
	        mobileCodeService.sendCode(mobile, businessType);
			return ResponseMessage.success();
		} catch (ValidateCodeException e) {
			return ResponseMessage.error(new CodeMessage(e.getCode(),e.getMessgae()));
		}
	}
	
}
