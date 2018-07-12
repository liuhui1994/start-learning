package org.business.system.common.cloud.member;

import org.business.system.common.model.Member;
import org.business.system.common.response.ResponseMessage;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value="member-service",name="member-service",path="/member")
public interface MemberCloudService {

	@RequestMapping(value="/manager/detail/{code}",method = RequestMethod.GET)
	public  ResponseMessage<Member> getUserBytoken(@PathVariable(name="code")String code);
}
