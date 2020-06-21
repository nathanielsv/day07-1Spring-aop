package com.wanho.java146.pojo;

import org.springframework.stereotype.Component;

import java.util.Date;


@Component
public class TransferLog {

    private String NO;

    private String sid;

    private String tid;

    private float money;

    private Date beginTime;

    private Date endTime;

    private String status;

    private String msg;

    private String exception;

    public String getNO() {
        return NO;
    }

    public void setNO(String NO) {
        this.NO = NO;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid;
    }

    public float getMoney() {
        return money;
    }

    public void setMoney(float money) {
        this.money = money;
    }

    public Date getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getException() {
        return exception;
    }

    public void setException(String exception) {
        this.exception = exception;
    }

    @Override
    public String toString() {
        return "TransferLog{" +
                "NO='" + NO + '\'' +
                ", sid='" + sid + '\'' +
                ", tid='" + tid + '\'' +
                ", money=" + money +
                ", beginTime=" + beginTime +
                ", endTime=" + endTime +
                ", status='" + status + '\'' +
                ", msg='" + msg + '\'' +
                ", exception='" + exception + '\'' +
                '}';
    }
}
