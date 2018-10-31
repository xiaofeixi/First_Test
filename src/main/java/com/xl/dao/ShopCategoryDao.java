package com.xl.dao;

import com.xl.model.ShopCategory;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by  X.L on 2018/9/11.
 */
@Repository
public interface ShopCategoryDao {

    List<ShopCategory> queryShopCategory(@Param("shopCategory") ShopCategory shopCategory);

}
