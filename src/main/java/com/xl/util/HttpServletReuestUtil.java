package com.xl.util;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by  X.L on 2018/9/10.
 */
public class HttpServletReuestUtil {
    public static int getInt(HttpServletRequest reuest, String key){
        try {
            return Integer.decode(reuest.getParameter(key));
        }catch (Exception e){
            return -1;
        }
    }

    public static Long getLong(HttpServletRequest reuest, String key){
        try {
            return Long.valueOf(reuest.getParameter(key));
        }catch (Exception e){
            return -1L;
        }
    }

    public static Double getDouble(HttpServletRequest reuest, String key){
        try {
            return Double.valueOf(reuest.getParameter(key));
        }catch (Exception e){
            return -1d;
        }
    }

    public static Boolean getBoolean(HttpServletRequest reuest, String key){
        try {
            return Boolean.valueOf(reuest.getParameter(key));
        }catch (Exception e){
            return false;
        }
    }

    public static String getString(HttpServletRequest reuest, String key){
        try {
            String resoult=reuest.getParameter(key);
            if(resoult !=null){
                return resoult.trim();
            }
            if("".equals(resoult)){
                return null;
            }
            return resoult;
        }catch (Exception e){
            return null;
        }
    }
}
