package com.yyk.sz.zhzy.bbxt.web;

import com.terran4j.commons.api2doc.annotations.Api2Doc;
import com.terran4j.commons.api2doc.annotations.ApiComment;
import com.yyk.sz.common.base.domain.Paging;
import com.yyk.sz.common.base.result.Result;
import com.yyk.sz.common.base.result.ResultFactory;
import com.yyk.sz.zhzy.bbxt.entity.BBDoctorTreatmentAnalysis;
import com.yyk.sz.zhzy.bbxt.service.BBDoctorTreatmentAnalysisService;
import com.yyk.sz.zhzy.bbxt.utils.UtilString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 报表系统 Controller
 */
@Api2Doc(id = "bbxt.ysjzfx", name = "报表系统")
@ApiComment(seeClass = BBDoctorTreatmentAnalysis.class)
@RestController
@RequestMapping(value = "/bbxt/ysjzfx/")
public class BBDoctorTreatmentAnalysisController {

    @Autowired
    private BBDoctorTreatmentAnalysisService bbDoctorTreatmentAnalysisService;

    /**
     * 根据日期段查询医生就诊记录
     *
     * @return 医生就诊记录
     */
    @ApiComment("根据日期段查询医生就诊记录")
    @RequestMapping(value = "/getDoctorTreatmentRecord", method = RequestMethod.POST)
    @ResponseBody
    public Result getDoctorTreatmentRecord(
            @RequestParam(value = "beginDate", required = false) String beginDate,
            @RequestParam(value = "endDate", required = false) String endDate,
            @RequestParam(value = "userCode",required = false) String userCode,
            @RequestParam(value = "pageNumber", required = false, defaultValue = "1") int pageNumber,
            @RequestParam(value = "pageSize", required = false, defaultValue = "10") int pageSize,
            @RequestParam(value = "searchText", required = false) String searchText,
            @RequestParam(value = "sortName", required = false) String sortName,
            @RequestParam(value = "sortOrder", required = false, defaultValue = "desc") String sortOrder
    ) {
        userCode = UtilString.judgeNull(userCode);
        searchText = UtilString.judgeNull(searchText);
        if (searchText != null) {
            searchText = "%" + searchText + "%";
        }
        Paging<BBDoctorTreatmentAnalysis> bbDoctorTreatments = bbDoctorTreatmentAnalysisService.getDoctorTreatmentRecord(beginDate, endDate, userCode, pageNumber, pageSize, searchText, sortName, sortOrder);
        if (bbDoctorTreatments == null || bbDoctorTreatments.getSize() == 0) {
            return ResultFactory.create("1", "没有医生就诊记录数据", null);
        }
        return ResultFactory.create("0", null, bbDoctorTreatments);
    }

    /**
     * 根据日期段 获取医生就诊金额
     *
     * @return 医生就诊记录
     */
    @ApiComment("根据日期段-获取医生就诊金额")
    @RequestMapping(value = "/getDoctorTreatmentMoney", method = RequestMethod.POST)
    @ResponseBody
    public Result getDoctorTreatmentMoney(
            @RequestParam(value = "beginDate", required = false) String beginDate,
            @RequestParam(value = "endDate", required = false) String endDate,
            @RequestParam(value = "userCode",required = false) String userCode
    ) {
        List<BBDoctorTreatmentAnalysis> bbDoctorTreatments = bbDoctorTreatmentAnalysisService.getDoctorTreatmentMoney(beginDate, endDate, userCode);
        if (bbDoctorTreatments == null || bbDoctorTreatments.size() == 0) {
            return ResultFactory.create("1", "没有医生就诊金额数据", null);
        }
        return ResultFactory.create("0", null, bbDoctorTreatments);
    }


    /**
     * 根据日期段查询医生工作量汇总
     *
     * @return 医生工作量汇总
     */
    @ApiComment("根据日期段-查询医生工作量汇总")
    @RequestMapping(value = "/getDoctorWorkloadByDate", method = RequestMethod.POST)
    @ResponseBody
    public Result getDoctorWorkloadByDate(
            @RequestParam(value = "beginDate", required = false) String beginDate,
            @RequestParam(value = "endDate", required = false) String endDate,
            @RequestParam(value = "userCode",required = false) String userCode
    ) {
        List<BBDoctorTreatmentAnalysis> bbDoctorTreatments = bbDoctorTreatmentAnalysisService.getDoctorWorkloadByDate(beginDate, endDate, userCode);
        if (bbDoctorTreatments == null || bbDoctorTreatments.size() == 0) {
            return ResultFactory.create("1", "没有医生工作量汇总数据", null);
        }
        return ResultFactory.create("0", null, bbDoctorTreatments);
    }


    /**
     * 根据 时间段查询科室工作量汇总
     *
     * @return 科室工作量汇总
     */
    @ApiComment("根据日期段-查询科室工作量汇总")
    @RequestMapping(value = "/getDeptWorkloadByTime", method = RequestMethod.POST)
    @ResponseBody
    public Result getDeptWorkloadByTime(
            @RequestParam(value = "beginDate", required = false) String beginDate,
            @RequestParam(value = "endDate", required = false) String endDate,
            @RequestParam(value = "userCode",required = false) String userCode
    ) {
        List<BBDoctorTreatmentAnalysis> bbDoctorTreatments = bbDoctorTreatmentAnalysisService.getDeptWorkloadByTime(beginDate, endDate, userCode);
        if (bbDoctorTreatments == null || bbDoctorTreatments.size() == 0) {
            return ResultFactory.create("1", "没有科室工作量汇总数据", null);
        }
        return ResultFactory.create("0", null, bbDoctorTreatments);
    }


}
