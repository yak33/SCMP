//package com.yyk.sz.zhzy.common.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.CorsRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
///**
// * 跨域配置
// *
// * @Author: ZhangChao
// * @Date: 2019/2/27 16:17
// * @Version: 1.0
// */
//@Configuration
//public class GlobalCorsConfig {
//
//    @Bean
//    public WebMvcConfigurer corsConfigurer(){
//        // 重写父类提供的跨域请求处理的接口
//        return new WebMvcConfigurer() {
//            @Override
//            public void addCorsMappings(CorsRegistry registry) {
//                // 添加映射路径
//                registry.addMapping("/**")
//                        // 放行哪些原始域
//                        .allowedOrigins("http://127.0.0.1", "http://localhost")
//                        // 放行哪些请求方式
//                        .allowedMethods("*")
//                        // 放行哪些头部信息
//                        .allowedHeaders("*")
//                        // 是否允许携带 cookie
//                        .allowCredentials(true);
//            }
//        };
//    }
//
//}
