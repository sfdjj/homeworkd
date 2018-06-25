package com.qunar.fresh2017.service;

import com.qunar.fresh2017.model.ContentModel;

import java.util.List;

public interface CounterService {

    void save(String articleUrl);

    void save(String title,Integer number, Integer cnNumber,Integer enNumber,Integer puncNumber);

    List<ContentModel> getData();

    List<ContentModel> getData(int offset);

    int getCount();
}
