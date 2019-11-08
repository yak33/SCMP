package com.yyk.sz.zhzy.zjxt.lczl.mapper;

import com.yyk.sz.zhzy.zjxt.lczl.entity.FangJiZJCodeRst;
import com.yyk.sz.zhzy.zjxt.lczl.entity.SFangJiCode;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface SFangJiCodeMapper {

    void GetFangJiCode(SFangJiCode sFangJiCode);

    List<FangJiZJCodeRst> GetFangJiZJCodeRst(@Param("proUUID") String proUUID);
}
