package com.tyb.restfulcrud.componet;

/**
 * @Auther: TYB
 * @Date: 2021/2/5 - 02 - 05 - 17:20
 * @Description: springboot-web-restfulcrud - IntelliJ IDEA
 * @Version: 1.0
 */

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 拦截器 ，登入检查
 */
public class LoginHandlerInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object loginUser = request.getSession().getAttribute("loginUser");
        if(loginUser == null){
            //未登入，返回登入页面
            request.setAttribute("msg", "未登入，请先登入^^");
            request.getRequestDispatcher("/login**").forward(request, response);
            return false;
        }else {
            return  true;
        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}