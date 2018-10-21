package org.business.system.activity.controller;

import java.util.List;

import org.business.system.activity.em.SelectType;
import org.business.system.activity.model.Task;
import org.business.system.activity.model.dto.TaskDto;
import org.business.system.activity.service.TaskService;
import org.business.system.common.base.service.SecurityValidateService;
import org.business.system.common.response.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
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
@RequestMapping("/task")
public class TaskController {

	@Autowired
    private TaskService  taskService;
	
	@Autowired
	private SecurityValidateService  securityValidateService;
	
	
	
	@ApiOperation(value="我的任务列表", notes="我的任务列表" )
    @ApiImplicitParams({
        @ApiImplicitParam(name = "userIdEnc", value = "用户加密id", required = true, dataType = "String",paramType = "path"),
        @ApiImplicitParam(name = "pageNum", value = "第几页", required = true, dataType = "Integer",paramType = "query"),
        @ApiImplicitParam(name = "pageSize", value = "每页数量", required = false, dataType = "Integer",paramType = "query"),
        @ApiImplicitParam(name = "orderBy", value = "排序", required = false, dataType = "String",paramType = "query"),
    })
    @RequestMapping(value="/{userIdEnc}/{selectType}", method= RequestMethod.POST)
	public ResponseMessage<PageInfo<TaskDto>>  mytask(@PathVariable (name="userIdEnc", required = true)String userIdEnc,
			@PathVariable (name="selectType", required = true)SelectType selectType,
		    @RequestParam(name="pageNum") Integer pageNum,
		    @RequestParam(name="pageSize",defaultValue="1") Integer pageSize,
		    @RequestParam(name="orderBy",defaultValue="id") String orderBy){
		Long userId = securityValidateService.getUserIdByUserIdEnc(userIdEnc);
		TaskDto taskdto = new TaskDto();
		taskdto.setUserId(userId);
		taskdto.setSelectType(selectType.name());
		PageHelper.startPage(pageNum, pageSize, orderBy);
		List<TaskDto> taskList = taskService.selectTaskByTaskDao(taskdto);
		PageInfo<TaskDto> pageInfo = new PageInfo<TaskDto>(taskList);
		return ResponseMessage.success(pageInfo);
	}
	
	
	@ApiOperation(value="通过任务id获取任务详情", notes="通过任务id获取任务详情" )
    @ApiImplicitParams({
        @ApiImplicitParam(name = "id", value = "任务id", required = true, dataType = "Long",paramType = "path"),
    })
    @RequestMapping(value="/{id}", method= RequestMethod.POST)
	public ResponseMessage<TaskDto>  taskById(@PathVariable (name="id", required = true)Long id){

		return ResponseMessage.success(taskService.getTaskDtoById(id));
	}
	
	
	
	@ApiOperation(value="任务列表", notes="任务列表" )
    @ApiImplicitParams({
        @ApiImplicitParam(name = "userIdEnc", value = "用户加密id", required = true, dataType = "String",paramType = "path"),
        @ApiImplicitParam(name = "pageNum", value = "第几页", required = true, dataType = "Integer",paramType = "query"),
        @ApiImplicitParam(name = "pageSize", value = "每页数量", required = false, dataType = "Integer",paramType = "query"),
        @ApiImplicitParam(name = "orderBy", value = "排序", required = false, dataType = "String",paramType = "query"),
    })
    @RequestMapping(value="/", method= RequestMethod.POST)
	public ResponseMessage<PageInfo<Task>>  taskList(@PathVariable (name="userIdEnc")String userIdEnc,
		    @RequestParam(name="pageNum") Integer pageNum,
		    @RequestParam(name="pageSize",defaultValue="1") Integer pageSize,
		    @RequestParam(name="orderBy",defaultValue="id") String orderBy){
		PageHelper.startPage(pageNum, pageSize, orderBy);
		List<Task> taskList = taskService.taskList(null);
		PageInfo<Task> pageInfo = new PageInfo<Task>(taskList);
		return ResponseMessage.success(pageInfo);
	}
}
