package com.xl.util;

/**
 * Created by  X.L on 2018/6/5.
 */
public class PathUtil {
    private static String seperator=System.getProperty("file.seperator");

    public static String getImgBasePath(){
        String os=System.getProperty("os.name");
        String basePath="";

        if(os.toLowerCase().startsWith("win")){
            basePath="E:/Idea_workspace/MY_WorkSpace/First_Test_Img/Shop/";
        }else{
            basePath="/home/xiangze/Image/";
        }

        return basePath;
    }

    public static String getShopImagePath(long shopId){
        String imagePath="E:/Idea_workspace/MY_WorkSpace/First_Test_Img/Shop/"+shopId;
        return imagePath;
    }
}
