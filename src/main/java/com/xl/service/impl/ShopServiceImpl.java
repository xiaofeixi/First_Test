package com.xl.service.impl;


import com.xl.dao.ShopDao;
import com.xl.dto.ShopExecution;
import com.xl.enums.ShopStateEnum;
import com.xl.exceptions.ShopOperationException;
import com.xl.exceptions.ShopOperationExecution;
import com.xl.model.Shop;
import com.xl.service.ShopService;
import com.xl.util.ImageUtil;
import com.xl.util.PageCalculator;
import com.xl.util.PathUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.InputStream;
import java.util.Date;
import java.util.List;

/**
 * Created by  X.L on 2018/6/25.
 */
@Service
public class ShopServiceImpl implements ShopService {
    @Autowired
    private ShopDao shopDao;

    @Override
    public ShopExecution getShopList(Shop shopCategory, int pageIndex, int pageSize) {
        int rowIndex = PageCalculator.calculatorRowIndex(pageIndex,pageSize);
        List<Shop> shopList = shopDao.queryShopList(shopCategory,rowIndex,pageSize);
        int count = shopDao.queryShopCount(shopCategory);
        ShopExecution se = new ShopExecution();
        if(shopList != null){
            se.setShopList(shopList);
            se.setCount(count);
        }else{
            se.setState(ShopStateEnum.INNER_ERROR.getState());
        }
        return se;
    }

    @Override
    public Shop getByShopId(Long shopId) {
        return shopDao.queryShopByShopId(shopId);
    }

    @Override
    public ShopExecution modifyShop(Shop shop, InputStream shopImgInputStream, String fileName) throws ShopOperationExecution {
        if (shop == null || shop.getShopId() == null) {
            return new ShopExecution(ShopStateEnum.NULL_SHOP_INFO);
        } else {
            //判断图片是否修改并删除修改
            try {
                if (shopImgInputStream != null && fileName != null && !"".equals(fileName)) {
                    Shop tempShop = shopDao.queryShopByShopId(shop.getShopId());
                    if (tempShop.getShopImg() != null) {
                        ImageUtil.deletefileOrPath(tempShop.getShopImg());
                    }
                    addShopImg(shop, shopImgInputStream, fileName);
                }

                //修改店铺信息
                shop.setLastEditTime(new Date());
                int effectedNum = shopDao.updateShop(shop);
                if (effectedNum <= 0) {
                    return new ShopExecution(ShopStateEnum.INNER_ERROR);
                } else {
                    shop = shopDao.queryShopByShopId(shop.getShopId());
                    return new ShopExecution(ShopStateEnum.SUCCESS, shop);
                }
            } catch (Exception e) {
                throw  new ShopOperationException("modifyShop error: "+e.getMessage());
            }
        }
    }

    @Override
    @Transactional
    public ShopExecution addShop(Shop shop, InputStream shopImgInputStream, String fileName) {

        //控制判断
        if(shop == null){
            return new ShopExecution(ShopStateEnum.NULL_SHOP_INFO);
        }
        try {
            //给店铺信息赋予初始值
            /*shop.setEnableStatus(0);
            shop.setCreateTime(new Date());
            shop.setLastEditTime(new Date());*/
            //添加店铺信息
            int effectedNum = shopDao.insertShop(shop);
            //创建失败
            if(effectedNum<=0){
                throw new ShopOperationException("创建店铺失败!");
            } else {
              if(shopImgInputStream != null){
                  try {
                      addShopImg(shop, shopImgInputStream, fileName);
                  } catch (Exception e) {
                      throw new ShopOperationException("addShopImg error:" + e.getMessage());
                  }
                  //更新店铺的图片地址
                  effectedNum = shopDao.updateShop(shop);
                  if(effectedNum <=0){
                      throw new ShopOperationException("更新店铺图片地址失败!");
                  }else{
                      System.out.println("成功！");
                  }
              }
            }

        } catch (Exception e) {throw new ShopOperationException("addShop error:" + e.getMessage());

        }

        return new ShopExecution(ShopStateEnum.CHECK,shop);
    }



    private void addShopImg(Shop shop, InputStream shopImgInputStream, String fileName) {
        //获取shop图片目录的相对路径
        String dest = PathUtil.getShopImagePath(shop.getShopId());
        String shopImgAddr = ImageUtil.generateThumbnail(shopImgInputStream,fileName,dest);
        shop.setShopImg(shopImgAddr);
    }
}
