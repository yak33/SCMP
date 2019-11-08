package com.yyk.sz.common.base.result;

/**
 * 返回结果工具
 * Created by Zhaofs on 2016/3/15.
 */
public class ResultFactory{


    /**
     * 创建响应结果
     * @param msg 返回信息
     * @return 响应结果
     */
    public static Result create(String msg) {
        Result result = new Result();
        result.setMsg(msg);
        return result;
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
    public static Result create(Object data, String[] includeFields) {
        //TODO 完成根据包含字段构建响应结果
        return new Result(data);
    }

    /**
     * 创建响应结果
     * @param msg 返回信息
     * @param data 传输对象
     * @return 响应结果
     */
    public static Result create(String msg, Object data) {
        return new Result("0", msg, data);
    }

    /**
     * 创建响应结果
     * @param code 信息编码，为0表示返回成功
     * @param msg 返回信息
     * @return 响应结果
     */
    public static Result create(String code, String msg) {
        return new Result(code,msg);
    }

    /**
     * 创建响应结果
     * @param code 信息编码，为0表示返回成功
     * @param msg 返回信息
     * @param data 传输对象
     * @return 响应结果
     */
    public static Result create(String code, String msg, Object data) {
        return new Result(code,msg,data);
    }

}
