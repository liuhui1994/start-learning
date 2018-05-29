package org.business.system.common.cloud.notice;

import org.business.system.common.model.Notice;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value="notice-service",name="notice-service",path="/notice")
public interface NoticeCloudService {
	
	@RequestMapping(value="/notice/{id}",method = RequestMethod.GET)
	public Notice putUser(@PathVariable("id") Long id);
	

}
