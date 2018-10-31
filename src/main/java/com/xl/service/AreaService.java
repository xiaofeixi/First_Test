package com.xl.service;

import com.xl.model.Area;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by  X.L on 2018/5/31.
 */
@Service
public interface AreaService {
    List<Area> getAreaList();
}
