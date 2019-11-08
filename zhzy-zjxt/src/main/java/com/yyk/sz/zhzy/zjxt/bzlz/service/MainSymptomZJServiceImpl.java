package com.yyk.sz.zhzy.zjxt.bzlz.service;

import com.yyk.sz.zhzy.zjxt.bzlz.entity.MainSymptomZJ;
import com.yyk.sz.zhzy.zjxt.bzlz.mapper.MainSymptomZJMapper;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Component
@Transactional
public class MainSymptomZJServiceImpl implements MainSymptomZJService {
    @Resource
    private MainSymptomZJMapper mainSymptomZJMapper;
    @Override
    public List<MainSymptomZJ> getMainSymptomList(String deptCode, String userCode) {
        return mainSymptomZJMapper.getMainSymptomList(deptCode, userCode);
    }

    @Override
    public List<MainSymptomZJ> getDiseaseList(int mainSymptomCode) {
        return mainSymptomZJMapper.getDiseaseList(mainSymptomCode);
    }

    @Override
    public List<MainSymptomZJ> getTongueList(int mainSymptomCode) {
        return mainSymptomZJMapper.getTongueList(mainSymptomCode);
    }

    @Override
    public List<MainSymptomZJ> getPulseList(int mainSymptomCode) {
        return mainSymptomZJMapper.getPulseList(mainSymptomCode);
    }
}
