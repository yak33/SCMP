package com.yyk.sz.zhzy.system.core.service;

import com.yyk.sz.zhzy.system.core.mappercust.TenantNode;

import java.util.List;

/**
 * @Author: ZhangChao
 * @Date: 2018/12/27 10:12
 * @Version: 1.0
 */
public interface TenantNodeService {

    int updateByInvitationCode(TenantNode record);

    List<TenantNode> getByInvitationCode(String invitationCode);

    List<TenantNode> getAllHospital();

    List<TenantNode> getBeUsedOrNo(String invitationCode);

    TenantNode getByNode(String node);

}
