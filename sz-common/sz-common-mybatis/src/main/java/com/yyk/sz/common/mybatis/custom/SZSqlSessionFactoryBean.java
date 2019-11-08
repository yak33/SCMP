package com.yyk.sz.common.mybatis.custom;

import com.yyk.sz.common.base.domain.BaseEntity;
import com.yyk.sz.common.base.identify.EnumIdentify;
import com.yyk.sz.common.mybatis.handler.EnumHandler;
import org.apache.ibatis.builder.xml.XMLConfigBuilder;
import org.apache.ibatis.builder.xml.XMLMapperBuilder;
import org.apache.ibatis.cache.Cache;
import org.apache.ibatis.executor.ErrorContext;
import org.apache.ibatis.io.ResolverUtil;
import org.apache.ibatis.io.VFS;
import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.apache.ibatis.mapping.DatabaseIdProvider;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.reflection.factory.ObjectFactory;
import org.apache.ibatis.reflection.wrapper.ObjectWrapperFactory;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.type.TypeHandler;
import org.apache.ibatis.type.TypeHandlerRegistry;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.transaction.SpringManagedTransactionFactory;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.core.NestedIOException;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.jdbc.datasource.TransactionAwareDataSourceProxy;
import org.springframework.util.ResourceUtils;

import javax.sql.DataSource;
import java.io.IOException;
import java.lang.reflect.Field;
import java.net.*;
import java.sql.SQLException;
import java.util.*;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

import static org.springframework.util.Assert.notNull;
import static org.springframework.util.Assert.state;
import static org.springframework.util.ObjectUtils.isEmpty;
import static org.springframework.util.StringUtils.hasLength;
import static org.springframework.util.StringUtils.tokenizeToStringArray;

/**
 * Created by xujiashuai on 2016/10/17.
 */
public class SZSqlSessionFactoryBean extends SqlSessionFactoryBean {
    private static final Log LOGGER = LogFactory.getLog(SqlSessionFactoryBean.class);

    private Resource configLocation;

    private Configuration configuration;

    private Resource[] mapperLocations;

    private DataSource dataSource;

    private TransactionFactory transactionFactory;

    private Properties configurationProperties;

    private SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();

    private SqlSessionFactory sqlSessionFactory;

    //EnvironmentAware requires spring 3.1
    private String environment = SqlSessionFactoryBean.class.getSimpleName();

    private boolean failFast;

    private Interceptor[] plugins;

    private TypeHandler<?>[] typeHandlers;

    private String typeHandlersPackage;

    private Class<?>[] typeAliases;

    private String typeAliasesPackage;

    private Class<?> typeAliasesSuperType;

    //issue #19. No default provider.
    private DatabaseIdProvider databaseIdProvider;

    private Class<? extends VFS> vfs;

    private Cache cache;

    private ObjectFactory objectFactory;

    private ObjectWrapperFactory objectWrapperFactory;

    private String basePackage;

    public SZSqlSessionFactoryBean(String basePackage) {
        this.basePackage = basePackage;
    }

    /**
     * Sets the ObjectFactory.
     *
     * @param objectFactory
     * @since 1.1.2
     */
    @Override
    public void setObjectFactory(ObjectFactory objectFactory) {
        this.objectFactory = objectFactory;
    }

    /**
     * Sets the ObjectWrapperFactory.
     *
     * @param objectWrapperFactory
     * @since 1.1.2
     */
    @Override
    public void setObjectWrapperFactory(ObjectWrapperFactory objectWrapperFactory) {
        this.objectWrapperFactory = objectWrapperFactory;
    }

    /**
     * Gets the DatabaseIdProvider
     *
     * @return
     * @since 1.1.0
     */
    @Override
    public DatabaseIdProvider getDatabaseIdProvider() {
        return databaseIdProvider;
    }

