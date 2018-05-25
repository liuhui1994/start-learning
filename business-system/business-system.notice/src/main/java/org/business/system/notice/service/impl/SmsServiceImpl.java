package org.business.system.notice.service.impl;

import java.text.MessageFormat;
import java.util.Date;

import org.business.system.notice.model.SmsNotice;
import org.business.system.notice.service.SmsService;
import org.business.system.notice.util.HttpClientUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


@Service
public class SmsServiceImpl  implements SmsService{
	
	@Autowired
	private ObjectMapper objMapper;

	@Override
	public int sendAuthCode(String mobile) {
		String url = "http://106.ihuyi.com/webservice/sms.php?method=Submit";
		SmsNotice smsNotice = new SmsNotice();
		try {
			HttpClientUtil.doPost(url, objMapper.writeValueAsString(smsNotice));
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	
	public static void main(String[] args) throws JsonProcessingException {
		 String url = "http://106.ihuyi.com/webservice/sms.php?method=Submit";
		 SmsNotice smsNotice = new SmsNotice();
		 smsNotice.setAccount("C15895331");
		 smsNotice.setPassword("7a10dfa0fb80611985647d9fffd3c842");
		 smsNotice.setContent(MessageFormat.format("您的验证码是:{0}.请不要把验证码泄露给其他人.", "123456"));
		 smsNotice.setMobile("17621875348");
		 smsNotice.setTime(new Date().getTime()/1000);
		 smsNotice.setFormat("json");
		 ObjectMapper objMapper = new ObjectMapper();
		 try {
			 System.out.println(objMapper.writeValueAsString(smsNotice));
			HttpClientUtil.doPost(url,objMapper.writeValueAsString(smsNotice));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		 
			
	}

}
