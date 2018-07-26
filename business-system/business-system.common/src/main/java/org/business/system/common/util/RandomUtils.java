package org.business.system.common.util;

import java.util.Random;

public class RandomUtils {
	
	//纯数字字符串
	public static final String NUMBER_CHAR = "0123456789";
	
	//纯小写字母字符串
	public  static final String SMALL_CHAR = "abcdefghijklmnopqrstuvwxyz";
	
	//大写字母字符串
	public static final String BIG_CHAR = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	
	/**
	 * 生成随机字符串  数字+小鞋字母
	 * @param length
	 * @return
	 */
	public static String generateString(int length) {
		String str = NUMBER_CHAR+SMALL_CHAR;
		Random random=new Random();  
        StringBuffer sb=new StringBuffer();
        //长度为几就循环几次
        for(int i=0; i<length; ++i){
          //产生0-61的数字
          int number=random.nextInt(str.length());
          //将产生的数字通过length次承载到sb中
          sb.append(str.charAt(number));
        }
        return sb.toString();
	}
	

	

}
