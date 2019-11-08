package com.yyk.sz.zhzy.system.core.service;

import com.yyk.sz.zhzy.system.core.mappercust.TenantUserNodeMapper;
import com.yyk.sz.zhzy.system.core.mappercust.UserNode;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Component
@Transactional
public class TenantUserNodeServiceImpl implements TenantUserNodeService {

    @Resource
    private TenantUserNodeMapper userNodeMapper;

    @Override
    public List<UserNode> getUserNode(UserNode userNode){
        return userNodeMapper.getUserNode(userNode);
    }

    @Override
    public int addSuperUser(UserNode userNode) {
        return userNodeMapper.addSuperUser(userNode);
    }

}
