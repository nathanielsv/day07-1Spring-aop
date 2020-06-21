package com.wanho.java146.pojo;

import org.springframework.stereotype.Component;

@Component
public class MoneyLimit {
    private Float Money;

    public Float getMoney() {
        return Money;
    }

    public void setMoney(Float money) {
        Money = money;
    }

    @Override
    public String toString() {
        return "Money{" +
                "Money=" + Money +
                '}';
    }
}
