package com.lening.email;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

/**
 * 本类作者： 石永栋
 * 创建时间为：2021/12/30 19:09
 * 本类作用： xxx
 */
public class SendMailUtil {

    public static Properties properties;
    public static Properties getEmailInfo(String path) throws  Exception{
        synchronized (SendMailUtil.class){
            if(properties==null){
                synchronized (SendMailUtil.class){
                    properties = new Properties();
                    FileInputStream fis = new FileInputStream(new File(path));
                    properties.load(fis);
                    return  properties;
                }
            }else{
                return  properties;
            }
        }
    }
    public static Integer getInteger(String key){
        return  Integer.parseInt(properties.getProperty(key));
    }
    public static String getString(String key){
        return  properties.getProperty(key);
    }
    public static Double getDouble(String key){
        return  Double.parseDouble(properties.getProperty(key));
    }


}
