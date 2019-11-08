package com.yyk.sz.zhzy.lzxt.cjyf.entity;

/**
 * 处方分类
 * @Author: ZhangChao
 * @Date: 2018/12/13 10:42
 * @Version: 1.0
 */
public class ClassifyVO {
    private String pCCode;
    private String pCName;
    private String pinYinCode;

    public String getpCCode() {
        return pCCode;
    }

    public void setpCCode(String pCCode) {
        this.pCCode = pCCode;
    }

    public String getpCName() {
        return pCName;
    }

    public void setpCName(String pCName) {
        this.pCName = pCName;
    }

    public String getPinYinCode() {
        return pinYinCode;
    }

    public void setPinYinCode(String pinYinCode) {
        this.pinYinCode = pinYinCode;
    }
}
