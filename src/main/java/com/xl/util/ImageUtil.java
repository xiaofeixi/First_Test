package com.xl.util;

import com.xl.exceptions.ShopOperationException;
import com.xl.web.superadmin.AreaController;
import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Positions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * Created by  X.L on 2018/6/5.
 */
public class ImageUtil {
    public static String basePath=Thread.currentThread().getContextClassLoader().getResource("").getPath();
    private static final SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyyMMddHHmmss");
    private static final Random r = new Random();
    private static Logger logger= LoggerFactory.getLogger(AreaController.class);

    //处理缩略图
    /*public static String generateThumbnail(File thumbnail,String targetAddr){
        String realFileName = getRandomFileName();//获取随机文件名
        String extension = getFileExtension(thumbnail);//上传文件拓展名
        makeDirPath(targetAddr);//生成文件
        String relativeAddr=targetAddr + realFileName + extension;
        logger.debug("current relative addr is:" + PathUtil.getImgBasePath() + relativeAddr);
        File dest=new File( PathUtil.getImgBasePath() + relativeAddr);
        logger.debug("current completeAddr is:" + relativeAddr);
        try {
            Thumbnails.of(thumbnail).size(200,200).watermark(Positions.BOTTOM_RIGHT,
                    ImageIO.read(new File(String.valueOf(thumbnail))),0.25f)
                    .outputQuality(0.8f).toFile(dest);
        } catch (IOException e) {
            throw new ShopOperationException("创建缩略图失败：" + e.toString());
        }
        return relativeAddr;
    }*/
    public static String generateThumbnail(InputStream thumbnailInputStream,String fileName, String targetAddr){
        String realFileName = getRandomFileName();//获取随机文件名
        String extension = getFileExtension(fileName);//上传文件拓展名
        makeDirPath(targetAddr);//生成文件
        String relativeAddr=targetAddr + "/" + realFileName + extension;
        logger.debug("current relative addr is:" + PathUtil.getImgBasePath() + relativeAddr);
        File dest=new File( relativeAddr);
        logger.debug("current completeAddr is:" + relativeAddr);
        try {
            Thumbnails.of(thumbnailInputStream).size(300,250).watermark(Positions.TOP_RIGHT,
                    ImageIO.read(new File(basePath+"/K.png")),0.5f)
                    .outputQuality(0.8f).toFile(dest);
        } catch (IOException e) {
            throw new ShopOperationException("创建缩略图失败：" + e.toString());
        }
        return relativeAddr;
    }

    //创建目标对象所涉及到的目录,即
    private static void makeDirPath(String targetAddr) {
        targetAddr=targetAddr.substring(targetAddr.lastIndexOf("/"));
        String realFilePath = PathUtil.getImgBasePath()+targetAddr;
        File dirPath = new File(realFilePath);
        if(!dirPath.exists()){
            // 递归创建文件夹
            dirPath.mkdirs();
        }
    }

    private static String getFileExtension(String fileName) {
        return fileName.substring(fileName.lastIndexOf("."));
    }


    public static void main(String[] args) throws IOException {
        String targetAddr="E:/Idea_workspace/MY_WorkSpace/First_Test_Img/10/";
        targetAddr=targetAddr.substring(targetAddr.lastIndexOf("/*/"));
        System.out.println(targetAddr);
        // Thumbnails.of(new File("E:\\Idea_workspace\\MY_WorkSpace\\First_Test_Img\\001.png"))
        //         .size(300,250).watermark(Positions.TOP_RIGHT,
        //         ImageIO.read(new File(basePath+"/K.png")),
        //         0.5f).outputQuality(0.8f).toFile
        //         ("E:\\Idea_workspace\\MY_WorkSpace\\First_Test_Img\\Test\\K001.png");
    }

    //生成随机的文件  名字都要不一样  当前年月日小时分钟秒+5位随机数
    public static String getRandomFileName() {
        //获取随机的五位数
        int rannum = r.nextInt(89999)+10000;
        String nowDate = simpleDateFormat.format(new Date());
        return nowDate + rannum;
    }

    /**
     * storePath 是文件路径还是目录的路径
     * 如果storePath是文件路径则删除该文件，
     * 如果storePath是目录路径，则删除该目录下的所有文件
     * @param storePath
     */
    public static void deletefileOrPath(String storePath){
        File fileOrPath = new File(storePath);
        if(fileOrPath.exists()){
            if(fileOrPath.isDirectory()){
                File files[] = fileOrPath.listFiles();
                for(int i = 0;i<files.length;i++){
                    files[i].delete();
                }
            }
            fileOrPath.delete();
        }
    }

}
