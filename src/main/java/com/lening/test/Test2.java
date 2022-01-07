package com.lening.test;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import org.junit.Test;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.UUID;

/**
 * 本类作者： 石永栋
 * 创建时间为：2021/12/30 14:05
 * 本类作用： 简单生成二维码
 */
@Controller
public class Test2 {

        /**
         * 生成发送二维码方法
         *
         * @param text     二维码生成规则(二维码可以是任何英文字母加数字生成的二维码)
         * @param width    宽度
         * @param height   高度
         * @param filePath 输出图片地址
         */
        public void getQRCodeImage(String text, int width, int height, String filePath) throws WriterException, IOException {
            //生成二维码类
            QRCodeWriter qrCodeWriter = new QRCodeWriter();
            //生成的二维码
            BitMatrix bitMatrix = qrCodeWriter.encode(text, BarcodeFormat.QR_CODE, width, height);
            //生成图片唯一名称,加上.png格式
            String pat = getUUID() + ".png";
            //图片路劲加上图片名称  (输出地址)
            filePath += pat;
            Path path = FileSystems.getDefault().getPath(filePath);
            //输出二维码图片
            MatrixToImageWriter.writeToPath(bitMatrix, "PNG", path);
        }


    /**
     * 把String自带的UUID去除下划线返回
     *
     * @return String UUID
     */
    public String getUUID() {
        String s = UUID.randomUUID().toString();
        //去掉“-”符号
        return s.substring(0, 8) + s.substring(9, 13) + s.substring(14, 18) + s.substring(19, 23) + s.substring(24);
    }

        //运行测试
        @CrossOrigin
        public static void main(String[] args) {
            try {
                Test2 qRcodeUtil = new Test2();
                //这里设置扫描二维码后展示的数据
                qRcodeUtil.getQRCodeImage("https://zhidao.baidu.com/question/91530733.html", 350, 350, "");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }



}
