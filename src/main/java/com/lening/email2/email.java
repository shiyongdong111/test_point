package com.lening.email2;

import com.sun.mail.util.MailSSLSocketFactory;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

/**
 * 本类作者： 石永栋
 * 创建时间为：2021/12/30 20:38
 * 本类作用： xxx
 */
public class email {

        public static void main(String[] args) {
            try {
                Properties prop=new Properties();
                //设置qq邮箱服务器、"mail.host", "smtp.qq.com")
                prop.setProperty("mail.host","smtp.qq.com");
                //邮箱发送协议"mail.transport.protocol", "smtp"
                prop.setProperty("mail.transport.protocol","smtp");
                //需要验证用户账号和密码"mail.smtp.auth", "true"
                prop.setProperty("mail.smtp.protocol","smtp");
                //设置SSL加密prop.put("mail.smtp.ssl.enable", "true");
                //        prop.put("mail.smtp.ssl.socketFactory", sf);
                MailSSLSocketFactory ssl=new MailSSLSocketFactory();
                ssl.setTrustAllHosts(true);
                prop.put("mail.smtp.protocol","true");
                prop.put("mail.smtp.protocol",ssl);


                //使用javaMail发送邮件的5个步骤
                //1.创建整个应用程序所需要的环境信息的session信息
                Session session=Session.getDefaultInstance(prop, new Authenticator() {
                    public PasswordAuthentication getPasswordAuthentication() {
                        //发邮件的账号和授权码
                        return new PasswordAuthentication("2817810975@qq.com","qbzyqehrxepndcge");
                    };

                });
                //开启session的debug模式，这样就可以查看程序发送email的运行状态
                session.getDebug();
                //2.通过session得到transport
                Transport transport = session.getTransport();
                //3.使用邮箱的用户名和授权码链接邮箱服务器
                //第一个参数：qq邮箱服务器
                //第二个参数：发件人账号
                //第三个参数：授权码
                transport.connect("smtp.qq.com","2817810975@qq.com","qbzyqehrxepndcge");
                //4.创建邮件
                //创建邮件对象
                MimeMessage message =new MimeMessage(session);
                //指明邮件的发件人
                message.setFrom(new InternetAddress("2817810975@qq.com"));
                //指明邮件的收件人
                message.setRecipient(Message.RecipientType.TO,new InternetAddress("2817810975@qq.com"));
                //邮件的标题
                message.setSubject("我爱北京天安门");
                //邮件的文本内容
                message.setContent("天安门上太阳升","text/html;charset=UTF-8");

                //5.发送邮
                transport.sendMessage(message,message.getAllRecipients());

                transport.close();

            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("有异常，发送失败");
            }
            System.out.println("发送成功");
        }

    }
