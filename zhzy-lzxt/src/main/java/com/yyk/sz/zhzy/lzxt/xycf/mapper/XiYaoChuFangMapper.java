package com.yyk.sz.zhzy.lzxt.xycf.mapper;

import com.yyk.sz.zhzy.lzxt.xycf.entity.FangJiDetailSubEntity;
import com.yyk.sz.zhzy.lzxt.xycf.entity.FangJiSubEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface XiYaoChuFangMapper {

    /**
     * 保存西药处方
     *
     * @return
     */
    public boolean saveWesternDrugFangji(
            FangJiSubEntity fangJiSubEntity
    );

    /**
     * 删除西药处方
     *
     * @return
     */
    public boolean deleteWesternDrugFangji(
            FangJiSubEntity fangJiSubEntity
    );

    public void saveWesternDrugFangji_SP(
            FangJiSubEntity fangJiSubEntity
    );

    public void updateWesternDrugFangji(
           FangJiSubEntity fangJiSubEntity
    );
}
