package com.yyk.sz.zhzy.lzxt.cjyf.web;

import com.terran4j.commons.api2doc.annotations.Api2Doc;
import com.terran4j.commons.api2doc.annotations.ApiComment;
import com.yyk.sz.common.base.result.Result;
import com.yyk.sz.common.base.result.ResultFactory;
import com.yyk.sz.zhzy.lzxt.cjyf.entity.ClassifyVO;
import com.yyk.sz.zhzy.lzxt.cjyf.entity.PrescriptionMain;
import com.yyk.sz.zhzy.lzxt.cjyf.entity.SufferTypeVO;
import com.yyk.sz.zhzy.lzxt.cjyf.service.PrescriptionMainService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Api2Doc(id = "lzxt.cjyf", name = "存经验方接口")
@ApiComment(seeClass = PrescriptionMain.class)
@RestController
@RequestMapping(value = "/lzxt/cjyf")
public class PrescriptionController {

    @Resource
    private PrescriptionMainService prescriptionMainService;


    /**
     * index，测试用
     */
    @Api2Doc(order = 10)
    @RequestMapping(name= "测试用",value = "/index", method = RequestMethod.GET)
    public Result index() {
        return ResultFactory.create("0","临症系统-存经验方测试访问成功。",null);
    }

    /**
     * 保存经验方
     * @param prescriptionMain
     * @return
     */
    @Api2Doc(order = 20)
    @ApiComment("保存方剂表的数据")
    @RequestMapping(name = "保存方剂表", value = "/savePrescriptionMain", method = RequestMethod.POST)
    @ResponseBody
    public Result savePrescriptionMain(@RequestBody PrescriptionMain prescriptionMain){
        //先删除旧的
        int delsub = prescriptionMainService.delPrescriptionSubZJ(prescriptionMain);
        int del = prescriptionMainService.delPrescriptionZJ(prescriptionMain);
        System.out.println(delsub+";"+del);
        //接收到的草药集合list
        List<PrescriptionMain> subList = prescriptionMain.getSubList();

        //1.插入方剂表，主表
        int insertMain = prescriptionMainService.insertMain(prescriptionMain);

        //判断重复
//        List<PrescriptionMain> list = prescriptionMainService.getWantCode(prescriptionMain);
//        if (list != null && list.size() > 0){
//            return ResultFactory.create("3","此用户下已经有此经验方!",0);
//        }
        //获取主表的code，以插入子表
        String pCode = prescriptionMainService.getWantCode(prescriptionMain).get(0).getPrescriptionCode();
        /*********测试START***********/
//        PrescriptionSub ps = new PrescriptionSub();
//        ps.setPrescriptionCode("15000");
//        ps.setDrugCode(12350);
//        ps.setPrescriptionSubID(222);
//        ps.setQuanitity(6);
//        ps.setSufferTypeCode("");
//        ps.setJFlag(true);
//        ps.setCFlag(true);
//        ps.setZFlag(true);
//        ps.setSFlag(true);
//        ps.setRemark("nima");
//        PrescriptionSub ps1 = new PrescriptionSub();
//        ps1.setPrescriptionCode("15000");
//        ps1.setDrugCode(13350);
//        ps1.setPrescriptionSubID(999);
//        ps1.setQuanitity(7);
//        ps1.setSufferTypeCode("");
//        ps1.setJFlag(false);
//        ps1.setCFlag(false);
//        ps1.setZFlag(false);
//        ps1.setSFlag(false);
//        ps1.setRemark("司法所发生");
//        PrescriptionSub ps2 = new PrescriptionSub();
//        ps2.setPrescriptionCode("15000");
//        ps2.setDrugCode(15350);
//        ps2.setPrescriptionSubID(666);
//        ps2.setQuanitity(8);
//        ps2.setSufferTypeCode("");
//        ps2.setJFlag(true);
//        ps2.setCFlag(true);
//        ps2.setZFlag(true);
//        ps2.setSFlag(true);
//        ps2.setRemark("dcxvczx");
//        prescriptionSubList.add(ps);
//        prescriptionSubList.add(ps1);
//        prescriptionSubList.add(ps2);
        /**********END**********/
        //2.循环list，插入方剂的草药子表
        boolean flag = false;
        if (subList != null && subList.size() > 0){
            for (int i=0; i < subList.size(); i++){
                subList.get(i).setPrescriptionCode(pCode);
                prescriptionMainService.insertSub(subList.get(i));
            }
            flag = true;
        }
        if(insertMain > 0 && flag){
            return ResultFactory.create("0","保存成功",1);
        }else {
            return ResultFactory.create("1",null,0);
        }

    }

    /**
     * 获取处方分类
     * @return
     */
    @ApiComment("获取处方分类")
    @RequestMapping(value = "/getClassify", method = RequestMethod.POST)
    public Result getClassify(){
        List<PrescriptionMain> list = prescriptionMainService.getClassify();
        List<ClassifyVO> voList = new ArrayList<ClassifyVO>();
        if (list != null && list.size() > 0){
            for (PrescriptionMain pm : list){
                ClassifyVO cvo = new ClassifyVO();
                cvo.setpCCode(pm.getpCCode());
                cvo.setpCName(pm.getpCName());
                cvo.setPinYinCode(pm.getPinYinCode());
                voList.add(cvo);
            }
            return ResultFactory.create("1","获取成功",voList);
        }
        return ResultFactory.create("0",null,"0");
    }

    /**
     * 获取煎熬方法
     * @return
     */
    @ApiComment("获取煎熬方法")
    @RequestMapping(value = "/getSufferType", method = RequestMethod.POST)
    public Result getSufferType(){
        List<PrescriptionMain> list = prescriptionMainService.getSufferType();
        List<SufferTypeVO> voList = new ArrayList<SufferTypeVO>();
        if (list != null && list.size() > 0){
            for (PrescriptionMain pm : list){
                SufferTypeVO stvo = new SufferTypeVO();
                stvo.setSufferTypeCode(pm.getSufferTypeCode());
                stvo.setSufferTypeName(pm.getSufferTypeName());
                stvo.setHisCode(pm.getHisCode());
                voList.add(stvo);
            }
            return ResultFactory.create("1","获取成功",voList);
        }
        return ResultFactory.create("0",null,"0");
    }

}
