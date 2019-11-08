package com.yyk.sz.zhzy.lzxt.blmb.service;

import com.yyk.sz.zhzy.lzxt.blmb.entity.Model;

import java.util.List;

public interface ModelService {
    public List<Model> getModelTable(String usedPhrasesType, String deptCode,String searchText);

    public boolean insertModel(Model model);

    public List<Model> selectModel(Model model);

    public boolean updateModel(Model model);

    public boolean deleteModel(Model model);
}
