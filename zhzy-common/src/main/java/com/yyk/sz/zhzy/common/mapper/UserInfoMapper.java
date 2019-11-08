package com.yyk.sz.zhzy.common.mapper;

import com.yyk.sz.zhzy.common.entity.UserInfo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserInfoMapper {

    /**
     * 根据用户账号查询用户
     *
     * @param account
     * @return
     */
    UserInfo getUserInfoByAccount(String account);

    /**
     * 插入信息，参数属性值是不是不为空都插入
     *
     * @param entity
     * @return
     */
    int insertSelective(UserInfo entity);

    /**
     * 更新信息，参数属性值是不是不为空都更新
     *
     * @param entity
     * @return
     */
    int updateSelective(UserInfo entity);
}
