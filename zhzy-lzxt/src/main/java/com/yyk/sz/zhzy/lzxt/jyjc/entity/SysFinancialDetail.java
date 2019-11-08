package com.yyk.sz.zhzy.lzxt.jyjc.entity;

import java.math.BigDecimal;

public class SysFinancialDetail {
    private String uuid;

    private String detailitemcode;

    private String detailitemname;

    private BigDecimal quantity;

    private BigDecimal unitprice;

    private String payitemcode;

    private Integer empbasicmainid;

    private Integer payitem;


    public Integer getEmpbasicmainid() {
        return empbasicmainid;
    }

    public void setEmpbasicmainid(Integer empbasicmainid) {
        this.empbasicmainid = empbasicmainid;
    }

    public Integer getPayitem() {
        return payitem;
    }

    public void setPayitem(Integer payitem) {
        this.payitem = payitem;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid == null ? null : uuid.trim();
    }

    public String getDetailitemcode() {
        return detailitemcode;
    }

    public void setDetailitemcode(String detailitemcode) {
        this.detailitemcode = detailitemcode == null ? null : detailitemcode.trim();
    }

    public String getDetailitemname() {
        return detailitemname;
    }

    public void setDetailitemname(String detailitemname) {
        this.detailitemname = detailitemname == null ? null : detailitemname.trim();
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getUnitprice() {
        return unitprice;
    }

    public void setUnitprice(BigDecimal unitprice) {
        this.unitprice = unitprice;
    }

    public String getPayitemcode() {
        return payitemcode;
    }

    public void setPayitemcode(String payitemcode) {
        this.payitemcode = payitemcode == null ? null : payitemcode.trim();
    }
}