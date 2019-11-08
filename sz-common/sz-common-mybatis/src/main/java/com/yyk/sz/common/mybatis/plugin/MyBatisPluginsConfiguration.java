package com.yyk.sz.common.mybatis.plugin;

import com.github.pagehelper.PageHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

/**
 * Created by zhaofs on 2017/4/7.
 * MyBatis 插件配置
 */
@Configuration
public class MyBatisPluginsConfiguration {
    private static final Log logger = LogFactory.getLog(MyBatisPluginsConfiguration.class);

    /**
     * 插件：共通字段添加
     * @return
     */
    @Bean
    @ConditionalOnMissingBean
    public CommonDataInterceptor commonDataInterceptor(){
        CommonDataInterceptor commonDate = new CommonDataInterceptor();
        Properties commonDateProps = new Properties();
        commonDateProps.setProperty("UUIDColumn",   "UUID");
        commonDateProps.setProperty("createDateColumn",   "SysCreateDate");
        commonDateProps.setProperty("updateDateColumn",   "SysUpdateDate");
        commonDateProps.setProperty("versionColumn",      "versionNum");
        commonDateProps.setProperty("delFlagColumn",      "SysDelFlag");
        commonDateProps.setProperty("createByColumn",     "SysCreateBy");
        commonDateProps.setProperty("updateByColumn",     "SysUpdateBy");
        commonDate.setProperties(commonDateProps);
        return commonDate;
    }

    /**
     * 插件：多租户分库
     * @return
     */
    @Bean
    @ConditionalOnMissingBean
    public TenantInterceptor tenantInterceptor(){
        TenantInterceptor tenantInterceptor = new TenantInterceptor();
        return tenantInterceptor;
    }


    /**
     * 插件：分页
     * @return PageHelper
     */
    @Bean
    @ConditionalOnMissingBean
    public PageHelper pageHelper(){
        PageHelper pageHelper = new PageHelper();
        Properties props = new Properties();
        props.setProperty("reasonable", "true");                //pageNum合理化，即，只有一页数据，pageNum为2则相当于1，为0也相当于1
        props.setProperty("supportMethodsArguments", "true");   //自动根据params配置取值
        props.setProperty("params", "count=countSql");
        props.setProperty("returnPageInfo", "check");           //用来支持直接返回PageInfo类型，默认值none，
                                                                //可选参数always总是返回PageInfo类型,check检查返回类型是否为PageInfo,
                                                                //none返回Page(List)类型。
                                                                //用法和配置参考com.github.pagehelper.test.basic包下的PageInfoTest，
                                                                //特别要注意接口的返回值和xml中的resultType类型。

        pageHelper.setProperties(props);

        logger.debug("Mybatis PageHelper plugin init finished");
        return pageHelper;
    }
}
