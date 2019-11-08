package com.yyk.sz.common.mybatis.plugin;

import com.yyk.sz.common.mybatis.util.PluginUtil;
import com.yyk.sz.common.mybatis.util.TypeUtil;
import com.yyk.sz.common.mybatis.util.UUIDUtil;
import net.sf.jsqlparser.expression.Expression;
import net.sf.jsqlparser.expression.StringValue;
import net.sf.jsqlparser.expression.TimestampValue;
import net.sf.jsqlparser.expression.operators.relational.ExpressionList;
import net.sf.jsqlparser.expression.operators.relational.ItemsList;
import net.sf.jsqlparser.expression.operators.relational.MultiExpressionList;
import net.sf.jsqlparser.parser.CCJSqlParserUtil;
import net.sf.jsqlparser.schema.Column;
import net.sf.jsqlparser.statement.Statement;
import net.sf.jsqlparser.statement.insert.Insert;
import net.sf.jsqlparser.statement.update.Update;
import org.apache.ibatis.binding.MapperMethod;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.SqlCommandType;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.SystemMetaObject;
import org.apache.ibatis.session.defaults.DefaultSqlSession;

import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 *
 */
@SuppressWarnings("all")
@Intercepts({@Signature(type = StatementHandler.class, method = "prepare", args = {Connection.class, Integer.class})})
public class CommonDataInterceptor implements Interceptor {

    private static final Log logger = LogFactory.getLog(CommonDataInterceptor.class);

    private Properties props = null;

    private String UUIDColumn = null;
    private String createDateColumn = null;
    private String createByColumn = null;
    private String updateDateColumn = null;
    private String updateByColumn = null;
    private String versionColumn = null;
    private String delFlagColumn = null;


    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        String interceptMethod = invocation.getMethod().getName();
        if (!"prepare".equals(interceptMethod)) {
            return invocation.proceed();
        }

        StatementHandler handler = (StatementHandler) PluginUtil.processTarget(invocation.getTarget());
        MetaObject metaObject = SystemMetaObject.forObject(handler);
        MappedStatement ms = (MappedStatement) metaObject.getValue("delegate.mappedStatement");
        SqlCommandType sqlCmdType = ms.getSqlCommandType();
        if (sqlCmdType != SqlCommandType.UPDATE && sqlCmdType != SqlCommandType.INSERT) {
            return invocation.proceed();
        }

        if (null == props || props.isEmpty()) {
            return invocation.proceed();
        }
        UUIDColumn = props.getProperty("UUIDColumn", "UUID");
        createDateColumn = props.getProperty("createDateColumn", "SysCreateDate");
        createByColumn = props.getProperty("createByColumn", "SysCreateBy");
        updateDateColumn = props.getProperty("updateDateColumn", "SysUpdateDate");
        updateByColumn = props.getProperty("updateByColumn", "SysUpdateBy");
        versionColumn = props.getProperty("versionColumn", "versionNum");
        delFlagColumn = props.getProperty("delFlagColumn", "SysDelFlag");


