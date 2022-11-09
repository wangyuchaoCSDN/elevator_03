package com.hp.elevator_02.inteceptor;

import com.hp.elevator_02.pojo.Euser;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component //组件
public class LoginInterceptor implements HandlerInterceptor {
    //拦截器用这个方法
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
    //从session取出你从入进去的login
        Euser login = (Euser) request.getSession().getAttribute("login");
        System.out.println("拦截器开始工作..........");
        if(login==null){
            //未登录

            //跳转到登录页面
            response.sendRedirect("/euser/showLogin");
            return false;
        }else{
            //用户已经登录
            return true;
        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
