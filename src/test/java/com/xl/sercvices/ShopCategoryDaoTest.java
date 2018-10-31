package com.xl.sercvices;

import com.xl.BaseTest;
import com.xl.dao.ShopCategoryDao;
import com.xl.model.ShopCategory;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by  X.L on 2018/9/11.
 */
@WebAppConfiguration("src/main/webapp/resources")
public class ShopCategoryDaoTest extends BaseTest {
    @Autowired
    private ShopCategoryDao shopCategoryDao;
    @Test
    public void testQueryShopCategory(){
        ShopCategory shopCategory = new ShopCategory();
        List<ShopCategory> shopCategoryList = shopCategoryDao.queryShopCategory(shopCategory);
        assertEquals(2,shopCategoryList.size());
    }
}
