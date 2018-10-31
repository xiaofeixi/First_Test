package com.xl.dao;

import com.xl.model.Shop;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by  X.L on 2018/6/4.
 */
@Repository
public interface ShopDao {
    /**
     * 分页查询店铺，可输入条件：店铺名（模糊查询），店铺状态，店铺分类，区域ID，owner
     * @param shopCondition
     * @param rowIndex 从第几行开始取值
     * @param pageSize 返回条数是多少条
     * @return
     */
    List<Shop> queryShopList(@Param("shopCondition")Shop shopCondition,
      @Param("rowIndex")int rowIndex , @Param("pageSize")int pageSize);

    /**
     * 返回queryShopList总数
     * @param shopCondition
     * @return
     */
    int queryShopCount(@Param("shopCondition")Shop shopCondition);

    //通过ID查找店铺
    Shop queryShopByShopId(Long shopId);

    //新增店铺
    int insertShop(Shop shop);

    //更新店铺
    int updateShop(Shop shop);

    //查找店铺
    List<Shop> selectShop();

}
