package org.business.system.common.cloud.account;

import java.math.BigDecimal;

import org.business.system.common.model.Account;
import org.business.system.common.response.ResponseMessage;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 此服务适用于   对接支付渠道中需要进行回调时  进行账户金额加减操作
 * @author liuhui
 *
 */
@FeignClient(value="account-service",name="account-service",path="/account")
public interface AccountCloudService {

	@RequestMapping(value="/manager/op",method = RequestMethod.GET)
	public  ResponseMessage<Account> getUserBytoken( @RequestParam("accountId") Long accountId,
		    @RequestParam("accountType") String accountType,
		    @RequestParam("amount") BigDecimal amount,
		    @RequestParam("tradeType") String tradeType);
	
}
