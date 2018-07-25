package org.business.system.common.util;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;
import org.springframework.util.ObjectUtils;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class WeiXinUtil {
	
	public static Map<String, Object> map = new HashMap<>();
	
	public static final String APP_ID = "wx534f1766899d2e30"; 
	public static final String SECRET = "ccb1ec4ec01a2a7741482d1e44e2781a"; 
	public static final String TOKEN_URL = "https://api.weixin.qq.com/cgi-bin/token"; 
	public static final String OPEN_ID_URL = "https://api.weixin.qq.com/sns/oauth2/access_token";
	
	//重定向授权服务器微信微信会携带code
	public static final String AUTH_URL = "https://open.weixin.qq.com/connect/oauth2/authorize?redirect_uri=REDICT_UTL&appid=APPID&response_type=code&scope=snsapi_base&state=1#wechat_redirect";

	/**
	 * 获取微信token
	 * @return
	 */
	public static String getWeiXinToken() {
		
		if(ObjectUtils.isEmpty(map.get("token"))) {
			try {
				HttpClient client = new HttpClient(); 
				PostMethod method = new PostMethod(TOKEN_URL);

				NameValuePair[] data = {//提交短信
					    new NameValuePair("appid", APP_ID), //查看用户名是登录用户中心->验证码短信->产品总览->APIID
					    new NameValuePair("secret", SECRET),  //查看密码请登录用户中心->验证码短信->产品总览->APIKEY
					    new NameValuePair("grant_type", "client_credential"), 
				};			

				method.setRequestBody(data);

				client.executeMethod(method);
				
				String submitResult = method.getResponseBodyAsString();
				String token = new ObjectMapper().readValue(submitResult, WeiXinToken.class).getAccess_token();
				if(!ObjectUtils.isEmpty(token)) {
					map.put("token", token);
					map.put("date", new Date().getTime());
				}
				return token;
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (HttpException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		Long tokenDate = Long.parseLong(map.get("date").toString());
		if((new Date().getTime()-tokenDate)<60*60*1000*1.5) {
			return map.get("token").toString();
		}
		
		return getWeiXinToken();

	}
	/**
	 * 获取当前授权用户openId
	 * @param code
	 * @return
	 */
	public static String getOpenId(String code) {
		try {
			HttpClient client = new HttpClient(); 
			PostMethod method = new PostMethod(OPEN_ID_URL);

			NameValuePair[] data = {//提交短信
				    new NameValuePair("appid", APP_ID), //查看用户名是登录用户中心->验证码短信->产品总览->APIID
				    new NameValuePair("secret", SECRET),  //查看密码请登录用户中心->验证码短信->产品总览->APIKEY
				    new NameValuePair("grant_type", "authorization_code"), 
				    new NameValuePair("code", code),
			};			

			method.setRequestBody(data);

			client.executeMethod(method);
			
			String result = method.getResponseBodyAsString();
            Object [] obj = new ObjectMapper().readValue(result,Object[].class);
			System.out.println(obj.toString());
			 
			String openid = obj[0].toString();
			return openid;

		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (HttpException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static void main(String[] args) {
		System.out.println(WeiXinUtil.getWeiXinToken());
		System.out.println(WeiXinUtil.getWeiXinToken());
		System.out.println(WeiXinUtil.getOpenId("123"));
	}

}
