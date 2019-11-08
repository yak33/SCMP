package com.yyk.sz.zhzy.lzxt.zjkf.service;

import com.yyk.sz.zhzy.lzxt.zjkf.entity.Process;
import com.yyk.sz.zhzy.lzxt.zjkf.mapper.ProcessMapper;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Component
@Transactional
public class ProcessServiceImpl implements ProcessService {

    @Resource
    private ProcessMapper processMapper;

    @Override
    public List<Process> getProcessList(String drugCode) {
        return processMapper.getProcessList(drugCode);
    }
}
