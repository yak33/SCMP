package com.yyk.sz.zhzy.lzxt.xycf.web;

import com.terran4j.commons.api2doc.annotations.Api2Doc;
import com.terran4j.commons.api2doc.annotations.ApiComment;
import com.yyk.sz.common.base.domain.Paging;
import com.yyk.sz.common.base.result.Result;
import com.yyk.sz.common.base.result.ResultFactory;
import com.yyk.sz.zhzy.lzxt.xycf.entity.WesternMedicine;
import com.yyk.sz.zhzy.lzxt.xycf.service.WesternMedicineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 临症系统-西药详情Controller
 */
@Api2Doc(id = "lzxt.xycf.4", name = "临症-西药详情")
@ApiComment(seeClass = WesternMedicine.class)
@RestController
@RequestMapping(value = "/lzxt/xycf/")
public class WesternMedicineController {

    @Autowired
    private WesternMedicineService westernMedicineService;

    /**
     * 根据西药编码获取西药信息
     *
     * @return 西药信息列表
     */
    @ApiComment("根据西药编码获取西药信息")
    @RequestMapping(value = "/getWesternMedicine", method = RequestMethod.POST)
    @ResponseBody
    public Result getWesternMedicine(
                                     @RequestParam(value = "pageNumber", required = false, defaultValue = "1") int pageNumber,
                                     @RequestParam(value = "pageSize", required = false, defaultValue = "10") int pageSize,
                                     @RequestParam(value = "searchText", required = false, defaultValue = "") String searchText,
                                     @RequestParam(value = "sortName", required = false) String sortName,
                                     @RequestParam(value = "sortOrder", required = false) String sortOrder
    ) {
        if(searchText!="") {
            searchText = "%" + searchText + "%";
        }
        Paging<WesternMedicine> drugWayList = westernMedicineService.getWesternMedicine(pageNumber,pageSize,searchText,sortName,sortOrder);
        if( drugWayList == null || drugWayList.getSize() == 0 ){
            return ResultFactory.create("1","没有西药信息数据",null);
        }
        return ResultFactory.create("0",null,drugWayList);
    }

}
