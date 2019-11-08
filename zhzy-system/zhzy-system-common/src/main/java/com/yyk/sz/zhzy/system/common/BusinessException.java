package com.yyk.sz.zhzy.system.common;

import com.yyk.sz.common.base.exception.BizException;
import com.yyk.sz.common.base.result.CodeMsgBase;

public class BusinessException extends BizException {

    public BusinessException(String msg) {
        super(new CodeMsgBase("5000", msg));
    }

    public BusinessException(String errorCode, String msg) {
        super(new CodeMsgBase(errorCode, msg));
    }
}
