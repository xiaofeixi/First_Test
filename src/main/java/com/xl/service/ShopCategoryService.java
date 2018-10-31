package com.xl.service;

import com.xl.model.ShopCategory;

import java.util.List;

/**
 * Created by  X.L on 2018/9/12.
 */
public interface ShopCategoryService {
    List<ShopCategory> getShopCategoryList(ShopCategory shopCategory);
}
