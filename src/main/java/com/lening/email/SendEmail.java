package com.lening.email;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

/**
 * 本类作者： 石永栋
 * 创建时间为：2021/12/30 19:10
 * 本类作用： 发送邮件测试类
 */
public class SendEmail {

    /*
    *     POP3/IMAP/SMTP/Exchange/CardDAV/CalDAV服务
    *
    * */


    public static void sendEmail() throws  Exception{
        Properties properties = SendMailUtil.getEmailInfo("src/main/resources/application.properties"); //配置邮件发送文件路径
        Session session = Session.getInstance(properties,new MailAuthenticator(SendMailUtil.getString("emailName"),SendMailUtil.getString("passWord")));//获取发件人名字和授权码
        System.out.println(SendMailUtil.getString("emailName")+"=====发件人邮箱");
        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress(SendMailUtil.getString("emailName")));
        message.setSubject("愿世间美好与你相拥");
        message.setContent("我爱北京天安门","text/plain;charset=utf-8");
        message.setReplyTo(new InternetAddress[]{new InternetAddress("2630830390@qq.com")});
        Transport transport = session.getTransport();
        transport.connect();
        transport.sendMessage(message,message.getReplyTo());
    }


    public static void main(String...arg){
        try {
            sendEmail();
            System.out.println("邮件发送成功");
        } catch (Exception e) {
            System.out.println("不好意思，发送失败了");
            e.printStackTrace();
        }
    }


}
