package com.yyk.sz.zhzy.gcxt.xybm.service;


import com.yyk.sz.zhzy.gcxt.xybm.entity.GCWesternMedicine;

import java.util.List;

public interface WesternMedicineService {

    public List<GCWesternMedicine> getAllWesternMedicineName(String searchText);
}
