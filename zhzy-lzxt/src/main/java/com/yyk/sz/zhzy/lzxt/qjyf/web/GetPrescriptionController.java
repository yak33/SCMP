package com.yyk.sz.zhzy.lzxt.qjyf.web;

import com.terran4j.commons.api2doc.annotations.Api2Doc;
import com.terran4j.commons.api2doc.annotations.ApiComment;
import com.yyk.sz.common.base.result.Result;
import com.yyk.sz.common.base.result.ResultFactory;
import com.yyk.sz.zhzy.lzxt.qjyf.entity.GetPrescription;
import com.yyk.sz.zhzy.lzxt.qjyf.service.GetPrescriptionService;
import com.yyk.sz.zhzy.lzxt.zjkf.entity.SaveOrFinishVisit;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Api2Doc(id = "lzxt.cqjyf", name = "临症-取经验方")
@ApiComment(seeClass = GetPrescription.class)
@RestController
@RequestMapping(value = "/lzxt/qjyf")
public class GetPrescriptionController {

    @Resource
    private GetPrescriptionService getPrescriptionService;

    /**
     * index，测试用
     */
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public Result index() {
        return ResultFactory.create("0","临症系统-取经验方测试访问成功。",null);
    }

    /**
     * 根据用户和方剂类型查询药方列表。
     * @param userCode
     * @param drugFlag
     * @return
     */
    @ApiComment("根据用户和方剂类型查询药方列表")
    @RequestMapping(value = "/getPrescriptionList" , method = RequestMethod.POST)
    @ResponseBody
    public Result getPrescriptionList(
            @RequestParam(value = "userCode" , required = false) String userCode,
            @RequestParam(value = "drugFlag" , required = false) String drugFlag){
        GetPrescription prescription = new GetPrescription();
        prescription.setUserCode(userCode);
        prescription.setDrugFlag(drugFlag);
        List<GetPrescription> prescriptionList = getPrescriptionService.selectPrescriptionList(prescription);
        if (prescriptionList == null || prescriptionList.size() == 0){
            return ResultFactory.create("1","用户"+userCode+"下方剂类型"+drugFlag+"没有数据!");
        }else {
            return ResultFactory.create("0",null,prescriptionList);
        }

    }


}
