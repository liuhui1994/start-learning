package org.business.system.newstart.controller;

import org.business.system.common.model.UserModel;
import org.business.system.newstart.service.UserModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
    public UserModel putUser(@PathVariable(name="id") Long id) { //@RequestBody Book book
        return userModelService.queryById(id);
    }
}