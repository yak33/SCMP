package com.yyk.sz;

import com.terran4j.commons.api2doc.config.EnableApi2Doc;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableApi2Doc
@SpringBootApplication
@MapperScan({"com.yyk.sz.zhzy.*.mapper","com.yyk.sz.zhzy.*.*.mapper","com.yyk.sz.zhzy.*.*.mappercust"})
@ServletComponentScan
@EnableDiscoveryClient
public class ZhzyStarter {
    public static void main(String[] args) {
        SpringApplication.run(ZhzyStarter.class, args);
    }
}








