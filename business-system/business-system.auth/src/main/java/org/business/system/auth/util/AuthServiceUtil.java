package org.business.system.auth.util;

import java.io.IOException;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class AuthServiceUtil {
	
	
	public static String doGet(String url){
		return "";
	}
	
	private String url;
	
	public static String doPost(String url,String username,String password) {
		try {
			
			HttpClient client = new HttpClient(); 
			PostMethod method = new PostMethod(url);

			client.getParams().setContentCharset("GBK");
//			method.setRequestHeader("ContentType","application/x-www-form-urlencoded;charset=GBK");
			method.setRequestHeader("authorization","Basic Y2xpZW50OmZ1Y2tzZWN1cml0eQ==");

			NameValuePair[] data = {//提交短信
				    new NameValuePair("password", password), //查看用户名是登录用户中心->验证码短信->产品总览->APIID
				    new NameValuePair("username", username),  //查看密码请登录用户中心->验证码短信->产品总览->APIKEY
				    new NameValuePair("grant_type", "password"), 
			};			

			method.setRequestBody(data);

            client.executeMethod(method);
			
			String submitResult =method.getResponseBodyAsString();


			System.out.println(submitResult);
//
//			response.close();
//
//			httpClient.close();
			
			return submitResult;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {
//		String json = AuthServiceUtil.doPost("http://localhost:8083/auth/oauth/token","17621875347","16b4fd94a5aa1605272871bff810c896");
//        Oauth2ResponseToken token  = new ObjectMapper().readValue(json, Oauth2ResponseToken.class);
//		"user": {"password": "69f5ebf857f165274258a5c2c9b6ad48","userModel": {"createDate": 1530865893665,"modifyDate": 1530865893665,"creator": "admin","modifier": "admin","loginName": "18296112413","password": "69f5ebf857f165274258a5c2c9b6ad48","phone": "18296112413","appId": "dde84b2518c8420ebde66607a2ce3df0","appKey": "91bd5150830f47299f844a7a267f0522","userType": "SYSTEM","state": "OPEN","userIdEnc": "B2300FB600789907FBD218E8593B4871"},"enabled": true,"authorities": [{"authority": "ADMIN"}],"accountNonLocked": true,"credentialsNonExpired": true,"accountNonExpired": true},
		String str = "{\"access_token\": \"TYXV0aGcHmkujNZY\", \"token_type\": \"bearer\",\"refresh_token\": \"eyM1YTUl5FeHBpcmVkIN2UWdxw0xOjBIkd8\",\"expires_in\": 43199,\"scope\": \"read write\",		\"user\": {\"password\": \"69f5ebf857f165274258a5c2c9b6ad48\",\"userModel\": {\"createDate\": 1530865893665,\"modifyDate\": 1530865893665,\"creator\": \"admin\",\"modifier\": \"admin\",\"loginName\": \"18296112413\",\"password\": \"69f5ebf857f165274258a5c2c9b6ad48\",\"phone\": \"18296112413\",\"appId\": \"dde84b2518c8420ebde66607a2ce3df0\",\"appKey\": \"91bd5150830f47299f844a7a267f0522\",\"userType\": \"SYSTEM\",\"state\": \"OPEN\",\"userIdEnc\": \"B2300FB600789907FBD218E8593B4871\"},\"enabled\": true,\"authorities\": [{\"authority\": \"ADMIN\"}],\"accountNonLocked\": true,\"credentialsNonExpired\": true,\"accountNonExpired\": true},\"jti\": \"5990b0d7-20e2-4477-b41a-c6867f3d37f1\"}";
        Oauth2ResponseToken token  = new ObjectMapper().readValue(str, Oauth2ResponseToken.class);
        System.out.println(token+"==");

        
	}
	
	

}
