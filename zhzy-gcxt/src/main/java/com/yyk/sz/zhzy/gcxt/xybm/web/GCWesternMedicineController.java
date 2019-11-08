package com.yyk.sz.zhzy.gcxt.xybm.web;

import com.terran4j.commons.api2doc.annotations.Api2Doc;
import com.terran4j.commons.api2doc.annotations.ApiComment;
import com.yyk.sz.common.base.result.Result;
import com.yyk.sz.common.base.result.ResultFactory;
import com.yyk.sz.zhzy.gcxt.xybm.entity.GCWesternMedicine;
import com.yyk.sz.zhzy.gcxt.xybm.service.WesternMedicineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 肛肠系统-西医病名 Controller
 */
@Api2Doc(id = "gcxt.xybm", name = "肛肠系统-症型治法")
@ApiComment(seeClass = GCWesternMedicine.class)
@RestController
@RequestMapping(value = "/gcxt/xybm/")
public class GCWesternMedicineController {

    @Autowired
    private WesternMedicineService westernMedicineService;

    /**
     * index，测试用
     */
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public Result index() {
        return ResultFactory.create("0","临症系统-症型治法测试访问成功。",null);
    }

    /**
     *  获取所有西医病名
     *
     * @return 西医病名列表
     */
    @ApiComment(" 获取所有西医病名")
    @RequestMapping(value = "/getAllWesternMedicineName", method = RequestMethod.POST)
    @ResponseBody
    public Result getAllWesternMedicineName( @RequestParam(value = "searchText", required = false) String searchText
    ) {
        List<GCWesternMedicine> westernMedicineList = westernMedicineService.getAllWesternMedicineName(searchText);
        if( westernMedicineList == null || westernMedicineList.size() == 0 ){
            return ResultFactory.create("1","没有西医病名数据",null);
        }
        return ResultFactory.create("0",null,westernMedicineList);
    }



}
