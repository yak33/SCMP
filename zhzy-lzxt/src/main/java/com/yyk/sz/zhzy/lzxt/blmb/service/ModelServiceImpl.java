package com.yyk.sz.zhzy.lzxt.blmb.service;


import com.yyk.sz.zhzy.lzxt.blmb.entity.Model;
import com.yyk.sz.zhzy.lzxt.blmb.mapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
public class ModelServiceImpl implements ModelService {


    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<Model> getModelTable(String usedPhrasesType, String deptCode,String searchText){
        return modelMapper.getModelTable(usedPhrasesType, deptCode,searchText);
    }

    @Override
    public boolean insertModel(Model model) {
        return modelMapper.insertModel(model);
    }

    @Override
    public List<Model> selectModel(Model model) {
        return modelMapper.selectModel(model);
    }

    @Override
    public boolean updateModel(Model model) {
        return  modelMapper.updateModel(model);
    }

    @Override
    public boolean deleteModel(Model model) {
        return modelMapper.deleteModel(model);
    }
}
