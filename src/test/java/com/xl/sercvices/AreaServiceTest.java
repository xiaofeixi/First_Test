package com.xl.sercvices;

import com.xl.BaseTest;
import com.xl.service.AreaService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * Created by  X.L on 2018/6/1.
 */
@WebAppConfiguration("src/main/webapp/resources")
public class AreaServiceTest extends BaseTest {
    @Autowired
    private AreaService areaService;

    @Test
    public void getAreaList(){

        //System.out.println(areaService.getAreaList());

        String a ="安信";
        String s = "安信总公司";
        System.out.println(s.contains(a));

    }




}
