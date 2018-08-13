package com.chadrc.training.interceptors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class SimpleInterceptor extends HandlerInterceptorAdapter {

    Logger logger = LoggerFactory.getLogger(SimpleInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object object) throws Exception {

        String accessToken = request.getHeader("accessToken");

        if ("password".equals(accessToken)) {
            logger.info("You sent a valid request");
            return true;
        } else {
            logger.error("You request is missing the password");
            return false;
        }
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
                                @Nullable Exception ex) throws Exception {

        logger.info("I am returning the request");
    }
}
