package com.yyk.sz.zhzy.jcsjxt.web;

import com.terran4j.commons.api2doc.annotations.Api2Doc;
import com.terran4j.commons.api2doc.annotations.ApiComment;
import com.yyk.sz.common.base.domain.Paging;
import com.yyk.sz.common.base.result.Result;
import com.yyk.sz.common.base.result.ResultFactory;
import com.yyk.sz.common.base.utils.UtilUuid;
import com.yyk.sz.zhzy.jcsjxt.entity.*;
import com.yyk.sz.zhzy.jcsjxt.service.JCSJDrugDictService;
import com.yyk.sz.zhzy.jcsjxt.utils.UtilString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * 基础数据-药品(穴位)字典 Controller
 */
@Api2Doc(id = "jcsjxt.ypzd", name = "基础数据-药品(穴位)字典")
@ApiComment(seeClass = JCSJDrugDict.class)
@RestController
@RequestMapping(value = "/jcsjxt/ypzd/")
public class JCSJDrugDictController {

    @Autowired
    private JCSJDrugDictService drugDictService;

    /**
     * 获取西药信息
     *
     * @return 西药信息列表
     */
    @ApiComment(" 获取西药信息")
    @RequestMapping(value = "/getWesternDistionaryTable", method = RequestMethod.POST)
    @ResponseBody
    public Result getWesternDistionaryTable(
            @RequestParam(value = "pageNumber", required = false, defaultValue = "1") int pageNumber,
            @RequestParam(value = "pageSize", required = false, defaultValue = "10") int pageSize,
            @RequestParam(value = "searchText", required = false) String searchText,
            @RequestParam(value = "sortName", required = false) String sortName,
            @RequestParam(value = "sortOrder", required = false, defaultValue = "desc") String sortOrder
    ) {
        searchText=UtilString.judgeNull(searchText);
        if(searchText!=null) {
            searchText = "%" + searchText + "%";
        }
        Paging<JCSJDrugDict> drugDicts = drugDictService.getWesternDistionaryTable(pageNumber, pageSize, searchText, sortName, sortOrder);
        if (drugDicts == null || drugDicts.getSize() == 0) {
            return ResultFactory.create("1", "没有西药数据", null);
        }
        return ResultFactory.create("0", null, drugDicts);
    }

    /**
     * 获取中药信息
     *
     * @return 药信息列表
     */
    @ApiComment(" 获取中药信息")
    @RequestMapping(value = "/getDrugDictDistionaryTable", method = RequestMethod.POST)
    @ResponseBody
    public Result getDrugDictDistionaryTable(
            @RequestParam(value = "pageNumber", required = false, defaultValue = "1") int pageNumber,
            @RequestParam(value = "pageSize", required = false, defaultValue = "10") int pageSize,
            @RequestParam(value = "searchText", required = false) String searchText,
            @RequestParam(value = "sortName", required = false) String sortName,
            @RequestParam(value = "sortOrder", required = false, defaultValue = "desc") String sortOrder
    ) {
        searchText=UtilString.judgeNull(searchText);
        if(searchText!=null) {
            searchText = "%" + searchText + "%";
        }
        Paging<JCSJDrugDict> drugDicts = drugDictService.getDrugDictDistionaryTable(pageNumber, pageSize, searchText, sortName, sortOrder);
        if (drugDicts == null || drugDicts.getSize() == 0) {
            return ResultFactory.create("1", "没有中药数据", null);
        }
        return ResultFactory.create("0", null, drugDicts);
    }

