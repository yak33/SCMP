package com.yyk.sz.zhzy.lzxt.bzlz.entity;

import com.yyk.sz.common.base.domain.BaseEntity;


public class Pulse extends BaseEntity {

    /**
     * 脉象编码
     */
    private String PulseCode;

    /**
     * 脉象名称
     */
    private String PulseName;

    /**
     *
     */
    private String selPulse;

    public String getPulseCode() {
        return PulseCode;
    }

    public void setPulseCode(String pulseCode) {
        PulseCode = pulseCode;
    }

    public String getPulseName() {
        return PulseName;
    }

    public void setPulseName(String pulseName) {
        PulseName = pulseName;
    }

    public String getSelPulse() {
        return selPulse;
    }

    public void setSelPulse(String selPulse) {
        this.selPulse = selPulse;
    }
}
