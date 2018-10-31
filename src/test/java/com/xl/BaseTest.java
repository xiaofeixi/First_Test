package com.xl;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 配合spring和junit整合,junit启动启动加载springIOC容器
 * Created by  X.L on 2018/5/31.
 */
@RunWith(SpringJUnit4ClassRunner.class)
//告诉junit  spring的配置文件的位置
@ContextConfiguration({"classpath:spring/applicationContext-mvc.xml"})
//@WebAppConfiguration("src/main/resources/mapper")
public class BaseTest {
}
