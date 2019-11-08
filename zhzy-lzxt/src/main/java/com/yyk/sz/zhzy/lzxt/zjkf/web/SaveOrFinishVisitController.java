package com.yyk.sz.zhzy.lzxt.zjkf.web;

import com.terran4j.commons.api2doc.annotations.Api2Doc;
import com.terran4j.commons.api2doc.annotations.ApiComment;
import com.yyk.sz.common.base.result.Result;
import com.yyk.sz.common.base.result.ResultFactory;
import com.yyk.sz.zhzy.lzxt.jyjc.entity.SysFinancial;
import com.yyk.sz.zhzy.lzxt.jyjc.entity.SysFinancialDetail;
import com.yyk.sz.zhzy.lzxt.jyjc.entity.SysInventory;
import com.yyk.sz.zhzy.lzxt.jyjc.entity.SysPharmacy;
import com.yyk.sz.zhzy.lzxt.jyjc.service.CheckItemService;
import com.yyk.sz.zhzy.lzxt.zjkf.entity.DirectPrescription;
import com.yyk.sz.zhzy.lzxt.zjkf.entity.SaveOrFinishVisit;
import com.yyk.sz.zhzy.lzxt.zjkf.service.SaveOrFinishVisitService;
import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.List;

@Api2Doc(id = "lzxt.zjkf.2", name = "临症-直接开方")
@ApiComment(seeClass = SaveOrFinishVisit.class)
@RestController
@RequestMapping(value = "/lzxt/zjkf/")
public class SaveOrFinishVisitController {

    private static final Log logger = LogFactory.getLog(SaveOrFinishVisitController.class);

    @Resource
    private SaveOrFinishVisitService saveOrFinishVisitService;
    @Resource
    private CheckItemService checkItemService;


    /**
     * 保存or完成就诊的方法
     * @param saveOrFinishVisit
     * @return
     */
    @ApiComment("保存or完成就诊的方法")
    @RequestMapping(value = "saveOrFinishVisit", method = RequestMethod.POST)
    @ResponseBody
    public Result saveOrFinishVisit(@RequestBody SaveOrFinishVisit saveOrFinishVisit){

        String flagg = saveOrFinishVisit.getFlag(); //取出标记== 0保存--1完成就诊

        // 财务相关
        // 先清一遍主表和子表，根据病人id和项目类型。--0
        int usageCount = saveOrFinishVisit.getUsageCount(); //付数
        int daijian = 0;
        boolean djian = saveOrFinishVisit.isDaiJian(); //是否代煎
        if (djian){
            daijian = 1;
        }
        SysFinancial sysFinancial = new SysFinancial();
        SysFinancialDetail sysFinancialDetail = new SysFinancialDetail();
        sysFinancial.setEmpbasicmainid(saveOrFinishVisit.getEmpBasicMainID());
        sysFinancial.setPayitem(0); //中药处方
        saveOrFinishVisitService.delFinancial(sysFinancial); //删除主表此人临证治疗..
        sysFinancialDetail.setEmpbasicmainid(saveOrFinishVisit.getEmpBasicMainID());
        sysFinancialDetail.setPayitem(0);
        saveOrFinishVisitService.delFinancialDetail(sysFinancialDetail); //删除子表此人临证治疗明细..
        sysFinancial.setPayitemcode("(๑¯ ³ ¯๑)");
        sysFinancial.setPaytype(60); //默认不报销
        sysFinancial.setPaystatus(0); //默认未缴费
        double totalmoney = 0;

        //药房相关
        SysPharmacy sysPharmacy = new SysPharmacy();
        sysPharmacy.setEmpbasicmainid(saveOrFinishVisit.getEmpBasicMainID());
        sysPharmacy.setItemtype(0); //中药处方
        saveOrFinishVisitService.delPharmacy(sysPharmacy); //删除药房表此人西药处方..
        sysPharmacy.setTakeflag(0); //默认未取药

        // 1.根据EmpBasicMainID和DrugFlag = 0删除CM_FangJiDetailSub表的数据。
        saveOrFinishVisitService.delFangJiDetailSub(saveOrFinishVisit);
        // 2.根据EmpBasicMainID和DrugFlag = 0删除CM_FangJiSub表的数据。
        saveOrFinishVisitService.delFangJiSub(saveOrFinishVisit);
        // 3.根据EmpBasicMainID更新病人基本信息表CM_EmpBasicMain的症型编码DialecticalCode,
        //   治则编码CureCode,中医病名ChineseMedicineCode，西医病名WesternMedicineCode。
        int updateEmp = saveOrFinishVisitService.updateEmpBasicMain(saveOrFinishVisit);
        System.out.println(updateEmp);
        // 4.根据挂号流水号@RegistrationNum更新CM_HISEmpBasicMain表的就诊状态为已就诊TreatmentState = 1
        if ("1".equals(flagg)){ //完成就诊，更改状态
            int updateHISEmp = saveOrFinishVisitService.updateHISEmpBasicMain(saveOrFinishVisit);
            System.out.println(updateHISEmp);
        }

        // 5.插入问诊方剂表CM_FangJiSub数据。
        int insertSub = saveOrFinishVisitService.insertFangJiSub(saveOrFinishVisit);
        System.out.println(insertSub);

        List<SaveOrFinishVisit> drugList = saveOrFinishVisit.getFangJiDetailList();
        boolean flag = false;
        if (drugList != null && drugList.size() > 0){
            List<SaveOrFinishVisit> SOFVList = saveOrFinishVisitService.getFangJiSubIDcc(saveOrFinishVisit.getEmpBasicMainID());
            int fangJiSubID = SOFVList.get(0).getFangJiSubID();
            //6.循环插入CM_FangJiDetailSub表中
            for (SaveOrFinishVisit sfv : drugList){
//                BigDecimal remainamount = checkItemService.selectByPrimaryKey(Integer.parseInt(sfv.getDrugCode())).getRemainamount(); //剩余库存
//                BigDecimal quanitity = new BigDecimal(sfv.getQuanitity()); //数量
//                if (remainamount.compareTo(quanitity) == -1){ //库存小于数量
//                    System.out.println(sfv.getDrugName()+"库存不足!");
//                    logger.debug(sfv.getDrugName()+"库存不足!剩余库存是："+remainamount);
//                    return ResultFactory.create("1",sfv.getDrugName()+"库存不足!",remainamount);
//                }
                //获取草药单价
                double LPrice = saveOrFinishVisitService.getDrugDict(sfv.getDrugCode()).getLPrice();
                double WholeMoney = LPrice * sfv.getQuanitity() * usageCount;
                totalmoney += WholeMoney;
                sfv.setFangJiSubID(fangJiSubID);
                sfv.setWholeMoney(WholeMoney);
                sfv.setLPrice(LPrice);
                int insertDetailSubcc = saveOrFinishVisitService.insertFangJiDetailSubcc(sfv);
                sysFinancialDetail.setDetailitemcode(sfv.getDrugCode());
                sysFinancialDetail.setDetailitemname(sfv.getDrugName());
//                sysFinancialDetail.setQuantity(new BigDecimal(Double.toString(sfv.getQuanitity() * usageCount)));
                sysFinancialDetail.setQuantity(new BigDecimal(Double.toString(sfv.getQuanitity())));
                sysFinancialDetail.setUnitprice(new BigDecimal(Double.toString(LPrice)));
                sysFinancialDetail.setPayitemcode("(๑¯ ³ ¯๑)");
                int insFinDet = saveOrFinishVisitService.insertFinDet(sysFinancialDetail);
                System.out.println(insFinDet+"中药处方--财务子表添加!");

                sysPharmacy.setDrugcode(sfv.getDrugCode());
                sysPharmacy.setDrugname(sfv.getDrugName());
//                sysPharmacy.setQuantity(sfv.getQuanitity() * usageCount);
                sysPharmacy.setQuantity(sfv.getQuanitity());
                sysPharmacy.setUsageCount(usageCount); //设置付数
                sysPharmacy.setDaiJian(daijian); //设置代煎
                int insPha = saveOrFinishVisitService.insertPha(sysPharmacy);
                System.out.println(insPha+"中药处方--药房表添加");

                if (insertDetailSubcc > 0){
                    flag = true;
                }
            }

        }
        sysFinancial.setTotalmoney(new BigDecimal(Double.toString(totalmoney)));
        int insFin = saveOrFinishVisitService.insertFin(sysFinancial);
        System.out.println(insFin+"中药处方--财务主表添加");
        System.out.println(flag);
//        int updateDetailSubcc = saveOrFinishVisitService.updateFangJiDetailSubcc(saveOrFinishVisit);
        if (updateEmp > 0 && insertSub > 0 && flag){
            return ResultFactory.create("0","保存成功!",1);
        }
        return ResultFactory.create("1","保存失败!",null);

    }

