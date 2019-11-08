package com.yyk.sz.common.base.utils;

import com.alibaba.fastjson.JSON;
import com.yyk.sz.common.base.beans.BeanRedis;
import com.yyk.sz.common.base.beans.BeanSpringContext;
import com.yyk.sz.common.base.domain.Token;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

public class UtilTokenDealer {

    private static int timeoutMinutes = 20;

    private static final String REDIS_TOKEN_USERNAME_PREFIX = "Token_UserName_";
    private static final String REDIS_TOKEN_ATTR_PREFIX = "Token_Attr_";

    private static ConcurrentHashMap<String, Token> userTokens = new ConcurrentHashMap<>();
    private static ConcurrentHashMap<String, HashMap<String, String>> tokenAttrsContainer = new ConcurrentHashMap<>();
    private static Logger logger = LoggerFactory.getLogger(UtilTokenDealer.class);

    public static void setTimeoutLimitMinutes(int tm){
        timeoutMinutes = tm;
    }

    /**
     * 生成当前请求的token信息
     * @return 返回token
     */
    public static Token makeToken(String userName) {

        logger.debug("【UtilToken】makeToken开始");

        if( userName == null ){
            logger.error("【UtilToken】参数userName为空，无法获取token");
            return null;
        }

        Token token = new Token();
        token.uuid = UtilUuid.uuid();
        token.userName = userName;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        token.createTime = sdf.format(new Date());
        token.ip = UtilIP.getIpAddr();

        //放入redis还是内存，优先放入redis
        BeanRedis redis = BeanSpringContext.getBean(BeanRedis.class);
        String tokenMd5 = UtilMD5.md5(JSON.toJSONString(token));
        logger.debug("tokenMd5:"+tokenMd5);
        //20190221追加
        token.tokenStr = tokenMd5;
        if( redis.valid() ) {//redis已设置，放入redis
            redis.setString(REDIS_TOKEN_USERNAME_PREFIX + userName, JSON.toJSONString(token));
            redis.setHash(REDIS_TOKEN_ATTR_PREFIX + tokenMd5, "userName", userName);
            redis.setHash(REDIS_TOKEN_ATTR_PREFIX + tokenMd5, "node", "dn0");
        }else{//redis未设置，放入内存
            userTokens.put(userName, token);
            setAttribute(tokenMd5, "userName", userName);
            setAttribute(tokenMd5, "node", "dn0");
        }

        return token;
    }

    /**
     * 获取当前请求的token信息
     * @return 返回token
     */
    public static Token getExistedToken(String userName) {

        logger.debug("【UtilToken】取得既存token开始"+",username:"+userName);

        if( userName == null ){
            logger.error("【UtilToken】参数userName为空，无法获取既存token");
            return null;
        }

        //从redis还是内存取token，优先从redis取
        BeanRedis redis = BeanSpringContext.getBean(BeanRedis.class);
        Token token = null;
        if( redis.valid() ) {//redis已设置，从redis取
            String tokenJson = redis.getString(REDIS_TOKEN_USERNAME_PREFIX + userName);
            token = JSON.parseObject(tokenJson, Token.class);
        }else{//redis未设置，从内存取
            token = userTokens.get(userName);
        }
        logger.debug("【UtilToken】获取既存token："+token+"");

        return token;
    }

    /**
     * 验证token
     * @param tokenStr
     * @return
     */
    public static boolean checkToken(String tokenStr){
        //从redis还是内存取token，优先从redis取
        BeanRedis redis = BeanSpringContext.getBean(BeanRedis.class);
        Token token = null;
        if( redis.valid() ) {//redis已设置，从redis取
            boolean tokenExist = redis.existKey(REDIS_TOKEN_ATTR_PREFIX + tokenStr);
            if( !tokenExist ){
                logger.debug("【UtilToken】token不存在");
                return false;
            }
            String userName = redis.getHash(REDIS_TOKEN_ATTR_PREFIX + tokenStr, "userName");
            if( userName == null ){
                logger.debug("【UtilToken】用户名不存在");
                return false;
            }

            String tokenJson = redis.getString(REDIS_TOKEN_USERNAME_PREFIX + userName);
            logger.debug("123456789: "+tokenJson);
            token = JSON.parseObject(tokenJson, Token.class);
        }else{//redis未设置，从内存取
            boolean tokenExist = tokenAttrsContainer.containsKey(tokenStr);
            if( !tokenExist ){
                logger.debug("【UtilToken】token不存在");
                return false;
            }
            String userName = (String)getAttribute(tokenStr,"userName");
            if( userName == null ){
                logger.debug("【UtilToken】用户名不存在");
                return false;
            }
            token = userTokens.get(userName);
        }
        if( token == null ){
            logger.debug("【UtilToken】容器内不存在");
            return false;
        }
        if( isTokenTimeout(token) ){
            logger.debug("【UtilToken】token超时");
            return false;
        }
        refreshTokenCreateTime(token);
        return true;
    }