        BoundSql boundSql = (BoundSql) metaObject.getValue("delegate.boundSql");
        Object parameterObject = boundSql.getParameterObject();
        //获取原始sql
        String originalSql = (String) metaObject.getValue("delegate.boundSql.sql");
        logger.debug("==> originalSql: " + originalSql);
        //追加参数
        String newSql = "";
        if (sqlCmdType == SqlCommandType.UPDATE && updateDateColumn.length() > 0) {
            newSql = addUpdateData(parameterObject, originalSql);
        } else if (sqlCmdType == SqlCommandType.INSERT && createDateColumn.length() > 0) {
            newSql = addInsertData(parameterObject, originalSql);
        }
        //修改原始sql
        if (newSql.length() > 0) {
            logger.debug("[mybatis共通拦截][替换sql]==> newSql: " + newSql);
            metaObject.setValue("delegate.boundSql.sql", newSql);
        }
        return invocation.proceed();
    }

    private String addInsertData(Object parameterObject, String originalSql) {
        String sql = null;
        SimpleDateFormat TIMESTAMP_FORMAT = new SimpleDateFormat("-yyyy-MM-dd HH:mm:ss.SSS-");
        TimestampValue nowTime = new TimestampValue(TIMESTAMP_FORMAT.format(new Date()));
//		StringValue UUIDValue = UUIDUtil.getUUID();
        sql = addInsertDataDetail(parameterObject, originalSql, createDateColumn, null, nowTime);
        sql = addInsertDataDetail(parameterObject, sql, UUIDColumn, null, new StringValue("-" + UUIDUtil.getUUID() + "-"));
        sql = addInsertDataDetail(parameterObject, sql, updateDateColumn, null, nowTime);
        sql = addInsertDataDetail(parameterObject, sql, createByColumn, null, new StringValue("-admin-"));
        sql = addInsertDataDetail(parameterObject, sql, updateByColumn, null, new StringValue("-admin-"));
        sql = addInsertDataDetail(parameterObject, sql, versionColumn, null, new StringValue("-0-"));
        sql = addInsertDataDetail(parameterObject, sql, delFlagColumn, null, new StringValue("-0-"));
        return sql;
    }

    private String addInsertDataDetail(Object parameterObject, String originalSql, String columnName, String fieldName, Expression expression) {
        try {
            Statement stmt = CCJSqlParserUtil.parse(originalSql);
            if (!(stmt instanceof Insert)) {
                return originalSql;
            }

            //为了防止多租户注解的丢失，先把多租户注解暂存
            String tenantStr = "";
            if (originalSql.indexOf("/*") > -1) {
                int tenantIndexStart = originalSql.indexOf("/*");
                int tenantIndexEnd = originalSql.indexOf("*/");
                tenantStr = originalSql.substring(tenantIndexStart, tenantIndexEnd + 2);
            }

            Insert update = (Insert) stmt;
            List<Column> columns = update.getColumns();
            if (!contains(columns, columnName)) {
                Column versionColumn = new Column();
                versionColumn.setColumnName(columnName);
                columns.add(versionColumn);
                ItemsList itemList = update.getItemsList();
                if (itemList instanceof ExpressionList) {//单个
                    ExpressionList expressionList = (ExpressionList) itemList;
                    List<Expression> expressions = expressionList.getExpressions();
                    if (expression != null) {
                        expressions.add(expression);
                    } else {
                        Object value = getFieldValue(parameterObject, 0, fieldName);
                        expressions.add(new StringValue(value.toString()));
                    }
                } else if (itemList instanceof MultiExpressionList) {//批量
                    MultiExpressionList multiExpressionList = (MultiExpressionList) itemList;
                    List<ExpressionList> expressionLists = multiExpressionList.getExprList();
                    for (int i = 0; i < expressionLists.size(); i++) {
                        ExpressionList expressionList = expressionLists.get(i);
                        List<Expression> expressions = expressionList.getExpressions();
                        if (expression != null) {
                            expressions.add(expression);
                        } else {
                            Object value = getFieldValue(parameterObject, i, fieldName);
                            expressions.add(new StringValue(value.toString()));
                        }
                    }
                } else {//insert select
                    columns.remove(columns.size() - 1);
                }
            }

            return tenantStr + stmt.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return originalSql;
        }
    }

    private String addUpdateData(Object parameterObject, String originalSql) {
        String sql = null;
        SimpleDateFormat TIMESTAMP_FORMAT = new SimpleDateFormat("-yyyy-MM-dd HH:mm:ss.SSS-");
        sql = addUpdateDataDetail(parameterObject, originalSql, updateDateColumn, null,
                new TimestampValue(TIMESTAMP_FORMAT.format(new Date())));
        sql = addUpdateDataDetail(parameterObject, sql, updateByColumn, null, new StringValue("-admin-"));
        return sql;
    }

    private String addUpdateDataDetail(Object parameterObject, String originalSql, String columnName, String fieldName, Expression expression) {
        StringBuilder sb = new StringBuilder();
        String sqlList[] = originalSql.split(";");

        //为了防止多租户注解的丢失，先把多租户注解暂存
        String tenantStr = "";
        if (originalSql.indexOf("/*") > -1) {
            int tenantIndexStart = originalSql.indexOf("/*");
            int tenantIndexEnd = originalSql.indexOf("*/");
            tenantStr = originalSql.substring(tenantIndexStart, tenantIndexEnd + 2);
        }

        for (int i = 0; i < sqlList.length; i++) {
            if (i > 0) {
                sb.append(";");
            }
            try {
                Statement stmt = CCJSqlParserUtil.parse(sqlList[i]);
                if (!(stmt instanceof Update)) {
                    return originalSql;
                }
                Update update = (Update) stmt;
                List<Column> columns = update.getColumns();
                if (contains(columns, columnName)) {
                    sb.append(sqlList[i]);
                    continue;
                }
            } catch (Exception e) {
                e.printStackTrace();
                sb.append(sqlList[i]);
                continue;
            }
            if (expression == null) {
                Object value = getFieldValue(parameterObject, i, fieldName);
                String sql = addUpdateDateToSql(sqlList[i], columnName, new StringValue(value.toString()));
                sb.append(sql);
            } else {
                String sql = addUpdateDateToSql(sqlList[i], columnName, expression);
                sb.append(sql);
            }
        }
        return tenantStr + sb.toString();
    }

    private String addUpdateDateToSql(String originalSql, String columnName, Expression expression) {
        try {
            Statement stmt = CCJSqlParserUtil.parse(originalSql);
            if (!(stmt instanceof Update)) {
                return originalSql;
            }
            Update update = (Update) stmt;
            List<Column> columns = update.getColumns();
            if (!contains(columns, columnName)) {
                Column versionColumn = new Column();
                versionColumn.setColumnName(columnName);
                columns.add(versionColumn);
                List<Expression> expressions = update.getExpressions();
                expressions.add(expression);
            }
            return stmt.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return originalSql;
        }
    }

    /**
     * insertUserParams(int id, String name,  String password, int version);      MapperMethod.ParamMap<V> {0=100, 1=name, 2=pass, 3=111, param3=pass, param4=111, param1=100, param2=name}
     * insertUserParams(@Param("id")int id, @Param("name")String name,
     *
     * @Param("password")String password, @Param("version")int version);         MapperMethod.ParamMap<V> {password=pass, name=name, id=100, param3=pass, version=111, param4=111, param1=100, param2=name}
     * insertUserWithDate(User user);                                             com.chrhc.mybatis.autodate.domain.User@d6e7bab
     * insertUserWithDate(@Param("user")User user);                               MapperMethod.ParamMap<V> {user=com.chrhc.mybatis.autodate.domain.User@6a6afff2, param1=com.chrhc.mybatis.autodate.domain.User@6a6afff2}
     * insertBatchUser(List<User> users);                                         DefaultSqlSession.StrictMap<V> {collection=[com.chrhc.mybatis.autodate.domain.User@33bc72d1, com.chrhc.mybatis.autodate.domain.User@1a75e76a], list=[com.chrhc.mybatis.autodate.domain.User@33bc72d1, com.chrhc.mybatis.autodate.domain.User@1a75e76a]}
     * insertBatchUser(@Param("users")List<User> users);                          MapperMethod.ParamMap<V>{users=[com.chrhc.mybatis.autodate.domain.User@5e2c3d18, com.chrhc.mybatis.autodate.domain.User@2cb4893b], param1=[com.chrhc.mybatis.autodate.domain.User@5e2c3d18, com.chrhc.mybatis.autodate.domain.User@2cb4893b]}
     */
    @SuppressWarnings("rawtypes")
    private Object getFieldValue(Object parameterObject, int index, String fieldName) {
        Object value = null;
        if (parameterObject instanceof DefaultSqlSession.StrictMap) {
            DefaultSqlSession.StrictMap map = (DefaultSqlSession.StrictMap) parameterObject;
            Object object = map.get("list");
            if (object == null) {
                object = map.get("array");
            }
            if (object != null) {
                value = getValueFromListOrArray(object, index, fieldName);
            }
        } else if (parameterObject instanceof MapperMethod.ParamMap<?>) {
            MapperMethod.ParamMap map = (MapperMethod.ParamMap) parameterObject;
            Object param1 = map.get("param1");
            if (param1.getClass().isArray() || List.class.isAssignableFrom(param1.getClass())) {
                value = getValueFromListOrArray(param1, index, fieldName);
            }
            if (value == null) {
                if (TypeUtil.isSimpleType(param1 == null ? null : param1.getClass())) {
                    Set keys = map.keySet();
                    for (Object key : keys) {
                        if (fieldName.equals(key)) {
                            value = map.get(key);
                            break;
                        }
                    }
                } else {
                    MetaObject metaObject = SystemMetaObject.forObject(param1);
                    value = metaObject.getValue(fieldName);
                }
            }
        } else if (parameterObject instanceof Map) {
            Map map = (Map) parameterObject;
            value = map.get(fieldName);
        } else {
            MetaObject metaObject = SystemMetaObject.forObject(parameterObject);
            value = metaObject.getValue(fieldName);
        }
        if (value == null) {
            // throw new IllegalArgumentException("value of["+fieldName+"]can not be empty");
            return "";
        }
        return value;
    }

    @SuppressWarnings("rawtypes")
    private Object getValueFromListOrArray(Object parameterObject, int index, String fieldName) {
        Object entity = null;
        if (parameterObject instanceof List) {
            entity = ((List) parameterObject).get(index);
        } else if (parameterObject != null && parameterObject.getClass().isArray()) {
            entity = ((Object[]) parameterObject)[index];
        }
        if (entity != null) {
            MetaObject metaObject = SystemMetaObject.forObject(entity);
            return metaObject.getValue(fieldName);
        }
        return null;
    }

    private boolean contains(List<Column> columns, String columnName) {
        if (columns == null || columns.size() <= 0) {
            return false;
        }
        if (columnName == null || columnName.length() <= 0) {
            return false;
        }
        for (Column column : columns) {
            if (column.getColumnName().equalsIgnoreCase(columnName)) {
                return true;
            }
        }
        return false;
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
        if (null != properties && !properties.isEmpty()) {
            props = properties;
        }
    }

}
