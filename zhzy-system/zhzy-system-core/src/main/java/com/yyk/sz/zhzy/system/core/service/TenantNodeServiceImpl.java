package com.yyk.sz.zhzy.system.core.service;

import com.yyk.sz.zhzy.system.core.mappercust.TenantNode;
import com.yyk.sz.zhzy.system.core.mappercust.TenantNodeMapper;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: ZhangChao
 * @Date: 2018/12/27 10:13
 * @Version: 1.0
 */
@Component
@Transactional
public class TenantNodeServiceImpl implements TenantNodeService {

    @Resource
    private TenantNodeMapper tenantNodeMapper;

    @Override
    public int updateByInvitationCode(TenantNode record) {
        return tenantNodeMapper.updateByInvitationCode(record);
    }

    @Override
    public List<TenantNode> getByInvitationCode(String invitationCode) {
        return tenantNodeMapper.getByInvitationCode(invitationCode);
    }

    @Override
    public List<TenantNode> getAllHospital() {
        return tenantNodeMapper.getAllHospital();
    }

    @Override
    public List<TenantNode> getBeUsedOrNo(String invitationCode) {
        return tenantNodeMapper.getBeUsedOrNo(invitationCode);
    }

    @Override
    public TenantNode getByNode(String node) {
        return tenantNodeMapper.getByNode(node);
    }


}
