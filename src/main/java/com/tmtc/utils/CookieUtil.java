package com.tmtc.utils;

import org.apache.log4j.Logger;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Creater: hbwhypw
 * Date: 2015/8/23 18:13
 * Function:
 */
public class CookieUtil {
    protected static final Logger logger = Logger.getLogger(CookieUtil.class);
    public static void addCookie(HttpServletResponse response,String cookieName,String cookieValue){
        Cookie cookie = new Cookie(cookieName,cookieValue);
        response.addCookie(cookie);
    }
    /**
     * cookie
     * @param response
     * @param cookieName  cookie
     * @param cookieValue cookieֵ
     * @param maxAge cookie
     */
    public static void addCookie(HttpServletResponse response,String cookieName,String cookieValue,int maxAge){
        Cookie cookie = new Cookie(cookieName,cookieValue);
        cookie.setMaxAge(maxAge);
        response.addCookie(cookie);
    }

    public static void removeCookies(HttpServletRequest request){
        Cookie[] cookies = request.getCookies();
        if(cookies != null){
            for (Cookie cookie: cookies){
                cookie.setMaxAge(0);
                cookie.setPath("/");
                cookie.setValue(null);
            }
        } else {
            logger.debug("cookies is null");
        }
    }

    public static void addCookie(HttpServletRequest request, HttpServletResponse response, String name, String value, int maxAge) {
        Cookie cookie = new Cookie(name, value == null ? "" : value);
        cookie.setMaxAge(maxAge);
        cookie.setPath(getPath(request));
        response.addCookie(cookie);
    }

    private static String getPath(HttpServletRequest request) {
        String path = request.getContextPath();
        return (path == null || path.length()==0) ? "/" : path;
    }
}
