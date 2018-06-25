package com.qunar.fresh2017.dao;

import com.qunar.fresh2017.model.ContentModel;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContentDao {

    Integer insert(ContentModel contentModel);

    List<ContentModel> query();

    List<ContentModel> queryByOffset(int offset);

    Integer queryCount();
}
