package com.yyk.sz.zhzy.common.config;

import com.yyk.sz.common.base.utils.UtilTokenDealer;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix="zhzy.token")
public class ConfigToken {

    private String timeout;

    public String getTimeout() {
        return timeout;
    }

    public void setTimeout(String timeout) {
        this.timeout = timeout;
        //读取到配置时，写入Util中
        int timeoutInt = Integer.parseInt(timeout);
        UtilTokenDealer.setTimeoutLimitMinutes(timeoutInt);
    }
}
