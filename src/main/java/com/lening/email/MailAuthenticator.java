package com.lening.email;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

/**
 * 本类作者： 石永栋
 * 创建时间为：2021/12/30 19:08
 * 本类作用： xxx
 */
public class MailAuthenticator extends Authenticator {
    private String emailName;
    private String password;
    public MailAuthenticator(){}

    public MailAuthenticator(String emailName,String password){
        this.emailName=emailName;
        this.password=password;
    }


    protected PasswordAuthentication getPasswordAuthentication() {
        return new PasswordAuthentication(emailName, password);
    }


}
