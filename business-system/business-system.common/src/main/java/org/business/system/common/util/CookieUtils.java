package org.business.system.common.util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

public class CookieUtils {
    public static String getValues(HttpServletRequest request, String key) throws UnsupportedEncodingException {
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie: cookies) {
            if(key.equals(cookie.getName())){
                return URLDecoder.decode(cookie.getValue(),"utf-8");
            }
        }
        return null;
    }
    public static void setCookie(HttpServletResponse response,String cookieName,String value,int maxTime) throws UnsupportedEncodingException {
        value = URLEncoder.encode(value, "utf-8");
        Cookie cookie = new Cookie(cookieName,value);
        cookie.setMaxAge(maxTime);
        response.addCookie(cookie);
    }

}
