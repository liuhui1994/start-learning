package org.business.system.auth.comfiguration;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;

@Configuration
public class CustomTokenEnhancer  implements TokenEnhancer{
	

	 @Override
	    public OAuth2AccessToken enhance(OAuth2AccessToken accessToken,  OAuth2Authentication authentication) {
	        Map<String, Object> additionalInfo = new HashMap<>();
	        additionalInfo.put("user",  (User)authentication.getPrincipal());
	        ((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(additionalInfo);
	        return accessToken;
	    }


}
