package com.yyk.sz.common.mybatis.page;

import com.yyk.sz.common.base.domain.Paging;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.ReflectionException;
import org.apache.ibatis.reflection.wrapper.DefaultObjectWrapperFactory;
import org.apache.ibatis.reflection.wrapper.ObjectWrapper;

/**
 * Created by xujiashuai on 2016/6/29.
 */
public class PageObjectWrapperFactory extends DefaultObjectWrapperFactory{

    @Override
    public boolean hasWrapperFor(Object object) {
        if(object instanceof Paging){
            return true;
        }
        return false;
    }

    @Override
    public ObjectWrapper getWrapperFor(MetaObject metaObject, Object object) {
        //throw new ReflectionException("The DefaultObjectWrapperFactory should never be called to provide an ObjectWrapper.");
        if(object instanceof Paging){
            return new PageObjectWrapper((Paging)object);
        }
        throw new ReflectionException("The DefaultObjectWrapperFactory should never be called to provide an ObjectWrapper.");
    }
}
