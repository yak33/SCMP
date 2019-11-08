package com.yyk.sz.zhzy.jcsjxt.web;

import com.terran4j.commons.api2doc.annotations.Api2Doc;
import com.terran4j.commons.api2doc.annotations.ApiComment;
import com.yyk.sz.common.base.domain.Paging;
import com.yyk.sz.common.base.result.Result;
import com.yyk.sz.common.base.result.ResultFactory;
import com.yyk.sz.common.base.utils.UtilUuid;
import com.yyk.sz.zhzy.jcsjxt.entity.GetBillCodeRst;
import com.yyk.sz.zhzy.jcsjxt.entity.JCSJPrescriptionMain;
import com.yyk.sz.zhzy.jcsjxt.entity.JCSJPrescriptionSub;
import com.yyk.sz.zhzy.jcsjxt.service.JCSJPrescriptionMainService;
import com.yyk.sz.zhzy.jcsjxt.utils.UtilString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * 基础数据-中药(针灸)处方设置 Controller
 */
@Api2Doc(id = "jcsjxt.zycfsz", name = "基础数据-中药(针灸)处方设置")
@ApiComment(seeClass = JCSJPrescriptionMain.class)
@RestController
@RequestMapping(value = "/jcsjxt/zycfsz/")
public class JCSJPrescriptionMainController {

    @Autowired
    private JCSJPrescriptionMainService prescriptionMainService;

    /**
     * 获取中药处方设置
     *
     * @return 中药处方设置列表
     */
    @ApiComment(" 获取中药处方")
    @RequestMapping(value = "/getPrescriptionMainTable", method = RequestMethod.POST)
    @ResponseBody
    public Result getPrescriptionMainTable(
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
        Paging<JCSJPrescriptionMain> prescriptionMains = prescriptionMainService.getPrescriptionMainTable(pageNumber, pageSize, searchText, sortName, sortOrder);
        if (prescriptionMains == null || prescriptionMains.getSize() == 0) {
            return ResultFactory.create("1", "没有中药处方数据", null);
        }
        return ResultFactory.create("0", null, prescriptionMains);
    }

    /**
     * 获取针灸处方设置
     *
     * @return 针灸处方列表
     */
    @ApiComment(" 获取针灸处方")
    @RequestMapping(value = "/getPrescriptionZJTable", method = RequestMethod.POST)
    @ResponseBody
    public Result getPrescriptionZJTable(
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
        Paging<JCSJPrescriptionMain> prescriptionMains = prescriptionMainService.getPrescriptionZJTable(pageNumber, pageSize, searchText, sortName, sortOrder);
        if (prescriptionMains == null || prescriptionMains.getSize() == 0) {
            return ResultFactory.create("1", "没有针灸处方数据", null);
        }
        return ResultFactory.create("0", null, prescriptionMains);
    }

    /**
     * 新增中药处方设置
     *
     * @return
     */
    @ApiComment(" 新增中药处方设置 DrugFlag 0中药方剂 1 针灸方剂 2西医")
    @RequestMapping(value = "/insertPrescriptionMain", method = RequestMethod.POST)
    @ResponseBody
    public Result insertPrescriptionMain(
            @RequestBody JCSJPrescriptionMain jcsjPrescriptionMain
    ) {
        if (prescriptionMainService.checkPrescriptionMainExits(null, jcsjPrescriptionMain.getPrescriptionname()).size() > 0) {
            return ResultFactory.create("1", "中药处方名称： " + jcsjPrescriptionMain.getPrescriptionname() + " 已经存在，不能重复添加！", null);
        }
        String proUUID = UtilUuid.uuid();
        getBillCode("1003",proUUID);
        GetBillCodeRst rst=prescriptionMainService.getBillCodeRst(proUUID).get(0);
        jcsjPrescriptionMain.setPrescriptioncode(rst.getGetBillId());
        if (prescriptionMainService.checkPrescriptionMainExits(jcsjPrescriptionMain.getPrescriptioncode(), null).size() > 0) {
            return ResultFactory.create("1", "中药处方编码： " + jcsjPrescriptionMain.getPrescriptioncode() + " 已经存在，不能重复添加！", null);
        }
        int flag = prescriptionMainService.insertPrescriptionMain(jcsjPrescriptionMain);
        if (jcsjPrescriptionMain.getJcsjPrescriptionSubList().size() > 0) {
            for (JCSJPrescriptionSub prescriptionSub : jcsjPrescriptionMain.getJcsjPrescriptionSubList()) {
                flag += prescriptionMainService.insertPrescriptionSub(prescriptionSub);
            }
        }
        if (flag > 0) {
            return ResultFactory.create("0", "保存成功", null);
        }
        return ResultFactory.create("1", "保存失败", null);
    }