    /**
     * 获取穴位信息
     *
     * @return 穴位信息列表
     */
    @ApiComment(" 获取穴位信息")
    @RequestMapping(value = "/getAcupointZJTable", method = RequestMethod.POST)
    @ResponseBody
    public Result getAcupointZJTable(
            @RequestParam(value = "pageNumber", required = false, defaultValue = "1") int pageNumber,
            @RequestParam(value = "pageSize", required = false, defaultValue = "10") int pageSize,
            @RequestParam(value = "searchText", required = false) String searchText,
            @RequestParam(value = "sortName", required = false) String sortName,
            @RequestParam(value = "sortOrder", required = false, defaultValue = "desc") String sortOrder
    ) {
        searchText=UtilString.judgeNull(searchText);
        if(searchText!=null) {
            searchText = "%" + searchText + "%";
        }
        Paging<JCSJDrugDict> drugDicts = drugDictService.getAcupointZJTable(pageNumber, pageSize, searchText, sortName, sortOrder);
        if (drugDicts == null || drugDicts.getSize() == 0) {
            return ResultFactory.create("1", "没有穴位数据", null);
        }
        return ResultFactory.create("0", null, drugDicts);
    }
    /**
     * 新增药品信息
     *
     * @return
     */
    @ApiComment(" 新增药品信息 DrugFlag 0 中药  DrugFlag 1 穴位  DrugFlag 2  西药")
    @RequestMapping(value = "/insertWesternDistionary", method = RequestMethod.POST)
    @ResponseBody
    public Result insertWesternDistionary(
            @RequestBody JCSJDrugDict jcsjDrugDict
    ) {
        if (drugDictService.GetDrugInfoByDrugName(jcsjDrugDict.getDrugname()).size() > 0)
        {
            return ResultFactory.create("1", "药品名称为： " + jcsjDrugDict.getDrugname() + " 的药品(穴位)已经存在，不能重复添加！", null);
        }
        JCSJDictCodeRst billInfo=getBillCode("1002");
        jcsjDrugDict.setDrugcode(Integer.parseInt(billInfo.getGetBillId()));
        int flag = drugDictService.insertWesternDistionary(jcsjDrugDict);
        if (flag > 0) {
            return ResultFactory.create("0", "保存成功", null);
        }
        return ResultFactory.create("1", "保存失败", null);
    }

    /**
     * 新增穴位信息
     *
     * @return
     */
    @ApiComment(" 新增穴位信息 DrugFlag 1 穴位; PType:1正面图 2侧面图 3背面图  MeridianCode:归经编码")
    @RequestMapping(value = "/insertAcupointZJ", method = RequestMethod.POST)
    @ResponseBody
    public Result insertAcupointZJ(
            @RequestBody JCSJDrugDict jcsjDrugDict
    ) {
        if (drugDictService.GetDrugInfoByDrugName(jcsjDrugDict.getDrugname()).size() > 0) {
            return ResultFactory.create("1", "穴位名称为： " + jcsjDrugDict.getDrugname() + " 的穴位已经存在，不能重复添加！", null);
        }
        JCSJDictCodeRst billInfo = getBillCode("1002");
        jcsjDrugDict.setDrugcode(Integer.parseInt(billInfo.getGetBillId()));
        int flag = drugDictService.insertWesternDistionary(jcsjDrugDict);
        //存储归经
        String[] meridiancode=null;
        if(jcsjDrugDict.getMeridiancode()!=null) {
            meridiancode = jcsjDrugDict.getMeridiancode().split(",");
        }
        if(meridiancode!=null) {
            for (int i = 0; i < meridiancode.length; i++) {
                flag += drugDictService.insertAcupointZJ(jcsjDrugDict.getDrugcode(),meridiancode[i]);
            }
        }
        if (flag > 0) {
            return ResultFactory.create("0", "保存成功", null);
        }
        return ResultFactory.create("1", "保存失败", null);
    }

