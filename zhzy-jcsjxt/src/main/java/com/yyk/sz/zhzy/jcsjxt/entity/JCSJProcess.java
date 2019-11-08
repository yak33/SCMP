package com.yyk.sz.zhzy.jcsjxt.entity;

public class JCSJProcess {

    private String processcode;


    private String uuid;


    private String processname;

    public JCSJProcess() {
        super();
    }

    public String getProcesscode() {
        return processcode;
    }

    public void setProcesscode(String processcode) {
        this.processcode = processcode == null ? null : processcode.trim();
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid == null ? null : uuid.trim();
    }

    public String getProcessname() {
        return processname;
    }

    public void setProcessname(String processname) {
        this.processname = processname == null ? null : processname.trim();
    }
}