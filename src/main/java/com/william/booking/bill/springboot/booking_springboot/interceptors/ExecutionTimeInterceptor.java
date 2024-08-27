package com.william.booking.bill.springboot.booking_springboot.interceptors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component("timeInterceptor")
public class ExecutionTimeInterceptor implements HandlerInterceptor{

    private static final Logger logger = LoggerFactory.getLogger(ExecutionTimeInterceptor.class);

    @Override
    @SuppressWarnings("null")
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception{
        try{
            Long startMs = System.currentTimeMillis();
            request.setAttribute("startMs", startMs);
        }catch(Exception ex){
            logger.error("Not possible to register start time execution: "+ex);
        }
        return true;
    }

    @Override
    @SuppressWarnings("null")
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception{
        try{
            HandlerMethod handlerMethod = (HandlerMethod)handler;
            String className = handlerMethod.getClass().getSimpleName();
            String methodName = handlerMethod.getMethod().getName();
            Long endMs = System.currentTimeMillis();
            Long startMs = (Long)request.getAttribute("startMs");
            if(startMs != null){
                logger.info(className+"."+methodName+", Execution time: "+(endMs-startMs)+"ms");
                response.setStatus(200);
            }else{
                logger.warn("Not possible to get start execution time");
            }
        }catch(Exception ex){
            logger.error("Not possible to register method execution time");
        }
    }
}
