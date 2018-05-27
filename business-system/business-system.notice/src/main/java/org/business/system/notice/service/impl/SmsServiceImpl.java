package org.business.system.notice.service.impl;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;
import org.business.system.notice.service.SmsService;
import org.springframework.stereotype.Service;


@Service
public class SmsServiceImpl  implements SmsService{
	

	@Override
	public int sendAuthCode(String mobile,String mobileCode) {
		String url = "http://106.ihuyi.com/webservice/sms.php?method=Submit";
		String account="C15895331";
		String password="7a10dfa0fb80611985647d9fffd3c842";
		String content = new String("您的验证码是：" + mobileCode + "。请不要把验证码泄露给其他人。");
		sendHYCode(url, account, password, mobile, content);
		return 0;
	}
	

	private  String sendHYCode(String url,String account,String password,String mobile,String content) {
		try {
			
			HttpClient client = new HttpClient(); 
			PostMethod method = new PostMethod(url);

			client.getParams().setContentCharset("GBK");
			method.setRequestHeader("ContentType","application/x-www-form-urlencoded;charset=GBK");

			NameValuePair[] data = {//提交短信
				    new NameValuePair("account", account), //查看用户名是登录用户中心->验证码短信->产品总览->APIID
				    new NameValuePair("password", password),  //查看密码请登录用户中心->验证码短信->产品总览->APIKEY
				    //new NameValuePair("password", util.StringUtil.MD5Encode("密码")),
				    new NameValuePair("mobile", mobile), 
				    new NameValuePair("content", content),
			};
			System.out.println(data);
			
			method.setRequestBody(data);

			
			String submitResult =method.getResponseBodyAsString();
			
			return submitResult;
		}  catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
