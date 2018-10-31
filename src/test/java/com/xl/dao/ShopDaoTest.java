package com.xl.dao;

import com.xl.BaseTest;
import com.xl.model.Area;
import com.xl.model.PersonInfo;
import com.xl.model.Shop;
import com.xl.model.ShopCategory;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.Date;

import static org.junit.Assert.assertEquals;

/**
 * Created by  X.L on 2018/6/4.
 */
@WebAppConfiguration("src/main/webapp/resources")
public class ShopDaoTest extends BaseTest {
    @Autowired
    private ShopDao shopDao;
    @Test
    public void testqueryShopByShopId(){
        Shop shop=shopDao.queryShopByShopId(45L);
        System.out.println("shop.getPriority()"+shop.getPriority());
        System.out.println(shop.getCreateTime());
        System.out.println("shop.getArea().getPriority()"+shop.getArea().getPriority());
        System.out.println(shop.getArea().getCreatTime());
    }
    @Test
    public  void testinsertShop(){
        Shop shop=new Shop();
        PersonInfo owner = new PersonInfo();
        Area area = new Area();
        ShopCategory shopCategory = new ShopCategory();
        Date date = new Date();

        owner.setUserId(20000L);
        area.setAreaId(10001);
        shopCategory.setShopCategoryId(60000L);
        shop.setArea(area);
        shop.setOwner(owner);
        shop.setShopCategory(shopCategory);
        shop.setShopName("测试店铺");
        shop.setShopDesc("test");
        shop.setShopAddr("test");
        shop.setPhone("test");
        //shop.setShopImg("test");
        shop.setCreateTime(date);
        shop.setLastEditTime(date);
        shop.setEnableStatus(1);
        shop.setAdvice("审核中");
        shop.setPriority(1);
        int effectedNum=shopDao.insertShop(shop);
        assertEquals(1,effectedNum);
    }

    @Test
    public  void testupdateShop(){
        Shop shop=new Shop();
        Date date = new Date();

        shop.setShopId(70006L);
        shop.setShopDesc("测试");
        shop.setShopAddr("测试");
        shop.setEnableStatus(1);
        shop.setPriority(1);
        int effectedNum=shopDao.updateShop(shop);
        assertEquals(1,effectedNum);
    }

}
