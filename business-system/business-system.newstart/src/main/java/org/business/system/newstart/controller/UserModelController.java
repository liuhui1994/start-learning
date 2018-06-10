package org.business.system.newstart.controller;

import java.util.List;

import org.business.system.common.model.UserModel;
import org.business.system.common.response.ResponseMessage;
import org.business.system.newstart.service.UserModelService;
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
@RequestMapping("/user")
public class UserModelController {

	@Autowired
	private UserModelService  userModelService;
	
	
	@ApiOperation(value="获取用户详情", notes="根据用户的唯一id来获取用户信息" )
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "图书ID", required = true, dataType = "Long",paramType = "path"),
          //  @ApiImplicitParam(name = "book", value = "图书实体book", required = true, dataType = "Book")
    })
    @RequestMapping(value="/{id}", method= RequestMethod.GET)
    public ResponseMessage<UserModel> putUser(@PathVariable(name="id") Long id) { //@RequestBody Book book
        return ResponseMessage.success(userModelService.queryById(id));
    }
	
	
	
	@ApiOperation(value="获取用户详情", notes="根据用户的唯一手机号来获取用户信息" )
    @ApiImplicitParams({
            @ApiImplicitParam(name = "mobile", value = "图书ID", required = true, dataType = "Long",paramType = "query"),
          //  @ApiImplicitParam(name = "book", value = "图书实体book", required = true, dataType = "Book")
    })
    @RequestMapping(value="/detail", method= RequestMethod.GET)
    public ResponseMessage<UserModel> detail(@RequestParam(name="mobile") String  mobile) { //@RequestBody Book book
        return ResponseMessage.success(userModelService.getUserByMobile(mobile));
    }
	
	@ApiOperation(value="获取用户列表", notes="获取用户列表" )
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userSelect", value = "用户查询对象", required = false, dataType = "UserModel"),
            @ApiImplicitParam(name = "pageNum", value = "第几页", required = true, dataType = "Integer",paramType = "query"),
            @ApiImplicitParam(name = "pageSize", value = "每页数量", required = false, dataType = "Integer",paramType = "query"),
            @ApiImplicitParam(name = "orderBy", value = "排序", required = false, dataType = "String",paramType = "query"),

    })
    @RequestMapping(value="/list", method= RequestMethod.POST)
    public ResponseMessage<PageInfo<UserModel>> list(
    		@RequestBody UserModel userSelect,
		    @RequestParam(name="pageNum") Integer pageNum,
		    @RequestParam(name="pageSize",defaultValue="10") Integer pageSize,
		    @RequestParam(name="orderBy",defaultValue="create_date") String orderBy){ 
		PageHelper.startPage(pageNum, pageSize, orderBy);
		List<UserModel> userList = userModelService.getUserList(userSelect);
		PageInfo<UserModel> pageInfo = new PageInfo<UserModel>(userList);
        return ResponseMessage.success(pageInfo);
    }
	
    @RequestMapping(value="/register",method=RequestMethod.POST)
	@ApiOperation(value="用户注册", notes="用户注册" )
    @ApiImplicitParams({
            @ApiImplicitParam(name = "user", value = "用户对象", required = true, dataType = "UserModel")
    })
   public ResponseMessage<UserModel> register(
	  		@RequestBody UserModel user) {
		   return ResponseMessage.success();
   }
}
