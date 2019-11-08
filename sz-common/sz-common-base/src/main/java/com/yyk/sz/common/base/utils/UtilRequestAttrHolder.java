package com.yyk.sz.common.base.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

public class UtilRequestAttrHolder {

    //TODO redis存储还是内存存储
    private static ConcurrentHashMap<HttpServletRequest, HashMap<String, Object>> requestAttrContainer = new ConcurrentHashMap<>();
    private static Logger logger = LoggerFactory.getLogger(UtilRequestAttrHolder.class);

    /**
     * 设置属性
     */
    public static void setAttribute(HttpServletRequest request, String attrName, Object attrValue) {
        if( request == null || attrName == null || attrValue == null ){
            return;
        }

        HashMap<String , Object> userAttrs = requestAttrContainer.get(request);
        if( userAttrs == null ){
            userAttrs = new HashMap<>();
            userAttrs.put(attrName,attrValue);
            requestAttrContainer.put(request, userAttrs);
        }else{
            userAttrs.put(attrName,attrValue);
        }
    }

    public static Object getAttribute(HttpServletRequest request, String attrName){
        if( request == null || attrName == null  ){
            return null;
        }
        HashMap<String , Object> userAttrs = requestAttrContainer.get(request);
        if( userAttrs == null ){
            requestAttrContainer.put(request, new HashMap<>());
            return null;
        }else{
            return userAttrs.get(attrName);
        }
    }

    public static void removeRequest(HttpServletRequest request){
        if( request == null ){
            return;
        }
        requestAttrContainer.remove(request);
    }
}
