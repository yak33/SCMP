package com.yyk.sz.zhzy.zjxt.lczl.web;

import com.terran4j.commons.api2doc.annotations.Api2Doc;
import com.terran4j.commons.api2doc.annotations.ApiComment;
import com.yyk.sz.common.base.result.Result;
import com.yyk.sz.common.base.result.ResultFactory;
import com.yyk.sz.common.base.utils.UtilUuid;
import com.yyk.sz.zhzy.lzxt.jyjc.entity.SysFinancial;
import com.yyk.sz.zhzy.lzxt.jyjc.entity.SysFinancialDetail;
import com.yyk.sz.zhzy.zjxt.lczl.entity.FangJiZJCodeRst;
import com.yyk.sz.zhzy.zjxt.lczl.entity.SFangJiCode;
import com.yyk.sz.zhzy.zjxt.lczl.entity.WesternCure;
import com.yyk.sz.zhzy.zjxt.lczl.service.SFangJiCodeService;
import com.yyk.sz.zhzy.zjxt.lczl.service.WesternCureService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * 针灸系统--临床治疗--临证
 */
@Api2Doc(id = "zjxt.lczl", name = "针灸-临床治疗-临证")
@ApiComment(seeClass = WesternCure.class)
@RestController
@RequestMapping("/zjxt/lczl")
public class WesternCureController {

    @Resource
    private WesternCureService westernCureService;
    @Resource
    private SFangJiCodeService sFangJiCodeService;

    /**
     * 获取患者已存的临床治疗
     *
     * @return
     */
    @ApiComment("获取患者已存的临床治疗")
    @RequestMapping(value = "/getYiCunMedicareCure", method = RequestMethod.POST)
    @ResponseBody
    public Result getYiCunMedicareCure(@RequestParam("empBasicMainID") Integer empBasicMainID) {
        List<WesternCure> getYiCunList = westernCureService.getYiCunMedicareCure(empBasicMainID);
        if (getYiCunList != null && getYiCunList.size() > 0) {
            return ResultFactory.create("0", null, getYiCunList);
        }
        return ResultFactory.create("1", "没有信息", null);
    }

    /**
     * 获取所有临床治疗
     *
     * @return
     */
    @ApiComment("获取所有临床治疗")
    @RequestMapping(value = "/getWesternCureList", method = RequestMethod.POST)
    @ResponseBody
    public Result getWesternCureList(@RequestParam(value = "searchText",required = false) String searchText) {
        List<WesternCure> westernCureList = westernCureService.getWesternCureList(searchText);
        if (westernCureList != null && westernCureList.size() > 0) {
            return ResultFactory.create("0", null, westernCureList);
        }
        return ResultFactory.create("1", "没有信息", null);
    }

    /**
     * 选中的临床治疗明细--根据明细code
     *
     * @return
     */
    @ApiComment("选中的临床治疗明细--根据明细code")
    @RequestMapping(value = "/getWesternCureDetailList", method = RequestMethod.POST)
    @ResponseBody
    public Result getWesternCureDetailList(
            @RequestParam("detailItemCode") String detailItemCode) {
        List<WesternCure> westernCureDetailList = westernCureService.getWesternCureDetailList(detailItemCode);
        if (westernCureDetailList != null && westernCureDetailList.size() > 0) {
            return ResultFactory.create("0", null, westernCureDetailList);
        }
        return ResultFactory.create("1", "没有信息", null);
    }

