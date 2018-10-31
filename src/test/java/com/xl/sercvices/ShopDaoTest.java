package com.xl.sercvices;

import com.xl.BaseTest;
import com.xl.dao.ShopDao;
import com.xl.model.Area;
import com.xl.model.PersonInfo;
import com.xl.model.Shop;
import com.xl.model.ShopCategory;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by  X.L on 2018/7/3.
 */
@WebAppConfiguration("src/main/webapp/resources")
public class ShopDaoTest extends BaseTest {
    @Autowired
    private ShopDao shopDao;



    @Test
    public void testqueryShopListAndCount(){
        Shop shopCondition = new Shop();
        PersonInfo owner = new PersonInfo();
        owner.setUserId(1L);
        shopCondition.setOwner(owner);
        List<Shop> shopList = shopDao.queryShopList(shopCondition,0,3);
        int count = shopDao.queryShopCount(shopCondition);
        System.out.println("queryShopList: "+shopList.size());
        System.out.println("queryShopList总数: "+count);
    }

    @Test
    public void insertShop(){
        Shop shop=new Shop();
        PersonInfo owner = new PersonInfo();
        Area area = new Area();
        ShopCategory shopCategory = new ShopCategory();
        Date date = new Date();

        owner.setUserId(1L);
        area.setAreaId(2);
        shopCategory.setShopCategoryId(1L);
        shop.setArea(area);
        shop.setOwner(owner);
        shop.setShopCategory(shopCategory);
        shop.setShopName("测试店铺1");
        shop.setShopDesc("test1");
        shop.setShopAddr("test1");
        shop.setPhone("test1");
        shop.setShopImg("test1");
        shop.setEnableStatus(1);
        shop.setCreateTime(new Date());
        shop.setLastEditTime(new Date());
        shop.setAdvice("审核中");
        shop.setPriority(1);

        int effectedNum = shopDao.insertShop(shop);
        assertEquals(1,effectedNum);

        // File ShopImg = new File("E:\\Idea_workspace\\MY_WorkSpace\\First_Test_Img\\001.png");
        // ShopExecution shopExecution=shopService.addShop(shop,ShopImg);

        // assertEquals(ShopStateEnum.CHECK.getState(),shopExecution.getState());
    }

    @Test
    public void testupdateShop(){
        Shop shop=new Shop();
        shop.setShopId(1L);
        shop.setShopDesc("测试描述");
        shop.setShopAddr("测试地址");
        shop.setPhone("15870684711");
        shop.setShopImg("E:\\Idea_workspace\\MY_WorkSpace\\First_Test_Img\\001.png");
        int effectedNum = shopDao.updateShop(shop);
        assertEquals(1,effectedNum);
    }
}
