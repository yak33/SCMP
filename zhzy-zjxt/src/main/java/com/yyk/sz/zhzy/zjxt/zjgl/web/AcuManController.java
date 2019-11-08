package com.yyk.sz.zhzy.zjxt.zjgl.web;

import com.terran4j.commons.api2doc.annotations.Api2Doc;
import com.terran4j.commons.api2doc.annotations.ApiComment;
import com.yyk.sz.common.base.domain.Paging;
import com.yyk.sz.common.base.result.Result;
import com.yyk.sz.common.base.result.ResultFactory;
import com.yyk.sz.zhzy.zjxt.zjgl.entity.AcuMan;
import com.yyk.sz.zhzy.zjxt.zjgl.service.AcuManService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 针灸管理
 *
 * @Author: ZhangChao
 * @Date: 2019/2/19 12:08
 * @Version: 1.0
 */
@Api2Doc(id = "zjxt.zjgl", name = "针灸管理")
@ApiComment(seeClass = AcuMan.class)
@RestController
@RequestMapping(value = "/zjxt/zjgl")
public class AcuManController {

    @Resource
    private AcuManService acuManService;

    /**
     * 获取数据(type: 0.已扎针 1.未扎针)
     *
     * @return
     */
    @ApiComment("获取数据(type: 0.未扎针 1.已扎针)")
    @RequestMapping(value = "/getAcuManAll", method = RequestMethod.POST)
    @ResponseBody
    public Result getAcuManAll(
            @RequestParam(value = "type",required = false) String type,
            @RequestParam(value = "searchText",required = false) String searchText,
            @RequestParam(value = "pageNumber", required = false, defaultValue = "1") int pageNumber,
            @RequestParam(value = "pageSize", required = false, defaultValue = "10") int pageSize,
            @RequestParam(value = "sortName", required = false, defaultValue = "CM_FangJiSub.ZZDateTime") String sortName,
            @RequestParam(value = "sortOrder", required = false, defaultValue = "desc") String sortOrder) {
        Paging<AcuMan> es;
        Paging<AcuMan> acuManAllList = acuManService.getAcuManAll(pageNumber,pageSize,searchText,sortName,sortOrder);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String strDateTime = sdf.format(new Date());
        //未扎针
        if (type != null && type.equals("0")){
            es = acuManService.getAcuManNoList(pageNumber,pageSize,searchText,sortName,sortOrder);
            return ResultFactory.create("0", "这是未扎针数据", es);
        }
        //已扎针
        if (type != null && type.equals("1")){
            es = acuManService.getAcuManYesList(pageNumber,pageSize,searchText,sortName,sortOrder,strDateTime);
            return ResultFactory.create("0", "这是已扎针数据", es);
        }
        //已扎针
        if (type != null && type.equals("2")){
            es = acuManService.getAcuManIngList(pageNumber,pageSize,searchText,sortName,sortOrder,strDateTime);
            return ResultFactory.create("0", "这是正在扎针数据", es);
        }

        if (acuManAllList != null) {
            return ResultFactory.create("0", "全部数据", acuManAllList);
        }
        return ResultFactory.create("1", "没有数据", null);
    }

    /**
     * 扎针
     *
     * @return
     */
    @ApiComment("扎针")
    @RequestMapping(value = "/updateZZDateTime", method = RequestMethod.POST)
    @ResponseBody
    public Result updateZZDateTime(@RequestParam("empBasicMainID") String empBasicMainID) {
        AcuMan acuMan = new AcuMan();
        acuMan.setEmpBasicMainID(empBasicMainID);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        acuMan.setZzDateTime(sdf.format(new Date()));
        int update = acuManService.updateZZDateTime(acuMan);
        if ( update > 0){
            return ResultFactory.create("0", "更新成功", 1);
        }
        return ResultFactory.create("1", "更新失败", null);
    }

}
