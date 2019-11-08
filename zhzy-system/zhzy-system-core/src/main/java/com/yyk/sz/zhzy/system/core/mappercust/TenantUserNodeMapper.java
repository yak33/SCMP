package com.yyk.sz.zhzy.system.core.mappercust;

import java.util.List;

public interface TenantUserNodeMapper {

    /**
     * 获取用户账号获取所属租户节点
     * @return
     */
    public List<UserNode> getUserNode(UserNode userNode);

    /**
     * 注册超级用户
     * @param userNode
     * @return
     */
    int addSuperUser(UserNode userNode);

}
