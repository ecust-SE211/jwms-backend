package io.github.ecustse211.utils;

import javax.imageio.ImageIO;
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
}
