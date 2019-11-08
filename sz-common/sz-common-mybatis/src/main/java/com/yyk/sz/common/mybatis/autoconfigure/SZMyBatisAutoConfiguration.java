package com.yyk.sz.common.mybatis.autoconfigure;

import com.yyk.sz.common.base.domain.BaseEntity;
import com.yyk.sz.common.mybatis.custom.SZSqlSessionFactoryBean;
import com.yyk.sz.common.mybatis.page.PageObjectFactory;
import com.yyk.sz.common.mybatis.page.PageObjectWrapperFactory;
import com.yyk.sz.common.mybatis.plugin.MyBatisPluginsConfiguration;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.ibatis.mapping.DatabaseIdProvider;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.boot.autoconfigure.MybatisAutoConfiguration;
import org.mybatis.spring.boot.autoconfigure.MybatisProperties;
import org.mybatis.spring.boot.autoconfigure.SpringBootVFS;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import javax.sql.DataSource;

/**
 * Created by zhaofs on 2017/4/7.
 * 对原有mybatis自动配置进行扩展
 */
@Configuration

@ConditionalOnClass({SqlSessionFactory.class, SqlSessionFactoryBean.class})

@AutoConfigureAfter(DataSourceAutoConfiguration.class)
@AutoConfigureBefore(org.mybatis.spring.boot.autoconfigure.MybatisAutoConfiguration.class)

@EnableConfigurationProperties(MybatisProperties.class)

@Import({MybatisAutoConfiguration.AutoConfiguredMapperScannerRegistrar.class, MyBatisPluginsConfiguration.class})
public class SZMyBatisAutoConfiguration implements InitializingBean {
    private static final Log logger = LogFactory.getLog(SZMyBatisAutoConfiguration.class);
    private static final String BASE_PACKAGE="com.yyk.sz";

    private final MybatisProperties properties;
    private final Interceptor[] interceptors;
    private final ResourceLoader resourceLoader;
    private final DatabaseIdProvider databaseIdProvider;

    public SZMyBatisAutoConfiguration(MybatisProperties properties,
                                      ObjectProvider<Interceptor[]> interceptorsProvider,
                                      ResourceLoader resourceLoader,
                                      ObjectProvider<DatabaseIdProvider> databaseIdProvider) {
        this.properties = properties;
        this.interceptors = interceptorsProvider.getIfAvailable();
        this.resourceLoader = resourceLoader;
        this.databaseIdProvider = databaseIdProvider.getIfAvailable();
    }

    @Bean
    @ConditionalOnMissingBean
    public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
        SqlSessionFactoryBean factory = new SZSqlSessionFactoryBean(BASE_PACKAGE);
        factory.setDataSource(dataSource);
        factory.setVfs(SpringBootVFS.class);

        if (StringUtils.hasText(this.properties.getConfigLocation())) {
            factory.setConfigLocation(this.resourceLoader.getResource(this.properties.getConfigLocation()));
        }
        factory.setConfiguration(properties.getConfiguration());
        if (this.properties.getConfigurationProperties() != null) {
            factory.setConfigurationProperties(this.properties.getConfigurationProperties());
        }
        if (!ObjectUtils.isEmpty(this.interceptors)) {
            factory.setPlugins(this.interceptors);
        }
        if (this.databaseIdProvider != null) {
            factory.setDatabaseIdProvider(this.databaseIdProvider);
        }
        if (StringUtils.hasLength(this.properties.getTypeHandlersPackage())) {
            factory.setTypeHandlersPackage(this.properties.getTypeHandlersPackage());
        }


        /*设置映射文件*/
        if (!ObjectUtils.isEmpty(this.properties.resolveMapperLocations())) {
            factory.setMapperLocations(this.properties.resolveMapperLocations());
        }else{
            ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
            factory.setMapperLocations(resolver.getResources("classpath*:"+BASE_PACKAGE+"/**/*Mapper.xml"));
            logger.debug("mapper location is classpath*:"+BASE_PACKAGE+"/**/*Mapper.xml");
        }

        /*设置实体别名扫描类型*/
        if (StringUtils.hasLength(this.properties.getTypeAliasesPackage())) {
            factory.setTypeAliasesPackage(this.properties.getTypeAliasesPackage());
        }else{
            factory.setTypeAliasesPackage(BASE_PACKAGE);
        }
        factory.setTypeAliasesSuperType(BaseEntity.class);

        // 自定义类型处理（Paging类型）
        factory.setObjectFactory(new PageObjectFactory());
        factory.setObjectWrapperFactory(new PageObjectWrapperFactory());

        logger.debug("custom mybatis auto configuration  finished!");
        return factory.getObject();
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        logger.info("[SZ共通-mybatis]初始化");
    }
}