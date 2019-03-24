package com.windmill.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @类名称：MyInterceptor
 * @作者: 段大神经
 * @创建时间: 2018/9/29 22:03
 * @说明: 拦截器类
 */
@Component
public class MyInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        Object login_user = request.getSession().getAttribute("user");
        if (login_user == null) {
            response.sendRedirect("/index");
            return false;
        }
        return true;
    }


}
