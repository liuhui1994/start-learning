package org.business.system.account.controller;

import org.business.system.account.cloud.Notice;
import org.business.system.account.cloud.NoticeCloudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {
	


    
	@Autowired
    private NoticeCloudService  noticeCloudService;
	   
	@RequestMapping("/test")
   public Notice get() {
   	   return noticeCloudService.putUser(1l);
   }
}
