package org.business.system.common.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternUtils {
	
	/**
	 * 校验手机号是否合法
	 * @param mobile
	 * @return
	 */
	public static boolean validateMobile(String mobile) {
		 String regex = "^((13[0-9])|(14[5|7])|(15([0-3]|[5-9]))|(17[013678])|(18[0,5-9]))\\d{8}$";
//		 String regex = "^1[3|4|5|7|8][0-9]\\d{4,8}$";
		 if(mobile==null || "".equals(mobile) || mobile.length()!=11) {
			 return false;
		 }
		 Pattern p = Pattern.compile(regex);
         Matcher m = p.matcher(mobile);
         boolean isMatch = m.matches();
		 return isMatch;
	}
	
}