    /**
     * 修改穴位信息
     *
     * @return
     */
    @ApiComment(" 修改穴位信息 drugname2 新的")
    @RequestMapping(value = "/updateAcupointZJ", method = RequestMethod.POST)
    @ResponseBody
    public Result updateAcupointZJ(
            @RequestBody JCSJDrugDict jcsjDrugDict
    ) {
        if(!jcsjDrugDict.getDrugname().equals(jcsjDrugDict.getDrugname2())){
            if (drugDictService.GetDrugInfoByDrugName(jcsjDrugDict.getDrugname2()).size() > 0)
            {
                return ResultFactory.create("1", "穴位名称为： " + jcsjDrugDict.getDrugname2() + " 的穴位已经存在，不能修改！", null);
            }
        }
        int flag = drugDictService.updateWesternDistionary(jcsjDrugDict);
        //归经先删除，再添加
        flag += drugDictService.deleteAcupointZJ(jcsjDrugDict.getDrugcode());
        String[] meridiancode=null;
        if(jcsjDrugDict.getMeridiancode()!=null) {
            meridiancode = jcsjDrugDict.getMeridiancode().split(",");
        }
        if(meridiancode!=null) {
            for (int i = 0; i < meridiancode.length; i++) {
                flag += drugDictService.insertAcupointZJ(jcsjDrugDict.getDrugcode(),meridiancode[i]);
            }
        }
        if (flag > 0) {
            return ResultFactory.create("0", "保存成功", null);
        }
        return ResultFactory.create("1", "保存失败", null);
    }

    /**
     * 修改西药信息
     *
     * @return
     */
    @ApiComment(" 修改药品信息 drugname2 新的")
    @RequestMapping(value = "/updateWesternDistionary", method = RequestMethod.POST)
    @ResponseBody
    public Result updateWesternDistionary(
            @RequestBody JCSJDrugDict jcsjDrugDict
    ) {
        if(!jcsjDrugDict.getDrugname().equals(jcsjDrugDict.getDrugname2())){
            if (drugDictService.GetDrugInfoByDrugName(jcsjDrugDict.getDrugname2()).size() > 0)
            {
                return ResultFactory.create("1", "药品名称为： " + jcsjDrugDict.getDrugname2() + " 的药品已经存在，不能修改！", null);
            }
        }
        int flag = drugDictService.updateWesternDistionary(jcsjDrugDict);
        if (flag > 0) {
            return ResultFactory.create("0", "保存成功", null);
        }
        return ResultFactory.create("1", "保存失败", null);
    }

    /**
     * 删除穴位信息
     *
     * @return
     */
    @ApiComment(" 删除穴位信息")
    @RequestMapping(value = "/deleteAcupointZJ", method = RequestMethod.POST)
    @ResponseBody
    public Result deleteAcupointZJ(
           @RequestParam("drugcode") Integer drugcode
    ) {
        //验证该穴位是否已被应用
        if (drugDictService.CheckZJAcuIsUsedOrNot(drugcode).size() > 0)
        {
            return ResultFactory.create("1", "该穴位已被应用，不能删除！", null);
        }
        if (drugDictService.CheckZJAcuIsUsedOrNotInPreSub(drugcode).size() > 0)
        {
            return ResultFactory.create("1", "该穴位已被应用，不能删除！", null);
        }
        int flag = drugDictService.deleteAcupointZJ(drugcode);
        flag += drugDictService.deleteWesternDistionary(drugcode);
        if (flag > 0) {
            return ResultFactory.create("0", "删除成功", null);
        }
        return ResultFactory.create("1", "删除失败", null);
    }

    /**
     * 删除西药信息
     *
     * @return
     */
    @ApiComment(" 删除西药信息")
    @RequestMapping(value = "/deleteWesternDistionary", method = RequestMethod.POST)
    @ResponseBody
    public Result deleteWesternDistionary(
            @RequestParam("drugcode") Integer drugcode
    ) {
        int flag = drugDictService.deleteWesternDistionary(drugcode);
        if (flag > 0) {
            return ResultFactory.create("0", "删除成功", null);
        }
        return ResultFactory.create("1", "删除失败", null);
    }

