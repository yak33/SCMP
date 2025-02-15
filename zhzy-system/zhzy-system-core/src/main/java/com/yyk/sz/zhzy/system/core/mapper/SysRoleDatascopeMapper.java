package com.yyk.sz.zhzy.system.core.mapper;

import com.yyk.sz.zhzy.system.core.entity.SysRoleDatascope;
import com.yyk.sz.zhzy.system.core.entity.SysRoleDatascopeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysRoleDatascopeMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_role_datascope
     *
     * @mbggenerated Tue Dec 18 11:46:00 CST 2018
     */
    int countByExample(SysRoleDatascopeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_role_datascope
     *
     * @mbggenerated Tue Dec 18 11:46:00 CST 2018
     */
    int deleteByExample(SysRoleDatascopeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_role_datascope
     *
     * @mbggenerated Tue Dec 18 11:46:00 CST 2018
     */
    int deleteByPrimaryKey(String uuid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_role_datascope
     *
     * @mbggenerated Tue Dec 18 11:46:00 CST 2018
     */
    int insert(SysRoleDatascope record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_role_datascope
     *
     * @mbggenerated Tue Dec 18 11:46:00 CST 2018
     */
    int insertSelective(SysRoleDatascope record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_role_datascope
     *
     * @mbggenerated Tue Dec 18 11:46:00 CST 2018
     */
    List<SysRoleDatascope> selectByExample(SysRoleDatascopeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_role_datascope
     *
     * @mbggenerated Tue Dec 18 11:46:00 CST 2018
     */
    SysRoleDatascope selectByPrimaryKey(String uuid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_role_datascope
     *
     * @mbggenerated Tue Dec 18 11:46:00 CST 2018
     */
    int updateByExampleSelective(@Param("record") SysRoleDatascope record, @Param("example") SysRoleDatascopeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_role_datascope
     *
     * @mbggenerated Tue Dec 18 11:46:00 CST 2018
     */
    int updateByExample(@Param("record") SysRoleDatascope record, @Param("example") SysRoleDatascopeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_role_datascope
     *
     * @mbggenerated Tue Dec 18 11:46:00 CST 2018
     */
    int updateByPrimaryKeySelective(SysRoleDatascope record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_role_datascope
     *
     * @mbggenerated Tue Dec 18 11:46:00 CST 2018
     */
    int updateByPrimaryKey(SysRoleDatascope record);
}