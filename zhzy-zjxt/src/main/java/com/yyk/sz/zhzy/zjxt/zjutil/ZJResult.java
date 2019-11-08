package com.yyk.sz.zhzy.zjxt.zjutil;

/**
 * @Author: ZhangChao
 * @Date: 2018/12/3 19:41
 * @Version: 1.0
 */
public class ZJResult {

    private String dd_tg;
    private String time_tg;
    private String time_dz;
    private String g_time_invalid_end;

    private long txtPointIfOpenEndTime;
    private String txttxtPointIfOpenEndTime;
    private String effectiveTime;


    public String getEffectiveTime() {
        return effectiveTime;
    }

    public void setEffectiveTime(String effectiveTime) {
        this.effectiveTime = effectiveTime;
    }

    public long getTxtPointIfOpenEndTime() {
        return txtPointIfOpenEndTime;
    }

    public void setTxtPointIfOpenEndTime(long txtPointIfOpenEndTime) {
        this.txtPointIfOpenEndTime = txtPointIfOpenEndTime;
    }

    public String getTxttxtPointIfOpenEndTime() {
        return txttxtPointIfOpenEndTime;
    }

    public void setTxttxtPointIfOpenEndTime(String txttxtPointIfOpenEndTime) {
        this.txttxtPointIfOpenEndTime = txttxtPointIfOpenEndTime;
    }

    public String getG_time_invalid_end() {
        return g_time_invalid_end;
    }

    public void setG_time_invalid_end(String g_time_invalid_end) {
        this.g_time_invalid_end = g_time_invalid_end;
    }

    public String getDd_tg() {
        return dd_tg;
    }

    public void setDd_tg(String dd_tg) {
        this.dd_tg = dd_tg;
    }

    public String getTime_tg() {
        return time_tg;
    }

    public void setTime_tg(String time_tg) {
        this.time_tg = time_tg;
    }

    public String getTime_dz() {
        return time_dz;
    }

    public void setTime_dz(String time_dz) {
        this.time_dz = time_dz;
    }
}
