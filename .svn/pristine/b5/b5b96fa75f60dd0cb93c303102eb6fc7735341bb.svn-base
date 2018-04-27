package com.tmtc.filter;

import com.tmtc.po.Admins;
import com.tmtc.utils.PropertiesUtil;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Creater: hbwhypw
 * Date: 2015/8/22 14:11
 * Function:
 */
public class LoginValidateFilter implements Filter {
    private static final String loginUrl = PropertiesUtil.getPropertyValue("system", "loginUrl");
    private static final String[] ignore = PropertiesUtil.getPropertyValue("system", "ignore").split(",");

    public void init(FilterConfig filterConfig) throws ServletException { }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String url = request.getRequestURI();
        HttpSession session = request.getSession();
        Admins admins = (Admins) session.getAttribute("admins");
        for (String str :ignore){
            if(url.contains(str)){
                filterChain.doFilter(servletRequest, servletResponse);
                return;
            }
        }
        
        if (url.contains(loginUrl) || admins != null && !admins.getUsername().isEmpty()) {
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            //如果是ajax请求响应头会有，x-requested-with；
            if (isAjaxRequest(request) || isFormRequest(request)) {
                //在响应头设置session状态
                response.setHeader("sessionStatus", "timeout");
                response.setStatus(403);
            } else {
                response.sendRedirect("/admin/index.jsp");
            }
        }
    }

    private boolean isAjaxRequest(HttpServletRequest request){
        return request.getHeader("x-requested-with") != null && request.getHeader("x-requested-with").equalsIgnoreCase("XMLHttpRequest");
    }

    private boolean isFormRequest(HttpServletRequest request){
        return request.getHeader("Content-Type") != null && request.getHeader("Content-Type").equalsIgnoreCase("application/x-www-form-urlencoded");
    }

    public void destroy() { }
}
