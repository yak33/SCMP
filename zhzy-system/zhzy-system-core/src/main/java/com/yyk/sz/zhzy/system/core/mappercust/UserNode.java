package com.yyk.sz.zhzy.system.core.mappercust;

import com.terran4j.commons.api2doc.annotations.ApiComment;
import com.yyk.sz.common.base.domain.BaseEntity;

/**
 * 用户-租户节点 对应关系
 */
public class UserNode extends BaseEntity {

    /**
     * 用户账号
     */
    @ApiComment(value = "用户账号", sample = "")
    public String account;

    /**
     * 租户节点
     */
    @ApiComment(value = "租户节点", sample = "")
    public String node;

    private String UUID;

    private String pId;


    public String getpId() {
        return pId;
    }

    public void setpId(String pId) {
        this.pId = pId;
    }

    public String getUUID() {
        return UUID;
    }

    public void setUUID(String UUID) {
        this.UUID = UUID;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getNode() {
        return node;
    }

    public void setNode(String node) {
        this.node = node;
    }
}
