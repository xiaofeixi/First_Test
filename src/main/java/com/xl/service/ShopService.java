package com.xl.service;

import com.xl.dto.ShopExecution;
import com.xl.exceptions.ShopOperationExecution;
import com.xl.model.Shop;
import org.springframework.stereotype.Service;

import java.io.InputStream;

/**
 * Created by  X.L on 2018/6/25.
 */
@Service
public interface ShopService {
   /**
    * 根据ShopCategory分页返回相应店铺列表
    * @param shopCategory
    * @param pageIndex
    * @param pageSize
    * @return
    */
   public ShopExecution getShopList(Shop shopCategory , int pageIndex, int pageSize);

   //通过店铺ID获取店铺信息
   Shop getByShopId(Long shopId);

   //更新店铺信息，包括对图片的处理、
   ShopExecution modifyShop( Shop shop , InputStream shopImgInputStream , String fileName ) throws ShopOperationExecution;


   //注册店铺包括图片处理
   ShopExecution addShop( Shop shop, InputStream shopImgInputStream , String fileName ) throws ShopOperationExecution;
}
