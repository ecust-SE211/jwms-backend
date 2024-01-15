package io.github.ecustse211.utils;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.Base64;

public class ImageUtil {
    public static void convertBase64ToImage(String base64, String path) {
        ByteArrayInputStream imageBytes = null;
        try {
            //获取解码器将base64解码成字节数组
            byte[] bytes = Base64.getDecoder().decode(base64);
            imageBytes = new ByteArrayInputStream(bytes);
            BufferedImage bufferedImage = ImageIO.read(imageBytes);
            File imageFile = new File(path);

            ImageIO.write(bufferedImage, "png", new File(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static String convertImageToBase64(String path) {
        ByteArrayOutputStream imageBytes = null;
        try {
            File file = new File(path);
            if (!file.exists() || !file.isFile()) {
                throw new IllegalArgumentException("文件不存在或不是一个文件");
            }
            BufferedImage image = ImageIO.read(file);
            imageBytes = new ByteArrayOutputStream();
            ImageIO.write(image, "png", imageBytes);

            byte[] bytes = imageBytes.toByteArray();
            return Base64.getEncoder().encodeToString(bytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    //预处理图片
    public static void PreProcessImage(String pic1path,String pic2path,int targetWidth,int targetHeight) throws IOException
    {
        try {
            // 读取第一张图片并调整大小
            BufferedImage img1 = ImageIO.read(new File(pic1path));
            BufferedImage resizedImg1 = ResizeImage(img1, targetWidth, targetHeight);

            // 读取第二张图片并调整大小
            BufferedImage img2 = ImageIO.read(new File(pic2path));
            BufferedImage resizedImg2 = ResizeImage(img2, targetWidth, targetHeight);

            ImageIO.write(resizedImg1, "png", new File(pic1path));
            ImageIO.write(resizedImg2, "png", new File(pic2path));

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    //将图片缩放到指定大小
    public static BufferedImage ResizeImage(BufferedImage source, int width, int height) throws IOException {
        BufferedImage dest=new BufferedImage(width,height,source.getType());
        Graphics2D g=dest.createGraphics();
        g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g.drawImage(source, 0, 0, width, height, null);
        g.dispose();
        return dest;
    }
}
