package com.yyk.sz.zhzy.lzxt.hzlb.web;

import com.terran4j.commons.api2doc.annotations.Api2Doc;
import com.terran4j.commons.api2doc.annotations.ApiComment;
import com.yyk.sz.common.base.domain.Paging;
import com.yyk.sz.common.base.result.Result;
import com.yyk.sz.common.base.result.ResultFactory;
import com.yyk.sz.zhzy.lzxt.hzlb.entity.PatientList;
import com.yyk.sz.zhzy.lzxt.hzlb.service.PatientListService;
import com.yyk.sz.zhzy.lzxt.utils.UtilString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 临症系统-患者列表 Controller
 */
@Api2Doc(id = "lzxt.hzlb", name = "临症-患者列表")
@ApiComment(seeClass = PatientList.class)
@RestController
@RequestMapping(value = "/lzxt/hzlb/")
public class PatientListController {

    @Autowired
    private PatientListService patientListService;

    /**
     * 获取未就诊列表或已就诊列表（根据请求传递的userCode和deptCode）
     *
     * @return 未就诊患者列表
     */
    @ApiComment("获取未就诊列表或已就诊列表")
    @RequestMapping(value = "/getSelectPatientListTable", method = RequestMethod.POST)
    public Result currentUser(@RequestParam("treatmentState") String treatmentState,
                              @RequestParam(value = "deptcode", required = false) String deptcode,
                              @RequestParam(value = "pageNumber", required = false, defaultValue = "1") int pageNumber,
                              @RequestParam(value = "pageSize", required = false, defaultValue = "10") int pageSize,
                              @RequestParam(value = "searchText", required = false) String searchText,
                              @RequestParam(value = "sortName", required = false, defaultValue = "makeDate") String sortName,
                              @RequestParam(value = "sortOrder", required = false, defaultValue = "desc") String sortOrder) {
        deptcode = UtilString.judgeNull(deptcode);
        searchText = UtilString.judgeNull(searchText);
        if (searchText != null) {
            searchText = "%" + searchText + "%";
        }
        Paging<PatientList> patientList = patientListService.getSelectPatientListTable(treatmentState,deptcode, pageNumber, pageSize, searchText, sortName, sortOrder);
        if (patientList == null || patientList.getSize() == 0) {
            return ResultFactory.create("1", "没有患者信息数据", null);
        }
        return ResultFactory.create("0", null, patientList);
    }

}
