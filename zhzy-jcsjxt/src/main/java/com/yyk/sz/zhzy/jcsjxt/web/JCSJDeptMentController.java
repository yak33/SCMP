package com.yyk.sz.zhzy.jcsjxt.web;

import com.terran4j.commons.api2doc.annotations.Api2Doc;
import com.terran4j.commons.api2doc.annotations.ApiComment;
import com.yyk.sz.common.base.domain.Paging;
import com.yyk.sz.common.base.result.Result;
import com.yyk.sz.common.base.result.ResultFactory;
import com.yyk.sz.zhzy.common.util.UtilDES;
import com.yyk.sz.zhzy.jcsjxt.entity.JCSJDeptMent;
import com.yyk.sz.zhzy.jcsjxt.service.JCSJDeptMentService;
import com.yyk.sz.zhzy.jcsjxt.utils.UtilString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 基础数据-科室设置 Controller
 */
@Api2Doc(id = "jcsjxt.kssz", name = "基础数据-科室设置")
@ApiComment(seeClass = JCSJDeptMent.class)
@RestController
@RequestMapping(value = "/jcsjxt/kssz/")
public class JCSJDeptMentController {

    @Autowired
    private JCSJDeptMentService deptMentService;

    /**
     * 获取科室设置
     *
     * @return 科室设置列表
     */
    @ApiComment(" 获取科室设置")
    @RequestMapping(value = "/getDeptMentTable", method = RequestMethod.POST)
    @ResponseBody
    public Result getDeptMentTable(
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
        Paging<JCSJDeptMent> pulses = deptMentService.getDeptMentTable(pageNumber, pageSize, searchText, sortName, sortOrder);
        if (pulses == null || pulses.getSize() == 0) {
            return ResultFactory.create("1", "没有科室数据", null);
        }
        return ResultFactory.create("0", null, pulses);
    }

    /**
     * 新增科室设置
     *
     * @return
     */
    @ApiComment(" 新增科室设置 mainsymptomCode主症编码，逗号隔开")
    @RequestMapping(value = "/insertDeptMent", method = RequestMethod.POST)
    @ResponseBody
    public Result insertDeptMent(
            @RequestBody JCSJDeptMent jcsjDeptMent
    ) {
        if (deptMentService.checkDeptMentExits(jcsjDeptMent.getDeptcode(), null).size() > 0) {
            return ResultFactory.create("1", "科室编码： " + jcsjDeptMent.getDeptcode() + " 已经存在，不能重复添加！", null);
        }
        if (deptMentService.checkDeptMentExits(null, jcsjDeptMent.getDeptname()).size() > 0) {
            return ResultFactory.create("1", "科室名称： " + jcsjDeptMent.getDeptname() + " 已经存在，不能重复添加！", null);
        }
        int flag = deptMentService.insertDeptMent(jcsjDeptMent);
        //保存部门和主症的关系
        String[] mainsymptomCode = null;
        if (jcsjDeptMent.getMainsymptomcode() != null) {
            mainsymptomCode = jcsjDeptMent.getMainsymptomcode().split(",");
        }
        if (mainsymptomCode != null) {
            for (int i = 0; i < mainsymptomCode.length; i++) {
                flag += deptMentService.insertDepartmentMainSymptom(jcsjDeptMent.getDeptcode(), mainsymptomCode[i]);
            }
        }
        if (flag > 0) {
            return ResultFactory.create("0", "保存成功", null);
        }
        return ResultFactory.create("1", "保存失败", null);
    }

    /**
     * 修改科室设置
     *
     * @return
     */
    @ApiComment(" 修改科室设置 deptname2 新的")
    @RequestMapping(value = "/updateDeptMent", method = RequestMethod.POST)
    @ResponseBody
    public Result updateDeptMent(
            @RequestBody JCSJDeptMent jcsjDeptMent
    ) {
        if (!jcsjDeptMent.getDeptname().equals(jcsjDeptMent.getDeptname2())) {
            if (deptMentService.checkDeptMentExits(null, jcsjDeptMent.getDeptname2()).size() > 0) {
                return ResultFactory.create("1", "科室名称： " + jcsjDeptMent.getDeptname2() + " 已经存在，不能修改！", null);
            }
        }
        int flag = deptMentService.updateDeptMent(jcsjDeptMent);
        //删除部门和主症的关系
        flag += deptMentService.deleteDepartmentMainSymptom(jcsjDeptMent.getDeptcode());
        //保存部门和主症的关系
        String[] mainsymptomCode = null;
        if (jcsjDeptMent.getMainsymptomcode() != null) {
            mainsymptomCode = jcsjDeptMent.getMainsymptomcode().split(",");
        }
        if (mainsymptomCode != null) {
            for (int i = 0; i < mainsymptomCode.length; i++) {
                flag += deptMentService.insertDepartmentMainSymptom(jcsjDeptMent.getDeptcode(), mainsymptomCode[i]);
            }
        }
        if (flag > 0) {
            return ResultFactory.create("0", "保存成功", null);
        }
        return ResultFactory.create("1", "保存失败", null);
    }

    /**
     * 删除科室设置
     *
     * @return
     */
    @ApiComment(" 删除科室设置")
    @RequestMapping(value = "/deleteDeptMent", method = RequestMethod.POST)
    @ResponseBody
    public Result deleteDeptMent(
            @RequestParam("deptcode") String deptcode
    ) {
        if (deptMentService.GetUserByDeptCode(deptcode).size() > 0) {
            return ResultFactory.create("1", deptcode + "  该科室存在用户,不能删除", null);
        }
        int flag = deptMentService.deleteDeptMent(deptcode);
        flag += deptMentService.deleteDepartmentMainSymptom(deptcode);
        if (flag > 0) {
            return ResultFactory.create("0", "删除成功", null);
        }
        return ResultFactory.create("1", "删除失败", null);
    }

    /**
     * 根据科室编码获取科室与主症关系信息
     *
     * @return
     */
    @ApiComment(" 根据科室编码获取科室与主症关系信息")
    @RequestMapping(value = "/getMainSymptomByDeptCode", method = RequestMethod.POST)
    @ResponseBody
    public Result getMainSymptomByDeptCode(
            @RequestParam("deptcode") String deptcode
    ) {
        List<JCSJDeptMent> deptMents = deptMentService.getMainSymptomByDeptCode(deptcode);
        if (deptMents == null || deptMents.size() == 0) {
            return ResultFactory.create("1", "没有科室与主症关系数据", null);
        }
        //DES解密主症名称
        for (JCSJDeptMent doc : deptMents) {
            doc.setMainsymptomname(UtilDES.Decrypt(doc.getMainsymptomname()));
        }
        return ResultFactory.create("0", null, deptMents);
    }

}
