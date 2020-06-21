package com.wanho.java146.pojo;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
public class Customer {
    private String cid;
    private String cname;
    private Float cbalance;

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public Float getCbalance() {
        return cbalance;
    }

    public void setCbalance(Float cbalance) {
        this.cbalance = cbalance;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "cid='" + cid + '\'' +
                ", cname='" + cname + '\'' +
                ", cbalance=" + cbalance +
                '}';
    }
}
