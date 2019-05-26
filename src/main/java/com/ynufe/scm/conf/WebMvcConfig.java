package com.ynufe.scm.conf;

import com.ynufe.scm.web.inteceptor.LoginIntecepter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Autowired
    private LoginIntecepter loginIntecepter;

    /**
     * 首页
     * @param registry
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("/login");
    }

    /**
     * 静态资源处理
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**")
                .addResourceLocations("classpath:/static/");
        registry.addResourceHandler("/*.html")
                .addResourceLocations("classpath:/templates/");
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginIntecepter)
                .addPathPatterns("/**")
                .excludePathPatterns("/login/**")
                .excludePathPatterns("/static/**")
                //不拦截*.html(这样做是不对的,应该使用loginIntecepter拦截,这里是为了测试方便,能访问所有页面)
                .excludePathPatterns("/*.html");


    }
}
