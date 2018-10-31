package com.xl.dao;

import com.xl.BaseTest;
import com.xl.model.Area;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by  X.L on 2018/5/31.
 */
public class AreaDaoTest extends BaseTest {
    @Autowired
    private AreaDao areaDao;

    @Test
    public void testQueryArea(){
        List<Area> areaList=areaDao.queryArea();
        System.out.println(areaList);

    }
}
