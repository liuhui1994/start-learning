package org.business.system.auth.comfiguration;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class UserService  implements UserDetailsService{

	@Override
	public UserDetails loadUserByUsername(String arg0) throws UsernameNotFoundException {
		//oauth/authorize  拿到的是当前应用的client_id 
		//oauth/token 拿到的是当前用户的username
		System.out.println("auth  获取的用户名: "+ arg0);
		UserDetails userd = new User("admin","admin123");
		return userd;
	}
 

	
}
