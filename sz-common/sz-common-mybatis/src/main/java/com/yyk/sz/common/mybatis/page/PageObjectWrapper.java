package com.yyk.sz.common.mybatis.page;

import com.github.pagehelper.Page;
import com.yyk.sz.common.base.domain.Paging;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.factory.ObjectFactory;
import org.apache.ibatis.reflection.property.PropertyTokenizer;
import org.apache.ibatis.reflection.wrapper.ObjectWrapper;

import java.util.List;

/**
 * Created by xujiashuai on 2016/6/29.
 */
public class PageObjectWrapper implements ObjectWrapper {

    private Paging paging;

    public PageObjectWrapper(Paging wrapped){
        this.paging = wrapped;
    }

    @Override
    public <E> void addAll(List<E> element) {
        Page page = (Page) element;
        paging.setPageNum(page.getPageNum());
        paging.setPageSize(page.getPageSize());
        paging.setTotalSize(page.getTotal());
        paging.setTotalPages(page.getPages());
        paging.setContent(page);
        paging.build();
    }

    @Override
    public Object get(PropertyTokenizer prop) {
        return null;
    }

    @Override
    public void set(PropertyTokenizer prop, Object value) {

    }

    @Override
    public String findProperty(String name, boolean useCamelCaseMapping) {
        return null;
    }

    @Override
    public String[] getGetterNames() {
        return new String[0];
    }

    @Override
    public String[] getSetterNames() {
        return new String[0];
    }

    @Override
    public Class<?> getSetterType(String name) {
        return null;
    }

    @Override
    public Class<?> getGetterType(String name) {
        return null;
    }

    @Override
    public boolean hasSetter(String name) {
        return false;
    }

    @Override
    public boolean hasGetter(String name) {
        return false;
    }

    @Override
    public MetaObject instantiatePropertyValue(String name, PropertyTokenizer prop, ObjectFactory objectFactory) {
        return null;
    }

    @Override
    public boolean isCollection() {
        return false;
    }

    @Override
    public void add(Object element) {

    }
}
