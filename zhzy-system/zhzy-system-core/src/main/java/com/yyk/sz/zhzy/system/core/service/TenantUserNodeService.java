package com.yyk.sz.zhzy.system.core.service;

import com.yyk.sz.zhzy.system.core.mappercust.UserNode;

import java.util.List;

public interface TenantUserNodeService {
    List<UserNode> getUserNode(UserNode userNode);

    int addSuperUser(UserNode userNode);
}
