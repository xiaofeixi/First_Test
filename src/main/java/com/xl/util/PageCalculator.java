package com.xl.util;

/**
 * Created by  X.L on 2018/10/11.
 */
public class PageCalculator {
    public static int calculatorRowIndex(int pageIndex, int pageSize){
        return (pageIndex>0) ? (pageIndex-1)*pageSize : 0;
    }
}
