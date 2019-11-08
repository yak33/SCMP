package com.yyk.sz.zhzy.lzxt.xycf.web;

import com.terran4j.commons.api2doc.annotations.Api2Doc;
import com.terran4j.commons.api2doc.annotations.ApiComment;
import com.yyk.sz.common.base.result.Result;
import com.yyk.sz.common.base.result.ResultFactory;
import com.yyk.sz.zhzy.lzxt.jyjc.entity.SysFinancial;
import com.yyk.sz.zhzy.lzxt.jyjc.entity.SysFinancialDetail;
import com.yyk.sz.zhzy.lzxt.jyjc.entity.SysPharmacy;
import com.yyk.sz.zhzy.lzxt.jyjc.service.CheckItemService;
import com.yyk.sz.zhzy.lzxt.xycf.entity.FangJiDetailSubEntity;
import com.yyk.sz.zhzy.lzxt.xycf.entity.FangJiSubEntity;
import com.yyk.sz.zhzy.lzxt.xycf.service.XiYaoChuFangService;
import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.List;


/**
 * 临症系统-西药处方 Controller
 */
@Api2Doc(id = "lzxt.xycf.2", name = "临症-西药处方")
@ApiComment(seeClass = FangJiSubEntity.class)
@RestController
@RequestMapping(value = "/lzxt/xycf/")
public class XiYaoChuFangController {

    private static final Log logger = LogFactory.getLog(XiYaoChuFangController.class);

    @Autowired
    private XiYaoChuFangService xiYaoChuFangService;

    @Resource
    private CheckItemService checkItemService;