    /**
     * 保存临床治疗
     *
     * @return
     */
    @ApiComment("保存临床治疗")
    @RequestMapping(value = "/saveWesternCure", method = RequestMethod.POST)
    @ResponseBody
    public Result saveWesternCure(@RequestBody List<WesternCure> westernCures) {
        //先删除两个表数据
        westernCureService.delFangJiDetailSub(westernCures.get(0).getEmpBasicMainID());
        westernCureService.delFangJiSub(westernCures.get(0).getEmpBasicMainID());
        // 财务相关
        // 先清一遍主表和子表，根据病人id和项目类型。--4
        SysFinancial sysFinancial = new SysFinancial();
        SysFinancialDetail sysFinancialDetail = new SysFinancialDetail();
        sysFinancial.setEmpbasicmainid(westernCures.get(0).getEmpBasicMainID());
        sysFinancial.setPayitem(4); //临证治疗
        westernCureService.delFinancial(sysFinancial); //删除主表此人临证治疗..
        sysFinancialDetail.setEmpbasicmainid(westernCures.get(0).getEmpBasicMainID());
        sysFinancialDetail.setPayitem(4);
        westernCureService.delFinancialDetail(sysFinancialDetail); //删除子表此人临证治疗明细..
        sysFinancial.setPayitemcode("(๑¯ ³ ¯๑)");
        sysFinancial.setPaytype(60); //默认不报销
        sysFinancial.setPaystatus(0); //默认未缴费
        double totalmoney = 0;
        //循环遍历取出多个处治;
        int insertFangJiSub = 0;
        boolean flag = false;
        for (int i = 0; i < westernCures.size(); i++) {
            WesternCure westernCure = westernCures.get(i);
            SFangJiCode sFangJiCode = new SFangJiCode();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String dateString = sdf.format(new Date());
            String proUUID = UtilUuid.uuid();
            sFangJiCode.setProUUID(proUUID);
            sFangJiCode.setBillCode("1003");
            sFangJiCode.setDateString(dateString);
            sFangJiCode.setItemCode("");
            sFangJiCode.setOption(1);
            sFangJiCode.setVoucherCode("");
            sFangJiCodeService.GetFangJiCode(sFangJiCode);
            FangJiZJCodeRst fangJiZJCodeRst= sFangJiCodeService.GetFangJiZJCodeRst(proUUID).get(0);
            String fangJiSubCode = fangJiZJCodeRst.getGetBillId() + "";
            westernCure.setFangJiSubCode(fangJiSubCode); //方剂编码
            westernCure.setFangJiSubName("处治" + (i + 1));
            //插入CM_FangJiSub表数据
            insertFangJiSub = westernCureService.saveWesternCure(westernCure);

            //取出此处治下的项目明细集合list
            List<WesternCure> getDetailList = westernCure.getGetDetailList();
            if (getDetailList != null && getDetailList.size() > 0){
                WesternCure wc = new WesternCure();
                wc.setEmpBasicMainID(westernCure.getEmpBasicMainID());
                wc.setFangJiSubCode(fangJiSubCode);
                int fangJiSubId = westernCureService.getFangJiSubID(wc).getFangJiSubID();
                //循环遍历取出单个的项目明细
                for (WesternCure wcc : getDetailList){
                    wcc.setFangJiSubID(fangJiSubId);
                    totalmoney += wcc.getPrice();
                    int insertDetailSub = westernCureService.saveWesternCureFangjiDetail(wcc);
                    sysFinancialDetail.setDetailitemcode(wcc.getDetailItemCode());
                    sysFinancialDetail.setDetailitemname(westernCureService.getDetailItemName(wcc.getDetailItemCode()));
                    sysFinancialDetail.setQuantity(new BigDecimal(1));
                    sysFinancialDetail.setUnitprice(new BigDecimal(Double.toString(wcc.getPrice())));
                    sysFinancialDetail.setPayitemcode("(๑¯ ³ ¯๑)");
                    int insFinDet = westernCureService.insertFinDet(sysFinancialDetail);
                    System.out.println(insFinDet+"临证治疗--财务子表添加!");
                    if (insertDetailSub > 0){
                        flag = true;
                    }
                }
            }
        }
        sysFinancial.setTotalmoney(new BigDecimal(Double.toString(totalmoney)));
        int insFin = westernCureService.insertFin(sysFinancial);
        System.out.println(insFin+"临证治疗--财务主表添加");
        if (insertFangJiSub > 0 && flag){
            return ResultFactory.create("0","保存成功!",1);
        }
        return ResultFactory.create("1", "添加失败!", null);
    }


}
