package org.business.system.activity.controller;

import java.util.List;

import org.business.system.activity.model.Activity;
import org.business.system.activity.model.Task;
import org.business.system.activity.model.dto.ActivityAwardDto;
import org.business.system.activity.service.ActivityService;
import org.business.system.common.base.service.SecurityValidateService;
import org.business.system.common.response.ResponseMessage;
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
public class ActivityController {

	@Autowired
	private ActivityService activityService;
	
	@Autowired
	private SecurityValidateService  securityValidateService;
	
	@ApiOperation(value="通过Id获取活动详情", notes="通过Id获取活动详情" )
	@ApiImplicitParams({
		@ApiImplicitParam(name="id", value="活动id",required = true,dataType="Long",paramType="path"),
	})
	@RequestMapping(value ="/{id}", method = RequestMethod.GET)
	public ResponseMessage<Activity> activityDetail(@PathVariable(name="id") Long id) {
			return ResponseMessage.success(activityService.getActivityById(id));
	}
	
	@ApiOperation(value="新增活动", notes="新增活动" )
	@ApiImplicitParams({
		@ApiImplicitParam(name="activity", value="活动id",required = true,dataType="Activity"),
	})
	@RequestMapping(value ="/insert", method = RequestMethod.POST)
	public ResponseMessage<Activity> insertActivity(
			@RequestBody Activity activity) {
			return ResponseMessage.success(activityService.insertActivity(activity));
	}
	
	@ApiOperation(value="编辑活动", notes="编辑活动" )
	@ApiImplicitParams({
		@ApiImplicitParam(name="activity", value="活动id",required = true,dataType="Activity"),
	})
	@RequestMapping(value ="/update", method = RequestMethod.POST)
	public ResponseMessage<Activity> updateActivity(
			@RequestBody Activity activity) {
			return ResponseMessage.success(activityService.updateActivity(activity));
	}
	
	
	@ApiOperation(value="获取活动列表", notes="获取活动列表" )
    @ApiImplicitParams({
            @ApiImplicitParam(name = "activity", value = "活动查询对象", required = false, dataType = "Activity"),
            @ApiImplicitParam(name = "pageNum", value = "第几页", required = true, dataType = "Integer",paramType = "query"),
            @ApiImplicitParam(name = "pageSize", value = "每页数量", required = false, dataType = "Integer",paramType = "query"),
            @ApiImplicitParam(name = "orderBy", value = "排序", required = false, dataType = "String",paramType = "query"),

    })
    @RequestMapping(value="/activitylist", method= RequestMethod.POST)
    public ResponseMessage<PageInfo<Activity>> list(
    		@RequestBody Activity activity,
		    @RequestParam(name="pageNum") Integer pageNum,
		    @RequestParam(name="pageSize",defaultValue="1") Integer pageSize,
		    @RequestParam(name="orderBy",defaultValue="id") String orderBy){ 
		PageHelper.startPage(pageNum, pageSize, orderBy);
		List<Activity> activityList = activityService.getActivityList(activity);
		PageInfo<Activity> pageInfo = new PageInfo<Activity>(activityList);
        return ResponseMessage.success(pageInfo);
    }
	
	@ApiOperation(value="活动奖励接口", notes="活动奖励接口" )
    @ApiImplicitParams({
        @ApiImplicitParam(name = "activityId", value = "活动id", required = true, dataType = "Integer",paramType = "query"),
        @ApiImplicitParam(name = "userIdEnc", value = "用户加密id", required = true, dataType = "String",paramType = "query"),
    })
    @RequestMapping(value="/activityAward", method= RequestMethod.POST)
	public ResponseMessage<ActivityAwardDto>  activityAward(@RequestParam(name="activityId")Long activityId,
			@RequestParam(name="userIdEnc")String userIdEnc){
		ActivityAwardDto ado = new ActivityAwardDto();
		ado.setActivityId(activityId);
		ado.setUserIdEnc(userIdEnc);
		return ResponseMessage.success(activityService.activityAward(ado));
		
	}
	

}
