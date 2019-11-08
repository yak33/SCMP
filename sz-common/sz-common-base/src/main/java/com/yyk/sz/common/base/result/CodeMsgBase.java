package com.yyk.sz.common.base.result;

/**
 * Created by zhaofs on 2017/4/6
 * 0为成功，非0为失败，失败信息命名前缀为500
 */
public class CodeMsgBase implements CodeMsgAble {


    /*成功信息*/
    public static final CodeMsgAble SUCCESS = CodeMsgBase.create("0", "操作成功");
    public static final CodeMsgAble SUCCESS_SAVE = CodeMsgBase.create("0", "保存成功");
    public static final CodeMsgAble SUCCESS_UPDATE = CodeMsgBase.create("0", "更新成功");
    public static final CodeMsgAble SUCCESS_DELETE = CodeMsgBase.create("0", "删除成功");

    /*失败信息*/
    public static final CodeMsgAble FAILURE = CodeMsgBase.create("5000", "操作失败");
    public static final CodeMsgAble FAILURE_SAVE = CodeMsgBase.create("5001", "保存失败");
    public static final CodeMsgAble FAILURE_UPDATE = CodeMsgBase.create("5002", "更新失败");
    public static final CodeMsgAble FAILURE_DELETE = CodeMsgBase.create("5003", "删除失败");
    public static final CodeMsgAble FAILURE_DELETE_HAS_CHILDREN = CodeMsgBase.create("5004", "删除失败，有下级子节点");


    private String code;
    private String msg;

    public CodeMsgBase() {
        this.code = SUCCESS_C;
        this.msg = SUCCESS_M;
    }

    public CodeMsgBase(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static CodeMsgAble create(String code, String msg) {

        return new CodeMsgBase(code, msg);
    }

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getMsg() {
        return msg;
    }
}