    /**
     * 新增针灸处方设置
     *
     * @return
     */
    @ApiComment(" 新增针灸处方设置 PCCode：处方分类 002-针灸处方;DrugCode 穴位编码 逗号隔开")
    @RequestMapping(value = "/insertPrescriptionZJ", method = RequestMethod.POST)
    @ResponseBody
    public Result insertPrescriptionZJ(
            @RequestBody JCSJPrescriptionMain jcsjPrescriptionMain
    ) {
        if (prescriptionMainService.checkPrescriptionMainExits(null, jcsjPrescriptionMain.getPrescriptionname()).size() > 0) {
            return ResultFactory.create("1", "针灸处方名称： " + jcsjPrescriptionMain.getPrescriptionname() + " 已经存在，不能重复添加！", null);
        }
        String proUUID = UtilUuid.uuid();
        getBillCode("1003",proUUID);
        GetBillCodeRst rst=prescriptionMainService.getBillCodeRst(proUUID).get(0);
        jcsjPrescriptionMain.setPrescriptioncode(rst.getGetBillId());
        jcsjPrescriptionMain.setPccode("002");
        if (prescriptionMainService.checkPrescriptionMainExits(jcsjPrescriptionMain.getPrescriptioncode(), null).size() > 0) {
            return ResultFactory.create("1", "针灸处方编码： " + jcsjPrescriptionMain.getPrescriptioncode() + " 已经存在，不能重复添加！", null);
        }
        int flag = prescriptionMainService.insertPrescriptionMain(jcsjPrescriptionMain);
        if (jcsjPrescriptionMain.getJcsjPrescriptionSubList().size() > 0) {
            for (JCSJPrescriptionSub prescriptionSub : jcsjPrescriptionMain.getJcsjPrescriptionSubList()) {
                flag += prescriptionMainService.insertPrescriptionSub(prescriptionSub);
            }
        }
        if (flag > 0) {
            return ResultFactory.create("0", "保存成功", null);
        }
        return ResultFactory.create("1", "保存失败", null);
    }

    /**
     * 修改中药(针灸)处方设置
     *
     * @return
     */
    @ApiComment(" 修改中药(针灸)处方设置 prescriptionname2 新的;DrugFlag 0中药方剂 1 针灸方剂 ")
    @RequestMapping(value = "/updatePrescriptionMain", method = RequestMethod.POST)
    @ResponseBody
    public Result updatePrescriptionMain(
            @RequestBody JCSJPrescriptionMain jcsjPrescriptionMain
    ) {
        if (!jcsjPrescriptionMain.getPrescriptionname().equals(jcsjPrescriptionMain.getPrescriptionname2())) {
            if (prescriptionMainService.checkPrescriptionMainExits(null, jcsjPrescriptionMain.getPrescriptionname2()).size() > 0) {
                return ResultFactory.create("1", "中药(针灸)处方名称： " + jcsjPrescriptionMain.getPrescriptionname2() + " 已经存在，不能修改！", null);
            }
        }
        int flag = prescriptionMainService.updatePrescriptionMain(jcsjPrescriptionMain);
        flag += prescriptionMainService.deletePrescriptionSub(jcsjPrescriptionMain.getPrescriptioncode());
        if (jcsjPrescriptionMain.getJcsjPrescriptionSubList().size() > 0) {
            for (JCSJPrescriptionSub prescriptionSub : jcsjPrescriptionMain.getJcsjPrescriptionSubList()) {
                flag += prescriptionMainService.insertPrescriptionSub(prescriptionSub);
            }
        }
        if (flag > 0) {
            return ResultFactory.create("0", "保存成功", null);
        }
        return ResultFactory.create("1", "保存失败", null);
    }