    /**
     * Sets the DatabaseIdProvider.
     * As of version 1.2.2 this variable is not initialized by default.
     *
     * @param databaseIdProvider
     * @since 1.1.0
     */
    @Override
    public void setDatabaseIdProvider(DatabaseIdProvider databaseIdProvider) {
        this.databaseIdProvider = databaseIdProvider;
    }

    @Override
    public Class<? extends VFS> getVfs() {
        return this.vfs;
    }

    @Override
    public void setVfs(Class<? extends VFS> vfs) {
        this.vfs = vfs;
    }

    @Override
    public Cache getCache() {
        return this.cache;
    }

    @Override
    public void setCache(Cache cache) {
        this.cache = cache;
    }

    /**
     * Mybatis plugin list.
     *
     * @param plugins list of plugins
     * @since 1.0.1
     */
    @Override
    public void setPlugins(Interceptor[] plugins) {
        this.plugins = plugins;
    }

    /**
     * Packages to search for type aliases.
     *
     * @param typeAliasesPackage package to scan for domain objects
     * @since 1.0.1
     */
    @Override
    public void setTypeAliasesPackage(String typeAliasesPackage) {
        this.typeAliasesPackage = typeAliasesPackage;
    }

    /**
     * Super class which domain objects have to extend to have a type alias created.
     * No effect if there is no package to scan configured.
     *
     * @param typeAliasesSuperType super class for domain objects
     * @since 1.1.2
     */
    @Override
    public void setTypeAliasesSuperType(Class<?> typeAliasesSuperType) {
        this.typeAliasesSuperType = typeAliasesSuperType;
    }

    /**
     * Packages to search for type handlers.
     *
     * @param typeHandlersPackage package to scan for type handlers
     * @since 1.0.1
     */
    @Override
    public void setTypeHandlersPackage(String typeHandlersPackage) {
        this.typeHandlersPackage = typeHandlersPackage;
    }

    /**
     * Set type handlers. They must be annotated with {@code MappedTypes} and optionally with {@code MappedJdbcTypes}
     *
     * @param typeHandlers Type handler list
     * @since 1.0.1
     */
    @Override
    public void setTypeHandlers(TypeHandler<?>[] typeHandlers) {
        this.typeHandlers = typeHandlers;
    }

    /**
     * List of type aliases to register. They can be annotated with {@code Alias}
     *
     * @param typeAliases Type aliases list
     * @since 1.0.1
     */
    @Override
    public void setTypeAliases(Class<?>[] typeAliases) {
        this.typeAliases = typeAliases;
    }

    /**
     * If true, a final check is done on Configuration to assure that all mapped
     * statements are fully loaded and there is no one still pending to resolve
     * includes. Defaults to false.
     *
     * @param failFast enable failFast
     * @since 1.0.1
     */
    @Override
    public void setFailFast(boolean failFast) {
        this.failFast = failFast;
    }

    /**
     * Set the location of the MyBatis {@code SqlSessionFactory} config file. A typical value is
     * "WEB-INF/mybatis-configuration.xml".
     */
    @Override
    public void setConfigLocation(Resource configLocation) {
        this.configLocation = configLocation;
    }

    /**
     * Set a customized MyBatis configuration.
     *
     * @param configuration MyBatis configuration
     * @since 1.3.0
     */
    @Override
    public void setConfiguration(Configuration configuration) {
        this.configuration = configuration;
    }

    /**
     * Set locations of MyBatis mapper files that are going to be merged into the {@code SqlSessionFactory}
     * configuration at runtime.
     * <p>
     * This is an alternative to specifying "&lt;sqlmapper&gt;" entries in an MyBatis config file.
     * This property being based on Spring's resource abstraction also allows for specifying
     * resource patterns here: e.g. "classpath*:sqlmap/*-mapper.xml".
     */
    @Override
    public void setMapperLocations(Resource[] mapperLocations) {
        this.mapperLocations = mapperLocations;
    }

