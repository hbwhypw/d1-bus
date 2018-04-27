package com.tmtc.controller;

import com.tmtc.utils.secret.MD5;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * Function:
 *
 * @auther: hbwhypw
 * Date: 2015-12-29 14:32
 */
public class CookieController extends BaseController {

    public String getCookie(HttpServletRequest request, String name) {
        Cookie[] cookies = request.getCookies();
        String value = "";
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (name.equals(cookie.getName())) {
                    value = cookie.getValue();
                }
            }
        }
        return value;
    }

    /**
     * 验证登录
     *
     * @param request
     * @return true 通过 false 不通过
     */
    public boolean vaildLogin(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        String token = "";
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if ("token".equals(cookie.getName())) {
                    token = cookie.getValue();
                }
            }
        }
        return token.equals(MD5.makeMd5("This is a valid"));
    }
}
