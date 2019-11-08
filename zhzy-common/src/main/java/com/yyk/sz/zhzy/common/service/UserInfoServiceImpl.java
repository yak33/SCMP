package com.yyk.sz.zhzy.common.service;


import java.util.UUID;

import com.yyk.sz.zhzy.common.entity.UserInfo;
import com.yyk.sz.zhzy.common.mapper.UserInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class UserInfoServiceImpl implements UserInfoService {


    @Autowired
    private UserInfoMapper userInfoMapper;

    /**
     * 保存
     *
     * @param entity
     * @return
     */
    @Override
    public String save(UserInfo entity) {

        UserInfo userInfo = userInfoMapper.getUserInfoByAccount(entity.getAccount());

        // 更新
        if (userInfo != null) {
            entity.setId(userInfo.getId());
            userInfoMapper.updateSelective(entity);
        } else {
            // 保存
            String id = UUID.randomUUID().toString().replace("-", "");
            entity.setId(id);
            entity.setVersionNum(0);
            userInfoMapper.insertSelective(entity);
        }
        return entity.getId();
    }

    @Override
    public UserInfo getUserInfoByAccount(String account) {
        return userInfoMapper.getUserInfoByAccount(account);
    }
}
