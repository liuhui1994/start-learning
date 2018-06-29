package org.business.system.account.controller;

import java.util.List;

import org.business.system.account.model.AccountFlowDto;
import org.business.system.account.service.AccountFlowService;
import org.business.system.common.response.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/accountFlow")
public class AccountFlowController {
	
	@Autowired
	private AccountFlowService  accountFlowService;
	
	@ApiOperation(value="账户流水列表", notes="账户流水列表" )
	@ApiImplicitParams({
        @ApiImplicitParam(name = "accountFlowDto", value = "账户流水查询对象", required = false, dataType = "AccountFlowDto"),
        @ApiImplicitParam(name = "pageNum", value = "第几页", required = true, dataType = "Integer",paramType = "query"),
        @ApiImplicitParam(name = "pageSize", value = "每页数量", required = false, dataType = "Integer",paramType = "query"),
        @ApiImplicitParam(name = "orderBy", value = "排序", required = false, dataType = "String",paramType = "query"),
	})
	@RequestMapping(value ="/list", method = RequestMethod.POST)
	public ResponseMessage<PageInfo<AccountFlowDto>> noticeList(
    		@RequestBody AccountFlowDto accountFlowDto,
		    @RequestParam(name="pageNum") Integer pageNum,
		    @RequestParam(name="pageSize",defaultValue="10") Integer pageSize,
		    @RequestParam(name="orderBy",defaultValue="create_date") String orderBy
			) {
		PageHelper.startPage(pageNum, pageSize, orderBy);
		List<AccountFlowDto> accountFlowDtoLiist = accountFlowService.getAccountFlowListByDao(accountFlowDto);
		PageInfo<AccountFlowDto> pageInfo = new PageInfo<AccountFlowDto>(accountFlowDtoLiist);
		return ResponseMessage.success(pageInfo);
	}
	
	
}
