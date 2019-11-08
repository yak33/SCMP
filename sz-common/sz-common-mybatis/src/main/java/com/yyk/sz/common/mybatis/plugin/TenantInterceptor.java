package com.yyk.sz.common.mybatis.plugin;

import com.yyk.sz.common.base.utils.UtilRequest;
import com.yyk.sz.common.base.utils.UtilRequestAttrHolder;
import com.yyk.sz.common.base.utils.UtilTokenDealer;
import com.yyk.sz.common.mybatis.util.PluginUtil;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.SystemMetaObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import java.sql.Connection;
import java.util.Properties;

/**
 *
 */
@SuppressWarnings("all")
@Intercepts({@Signature(type = StatementHandler.class, method = "prepare", args = {Connection.class, Integer.class})})
public class TenantInterceptor implements Interceptor {

	private static final Logger logger = LoggerFactory.getLogger(TenantInterceptor.class);

	private static final String preState="/*!mycat:datanode=";
	private static final String afterState="*/";

	private Properties props = null;

	@Override
	public Object intercept(Invocation invocation) throws Throwable {
		String interceptMethod = invocation.getMethod().getName();
		if(!"prepare".equals(interceptMethod)) {
			return invocation.proceed();
		}

		StatementHandler handler = (StatementHandler) PluginUtil.processTarget(invocation.getTarget());
		MetaObject metaObject = SystemMetaObject.forObject(handler);
		//获取原始sql
		String originalSql = (String) metaObject.getValue("delegate.boundSql.sql");
		String newSql = originalSql;
		logger.debug("==> originalSql: " + originalSql);

        //追加SQL注解（租户节点注解）
		HttpServletRequest request = UtilRequest.getRequest();
		String node = (String)UtilRequestAttrHolder.getAttribute(request, "node");//直接设置了node
		String tokenStr = (String)UtilRequestAttrHolder.getAttribute(request, "token");//未设置node，设置了token
        logger.info("【多租户拦截】【获取token】 request:"+request+"，token:"+tokenStr);
        logger.info("【多租户拦截】【node:】"+node);
        //当session内有有效信息，说明已经登录，使用session内存储的租户节点构造SQL
        boolean isNodeExist = false;
        if( node != null){
            newSql = preState + node + afterState + originalSql;
            isNodeExist = true;
        }else{
        	if( tokenStr != null ){
                node = (String)UtilTokenDealer.getTokenAttr(tokenStr,"node");
                if( node != null ){
                    newSql = preState + node + afterState + originalSql;
                    isNodeExist = true;
                }
			}
        }

        //当没有有效节点信息，说明还没有登录，此时所有的查询都指向公共库
        if( !isNodeExist ){
            newSql = preState + "dn0" + afterState + originalSql;
        }

        //有关数据共享的SQL，不走mycat，全部放过
		if (newSql.indexOf("T_CountyTown") != -1
				|| newSql.indexOf("T_CountyHosp") != -1
					|| newSql.indexOf("T_HospRelation") != -1
						|| newSql.indexOf("Proc_EBMList") != -1
							|| newSql.indexOf("Proc_EBMSearch") != -1){
			logger.debug("【多租户拦截】这是属于数据共享的，放过它吧宝贝儿!");
			newSql = originalSql;
		}

		//修改原始sql
		if(newSql.length() > 0){
			logger.debug("[mybatis多租户拦截][替换sql]==> newSql: " + newSql);
			metaObject.setValue("delegate.boundSql.sql", newSql);
		}
	    return invocation.proceed();
	}

	@Override
	public Object plugin(Object target) {
		if (target instanceof StatementHandler) {
            return Plugin.wrap(target, this);
        } else {
            return target;
        }
	}

	@Override
	public void setProperties(Properties properties) {
		if(null != properties && !properties.isEmpty()) {
			props = properties;
		}
	}

}
