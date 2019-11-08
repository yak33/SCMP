package com.yyk.sz.zhzy.common.util;

import com.alibaba.fastjson.JSON;
import com.yyk.sz.common.base.result.Result;
import com.yyk.sz.common.base.result.ResultFactory;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class UtilResponse {

    public static void resetToLogin(HttpServletResponse response){
        // 重定向到登录页面
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");
        Result result = ResultFactory.create("401","请先登录",null);
        String resultJSON = JSON.toJSONString(result);
        PrintWriter out = null;
        try {
            out = response.getWriter();
            out.append(resultJSON);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (out != null) {
                out.close();
            }
        }
    }

}