    /**
     * 删除中药处方设置
     *
     * @return
     */
    @ApiComment(" 删除中药处方设置")
    @RequestMapping(value = "/deletePrescriptionMain", method = RequestMethod.POST)
    @ResponseBody
    public Result deletePrescriptionMain(
            @RequestParam("prescriptioncode") String prescriptioncode
    ) {
        if (prescriptionMainService.GetCMedicinePrescription(prescriptioncode).size() > 0) {
            return ResultFactory.create("1", prescriptioncode + "  中医病名中用到了该方剂，不能删除！", null);
        }
        int flag = prescriptionMainService.deletePrescriptionMain(prescriptioncode);
        flag += prescriptionMainService.deletePrescriptionSub(prescriptioncode);
        if (flag > 0) {
            return ResultFactory.create("0", "删除成功", null);
        }
        return ResultFactory.create("1", "删除失败", null);
    }

    /**
     * 删除针灸处方设置
     *
     * @return
     */
    @ApiComment(" 删除针灸处方设置")
    @RequestMapping(value = "/deletePrescriptionZJ", method = RequestMethod.POST)
    @ResponseBody
    public Result deletePrescriptionZJ(
            @RequestParam("prescriptioncode") String prescriptioncode
    ) {
        //验证针灸方剂是否已被应用
        if (prescriptionMainService.CheckZJPreIsUsedOrNot(prescriptioncode).size() > 0) {
            return ResultFactory.create("1", prescriptioncode + "  该方剂已被应用,不能删除", null);
        }
        int flag = prescriptionMainService.deletePrescriptionMain(prescriptioncode);
        flag += prescriptionMainService.deletePrescriptionSub(prescriptioncode);
        if (flag > 0) {
            return ResultFactory.create("0", "删除成功", null);
        }
        return ResultFactory.create("1", "删除失败", null);
    }

    /**
     * 获取指定的方剂及方剂中的草药信息
     *
     * @return 获取指定的方剂及方剂中的草药信息
     */
    @ApiComment(" 获取指定的方剂及方剂中的草药信息")
    @RequestMapping(value = "/GetPrescriptionMedicine", method = RequestMethod.POST)
    @ResponseBody
    public Result GetPrescriptionMedicine(
            @RequestParam("prescriptioncode") String prescriptioncode
    ) {
        List<JCSJPrescriptionMain> prescriptionMains = prescriptionMainService.GetPrescriptionMedicine(prescriptioncode);
        if (prescriptionMains != null && prescriptionMains.size() > 0) {
            prescriptionMains.get(0).setJcsjPrescriptionSubList(prescriptionMainService.GetPrescriptionMedicineSub(prescriptioncode));
            return ResultFactory.create("0", null, prescriptionMains.get(0));
        }
        return ResultFactory.create("1", "没有数据", null);
    }

    /**
     * 获取最大方剂编码
     *
     * @return 获取最大方剂编码
     */
    @ApiComment(" 获取最大方剂编码")
    @RequestMapping(value = "/GetMaxPrescriptionCode", method = RequestMethod.POST)
    @ResponseBody
    public Result GetMaxPrescriptionCode(
    ) {
        List<JCSJPrescriptionMain> prescriptionMains = prescriptionMainService.GetMaxPrescriptionCode();
        return ResultFactory.create("0", null, prescriptionMains.get(0));
    }

    public void getBillCode(String billCode,String uuid) {
        JCSJPrescriptionMain patientInfo = new JCSJPrescriptionMain();
        Date currentTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String dateString = formatter.format(currentTime);
        patientInfo.setBillCode(billCode);
        patientInfo.setDateString(dateString);
        patientInfo.setItemCode("");
        patientInfo.setOption(1);
        patientInfo.setVoucherCode("");
        patientInfo.setProUUID(uuid);
        prescriptionMainService.getBillCode(patientInfo);
    }
}
