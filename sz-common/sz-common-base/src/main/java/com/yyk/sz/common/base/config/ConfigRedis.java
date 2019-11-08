package com.yyk.sz.common.base.config;

import io.lettuce.core.RedisURI;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigRedis {
    @Value("${spring.redis.host}")
    private String url;
    @Value("${spring.redis.password}")
    private String password;
    @Value("${spring.redis.database}")
    private int database;

    @Bean
    public RedisURI redisUri(){
        return RedisURI.Builder.redis(url)
                .withPassword(password)
                .withDatabase(database)
                .build();
    }

}