    /**
     * 删除中药信息
     *
     * @return
     */
    @ApiComment(" 删除中药信息")
    @RequestMapping(value = "/deleteDrugDictDistionary", method = RequestMethod.POST)
    @ResponseBody
    public Result deleteDrugDictDistionary(
            @RequestParam("drugcode") Integer drugcode
    ) {
        //判断方剂中是否用到该中药
        if (drugDictService.GetDrugInfoByPrescription(drugcode).size() > 0)
        {
            return ResultFactory.create("1", "方剂草药中用到了该药品，不能删除！", null);
        }
        //判断药品禁忌中是否用到该中药
        if (drugDictService.GetDrugInfoByDrugTaboos(drugcode).size() > 0)
        {
            return ResultFactory.create("1", "药品禁忌中用到了该药品，不能删除！", null);
        }
        //判断问诊方剂明细中是否用到该中药
        if (drugDictService.GetDrugInfoFromFangJiDetailSub(drugcode).size() > 0)
        {
            return ResultFactory.create("1", "问诊方剂中用到了该药品，不能删除！", null);
        }
        int flag = drugDictService.deleteWesternDistionary(drugcode);
        if (flag > 0) {
            return ResultFactory.create("0", "删除成功", null);
        }
        return ResultFactory.create("1", "删除失败", null);
    }

    /**
     * 获取药品剂型
     *
     * @return
     */
    @ApiComment(" 获取药品剂型")
    @RequestMapping(value = "/getDosage", method = RequestMethod.POST)
    @ResponseBody
    public Result getDosage(
    ) {
        List<JCSJDosage> jcsjDosageList = drugDictService.getDosage();
        if (jcsjDosageList == null || jcsjDosageList.size() == 0) {
            return ResultFactory.create("1", "没有药品剂型数据", null);
        }
        return ResultFactory.create("0", null, jcsjDosageList);
    }

    /**
     * 获取药品类别
     *
     * @return
     */
    @ApiComment(" 获取药品类别")
    @RequestMapping(value = "/getDrugModel", method = RequestMethod.POST)
    @ResponseBody
    public Result getDrugModel(
    ) {
        List<JCSJDrugModel> jcsjDrugModels = drugDictService.getDrugModel();
        if (jcsjDrugModels == null || jcsjDrugModels.size() == 0) {
            return ResultFactory.create("1", "没有药品类别数据", null);
        }
        return ResultFactory.create("0", null, jcsjDrugModels);
    }

    /**
     * 获取药品服法
     *
     * @return
     */
    @ApiComment(" 获取药品服法")
    @RequestMapping(value = "/getDrugWay", method = RequestMethod.POST)
    @ResponseBody
    public Result getDrugWay(
    ) {
        List<JCSJDrugWay> jcsjDrugWays = drugDictService.getDrugWay();
        if (jcsjDrugWays == null || jcsjDrugWays.size() == 0) {
            return ResultFactory.create("1", "没有药品服法数据", null);
        }
        return ResultFactory.create("0", null, jcsjDrugWays);
    }

    /**
     * 获取炮制
     *
     * @return
     */
    @ApiComment(" 获取炮制")
    @RequestMapping(value = "/getProcess", method = RequestMethod.POST)
    @ResponseBody
    public Result getProcess(
    ) {
        List<JCSJProcess> jcsjProcesses = drugDictService.getProcess();
        if (jcsjProcesses == null || jcsjProcesses.size() == 0) {
            return ResultFactory.create("1", "没有炮制数据", null);
        }
        return ResultFactory.create("0", null, jcsjProcesses);
    }


    public JCSJDictCodeRst getBillCode(String billCode) {
        JCSJDrugDict jcsjDrugDict = new JCSJDrugDict();
        Date currentTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String dateString = formatter.format(currentTime);
        String proUUID = UtilUuid.uuid();
        jcsjDrugDict.setProUUID(proUUID);
        jcsjDrugDict.setBillCode(billCode);
        jcsjDrugDict.setDateString(dateString);
        jcsjDrugDict.setItemCode("");
        jcsjDrugDict.setOption(1);
        jcsjDrugDict.setVoucherCode("");
        drugDictService.getBillCode(jcsjDrugDict);
        JCSJDictCodeRst jcsjDictCodeRst=drugDictService.GetDictCodeRst(proUUID).get(0);
        if( jcsjDictCodeRst == null){
            return null;
        }
        return jcsjDictCodeRst;
    }
}
