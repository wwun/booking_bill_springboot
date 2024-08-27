package com.william.booking.bill.springboot.booking_springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer{

    @Autowired
    @Qualifier("timeInterceptor")
    private HandlerInterceptor handlerInterceptor;

    @Override
    @SuppressWarnings("null")
    public void addInterceptors(InterceptorRegistry registry){
        registry.addInterceptor(handlerInterceptor).addPathPatterns("/*");
    }

    @Override
    @SuppressWarnings("null")
    public void addCorsMappings(CorsRegistry registry){
        registry.addMapping("/**")
        .allowedOrigins("http://127.0.0.1:5500")
        .allowedMethods("GET", "POST", "PUT", "DELETE","OPTIONS")
        .allowedHeaders("*")
        .allowCredentials(true);
    }
}
