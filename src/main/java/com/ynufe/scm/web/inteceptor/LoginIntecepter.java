package com.ynufe.scm.web.inteceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 对所有访问进行拦截(必须登录)
 */
@Component
public class LoginIntecepter implements HandlerInterceptor {

    public static String USER_SESSION_KEY = "user_session";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        final Object obj = request.getSession().getAttribute(USER_SESSION_KEY);
        //如果user不为空则放行
        if (null != obj) {
            //response.sendRedirect("/admin/login");
            return true;
        }
        //否则拦截并跳转到登录
        response.sendRedirect("/login");
        return false;
    }
}