    /**
     * Set optional properties to be passed into the SqlSession configuration, as alternative to a
     * {@code &lt;properties&gt;} tag in the configuration xml file. This will be used to
     * resolve placeholders in the config file.
     */
    @Override
    public void setConfigurationProperties(Properties sqlSessionFactoryProperties) {
        this.configurationProperties = sqlSessionFactoryProperties;
    }

    /**
     * Set the JDBC {@code DataSource} that this instance should manage transactions for. The {@code DataSource}
     * should match the one used by the {@code SqlSessionFactory}: for example, you could specify the same
     * JNDI DataSource for both.
     * <p>
     * A transactional JDBC {@code Connection} for this {@code DataSource} will be provided to application code
     * accessing this {@code DataSource} directly via {@code DataSourceUtils} or {@code DataSourceTransactionManager}.
     * <p>
     * The {@code DataSource} specified here should be the target {@code DataSource} to manage transactions for, not
     * a {@code TransactionAwareDataSourceProxy}. Only data access code may work with
     * {@code TransactionAwareDataSourceProxy}, while the transaction manager needs to work on the
     * underlying target {@code DataSource}. If there's nevertheless a {@code TransactionAwareDataSourceProxy}
     * passed in, it will be unwrapped to extract its target {@code DataSource}.
     */
    @Override
    public void setDataSource(DataSource dataSource) {
        if (dataSource instanceof TransactionAwareDataSourceProxy) {
            // If we got a TransactionAwareDataSourceProxy, we need to perform
            // transactions for its underlying target DataSource, else data
            // access code won't see properly exposed transactions (i.e.
            // transactions for the target DataSource).
            this.dataSource = ((TransactionAwareDataSourceProxy) dataSource).getTargetDataSource();
        } else {
            this.dataSource = dataSource;
        }
    }

    /**
     * Sets the {@code SqlSessionFactoryBuilder} to use when creating the {@code SqlSessionFactory}.
     * <p>
     * This is mainly meant for testing so that mock SqlSessionFactory classes can be injected. By
     * default, {@code SqlSessionFactoryBuilder} creates {@code DefaultSqlSessionFactory} instances.
     */
    @Override
    public void setSqlSessionFactoryBuilder(SqlSessionFactoryBuilder sqlSessionFactoryBuilder) {
        this.sqlSessionFactoryBuilder = sqlSessionFactoryBuilder;
    }

    /**
     * Set the MyBatis TransactionFactory to use. Default is {@code SpringManagedTransactionFactory}
     * <p>
     * The default {@code SpringManagedTransactionFactory} should be appropriate for all cases:
     * be it Spring transaction management, EJB CMT or plain JTA. If there is no active transaction,
     * SqlSession operations will execute SQL statements non-transactionally.
     * <p>
     * <b>It is strongly recommended to use the default {@code TransactionFactory}.</b> If not used, any
     * attempt at getting an SqlSession through Spring's MyBatis framework will throw an exception if
     * a transaction is active.
     *
     * @param transactionFactory the MyBatis TransactionFactory
     * @see SpringManagedTransactionFactory
     */
    @Override
    public void setTransactionFactory(TransactionFactory transactionFactory) {
        this.transactionFactory = transactionFactory;
    }

