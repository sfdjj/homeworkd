package com.qunar.fresh2017.dao;

import com.qunar.fresh2017.model.ContentModel;
import com.qunar.fresh2017.service.CounterService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:spring.xml")
public class ContentDaoTest {

    @Resource
    private ContentDao contentDao;

    @Resource
    private CounterService counterService;

    @Test
    public void insert() throws Exception {
    }

    @Test
    public void save() throws Exception {
        counterService.save("https://blog.csdn.net/ityouknow/article/details/80682237");
    }

    @Test
    public void query() throws Exception {
        List<ContentModel> contentModels = contentDao.query();
        for(ContentModel contentModel:contentModels) {
            System.out.println(contentModel.getTitle());
        }
        System.out.println(contentModels.toString());
    }

    @Test
    public void queryByOffset() throws Exception {
        List<ContentModel> contentModels = contentDao.queryByOffset(12);
        for(ContentModel contentModel:contentModels) {
            System.out.println(contentModel.getTitle());
        }
        System.out.println(contentModels.toString());
    }

    @Test
    public void queryCount() throws Exception {
        System.out.println(contentDao.queryCount());
    }

}