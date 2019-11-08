package com.yyk.sz.common.base.utils;

import com.yyk.sz.common.base.domain.security.CurrentUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by lhw on 2018/12/26
 * session相关工具
 */
@WebListener
public class UtilSession implements HttpSessionListener {

    private static ConcurrentHashMap<CurrentUser, HttpSession> userSessions = new ConcurrentHashMap<>();
    private static Logger logger = LoggerFactory.getLogger(UtilSession.class);

    /**
     * 获取当前请求的session信息
     * @return 返回session
     */
    public static HttpSession getSession() {
        //获取当前session
        HttpSession session = UtilRequest.getRequest().getSession();

        logger.debug("【UtilSession】取得session：" + session);
        synchronized (session) {
            //设置ip
            if (session != null) {
                if (session.getAttribute("ip") == null) {  //第一次取session
                    String ip = UtilIP.getIpAddr();
                    logger.debug("【UtilSession】首次获取的session，设置IP：" + ip + "，给session：" + session);
                    session.setAttribute("ip", ip);
                }
            }
            return session;
        }
    }

    /**
     * 获取指定用户账号的既存session信息，
     * @return 返回既存session
     */
    public static ArrayList<HttpSession> getExistedSession(String account) {
        ArrayList<HttpSession> foundSessions = new ArrayList();
        userSessions.forEach((user,session)->{if(user.getAccount().equalsIgnoreCase(account)){foundSessions.add(session);}});
        if( foundSessions.size() == 0 ){
            logger.debug("【UtilSession】获取用户："+account+"，的既存session，共0个，没有已存的session");
            return foundSessions;
        }
        logger.debug("【UtilSession】获取用户："+account+"，的既存session，共："+foundSessions.size()+"个。");
        return foundSessions;
    }


    public static void setSession(CurrentUser user, HttpSession session){
        if( user == null || session == null ){
            return;
        }
        userSessions.put(user, session);
    }

    /**
     * 判断指定的session是否有效（没有被销毁）
     * @param ps
     * @return
     */
    public static boolean findSession(HttpSession ps){
        if( ps == null ){
            return false;
        }
        synchronized (ps) {
            ArrayList<HttpSession> sessions = new ArrayList<>();
            userSessions.forEach((user, session) -> {
                if (session.getId().equalsIgnoreCase(ps.getId())) {
                    sessions.add(session);
                }
            });
            logger.debug("【UtilSession】【查找session】找到与参数session相同id的既存session数量：" + sessions.size());
            if (sessions.size() > 0) {
                return true;
            }
            return false;
        }
    }

    /**
     * 移除session，容器不再管理（使用findSession查找不到）
     * @param ps
     */
    public static void removeSession(HttpSession ps){
        if( ps == null ){
            return ;
        }
        //对参数session上锁，目的：防止删除未完成前有查找（findSession）操作
        synchronized (ps) {
            ArrayList<CurrentUser> cus = new ArrayList<>();
            userSessions.forEach((user, session) -> {
                if (session.getId().equalsIgnoreCase(ps.getId())) {
                    cus.add(user);
                }
            });
            logger.debug("【UtilSession】【移除session】判断需要移除的session数量：" + cus.size());
            if (cus.size() > 0) {
                cus.forEach((user) -> userSessions.remove(user));
                logger.debug("【UtilSession】【移除session】移除完毕");
            }
        }
    }

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        logger.debug("【UtilSession】【监听到session创建】");
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        logger.debug("【UtilSession】【监听到session销毁】，从容器中移除。");
        removeSession(se.getSession());
    }
}
