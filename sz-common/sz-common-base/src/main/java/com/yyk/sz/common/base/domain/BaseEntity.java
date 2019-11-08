package com.yyk.sz.common.base.domain;

import java.util.Date;

/**
 * Created by lvhuawei on 2018/9/12.
 * 表记录的统一基类
 */
public abstract class BaseEntity {

    protected String id;
    private String createBy;
    private Date createDate;
    private String updateBy;
    private Date updateDate;
    private Integer versionNum;
    private String delFlag = "0";

    public String getId() {
        return id;
    }

    public void setId(String id) {
        if (id == null || id.trim().length() == 0) {
            this.id = null;
        } else {
            this.id = id;
        }
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public Integer getVersionNum() {
        return versionNum;
    }

    public void setVersionNum(Integer versionNum) {
        this.versionNum = versionNum;
    }

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }
}
