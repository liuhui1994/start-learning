package org.business.system.activity.controller;

import org.business.system.activity.model.Activity;
import org.business.system.common.response.ResponseMessage;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("")
public class ActivityController {

	
	@ApiOperation(value="通过Id获取活动详情", notes="通过Id获取活动详情" )
	@ApiImplicitParams({
		@ApiImplicitParam(name="id", value="活动id",required = true,dataType="Long",paramType="path"),
	})
	@RequestMapping(value ="/{id}", method = RequestMethod.GET)
	public ResponseMessage<Activity> validateCode(
			@RequestParam(name="id",required = true) Long id
			) {
			return ResponseMessage.success();
	}
}
