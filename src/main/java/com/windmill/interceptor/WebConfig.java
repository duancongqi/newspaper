package com.windmill.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @类名称：WebConfig
 * @作者: 段大神经
 * @创建时间: 2018/9/29 22:09
 * @说明: web配置类
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Autowired
    private MyInterceptor myInterceptor;
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //定义拦截路径和放行路径
        registry.addInterceptor(myInterceptor)
                //拦截配置
                .addPathPatterns("/**")
                .excludePathPatterns(
               "/js/**","/image/**","/login","/index","/","/findDepartment","/upload/**"
        )
        ;
    }
}
