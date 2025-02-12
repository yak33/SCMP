package com.yyk.sz.zhzy.system.core.mapper;

import com.yyk.sz.zhzy.system.core.entity.SysResource;
import com.yyk.sz.zhzy.system.core.entity.SysResourceExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SysResourceMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_resource
     *
     * @mbggenerated Tue Dec 18 11:46:00 CST 2018
     */
    int countByExample(SysResourceExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_resource
     *
     * @mbggenerated Tue Dec 18 11:46:00 CST 2018
     */
    int deleteByExample(SysResourceExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_resource
     *
     * @mbggenerated Tue Dec 18 11:46:00 CST 2018
     */
    int deleteByPrimaryKey(String uuid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_resource
     *
     * @mbggenerated Tue Dec 18 11:46:00 CST 2018
     */
    int insert(SysResource record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_resource
     *
     * @mbggenerated Tue Dec 18 11:46:00 CST 2018
     */
    int insertSelective(SysResource record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_resource
     *
     * @mbggenerated Tue Dec 18 11:46:00 CST 2018
     */
    List<SysResource> selectByExample(SysResourceExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_resource
     *
     * @mbggenerated Tue Dec 18 11:46:00 CST 2018
     */
    SysResource selectByPrimaryKey(String uuid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_resource
     *
     * @mbggenerated Tue Dec 18 11:46:00 CST 2018
     */
    int updateByExampleSelective(@Param("record") SysResource record, @Param("example") SysResourceExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_resource
     *
     * @mbggenerated Tue Dec 18 11:46:00 CST 2018
     */
    int updateByExample(@Param("record") SysResource record, @Param("example") SysResourceExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_resource
     *
     * @mbggenerated Tue Dec 18 11:46:00 CST 2018
     */
    int updateByPrimaryKeySelective(SysResource record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_resource
     *
     * @mbggenerated Tue Dec 18 11:46:00 CST 2018
     */
    int updateByPrimaryKey(SysResource record);
}