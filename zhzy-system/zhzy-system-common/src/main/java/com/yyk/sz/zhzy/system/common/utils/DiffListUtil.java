package com.yyk.sz.zhzy.system.common.utils;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 恺 on 2017/5/9.
 */
@Component
public class DiffListUtil<T>
{

    public List<T> getAddedList(List<T> list1,List<T> list2){

        List<T> list1Temp = new ArrayList<>();
        list1Temp.addAll(list1);
        List<T> list2Temp = new ArrayList<>();
        list2Temp.addAll(list2);
        list2Temp.removeAll(list1Temp);

        return list2Temp;
    }

    public List<T> getRemovedList(List<T> list1,List<T> list2){

        List<T> list1Temp = new ArrayList<>();
        list1Temp.addAll(list1);
        List<T> list2Temp = new ArrayList<>();
        list2Temp.addAll(list2);
        list1Temp.removeAll(list2Temp);

        return list1Temp;
    }

}
