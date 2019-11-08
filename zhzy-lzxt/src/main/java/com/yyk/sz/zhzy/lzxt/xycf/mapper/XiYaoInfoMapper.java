package com.yyk.sz.zhzy.lzxt.xycf.mapper;

import com.yyk.sz.common.base.domain.Paging;
import com.yyk.sz.zhzy.lzxt.xycf.entity.FangJiCodeRst;
import com.yyk.sz.zhzy.lzxt.xycf.entity.XiYaoInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

@Mapper
public interface XiYaoInfoMapper {

    /**
     * 获取西药列表
     *
     * @return
     */
    public Paging<XiYaoInfo> getXiYaoTable(
            @Param("pageNum") int pageNum,
            @Param("pageSize") int pageSize,
            @Param("searchText") String searchText,
            @Param("sortName") String sortName,
            @Param("sortOrder") String sortOrder
    );

    /**
     * 获取用药方式列表
     *
     * @return
     */
    public List<XiYaoInfo> getDrugWayTable();

    /**
     * 获取用药频次列表
     *
     * @return
     */
    public List<XiYaoInfo> getFrequencyTable();

    /**
     * 获取西药处方列表
     *
     * @return
     */
    public List<XiYaoInfo> getFangJiTable(@Param("empBasicMainID") String empBasicMainID);

    /**
     * 获取西药处方编码
     *
     * @return
     */
    public void GetFangJiCode(XiYaoInfo xiYaoInfo);

    public List<FangJiCodeRst> GetFangJiCodeRst(@Param("proUUID") String proUUID);
}
