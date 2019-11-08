package com.yyk.sz.zhzy.lzxt.blmb.mapper;

import com.yyk.sz.zhzy.lzxt.blmb.entity.Model;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ModelMapper {

    /**
     * 根据所属部门和模版类型查询模版
     *
     * @param usedPhrasesType
     * @param deptCode
     * @return
     */
    List<Model> getModelTable(@Param("usedPhrasesType") String usedPhrasesType, @Param("deptCode") String deptCode, @Param("searchText") String searchText);

    /**
     * 新增模版
     *
     * @param model
     * @return
     */
    boolean insertModel(@Param("model") Model model);

    /**
     * 查询模版
     *
     * @param model
     * @return
     */
    List<Model> selectModel(@Param("model") Model model);

    /**
     * 修改模版
     *
     * @param model
     * @return
     */
    boolean updateModel(@Param("model") Model model);

    /**
     * 删除模版
     *
     * @param model
     * @return
     */
    boolean deleteModel(@Param("model") Model model);
}
