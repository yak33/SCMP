package com.yyk.sz.zhzy.jcsjxt.web;

import com.terran4j.commons.api2doc.annotations.Api2Doc;
import com.terran4j.commons.api2doc.annotations.ApiComment;
import com.yyk.sz.common.base.domain.Paging;
import com.yyk.sz.common.base.result.Result;
import com.yyk.sz.common.base.result.ResultFactory;
import com.yyk.sz.zhzy.jcsjxt.entity.JCSJTongue;
import com.yyk.sz.zhzy.jcsjxt.service.JCSJTongueService;
import com.yyk.sz.zhzy.jcsjxt.utils.UtilString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.*;

/**
 * 基础数据-舌像设置 Controller
 */
@Api2Doc(id = "jcsjxt.sxsz", name = "基础数据-舌像设置")
@ApiComment(seeClass = JCSJTongue.class)
@RestController
@RequestMapping(value = "/jcsjxt/sxsz/")
public class JCSJTongueController {

    @Autowired
    private JCSJTongueService tongueService;

    /**
     * 获取舌像设置
     *
     * @return 舌像设置列表
     */
    @ApiComment(" 获取舌像设置")
    @RequestMapping(value = "/getTongueTable", method = RequestMethod.POST)
    @ResponseBody
    public Result getTongueTable(
            @RequestParam(value = "pageNumber", required = false, defaultValue = "1") int pageNumber,
            @RequestParam(value = "pageSize", required = false, defaultValue = "10") int pageSize,
            @RequestParam(value = "searchText", required = false) String searchText,
            @RequestParam(value = "sortName", required = false) String sortName,
            @RequestParam(value = "sortOrder", required = false, defaultValue = "desc") String sortOrder
    ) {
        searchText = UtilString.judgeNull(searchText);
        if (searchText != null) {
            searchText = "%" + searchText + "%";
        }
        Paging<JCSJTongue> jcsjTongues = tongueService.getTongueTable(pageNumber, pageSize, searchText, sortName, sortOrder);
        if (jcsjTongues == null || jcsjTongues.getSize() == 0) {
            return ResultFactory.create("1", "没有舌像数据", null);
        }
        return ResultFactory.create("0", null, jcsjTongues);
    }

    /**
     * 新增舌像设置
     *
     * @return
     */
    @ApiComment(" 新增舌像设置")
    @RequestMapping(value = "/insertTongue", method = RequestMethod.POST)
    @ResponseBody
    public Result insertTongue(
            @RequestBody JCSJTongue jcsjTongue
    ) {
        if (tongueService.checkTongueExits(jcsjTongue.getTonguecode(), null).size() > 0) {
            return ResultFactory.create("1", "舌像编码： " + jcsjTongue.getTonguecode() + " 已经存在，不能重复添加！", null);
        }
        if (tongueService.checkTongueExits(null, jcsjTongue.getTonguename()).size() > 0) {
            return ResultFactory.create("1", "舌像名称： " + jcsjTongue.getTonguename() + " 已经存在，不能重复添加！", null);
        }
        //上传图片


        int flag = tongueService.insertTongue(jcsjTongue);
        if (flag > 0) {
            return ResultFactory.create("0", "保存成功", null);
        }
        return ResultFactory.create("1", "保存失败", null);
    }

    /**
     * 修改舌像设置
     *
     * @return
     */
    @ApiComment(" 修改舌像设置 tonguename2 新的")
    @RequestMapping(value = "/updateTongue", method = RequestMethod.POST)
    @ResponseBody
    public Result updateTongue(
            @RequestBody JCSJTongue jcsjTongue
    ) {
        int flag = 0;
        if (!jcsjTongue.getTonguename().equals(jcsjTongue.getTonguename2())) {
            if (tongueService.checkTongueExits(null, jcsjTongue.getTonguename2()).size() > 0) {
                return ResultFactory.create("1", "舌像名称： " + jcsjTongue.getTonguename2() + " 已经存在，不能修改！", null);
            }
        }
        flag = tongueService.updateTongue(jcsjTongue);
        if (flag > 0) {
            return ResultFactory.create("0", "保存成功", null);
        }
        return ResultFactory.create("1", "保存失败", null);
    }

    /**
     * 删除舌像设置
     *
     * @return
     */
    @ApiComment(" 删除舌像设置")
    @RequestMapping(value = "/deleteTongue", method = RequestMethod.POST)
    @ResponseBody
    public Result deleteTongue(
            @RequestParam("tonguecode") String tonguecode
    ) {
        if (tongueService.GetMainTongueByTongueCode(tonguecode).size() > 0) {
            return ResultFactory.create("1", tonguecode + "  的舌像信息存在主症关系，不能要删除！", null);
        }
        int flag = tongueService.deleteTongue(tonguecode);
        if (flag > 0) {
            return ResultFactory.create("0", "删除成功", null);
        }
        return ResultFactory.create("1", "删除失败", null);
    }

    @ApiComment(" 上传图片")
    @RequestMapping(value = "uploadFile")
    public Object uploadFile(HttpServletRequest request, MultipartHttpServletRequest multiReq, HttpServletResponse response) throws Exception, IOException {
        // 获取上传文件的路径
        String uploadFilePath = multiReq.getFile("file").getOriginalFilename();
        // 截取上传文件的后缀
        String uploadFileSuffix = uploadFilePath.substring(
                uploadFilePath.lastIndexOf("."));
        // 使用UUID生成文件名称
        String filename = UUID.randomUUID().toString() + uploadFileSuffix;// 构建文件名称
        FileOutputStream fos = null;
        FileInputStream fis = null;
        String logoPathDir = "D:/image/tongueimages/";
        // 根据真实路径创建目录
        File logoSaveFile = new File(logoPathDir);
        if (!logoSaveFile.exists()) {
            logoSaveFile.mkdirs();
        }
        try {
            fis = (FileInputStream) multiReq.getFile("file").getInputStream();
            fos = new FileOutputStream(new File(logoPathDir + filename));
            byte[] temp = new byte[1024];
            int i = fis.read(temp);
            while (i != -1) {
                fos.write(temp, 0, temp.length);
                fos.flush();
                i = fis.read(temp);
            }
        } catch (IOException e) {
            //e.printStackTrace();
            return ResultFactory.create("1", "上传失败", e.getMessage());
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    //e.printStackTrace();
                    return ResultFactory.create("1", "上传失败", e.getMessage());
                }
            }
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    //e.printStackTrace();
                    return ResultFactory.create("1", "上传失败", e.getMessage());
                }
            }
        }
        return ResultFactory.create("0", "上传成功", filename);
    }

    /**
     * 删除舌像图片
     *
     * @return
     */
    @ApiComment(" 删除舌像图片")
    @RequestMapping(value = "/deleteTongueImage", method = RequestMethod.POST)
    @ResponseBody
    public Result deleteTongueImage(
            @RequestParam("imagecode") String imagecode
    ) {
        try {
            String logoPathDir = "D:/image/tongueimages/" + imagecode;
            // 根据真实路径创建目录
            File logoSaveFile = new File(logoPathDir);
            if (logoSaveFile.exists()) {
                logoSaveFile.delete();
            }
        } catch (Exception e) {
            //e.printStackTrace();
            return ResultFactory.create("1", "删除失败", e.getMessage());
        }
        return ResultFactory.create("0", "删除成功", null);
    }
}
