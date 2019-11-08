package com.yyk.sz.zhzy.zjxt.cqjyf.web;

import com.terran4j.commons.api2doc.annotations.Api2Doc;
import com.terran4j.commons.api2doc.annotations.ApiComment;
import com.yyk.sz.common.base.result.Result;
import com.yyk.sz.common.base.result.ResultFactory;
import com.yyk.sz.zhzy.zjxt.cqjyf.entity.Prescription;
import com.yyk.sz.zhzy.zjxt.cqjyf.service.PrescriptionService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 存取经验方--针灸系统
 * @Author: ZhangChao
 * @Date: 2018/11/23 16:26
 * @Version: 1.0
 */
@Api2Doc(id = "zjxt.cqjyf",name = "针灸-存取经验方")
@ApiComment(seeClass = Prescription.class)
@RestController
@RequestMapping("/zjxt/cqjyf")
public class PrescriptionZJController {

    @Resource
    private PrescriptionService prescriptionService;

    /**
     * 取经验方--针灸系统
     * @param userCode
     * @param drugFlag
     * @return
     */
    @ApiComment("取经验方")
    @RequestMapping(value = "/getPrescription" , method = RequestMethod.POST)
    @ResponseBody
    public Result getPrescription(
            @RequestParam(value = "userCode") String userCode,
            @RequestParam(value = "drugFlag") String drugFlag,
            @RequestParam(value = "searchText",required = false) String searchText){
        Prescription prescription = new Prescription();
        prescription.setUserCode(userCode);
        prescription.setDrugFlag(drugFlag);
        if (searchText != null && !"".equals(searchText)){
            prescription.setSearchText(searchText);
        }
        List<Prescription> prescriptionList = prescriptionService.getPrescription(prescription);
        if (prescriptionList == null || prescriptionList.size() == 0){
            return ResultFactory.create("1","用户"+userCode+"下方剂类型"+drugFlag+"没有数据!");
        }else {
            return ResultFactory.create("0",null,prescriptionList);
        }

    }

    /**
     * 保存经验方--针灸系统
     * @param prescription
     * @return
     */
    @ApiComment("保存经验方")
    @RequestMapping(value = "/savePrescriptionZJ", method = RequestMethod.POST)
    @ResponseBody
    public Result savePrescriptionZJ(@RequestBody Prescription prescription){
        int delsub = prescriptionService.delPrescriptionSubZJ(prescription);
        int del = prescriptionService.delPrescriptionZJ(prescription);
        System.out.println(del+";"+delsub);
        //接收到的穴位集合list
        List<Prescription> acupointList = prescription.getSubList();
        //首先插入方剂主表
        int insertMain = prescriptionService.savePrescriptionZJ(prescription);

        //获取主表的code，以插入子表
        //String pCode = prescriptionService.getMaxCode();
        String pCode1 = prescriptionService.getWantCode(prescription).get(0).getPrescriptionCode();
        //System.out.println(pCode+";"+pCode1);
        String prescriptionCode = "";
//        if (pCode.equals(pCode1)){
//            prescriptionCode = pCode;
//        }else{
            prescriptionCode = pCode1;
//        }
        boolean flag = false;
        if (acupointList != null && acupointList.size() > 0){
            //遍历集合，循环插入穴位子表
            for (int i = 0; i < acupointList.size(); i++){
                acupointList.get(i).setPrescriptionCode(prescriptionCode);
                int insertSub = prescriptionService.savePrescriptionSubZJ(acupointList.get(i));
                if (insertSub > 0){
                    flag = true;
                }
            }
        }
        if (insertMain > 0 && flag){
            return ResultFactory.create("0","保存成功",1);
        }
        return ResultFactory.create("1",null,0);
    }

    /**
     * 获取方解
     * @param prescriptionCode
     * @return
     */
    @ApiComment("获取方解")
    @RequestMapping(value = "/getFangJie", method = RequestMethod.POST)
    @ResponseBody
    public Result getFangJie(@RequestParam("prescriptionCode") String prescriptionCode){
        List<Prescription> FJList = prescriptionService.getFangJie(prescriptionCode);
        if (FJList != null && FJList.size() > 0){
            return ResultFactory.create("0","获取成功",FJList);
        }
        return ResultFactory.create("1",null,0);
    }

}
