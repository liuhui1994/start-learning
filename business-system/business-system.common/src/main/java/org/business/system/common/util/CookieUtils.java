package org.business.system.common.util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieUtils {
    public static String getValues(HttpServletRequest request, String key){
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie: cookies) {
            if(key.equals(cookie.getName())){
                return cookie.getValue();
            }
        }
        return null;
    }
    public static void setCookie(HttpServletResponse response,String cookieName,String value,int maxTime){
        Cookie cookie = new Cookie(cookieName,value);
        cookie.setMaxAge(maxTime);
        response.addCookie(cookie);
    }

}
