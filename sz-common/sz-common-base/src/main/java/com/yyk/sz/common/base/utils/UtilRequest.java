package com.yyk.sz.common.base.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.ServletRequest;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletRequest;

@WebListener
public class UtilRequest implements ServletRequestListener {

    private static Logger logger = LoggerFactory.getLogger(UtilRequest.class);

    public static HttpServletRequest getRequest(){
        //获取当前请求
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();
        return request;
    }

    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        ServletRequest sr = sre.getServletRequest();
        HttpServletRequest hsr = (HttpServletRequest)sr;
        //销毁request属性容器中保存的本request的所有信息
        UtilRequestAttrHolder.removeRequest(hsr);
    }

    @Override
    public void requestInitialized(ServletRequestEvent sre) {

    }
}
