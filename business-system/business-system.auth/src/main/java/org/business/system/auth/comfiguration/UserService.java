package org.business.system.auth.comfiguration;

import org.business.system.common.cloud.user.UserCloudService;
import org.business.system.common.model.dto.UserModelDto;
import org.business.system.common.response.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class UserService  implements UserDetailsService{
	
	@Autowired
	private UserCloudService userCloudService;
	

	@Override
	public UserDetails loadUserByUsername(String arg0) throws UsernameNotFoundException {
		//oauth/authorize  拿到的是当前应用的client_id 
		//oauth/token 拿到的是当前用户的username
		System.out.println("auth  获取的用户名: "+ arg0);
		ResponseMessage<UserModelDto> userModel = null;
		try {
			userModel = userCloudService.getUserByLoginName(arg0);
		} catch (Exception e) {
            throw new BadCredentialsException("无效的用户名和密码");
		}
		if(userModel ==null ) {
			throw new BadCredentialsException("无效的用户名和密码");
		}
		UserDetails userd = new User(userModel.getData());
		return userd;
	}
 

	
}
