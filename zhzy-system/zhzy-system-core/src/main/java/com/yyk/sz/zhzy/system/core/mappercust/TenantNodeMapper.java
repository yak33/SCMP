package com.yyk.sz.zhzy.system.core.mappercust;


import java.util.List;

public interface TenantNodeMapper {

    int updateByInvitationCode(TenantNode record);

    /**
     * 根据邀请码获取数据
     * @param invitationCode
     * @return
     */
    List<TenantNode> getByInvitationCode(String invitationCode);

    /**
     * 获取所有的医院
     * @return
     */
    List<TenantNode> getAllHospital();

    /**
     * 判断此邀请码有没有被使用，即有木有绑定医院或超级用户
     * @param invitationCode
     * @return
     */
    List<TenantNode> getBeUsedOrNo(String invitationCode);

    TenantNode getByNode(String node);
}