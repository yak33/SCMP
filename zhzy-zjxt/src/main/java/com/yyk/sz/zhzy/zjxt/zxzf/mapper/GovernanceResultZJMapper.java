package com.yyk.sz.zhzy.zjxt.zxzf.mapper;

import com.yyk.sz.zhzy.zjxt.zxzf.entity.GRZJListRst;
import com.yyk.sz.zhzy.zjxt.zxzf.entity.GovernanceResultZJ;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: ZhangChao
 * @Date: 2018/12/1 10:46
 * @Version: 1.0
 */
@Mapper
public interface GovernanceResultZJMapper {

    /**
     * 获取论治结果-针灸（存储过程）
     * @param governanceResultZJ
     * @return
     */
    void getGRZJList(GovernanceResultZJ governanceResultZJ);

    /**
     * 获取论治结果-针灸
     * @param proUUID
     * @return
     */
    List<GRZJListRst> getGRZJListRst(String proUUID);

    int updateEmpBasicMain(GovernanceResultZJ governanceResultZJ);
}
