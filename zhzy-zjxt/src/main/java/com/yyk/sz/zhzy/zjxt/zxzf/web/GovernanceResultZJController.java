package com.yyk.sz.zhzy.zjxt.zxzf.web;

import com.terran4j.commons.api2doc.annotations.Api2Doc;
import com.terran4j.commons.api2doc.annotations.ApiComment;
import com.yyk.sz.common.base.result.Result;
import com.yyk.sz.common.base.result.ResultFactory;
import com.yyk.sz.common.base.utils.UtilUuid;
import com.yyk.sz.zhzy.zjxt.bzlz.entity.Acupoint;
import com.yyk.sz.zhzy.zjxt.bzlz.service.AcupointService;
import com.yyk.sz.zhzy.zjxt.zxzf.entity.GRZJListRst;
import com.yyk.sz.zhzy.zjxt.zxzf.entity.GovernanceResultZJ;
import com.yyk.sz.zhzy.zjxt.zxzf.service.GovernanceResultZJService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: ZhangChao
 * @Date: 2018/12/1 11:01
 * @Version: 1.0
 */
@Api2Doc(id = "zjxt.zxzf.2", name = "针灸-证型治法2")
@ApiComment(seeClass = GovernanceResultZJ.class)
@RestController
@RequestMapping(value = "/zjxt/zxzf")
public class GovernanceResultZJController {

    @Resource
    private GovernanceResultZJService governanceResultZJService;

    @Resource
    private AcupointService acupointService;

    /**
     * 获取论治结果--针灸
     * @param empBasicMainID
     * @param operationType
     * @param dialecticalCode
     * @param cureCode
     * @return
     */
    @ApiComment("获取论治结果--针灸")
    @RequestMapping(value = "/getGovernanceResultZJ", method = RequestMethod.POST)
    @ResponseBody
    public Result getGovernanceResultZJ(
            @RequestParam("empBasicMainID") int empBasicMainID,
            @RequestParam("operationType") int operationType,
            @RequestParam(value = "dialecticalCode",required = false) String dialecticalCode,
            @RequestParam(value = "cureCode",required = false) String cureCode){
        GovernanceResultZJ grzj = new GovernanceResultZJ();
        grzj.setEmpBasicMainID(empBasicMainID);
        grzj.setOperationType(operationType);
        grzj.setDialecticalCode(dialecticalCode);
        grzj.setCureCode(cureCode);
        governanceResultZJService.updateEmpBasicMain(grzj);

        String proUUID = UtilUuid.uuid();
        grzj.setProUUID(proUUID);
        governanceResultZJService.getGRZJList(grzj);
        List<GRZJListRst> getGRZJList = governanceResultZJService.getGRZJListRst(proUUID);
        if (getGRZJList != null && getGRZJList.size() > 0){
            return ResultFactory.create("0",null, getGRZJList);
        }
        return ResultFactory.create("1","没有信息",null);
    }

    /**
     * 根据选中的论治结果里的方剂编码获取该方剂里的穴位信息
     * @param prescriptionCode
     * @return
     */
    @ApiComment("根据选中的论治结果里的方剂编码获取该方剂里的穴位信息")
    @RequestMapping(value = "/getAcupointByPrescriptionCode", method = RequestMethod.POST)
    @ResponseBody
    public Result getAcupointByPrescriptionCode(
            @RequestParam("prescriptionCode") String prescriptionCode){
        List<Acupoint> getAcupointList = acupointService.getAcupointByPrescriptionCode(prescriptionCode);
        if (getAcupointList != null && getAcupointList.size() > 0){
            return ResultFactory.create("0",null, getAcupointList);
        }
        return ResultFactory.create("1","没有信息",null);
    }



}
