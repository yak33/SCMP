package com.yyk.sz.zhzy.common.util;

import com.yyk.sz.common.base.utils.UtilRequestAttrHolder;
import com.yyk.sz.common.base.utils.UtilTokenDealer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component//将此Filter交给Spring容器管理
@WebFilter(urlPatterns = "/*", filterName = "webFilterAll")
@Order(1)//指定过滤器的执行顺序,值越大越靠后执行
public class UtilWebFilter implements Filter {

    private FilterConfig config;
    private Logger logger = LoggerFactory.getLogger(UtilWebFilter.class);

    @Override
    public void init(FilterConfig filterConfig) {//初始化过滤器
        this.config = filterConfig;
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
                         FilterChain chain) throws IOException, ServletException {
        // 获取配置参数
        String loginURL = config.getInitParameter("loginURL");
        String loginProcess = config.getInitParameter("loginProcess");
        String encoding = config.getInitParameter("encoding");

        if( loginURL == null ){
            loginURL = "/login.html";
        }
        if( loginProcess == null ){
            loginProcess = "/core/user/login";
        }
        if( encoding == null ){
            encoding = "utf-8";
        }
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        // 设置请求的字符集（post请求方式有效）
        request.setCharacterEncoding(encoding);

        // 不带http://域名:端口的地址
        String uri = request.getRequestURI();
        String extra = "/register.html,/core/user/register,/core/user/getAllHospital,/index.html"; //需要额外放行的URI
        String extra1 = "/static/";
        String extra2 = "/api2doc/";
        String extra3 = "/website/";
        String extra4 = "/image/";
        String extra5 = "/actuator/";
        if (uri.contains(loginURL) || uri.contains(loginProcess) || uri.contains(extra1)
                || extra.indexOf(uri) != -1 || uri.contains(extra2) || uri.contains(extra3)
                    || uri.contains(extra4) || uri.contains(extra5)) {
            // 请求的登录，放行
            chain.doFilter(request, response);
        } else {
            logger.debug("【URL拦截】当前uri："+uri);
            String tokenStr = request.getHeader("Authorization");
            logger.debug("【URL拦截】获取token："+tokenStr);
            boolean tokenValid = UtilTokenDealer.checkToken(tokenStr);
            logger.debug("【URL拦截】验证token合法结果："+tokenValid);

            if( !tokenValid ){
                // 重定向到login（"401")
                logger.debug("【URL拦截】token已失效，401，重定向到login");
                UtilResponse.resetToLogin(response);
            } else {
                // 已经登录，放行，放行前，把token作为属性放入request中
                logger.info("【URL拦截】【设置token】 request:"+request+"，token:"+tokenStr);
                UtilRequestAttrHolder.setAttribute(request,"token",tokenStr);
                logger.debug("【URL拦截】token未失效，已经登录，放行");
                chain.doFilter(request, response);
            }
        }
    }

    @Override
    public void destroy() {
    }

}
