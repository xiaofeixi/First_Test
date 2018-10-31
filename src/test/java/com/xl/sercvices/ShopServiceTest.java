package com.xl.sercvices;

import com.xl.BaseTest;
import com.xl.dto.ShopExecution;
import com.xl.exceptions.ShopOperationException;
import com.xl.model.Area;
import com.xl.model.PersonInfo;
import com.xl.model.Shop;
import com.xl.model.ShopCategory;
import com.xl.service.ShopService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.web.WebAppConfiguration;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Date;

/**
 * Created by  X.L on 2018/9/7.
 */
@WebAppConfiguration("src/main/webapp/resources")
public class ShopServiceTest extends BaseTest {
    @Autowired
    private ShopService shopService;

    @Test
    public void testGetShopList(){
        Shop shopCategory = new Shop();
        ShopCategory sc = new ShopCategory();
        sc.setShopCategoryId(1L);
        shopCategory.setShopCategory(sc);
        ShopExecution se = shopService.getShopList(shopCategory,2,2);
        System.out.println("店铺列表数： "+se.getShopList().size());
        System.out.println("店铺列表总数： "+se.getCount());
    }

    @Test
    public void testModifyShop() throws FileNotFoundException,ShopOperationException {
        Shop shop = new Shop();
        shop.setShopId(1L);
        shop.setShopName("测试修改店铺名称");
        File shopImg = new File("E:\\Idea_workspace\\MY_WorkSpace\\First_Test_Img\\017.png");
        InputStream is = new FileInputStream(shopImg);
        ShopExecution shopExecution = shopService.modifyShop(shop,is,"017.png");
        System.out.println("新图片地址： "+shopExecution.getShop().getShopImg());
    }

    @Test
    public void testaddShop() throws FileNotFoundException {
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
        shop.setShopName("测试店铺3");
        shop.setShopDesc("test3");
        shop.setShopAddr("test3");
        shop.setPhone("test3");
        shop.setAdvice("审核中");
        shop.setPriority(1);

        File shopImg = new File("E:\\Idea_workspace\\MY_WorkSpace\\First_Test_Img\\001.png");
        InputStream is = new FileInputStream(shopImg);
        ShopExecution se = shopService.addShop(shop,is,shopImg.getName());
        System.out.println(se.getShop());
        System.out.println(se.getState());

    }
}
