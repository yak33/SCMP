package com.yyk.sz.common.base.result;

import com.terran4j.commons.api2doc.annotations.ApiComment;

import java.io.Serializable;

/**
 * 返回结果
 * Created by Zhaofs on 2016/3/15.
 */
public class Result<T> implements Serializable{
    @ApiComment(value = "成功或有数据为0，失败或无数据为1",sample = "0")
    private String code;
    @ApiComment(value = "返回的信息", sample = "无数据返回")
    private String msg;
    @ApiComment(value = "返回的数据data")
    private T data;

    public Result(){
        this.code="0";
    }
    
    public Result(T data){
        this.code="0";
        this.data=data;
    }

    public Result(String code,String msg){
        this.code=code;
        this.msg=msg;
    }

    public Result(String code, String msg, T data){
        this.code=code;
        this.msg=msg;
        this.data=data;
    }


    /**
     * 创建响应结果
     * @param data 传输对象
     * @return 响应结果
     */
    public static Result create(Object data) {
        return new Result(data);
    }

    /**
     * 创建响应结果
     * @param data 传输对象
     * @param includeFields 包含字段
     * @return 响应结果
     */
    public static Result create(Object data,String[] includeFields) {
        //TODO 完成根据包含字段构建响应结果
        return new Result(data);
    }


    /**
     * 创建响应结果
     * @param code 信息编码，为0表示返回成功
     * @param msg 返回信息
     * @return 响应结果
     */
    public static Result create(String code,String msg) {
        return new Result(code,msg);
    }

    /**
     * 创建响应结果
     * @param code 信息编码，为0表示返回成功
     * @param msg 返回信息
     * @param data 传输对象
     * @return 响应结果
     */
    public static Result create(String code,String msg,Object data) {
        return new Result(code,msg,data);
    }


    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
