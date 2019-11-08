package com.yyk.sz.common.mybatis.page;

import com.yyk.sz.common.base.domain.Paging;
import org.apache.ibatis.reflection.factory.DefaultObjectFactory;

/**
 * Created by xujiashuai on 2016/6/29.
 *
 */
public class PageObjectFactory extends DefaultObjectFactory {

    private static final long serialVersionUID = 3963031299778136554L;

    /**
     * 如果类型为page的话让其也判断为集合
     */
    @Override
    public <T> boolean isCollection(Class<T> type) {
        if (type.isAssignableFrom(Paging.class)) {
            return true;
        }
        return super.isCollection(type);
    }

    @Override
    @SuppressWarnings("unchecked")
    public <T> T create(Class<T> type) {
        if (type.isAssignableFrom(Paging.class)) {
            return (T) new Paging<Object>();
        }
        return create(type, null, null);
    }
}