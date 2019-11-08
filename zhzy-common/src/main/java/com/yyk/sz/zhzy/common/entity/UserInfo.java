package com.yyk.sz.zhzy.common.entity;

import com.yyk.sz.common.base.domain.BaseEntity;



public class UserInfo extends BaseEntity {

    /**
     * 账号
     */
    private String account;

    /**
     * 名称
     */
    private String name;

    /**
     * 备注
     */
    private String note;


    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
