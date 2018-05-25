package org.business.system.notice.util;

import java.io.IOException;
import java.nio.charset.UnsupportedCharsetException;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;

public class HttpClientUtil {
	
	
	public static String doGet(String url){
		return "";
	}
	
	
	public static String doPost(String url,String json) {
		try {
			
			HttpClient client = new HttpClient(); 
			PostMethod method = new PostMethod(url);

			client.getParams().setContentCharset("GBK");
			method.setRequestHeader("ContentType","application/x-www-form-urlencoded;charset=GBK");
			int mobile_code = (int)((Math.random()*9+1)*100000);

		    String content = new String("您的验证码是：" + mobile_code + "。请不要把验证码泄露给其他人。");
			NameValuePair[] data = {//提交短信
				    new NameValuePair("account", "C15895331"), //查看用户名是登录用户中心->验证码短信->产品总览->APIID
				    new NameValuePair("password", "7a10dfa0fb80611985647d9fffd3c842"),  //查看密码请登录用户中心->验证码短信->产品总览->APIKEY
				    //new NameValuePair("password", util.StringUtil.MD5Encode("密码")),
				    new NameValuePair("mobile", "17621875348"), 
				    new NameValuePair("content", content),
			};
			System.out.println(data);
			

			method.setRequestBody(data);

//            client.executeMethod(method);
			
			String submitResult =method.getResponseBodyAsString();
//			CloseableHttpClient httpClient = HttpClients.createDefault();
			
           
//			//创建一个post对象
//
//			HttpPost post =new HttpPost(url);
//			
//            post.setHeader("ContentType", "application/x-www-form-urlencoded;charset=GBK");
//            
//			//包装成一个Entity对象
//
//			StringEntity entity = new StringEntity(json, "GBK");
//			
//			System.out.println(entity);

			//设置请求的内容

//			post.setEntity(new UrlEncodedFormEntity());

//
//			//执行post请求
//
//			CloseableHttpResponse response =httpClient.execute(post);
//
//			String string = EntityUtils.toString(response.getEntity());

			System.out.println(submitResult);
//
//			response.close();
//
//			httpClient.close();
			
			return submitResult;
		} catch (UnsupportedCharsetException e) {
			e.printStackTrace();
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

}
