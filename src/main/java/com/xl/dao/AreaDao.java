package com.xl.dao;

import com.xl.model.Area;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 列出区域列表
 * Created by  X.L on 2018/5/31.
 */
@Repository
public interface AreaDao {
    //查询区域
    List<Area> queryArea();
    //添加用户
    int insertArea(Area area);

}