    /**
     * <b>NOTE:</b> This class <em>overrides</em> any {@code Environment} you have set in the MyBatis
     * config file. This is used only as a placeholder name. The default value is
     * {@code SqlSessionFactoryBean.class.getSimpleName()}.
     *
     * @param environment the environment name
     */
    @Override
    public void setEnvironment(String environment) {
        this.environment = environment;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void afterPropertiesSet() throws Exception {
        notNull(dataSource, "Property 'dataSource' is required");
        notNull(sqlSessionFactoryBuilder, "Property 'sqlSessionFactoryBuilder' is required");
        state((configuration == null && configLocation == null) || !(configuration != null && configLocation != null),
                "Property 'configuration' and 'configLocation' can not specified with together");

        this.sqlSessionFactory = buildSqlSessionFactory();
    }

    private void scanEnums(Configuration configuration, String basePackage) {
        ResolverUtil<Class<?>> resolverUtil = new ResolverUtil<Class<?>>();
        resolverUtil.find(new ResolverUtil.IsA(EnumIdentify.class), basePackage);
        Set<Class<? extends Class<?>>> mTypes = resolverUtil.getClasses();
        for (Class<?> javaTypeClass : mTypes) {
            LOGGER.debug("Enum :" + javaTypeClass);
            registerEnumHandler(configuration, javaTypeClass);
        }
    }

    public void scanEnumAndAliceInJars(Configuration configuration, String basePackage) throws Exception {
        Set<Resource> result = new LinkedHashSet<Resource>(256);
        ClassLoader cl = this.getClass().getClassLoader();
        Enumeration<URL> resourceUrls = cl.getResources("");
        while (resourceUrls.hasMoreElements()) {
            URL url = resourceUrls.nextElement();
            result.add(new UrlResource(url));
        }
        addAllClassLoaderJarRoots(cl, result);
        for (Resource resource : result) {
            if (!ResourceUtils.isJarURL(resource.getURL())) {
                continue;
            }
            URLConnection con = resource.getURL().openConnection();
            if (!(con instanceof JarURLConnection)) {
                continue;
            }
            JarURLConnection jarCon = (JarURLConnection) con;
            ResourceUtils.useCachesIfNecessary(jarCon);
            JarFile jarFile = jarCon.getJarFile();
            for (Enumeration<JarEntry> entries = jarFile.entries(); entries.hasMoreElements(); ) {
                JarEntry entry = entries.nextElement();
                String entryPath = entry.getName();
                entryPath = entryPath.replace("/", ".");
                if (entryPath.indexOf(basePackage) >= 0 && entryPath.endsWith(".class")) {
                    try {
                        Class<?> clazz = Class.forName(entryPath.substring(0, entryPath.indexOf(".class")), false, Thread.currentThread().getContextClassLoader());
                        if (EnumIdentify.class.isAssignableFrom(clazz)) {
                            LOGGER.debug("Enum in jar:" + clazz);
                            registerEnumHandler(configuration, clazz);
                        } else if (BaseEntity.class.isAssignableFrom(clazz)) {
                            if (clazz == BaseEntity.class) {
                                continue;
                            }
                            LOGGER.debug("Alice in jar:" + clazz);
                            configuration.getTypeAliasRegistry().registerAlias(clazz.getSimpleName(), clazz);
                        }
                    } catch (Exception e) {
                        if (LOGGER.isDebugEnabled()) {
                            LOGGER.debug(e.getMessage());
                        }
                    }
                }
            }
        }
    }

    private void registerEnumHandler(Configuration configuration, Class<?> javaTypeClass) {
        if (javaTypeClass == EnumIdentify.class) {
            return;
        }
        TypeHandlerRegistry registry = configuration.getTypeHandlerRegistry();
        registry.register(javaTypeClass, EnumHandler.class);
        try {
            Field field = TypeHandlerRegistry.class.getDeclaredField("ALL_TYPE_HANDLERS_MAP");
            field.setAccessible(true);
            Map<Class<?>, TypeHandler<?>> map = (Map<Class<?>, TypeHandler<?>>) field.get(registry);
            map.remove(EnumHandler.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void addAllClassLoaderJarRoots(ClassLoader classLoader, Set<Resource> result) {
        if (classLoader instanceof URLClassLoader) {
            try {
                for (URL url : ((URLClassLoader) classLoader).getURLs()) {
                    if (ResourceUtils.isJarFileURL(url)) {
                        try {
                            UrlResource jarResource = new UrlResource(
                                    ResourceUtils.JAR_URL_PREFIX + url.toString() + ResourceUtils.JAR_URL_SEPARATOR);
                            if (jarResource.exists()) {
                                result.add(jarResource);
                            }
                        } catch (MalformedURLException ex) {
                            if (LOGGER.isDebugEnabled()) {
                                LOGGER.debug("Cannot search for matching files underneath [" + url +
                                        "] because it cannot be converted to a valid 'jar:' URL: " + ex.getMessage());
                            }
                        }
                    }
                }
            } catch (Exception ex) {
                if (LOGGER.isDebugEnabled()) {
                    LOGGER.debug("Cannot introspect jar files since ClassLoader [" + classLoader +
                            "] does not support 'getURLs()': " + ex);
                }
            }
        }
        if (classLoader != null) {
            try {
                // Hierarchy traversal...
                addAllClassLoaderJarRoots(classLoader.getParent(), result);
            } catch (Exception ex) {
                if (LOGGER.isDebugEnabled()) {
                    LOGGER.debug("Cannot introspect jar files in parent ClassLoader since [" + classLoader +
                            "] does not support 'getParent()': " + ex);
                }
            }
        }
    }


    /**
     * Build a {@code SqlSessionFactory} instance.
     * <p>
     * The default implementation uses the standard MyBatis {@code XMLConfigBuilder} API to build a
     * {@code SqlSessionFactory} instance based on an Reader.
     * Since 1.3.0, it can be specified a {@link Configuration} instance directly(without config file).
     *
     * @return SqlSessionFactory
     * @throws IOException if loading the config file failed
     */
    @Override
    protected SqlSessionFactory buildSqlSessionFactory() throws IOException {

        Configuration configuration;

        XMLConfigBuilder xmlConfigBuilder = null;
        if (this.configuration != null) {
            configuration = this.configuration;
            if (configuration.getVariables() == null) {
                configuration.setVariables(this.configurationProperties);
            } else if (this.configurationProperties != null) {
                configuration.getVariables().putAll(this.configurationProperties);
            }
        } else if (this.configLocation != null) {
            xmlConfigBuilder = new XMLConfigBuilder(this.configLocation.getInputStream(), null, this.configurationProperties);
            configuration = xmlConfigBuilder.getConfiguration();
        } else {
            if (LOGGER.isDebugEnabled()) {
                LOGGER.debug("Property `configuration` or 'configLocation' not specified, using default MyBatis Configuration");
            }
            configuration = new Configuration();
            configuration.setVariables(this.configurationProperties);
        }
        try {
            // 枚举处理器
            scanEnums(configuration, basePackage);
            // 继续处理jar包中的Enum和Alice
            scanEnumAndAliceInJars(configuration, basePackage);
            //下划线转驼峰
            configuration.setMapUnderscoreToCamelCase(true);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (this.objectFactory != null) {
            configuration.setObjectFactory(this.objectFactory);
        }

        if (this.objectWrapperFactory != null) {
            configuration.setObjectWrapperFactory(this.objectWrapperFactory);
        }

        if (this.vfs != null) {
            configuration.setVfsImpl(this.vfs);
        }

        if (hasLength(this.typeAliasesPackage)) {
            String[] typeAliasPackageArray = tokenizeToStringArray(this.typeAliasesPackage,
                    ConfigurableApplicationContext.CONFIG_LOCATION_DELIMITERS);
            for (String packageToScan : typeAliasPackageArray) {
                configuration.getTypeAliasRegistry().registerAliases(packageToScan,
                        typeAliasesSuperType == null ? Object.class : typeAliasesSuperType);
                if (LOGGER.isDebugEnabled()) {
                    LOGGER.debug("Scanned package: '" + packageToScan + "' for aliases");
                }
            }
        }

        if (!isEmpty(this.typeAliases)) {
            for (Class<?> typeAlias : this.typeAliases) {
                configuration.getTypeAliasRegistry().registerAlias(typeAlias);
                if (LOGGER.isDebugEnabled()) {
                    LOGGER.debug("Registered type alias: '" + typeAlias + "'");
                }
            }
        }

        if (!isEmpty(this.plugins)) {
            for (Interceptor plugin : this.plugins) {
                configuration.addInterceptor(plugin);
                if (LOGGER.isDebugEnabled()) {
                    LOGGER.debug("Registered plugin: '" + plugin + "'");
                }
            }
        }

        if (hasLength(this.typeHandlersPackage)) {
            String[] typeHandlersPackageArray = tokenizeToStringArray(this.typeHandlersPackage,
                    ConfigurableApplicationContext.CONFIG_LOCATION_DELIMITERS);
            for (String packageToScan : typeHandlersPackageArray) {
                configuration.getTypeHandlerRegistry().register(packageToScan);
                if (LOGGER.isDebugEnabled()) {
                    LOGGER.debug("Scanned package: '" + packageToScan + "' for type handlers");
                }
            }
        }

        if (!isEmpty(this.typeHandlers)) {
            for (TypeHandler<?> typeHandler : this.typeHandlers) {
                configuration.getTypeHandlerRegistry().register(typeHandler);
                if (LOGGER.isDebugEnabled()) {
                    LOGGER.debug("Registered type handler: '" + typeHandler + "'");
                }
            }
        }

        if (this.databaseIdProvider != null) {//fix #64 set databaseId before parse mapper xmls
            try {
                configuration.setDatabaseId(this.databaseIdProvider.getDatabaseId(this.dataSource));
            } catch (SQLException e) {
                throw new NestedIOException("Failed getting a databaseId", e);
            }
        }

        if (this.cache != null) {
            configuration.addCache(this.cache);
        }

        if (xmlConfigBuilder != null) {
            try {
                xmlConfigBuilder.parse();

                if (LOGGER.isDebugEnabled()) {
                    LOGGER.debug("Parsed configuration file: '" + this.configLocation + "'");
                }
            } catch (Exception ex) {
                throw new NestedIOException("Failed to parse config resource: " + this.configLocation, ex);
            } finally {
                ErrorContext.instance().reset();
            }
        }

        if (this.transactionFactory == null) {
            this.transactionFactory = new SpringManagedTransactionFactory();
        }

        configuration.setEnvironment(new Environment(this.environment, this.transactionFactory, this.dataSource));

        if (!isEmpty(this.mapperLocations)) {
            for (Resource mapperLocation : this.mapperLocations) {
                if (mapperLocation == null) {
                    continue;
                }

                try {
                    XMLMapperBuilder xmlMapperBuilder = new XMLMapperBuilder(mapperLocation.getInputStream(),
                            configuration, mapperLocation.toString(), configuration.getSqlFragments());
                    xmlMapperBuilder.parse();
                } catch (Exception e) {
                    throw new NestedIOException("Failed to parse mapping resource: '" + mapperLocation + "'", e);
                } finally {
                    ErrorContext.instance().reset();
                }

                if (LOGGER.isDebugEnabled()) {
                    LOGGER.debug("Parsed mapper file: '" + mapperLocation + "'");
                }
            }
        } else {
            if (LOGGER.isDebugEnabled()) {
                LOGGER.debug("Property 'mapperLocations' was not specified or no matching resources found");
            }
        }

        return this.sqlSessionFactoryBuilder.build(configuration);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SqlSessionFactory getObject() throws Exception {
        if (this.sqlSessionFactory == null) {
            afterPropertiesSet();
        }

        return this.sqlSessionFactory;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Class<? extends SqlSessionFactory> getObjectType() {
        return this.sqlSessionFactory == null ? SqlSessionFactory.class : this.sqlSessionFactory.getClass();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isSingleton() {
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        if (failFast && event instanceof ContextRefreshedEvent) {
            // fail-fast -> check all statements are completed
            this.sqlSessionFactory.getConfiguration().getMappedStatementNames();
        }
    }

}