    /**
     * 保存西医处方
     *
     * @return 成功
     */
    @ApiComment("保存西医处方 operaType 0:新增   1：修改")
    @RequestMapping(value = "/saveWesternDrugFangji", method = RequestMethod.POST)
    @ResponseBody
    public Result saveWesternDrugFangji(@RequestBody List<FangJiSubEntity> fangJiSubEntityList) {
        //String empBasicMainID = fangJiSubEntityList.get(0).getEmpBasicMainID();
        //String fangJiSubID = fangJiSubEntityList.get(0).getFangJiSubID();
       //String fangJiSubCode = fangJiSubEntityList.get(0).getFangJiSubCode();

        // 财务相关--2019/1/15zhangchao
        //*************************START*********************************
        // 先清一遍主表和子表，根据病人id和项目类型。--4
        SysFinancial sysFinancial = new SysFinancial();
        SysFinancialDetail sysFinancialDetail = new SysFinancialDetail();
        sysFinancial.setEmpbasicmainid(Integer.parseInt(fangJiSubEntityList.get(0).getEmpBasicMainID()));
        sysFinancial.setPayitem(1); //西药处方
        xiYaoChuFangService.delFinancial(sysFinancial); //删除主表此人西药处方..
        sysFinancialDetail.setEmpbasicmainid(Integer.parseInt(fangJiSubEntityList.get(0).getEmpBasicMainID()));
        sysFinancialDetail.setPayitem(1);
        xiYaoChuFangService.delFinancialDetail(sysFinancialDetail); //删除子表此人西药处方明细..
        sysFinancial.setPayitemcode("(๑¯ ³ ¯๑)");
        sysFinancial.setPaytype(60); //默认不报销
        sysFinancial.setPaystatus(0); //默认未缴费
        double totalmoney = 0;

        //药房相关
        SysPharmacy sysPharmacy = new SysPharmacy();
        sysPharmacy.setEmpbasicmainid(Integer.parseInt(fangJiSubEntityList.get(0).getEmpBasicMainID()));
        sysPharmacy.setItemtype(1); //西药处方
        xiYaoChuFangService.delPharmacy(sysPharmacy); //删除药房表此人西药处方..
        sysPharmacy.setTakeflag(0); //默认未取药

        boolean insertFangJiSub = false;
        boolean isSuc = false;
        //遍历处方
        for (int i = 0; i < fangJiSubEntityList.size(); i++) {
            isSuc = false;
            insertFangJiSub = false;
            String DrugCodeValue = ""; //西药编码
            String ConsumptionValue = ""; //用量
            String DrugWayCodeValue = ""; //用药方式
            String FrequencyCodeValue = ""; //用药频率
            String UseDaysValue = ""; //用药天数
            String TotalAmountValue = ""; //总量
            String QuanitityValue = ""; //领量
            String LPriceValue = "";    //单价
            String WholeMoneyValue = ""; //
            FangJiSubEntity fangJiSubEntity = fangJiSubEntityList.get(i);
            //子list
            List<FangJiSubEntity> subList = fangJiSubEntity.getFangJiDetailSubList();
            if (subList != null && subList.size() > 0) {
                for (FangJiSubEntity fjse : subList) {
                    BigDecimal remainamount = checkItemService.selectByPrimaryKey(Integer.parseInt(fjse.getDrugCode())).getRemainamount(); //剩余库存
                    BigDecimal quanitity = new BigDecimal(fjse.getQuanitity()); //数量
                    if (remainamount.compareTo(quanitity) == -1){ //库存小于数量
                        logger.debug(fjse.getDrugName()+"库存不足!剩余库存是："+remainamount);
                        return ResultFactory.create("1",fjse.getDrugName()+"库存不足!",remainamount);
                    }
                    totalmoney += fjse.getWholeMoney();
                    sysFinancialDetail.setDetailitemcode(fjse.getDrugCode());
                    sysFinancialDetail.setDetailitemname(fjse.getDrugName());
                    sysFinancialDetail.setQuantity(new BigDecimal(Double.toString(fjse.getQuanitity())));
                    sysFinancialDetail.setUnitprice(new BigDecimal(Double.toString(fjse.getLPrice())));
                    sysFinancialDetail.setPayitemcode("(๑¯ ³ ¯๑)");
                    int insFinDet = xiYaoChuFangService.insertFinDet(sysFinancialDetail);
                    System.out.println(insFinDet+"西药处方--财务子表添加!");
                    sysPharmacy.setDrugcode(fjse.getDrugCode());
                    sysPharmacy.setDrugname(fjse.getDrugName());
                    sysPharmacy.setQuantity(fjse.getQuanitity());
                    int insPha = xiYaoChuFangService.insertPha(sysPharmacy);
                    System.out.println(insPha+"西药处方--药房表添加");

                    DrugCodeValue += fjse.getDrugCode() + ",";
                    ConsumptionValue += (fjse.getDrugCode() + "|" + fjse.getConsumption()) + ",";
                    DrugWayCodeValue += (fjse.getDrugCode() + "|" + fjse.getDrugWayCode()) + ",";
                    FrequencyCodeValue += (fjse.getDrugCode() + "|" + fjse.getFrequencyCode()) + ",";
                    UseDaysValue += (fjse.getDrugCode() + "|" + fjse.getUseDays()) + ",";
                    TotalAmountValue += (fjse.getDrugCode() + "|" + fjse.getTotalAmount()) + ",";
                    QuanitityValue += (fjse.getDrugCode() + "|" + fjse.getQuanitity()) + ",";
                    LPriceValue += (fjse.getDrugCode() + "|" + fjse.getLPrice()) + ",";
                    WholeMoneyValue += (fjse.getDrugCode() + "|" + fjse.getWholeMoney()) + ",";
                }
            }

            FangJiSubEntity _FangJiDetailSubEntity = new FangJiSubEntity();
            _FangJiDetailSubEntity.setDrugCodeValue(DrugCodeValue.length() > 0 ? DrugCodeValue.substring(0, DrugCodeValue.length() - 1) : "");
            _FangJiDetailSubEntity.setConsumptionValue(ConsumptionValue.length() > 0 ? ConsumptionValue.substring(0, ConsumptionValue.length() - 1) : "");
            _FangJiDetailSubEntity.setDrugWayCodeValue(DrugWayCodeValue.length() > 0 ? DrugWayCodeValue.substring(0, DrugWayCodeValue.length() - 1) : "");
            _FangJiDetailSubEntity.setFrequencyCodeValue(FrequencyCodeValue.length() > 0 ? FrequencyCodeValue.substring(0, FrequencyCodeValue.length() - 1) : "");
            _FangJiDetailSubEntity.setUseDaysValue(UseDaysValue.length() > 0 ? UseDaysValue.substring(0, UseDaysValue.length() - 1) : "");
            _FangJiDetailSubEntity.setTotalAmountValue(TotalAmountValue.length() > 0 ? TotalAmountValue.substring(0, TotalAmountValue.length() - 1) : "");
            _FangJiDetailSubEntity.setQuanitityValue(QuanitityValue.length() > 0 ? QuanitityValue.substring(0, QuanitityValue.length() - 1) : "");
            _FangJiDetailSubEntity.setLPriceValue(LPriceValue.length() > 0 ? LPriceValue.substring(0, LPriceValue.length() - 1) : "");
            _FangJiDetailSubEntity.setWholeMoneyValue(WholeMoneyValue.length() > 0 ? WholeMoneyValue.substring(0, WholeMoneyValue.length() - 1) : "");
            _FangJiDetailSubEntity.setEmpBasicMainID(fangJiSubEntity.getEmpBasicMainID());
            _FangJiDetailSubEntity.setFangJiSubID(fangJiSubEntity.getFangJiSubID());
            _FangJiDetailSubEntity.setFangJiSubCode(fangJiSubEntity.getFangJiSubCode());

            if ("0".equals(fangJiSubEntity.getOperaType())) {
                insertFangJiSub = xiYaoChuFangService.saveWesternDrugFangji(fangJiSubEntity);
                xiYaoChuFangService.saveWesternDrugFangji_SP(_FangJiDetailSubEntity);
                isSuc = true;
            } else {
                xiYaoChuFangService.updateWesternDrugFangji(_FangJiDetailSubEntity);
                isSuc = true;
                insertFangJiSub=true;
            }
        }
        sysFinancial.setTotalmoney(new BigDecimal(Double.toString(totalmoney)));
        int insFin = xiYaoChuFangService.insertFin(sysFinancial);
        System.out.println(insFin+"西药处方--财务主表添加");

        if (insertFangJiSub && isSuc) {
            return ResultFactory.create("1", "保存成功", null);
        }
        return ResultFactory.create("0", "保存失败", null);
    }


    /**
     * 删除西医处方
     *
     * @return 成功
     */
    @ApiComment("删除西医处方")
    @RequestMapping(value = "/deleteWesternDrugFangji", method = RequestMethod.POST)
    @ResponseBody
    public Result deleteWesternDrugFangji(@RequestParam("empBasicMainID") String empBasicMainID,@RequestParam("fangJiSubID") String fangJiSubID) {
        FangJiSubEntity fangJiSubEntity=new FangJiSubEntity();
        fangJiSubEntity.setEmpBasicMainID(empBasicMainID);
        fangJiSubEntity.setFangJiSubID(fangJiSubID);
        boolean issuc = xiYaoChuFangService.deleteWesternDrugFangji(fangJiSubEntity);
        if (issuc) {
            return ResultFactory.create("1", "删除成功", null);
        }
        return ResultFactory.create("0", "删除失败", null);
    }


}