    /**
     * 保存or完成就诊的方法1--改状态--前端要求
     * @param registrationNum
     * @return
     */
    @ApiComment("保存or完成就诊的方法1--改状态")
    @RequestMapping(value = "saveOrFinishVisit1", method = RequestMethod.POST)
    @ResponseBody
    public Result saveOrFinishVisit1(@RequestParam("registrationNum") String registrationNum){

        int updateHISEmp = saveOrFinishVisitService.updateHISEmpBasicMain1(registrationNum);
        System.out.println(updateHISEmp);

        if (updateHISEmp > 0){
            return ResultFactory.create("0","保存成功!",1);
        }
        return ResultFactory.create("1","保存失败!",null);

    }

    /**
     * 打印处方
     * @param empBasicMainID
     * @return
     */
    @ApiComment("打印处方")
    @RequestMapping(value = "printChuFang", method = RequestMethod.POST)
    @ResponseBody
    public Result printChuFang(
            @RequestParam("empBasicMainID") Integer empBasicMainID,
            @RequestParam("drugFlag") Integer drugFlag) {
        SaveOrFinishVisit saveOrFinishVisit = new SaveOrFinishVisit();
        saveOrFinishVisit.setEmpBasicMainID(empBasicMainID);
        saveOrFinishVisit.setDrugFlag(drugFlag);
        List<SaveOrFinishVisit> fangJiModels = saveOrFinishVisitService.getFangJi(saveOrFinishVisit);
        if (fangJiModels != null && fangJiModels.size() > 0) {
            //获取草药列表
            List<SaveOrFinishVisit> drugList = saveOrFinishVisitService.getFangJiDetailSub(saveOrFinishVisit);
            if (drugList != null && drugList.size() > 0) {
                fangJiModels.get(0).setFangJiDetailList(drugList);
            }
            if (fangJiModels.get(0) != null) {
                return ResultFactory.create("0", "获取成功!", fangJiModels.get(0));
            }
        }
        return ResultFactory.create("1", "获取失败!", null);
    }


}
