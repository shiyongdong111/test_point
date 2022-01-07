package com.lening.utils;

import java.io.Serializable;

/**
 * 本类作者： 石永栋
 * 创建时间为：2021/12/10 16:57
 * 本类作用： xxx
 */
public class ResultInfo implements Serializable {

    private boolean flag;
    private String msg;

    public ResultInfo(boolean flag, String msg) {
        this.flag = flag;
        this.msg = msg;
    }

    public ResultInfo() {
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

}
