package com.hp.elevator_02.config;

import com.hp.elevator_02.inteceptor.LoginInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Configuration //配置类
public class WebConfigurer implements WebMvcConfigurer {

    @Autowired
    private LoginInterceptor loginInterceptor;
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
            //拦截器的注册
            registry.addInterceptor(loginInterceptor)
                    .addPathPatterns("/**/*")//拦截所有
                    .excludePathPatterns("/euser/showLogin",
                            "/euser/login",
                            "/euser/error",
                            "/euser/generateCheckCode",
                            "/**/*.html",
                            "/**/*.js",
                            "/**/*.css"); //登录不拦截
            WebMvcConfigurer.super.addInterceptors(registry);
    }
}
