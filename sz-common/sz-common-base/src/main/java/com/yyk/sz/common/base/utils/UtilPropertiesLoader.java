package com.yyk.sz.common.base.utils;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.NoSuchElementException;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by xujiashuai on 2016/9/5.
 */
public class UtilPropertiesLoader {

    private static Logger logger = LoggerFactory.getLogger(UtilPropertiesLoader.class);

    public static ConcurrentHashMap<String, UtilPropertiesLoader> propertiesHolder = new ConcurrentHashMap<String, UtilPropertiesLoader>();

    private Properties properties;

    private UtilPropertiesLoader(Properties properties){
        this.properties = properties;
    }

    public static UtilPropertiesLoader getPropertyLoader(String resourcesPath){
        UtilPropertiesLoader propertiesLoader =  propertiesHolder.get(resourcesPath);
        if(propertiesLoader == null){
            synchronized(UtilPropertiesLoader.class){
                propertiesLoader =  propertiesHolder.get(resourcesPath);
                if(propertiesLoader == null){
                    Properties properties = loadProperties(resourcesPath);
                    propertiesLoader = new UtilPropertiesLoader(properties);
                    propertiesHolder.put(resourcesPath, propertiesLoader);
                }
            }
        }
        return propertiesLoader;
    }

    private String getValue(String key) {
        String systemProperty = System.getProperty(key);
        return systemProperty != null?systemProperty:this.properties.getProperty(key);
    }

    public String getProperty(String key) {
        String value = this.getValue(key);
        if(value == null) {
            throw new NoSuchElementException();
        } else {
            return value;
        }
    }

    public String getProperty(String key, String defaultValue) {
        String value = this.getValue(key);
        return value != null?value:defaultValue;
    }

    public Integer getInteger(String key) {
        String value = this.getValue(key);
        if(value == null) {
            throw new NoSuchElementException();
        } else {
            return Integer.valueOf(value);
        }
    }

    public Integer getInteger(String key, Integer defaultValue) {
        String value = this.getValue(key);
        return value != null?Integer.valueOf(value):defaultValue;
    }

    public Double getDouble(String key) {
        String value = this.getValue(key);
        if(value == null) {
            throw new NoSuchElementException();
        } else {
            return Double.valueOf(value);
        }
    }

    public Double getDouble(String key, Double defaultValue) {
        String value = this.getValue(key);
        return Double.valueOf(value != null?Double.valueOf(value).doubleValue():(double)defaultValue.intValue());
    }

    public Float getFloat(String key, Double defaultValue) {
        String value = this.getValue(key);
        if(value == null) {
            throw new NoSuchElementException();
        } else {
            return Float.valueOf(value);
        }
    }

    public Float getFloat(String key, Float defaultValue) {
        String value = this.getValue(key);
        return Float.valueOf(value != null?Float.valueOf(value).floatValue():(float)defaultValue.floatValue());
    }

    public Boolean getBoolean(String key) {
        String value = this.getValue(key);
        if(value == null) {
            throw new NoSuchElementException();
        } else {
            return Boolean.valueOf(value);
        }
    }

    public Boolean getBoolean(String key, boolean defaultValue) {
        String value = this.getValue(key);
        return Boolean.valueOf(value != null?Boolean.valueOf(value).booleanValue():defaultValue);
    }

    private static Properties loadProperties(String... resourcesPaths) {//放在classpath下面
        Properties props = new Properties();
        String[] arr = resourcesPaths;
        int len = resourcesPaths.length;
        for(int i = 0; i < len; ++i) {
            String location = arr[i];
            logger.debug("Loading properties file from path:{}", location);
            InputStream is = null;
            try {
                is = UtilPropertiesLoader.class.getClassLoader().getResourceAsStream(location);
                props.load(is);
            } catch (IOException var12) {
                logger.info("Could not load properties from path:{}, {} ", location, var12.getMessage());
            } finally {
                IOUtils.closeQuietly(is);
            }
        }

        return props;
    }
}