    /**
     * 移除token，容器不再管理
     * @param token
     */
    public static void removeToken(Token token){
        if( token == null ){
            return;
        }
        logger.debug("【removeToken】token.userName:"+token.userName+", token.createTime:"+token.createTime);
//        String tokenMd5 = UtilMD5.md5(JSON.toJSONString(token));
        String tokenMd5 = token.tokenStr;
        logger.debug("【removeToken】tokenMd5:"+tokenMd5);
        //没有注释，没有明白几句代码的意义何在？
//        String userName = (String)getAttribute(tokenMd5,"userName");
        String userName = token.userName;
//        if( userName == null ){
//            logger.debug("【removeToken】这里的userName就一直是null...");
//            return;
//        }

        //从redis还是内存删token，优先从redis删
        BeanRedis redis = BeanSpringContext.getBean(BeanRedis.class);
        if( redis.valid() ) {//redis已设置，从redis删
            redis.removeString(REDIS_TOKEN_USERNAME_PREFIX + userName);
            redis.removeHash(REDIS_TOKEN_ATTR_PREFIX + tokenMd5, "userName");
            redis.removeHash(REDIS_TOKEN_ATTR_PREFIX + tokenMd5, "node");
        }else{//redis未设置，从内存删
            userTokens.remove(userName);
            tokenAttrsContainer.remove(tokenMd5);
        }
    }

    public static void setTokenAttr(String tokenMd5, String attrName, String attrValue){
        //向redis还是内存设置，优先从redis设
        BeanRedis redis = BeanSpringContext.getBean(BeanRedis.class);
        if( redis.valid() ) {//redis已设置，向redis设
            redis.setHash(REDIS_TOKEN_ATTR_PREFIX + tokenMd5, attrName, attrValue);
        }else{//redis未设置，向内存设
            setAttribute(tokenMd5, attrName, attrValue);
        }
    }

    public static String getTokenAttr(String tokenMd5, String attrName){
        //向redis还是内存设置，优先从redis设
        BeanRedis redis = BeanSpringContext.getBean(BeanRedis.class);
        if( redis.valid() ) {//redis已设置，向redis设
            return redis.getHash(REDIS_TOKEN_ATTR_PREFIX + tokenMd5, attrName);
        }else{//redis未设置，向内存设
            return (String)getAttribute(tokenMd5, attrName);
        }
    }

    public static String getTokenStr(Token token){
//        String tokenMd5 = UtilMD5.md5(JSON.toJSONString(token));
        return token.tokenStr;
    }

    public static Token getToken(String tokenStr){
        //从redis还是内存获取token，优先从redis获取
        BeanRedis redis = BeanSpringContext.getBean(BeanRedis.class);
        if( redis.valid() ) {//redis已设置，从redis获取
            String userName = redis.getHash(REDIS_TOKEN_ATTR_PREFIX + tokenStr, "userName");
            logger.debug("【getToken】userName:"+userName);
            if( userName == null ){
                return null;
            }
            String tokenJson = redis.getString(REDIS_TOKEN_USERNAME_PREFIX + userName);
            Token token = JSON.parseObject(tokenJson, Token.class);
            return token;
        }else{//redis未设置，从内存获取
            String userName = (String)getAttribute(tokenStr,"userName");
            if( userName == null ){
                return null;
            }
            return userTokens.get(userName);
        }
    }


    /**
     * 设置属性
     */
    private static void setAttribute(String tokenMd5, String attrName, Object attrValue) {
        if( tokenMd5 == null || attrName == null || attrValue == null ){
            return;
        }

        HashMap tokenAttrs = tokenAttrsContainer.get(tokenMd5);
        if( tokenAttrs == null ){
            tokenAttrs = new HashMap<>();
            tokenAttrs.put(attrName,attrValue);
            tokenAttrsContainer.put(tokenMd5,tokenAttrs);
        }else{
            tokenAttrs.put(attrName,attrValue);
        }
    }

    private static Object getAttribute(String tokenMd5, String attrName){
        if( tokenMd5 == null || attrName == null  ){
            return null;
        }
        HashMap tokenAttrs = tokenAttrsContainer.get(tokenMd5);
        if( tokenAttrs == null ){
            tokenAttrsContainer.put(tokenMd5, new HashMap<>());
            return null;
        }else{
            return tokenAttrs.get(attrName);
        }
    }

    /**
     * 检测token是否过期
     * @param token
     * @return
     */
    private static boolean isTokenTimeout(Token token){
        String createTime = token.createTime;
        try {
            Calendar createCalen = Calendar.getInstance();
            logger.debug("【UtilToken】token创建时间："+createTime);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
            Date createDate = sdf.parse(createTime);
//            logger.debug("【UtilToken】parse之后时间："+sdf.format(createDate));
            createCalen.setTime(createDate);
            createCalen.add(Calendar.SECOND, timeoutMinutes * 60);
            Date createDateAfter = createCalen.getTime();
            logger.debug("【UtilToken】token创建时间加："+timeoutMinutes+"分钟后："+sdf.format(createDateAfter));
            Date nowDate = new Date();
            logger.debug("【UtilToken】当前时间："+sdf.format(nowDate));//判断
            logger.debug("【UtilToken】判断结果："+nowDate.after(createDateAfter));

            return nowDate.after(createDateAfter);
        }catch (Exception e){
            e.printStackTrace();
        }
        return true;
    }

    /**
     * 刷新token的创建时间
     * @param token
     */
    private static void refreshTokenCreateTime(Token token){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        token.createTime = sdf.format(new Date());
        BeanRedis redis = BeanSpringContext.getBean(BeanRedis.class);
        String userName = token.userName;
        logger.debug("刷新token的创建时间："+token.userName+","+token.createTime+","+token.ip+","+token.uuid);
        redis.setString(REDIS_TOKEN_USERNAME_PREFIX + userName, JSON.toJSONString(token));
    }
}
