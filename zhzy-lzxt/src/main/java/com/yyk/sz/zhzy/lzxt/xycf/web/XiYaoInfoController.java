package com.yyk.sz.zhzy.lzxt.xycf.web;

import com.terran4j.commons.api2doc.annotations.Api2Doc;
import com.terran4j.commons.api2doc.annotations.ApiComment;
import com.yyk.sz.common.base.domain.Paging;
import com.yyk.sz.common.base.result.Result;
import com.yyk.sz.common.base.result.ResultFactory;
import com.yyk.sz.common.base.utils.UtilUuid;
import com.yyk.sz.zhzy.lzxt.utils.UtilString;
import com.yyk.sz.zhzy.lzxt.xycf.entity.FangJiCodeRst;
import com.yyk.sz.zhzy.lzxt.xycf.entity.XiYaoInfo;
import com.yyk.sz.zhzy.lzxt.xycf.service.XiYaoInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * 临症系统-药品信息Controller
 */
@Api2Doc(id = "lzxt.xycf.3", name = "临症-药品信息")
@ApiComment(seeClass = XiYaoInfo.class)
@RestController
@RequestMapping(value = "/lzxt/xycf/")
public class XiYaoInfoController {

    @Autowired
    private XiYaoInfoService xiYaoInfoService;

    /**
     * 西药药品查询
     *
     * @return 西药信息列表
     */
    @ApiComment("西药药品查询")
    @RequestMapping(value = "/getXiYaoTable", method = RequestMethod.POST)
    @ResponseBody
    public Result getXiYaoTable(
            @RequestParam(value = "pageNumber", required = false, defaultValue = "1") int pageNumber,
            @RequestParam(value = "pageSize", required = false, defaultValue = "10") int pageSize,
            @RequestParam(value = "searchText", required = false) String searchText,
            @RequestParam(value = "sortName", required = false) String sortName,
            @RequestParam(value = "sortOrder", required = false) String sortOrder
    ) {
        searchText = UtilString.judgeNull(searchText);
        if (searchText != null) {
            searchText = "%" + searchText + "%";
        }
        Paging<XiYaoInfo> dialecticalOrCureList = xiYaoInfoService.getXiYaoTable(pageNumber,pageSize,searchText,sortName,sortOrder);
        if( dialecticalOrCureList == null || dialecticalOrCureList.getSize() == 0 ){
            return ResultFactory.create("1","没有西药信息数据",null);
        }
        return ResultFactory.create("0",null,dialecticalOrCureList);
    }

    /**
     * 用药方式
     *
     * @return 用药方式列表
     */
    @ApiComment("用药方式")
    @RequestMapping(value = "/getDrugWayTable", method = RequestMethod.POST)
    @ResponseBody
    public Result getDrugWayTable(
    ) {
        List<XiYaoInfo> drugWayList = xiYaoInfoService.getDrugWayTable();
        if( drugWayList == null || drugWayList.size() == 0 ){
            return ResultFactory.create("1","没有用药方式数据",null);
        }
        return ResultFactory.create("0",null,drugWayList);
    }

    /**
     * 用药频次
     *
     * @return 用药频次列表
     */
    @ApiComment("用药频次")
    @RequestMapping(value = "/getFrequencyTable", method = RequestMethod.POST)
    @ResponseBody
    public Result getFrequencyTable(
    ) {
        List<XiYaoInfo> frequencyList = xiYaoInfoService.getFrequencyTable();
        if( frequencyList == null || frequencyList.size() == 0 ){
            return ResultFactory.create("1","没有用药频次数据",null);
        }
        return ResultFactory.create("0",null,frequencyList);
    }

    /**
     * 获取患者的西药处方列表
     *
     * @param empBasicMainID
     * @return 西药处方列表
     */
    @ApiComment("获取患者的西药处方列表")
    @RequestMapping(value = "/getFangJiTable", method = RequestMethod.POST)
    @ResponseBody
    public Result getFangJiTable(@RequestParam("empBasicMainID") String empBasicMainID
    ) {
        List<XiYaoInfo> frequencyList = xiYaoInfoService.getFangJiTable(empBasicMainID);
        if( frequencyList == null || frequencyList.size() == 0 ){
            return ResultFactory.create("1","该患者的没有西药处方信息",null);
        }
        return ResultFactory.create("0",null,frequencyList);
    }

    /**
     * 获取西药处方编码
     *
     * @return 西药处方编码
     */
    @ApiComment("获取西药处方编码")
    @RequestMapping(value = "/GetFangJiCode", method = RequestMethod.POST)
    @ResponseBody
    public Result GetFangJiCode() {
        XiYaoInfo xiYaoInfo = new XiYaoInfo();
        Date currentTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String dateString = formatter.format(currentTime);
        xiYaoInfo.setBillCode("1003");
        xiYaoInfo.setDateString(dateString);
        xiYaoInfo.setItemCode("");
        xiYaoInfo.setOption(1);
        xiYaoInfo.setVoucherCode("");
        String proUUID = UtilUuid.uuid();
        xiYaoInfo.setProUUID(proUUID);
        xiYaoInfoService.GetFangJiCode(xiYaoInfo);
        List<FangJiCodeRst> frequencyList =xiYaoInfoService.GetFangJiCodeRst(proUUID);
        if( frequencyList == null || frequencyList.size() == 0 ){
            return ResultFactory.create("1","执行出错",null);
        }
        return ResultFactory.create("0",null,frequencyList.get(0));
    }

}
