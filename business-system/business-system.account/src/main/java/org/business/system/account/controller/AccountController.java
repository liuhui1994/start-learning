package org.business.system.account.controller;

import java.math.BigDecimal;

import org.business.system.account.model.Account;
import org.business.system.account.service.AccountService;
import org.business.system.common.response.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@RestController
public class AccountController {
	
	 @Autowired
     private AccountService  accountService;
   
    @RequestMapping(value="/",method=RequestMethod.GET)
	@ApiOperation(value="账户详情", notes="根的唯一id来获取账户详情" )
    @ApiImplicitParams({
            @ApiImplicitParam(name = "accountId", value = "账户ID", required = true, dataType = "Long",paramType = "query"),
            @ApiImplicitParam(name = "accountType", value = "账户类型", required = true, dataType = "String",paramType = "query")
    })
   public ResponseMessage<Account> accountDetail(
		   @RequestParam(value="accountId") Long accountId,
		    @RequestParam(value="accountType",required=true) String accountType) {
		   Account account = accountService.selectAccountByAccountIdAndType(accountId, accountType);
		   return ResponseMessage.success(account);
   }
   
    @RequestMapping(value="/newAccount",method=RequestMethod.POST)
	@ApiOperation(value="账户新增", notes="账户信息实体类" )
    @ApiImplicitParams({
            @ApiImplicitParam(name = "account", value = "账户实体", required = true, dataType = "Account")
    })
   public ResponseMessage<Account> newAccount(
		    @RequestBody Account account) {
		   Account newAccount = accountService.newAccount(account);
		   return ResponseMessage.success(newAccount);
   }
    
    
    @RequestMapping(value="/op",method=RequestMethod.POST)
	@ApiOperation(value="账户金额加减操作", notes="账户金额加减操作" )
    @ApiImplicitParams({
            @ApiImplicitParam(name = "accountId", value = "账户ID", required = true, dataType = "Long",paramType = "query"),
            @ApiImplicitParam(name = "accountType", value = "账户类型", required = true, dataType = "String",paramType = "query"),
            @ApiImplicitParam(name = "amount", value = "金额", required = true, dataType = "BigDecimal",paramType = "query"),
            @ApiImplicitParam(name = "opType", value = "操作类型", required = true, dataType = "String",paramType = "query")
    })
   public ResponseMessage<Account> accountAddandReduce(
		   @RequestParam("accountId") Long accountId,
		    @RequestParam("accountType") String accountType,
		    @RequestParam("amount") BigDecimal amount,
		    @RequestParam("opType") String opType) {
		   Account account = accountService.accountAddAndReduce(accountId, accountType, amount, opType);
		   return ResponseMessage.success(account);
   }
    
}
