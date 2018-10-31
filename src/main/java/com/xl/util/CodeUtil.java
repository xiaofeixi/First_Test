package com.xl.util;

import com.google.code.kaptcha.Constants;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by  X.L on 2018/9/12.
 */
public class CodeUtil {

    public static boolean checkVerifyCode(HttpServletRequest request){
        String verifyCodeExpectde = (String) request.getSession().getAttribute(
                Constants.KAPTCHA_SESSION_KEY);
        String verifyCodeActual = HttpServletReuestUtil.getString(request,"verifyCodeActual");
        if(verifyCodeActual == null || !verifyCodeExpectde.equals(verifyCodeActual)){
            return false;
        }
        return true;
    }
}
