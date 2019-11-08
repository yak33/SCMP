package com.yyk.sz.common.base.beans;

import com.yyk.sz.common.base.config.ConfigRedis;
import io.lettuce.core.RedisClient;
import io.lettuce.core.RedisURI;
import io.lettuce.core.api.StatefulRedisConnection;
import io.lettuce.core.api.sync.RedisCommands;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BeanRedis {

    @Autowired
    private RedisURI redisURI;

    public boolean valid(){
        return redisURI != null;
    }

    public void setString(String key, String value){
        RedisClient redisClient = RedisClient.create(redisURI);
        StatefulRedisConnection<String, String> connection = redisClient.connect();
        RedisCommands<String, String> syncCommands = connection.sync();

        syncCommands.set(key, value);

        connection.close();
        redisClient.shutdown();
    }

    public String getString(String key){
        RedisClient redisClient = RedisClient.create(redisURI);
        StatefulRedisConnection<String, String> connection = redisClient.connect();
        RedisCommands<String, String> syncCommands = connection.sync();

        String result = null;
        result= syncCommands.get(key);

        connection.close();
        redisClient.shutdown();

        return result;
    }

    public void removeString(String key){
        RedisClient redisClient = RedisClient.create(redisURI);
        StatefulRedisConnection<String, String> connection = redisClient.connect();
        RedisCommands<String, String> syncCommands = connection.sync();

        syncCommands.del(key);

        connection.close();
        redisClient.shutdown();
    }

    public void setHash(String key, String subkey, String value){
        RedisClient redisClient = RedisClient.create(redisURI);
        StatefulRedisConnection<String, String> connection = redisClient.connect();
        RedisCommands<String, String> syncCommands = connection.sync();

        syncCommands.hset(key, subkey, value);

        connection.close();
        redisClient.shutdown();
    }

    public String getHash(String key, String subkey){
        RedisClient redisClient = RedisClient.create(redisURI);
        StatefulRedisConnection<String, String> connection = redisClient.connect();
        RedisCommands<String, String> syncCommands = connection.sync();

        String result = null;
        result= syncCommands.hget(key, subkey);

        connection.close();
        redisClient.shutdown();
        return result;
    }

    public void removeHash(String key, String subkey){
        RedisClient redisClient = RedisClient.create(redisURI);
        StatefulRedisConnection<String, String> connection = redisClient.connect();
        RedisCommands<String, String> syncCommands = connection.sync();

        syncCommands.hdel(key, subkey);

        connection.close();
        redisClient.shutdown();
    }

    public void removeHash(String key){
        RedisClient redisClient = RedisClient.create(redisURI);
        StatefulRedisConnection<String, String> connection = redisClient.connect();
        RedisCommands<String, String> syncCommands = connection.sync();

        syncCommands.hdel(key);

        connection.close();
        redisClient.shutdown();
    }

    public boolean existKey(String key){
        RedisClient redisClient = RedisClient.create(redisURI);
        StatefulRedisConnection<String, String> connection = redisClient.connect();
        RedisCommands<String, String> syncCommands = connection.sync();

        long result = syncCommands.exists(key);

        connection.close();
        redisClient.shutdown();

        return result > 0;
    }

}
