package com.yyk.sz.zhzy.zjxt.zjgl.service;

import com.yyk.sz.common.base.domain.Paging;
import com.yyk.sz.zhzy.zjxt.zjgl.entity.AcuMan;
import com.yyk.sz.zhzy.zjxt.zjgl.mapper.AcuManMapper;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: ZhangChao
 * @Date: 2019/2/19 12:06
 * @Version: 1.0
 */
@Component
@Transactional
public class AcuManServiceImpl implements AcuManService {

    @Resource
    private AcuManMapper acuManMapper;


    @Override
    public Paging<AcuMan> getAcuManAll(int pageNum, int pageSize, String searchText, String sortName, String sortOrder) {
        return acuManMapper.getAcuManAll(pageNum,pageSize,searchText,sortName,sortOrder);
    }

    @Override
    public Paging<AcuMan> getAcuManNoList(int pageNum, int pageSize, String searchText, String sortName, String sortOrder) {
        return acuManMapper.getAcuManNoList(pageNum,pageSize,searchText,sortName,sortOrder);
    }

    @Override
    public Paging<AcuMan> getAcuManYesList(int pageNum, int pageSize, String searchText, String sortName, String sortOrder, String strDateTime) {
        return acuManMapper.getAcuManYesList(pageNum,pageSize,searchText,sortName,sortOrder,strDateTime);
    }

    @Override
    public Paging<AcuMan> getAcuManIngList(int pageNum, int pageSize, String searchText, String sortName, String sortOrder, String strDateTime) {
        return acuManMapper.getAcuManIngList(pageNum,pageSize,searchText,sortName,sortOrder,strDateTime);
    }

    @Override
    public int updateZZDateTime(AcuMan acuMan) {
        return acuManMapper.updateZZDateTime(acuMan);
    }

}
