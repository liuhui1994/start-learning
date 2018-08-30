package org.business.system.auth.util;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;

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
	
	public static void main(String[] args) {
		AuthServiceUtil.doPost("http://localhost:8083/auth/oauth/token","17621875347","16b4fd94a5aa1605272871bff810c896");
	}
	
	

}
