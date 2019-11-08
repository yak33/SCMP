package com.yyk.sz.zhzy.jcsjxt.service;


import com.yyk.sz.common.base.domain.Paging;
import com.yyk.sz.zhzy.jcsjxt.entity.JCSJPulse;
import com.yyk.sz.zhzy.jcsjxt.mapper.JCSJPulseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
public class JCSJPulseServiceImpl implements JCSJPulseService {


    @Autowired
    private JCSJPulseMapper jcsjPulseMapper;

    @Override
    public Paging<JCSJPulse> getPulseTable(int pageNum,
                                            int pageSize,
                                            String searchText,
                                            String sortName,
                                            String sortOrder) {
        return jcsjPulseMapper.getPulseTable(pageNum, pageSize, searchText, sortName, sortOrder);
    }

    @Override
    public int insertPulse(JCSJPulse jcsjPulse) {
        return jcsjPulseMapper.insertPulse(jcsjPulse);
    }

    @Override
    public int updatePulse(JCSJPulse jcsjPulse) {
        return jcsjPulseMapper.updatePulse(jcsjPulse);
    }

    @Override
    public int deletePulse(String pulsecode) {
        return jcsjPulseMapper.deletePulse(pulsecode);
    }

    @Override
    public List<JCSJPulse> checkPulseExits(String pulsecode, String pulsename) {
        return jcsjPulseMapper.checkPulseExits(pulsecode, pulsename);
    }

    @Override
    public List<JCSJPulse> GetMainPulseByPulseCode(String pulsecode) {
        return jcsjPulseMapper.GetMainPulseByPulseCode(pulsecode);
    }
}
