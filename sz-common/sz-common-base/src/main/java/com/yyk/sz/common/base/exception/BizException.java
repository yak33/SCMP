package com.yyk.sz.common.base.exception;


import com.yyk.sz.common.base.result.CodeMsgAble;

/**
 * Created by zhaofs on 2016/6/24.
 *
 */
public class BizException extends RuntimeException{

    private CodeMsgAble codeMsg;
    private Object[] args;

    public BizException(CodeMsgAble codeMsg){
        this(codeMsg,null);
    }

    public BizException(CodeMsgAble codeMsg, Object... args){
        this(codeMsg,null,args);
    }

    public BizException(CodeMsgAble codeMsg, Throwable t, Object... args) {
        super(codeMsg.getCode() + ":" + (args == null || args.length <= 0 ? codeMsg.getMsg() : String.format(codeMsg.getMsg(), args)), t);
        this.codeMsg = codeMsg;
        this.args = args;
    }

    public String getCode(){
        if(codeMsg != null){
            return codeMsg.getCode();
        }
        return null;
    }

    public String getMsg(){
        if(codeMsg != null){
            if(args == null || args.length <= 0){
                return codeMsg.getMsg();
            }else{
                return String.format(codeMsg.getMsg(),args);
            }
        }
        return null;
    }

}
