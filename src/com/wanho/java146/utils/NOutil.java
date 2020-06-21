package com.wanho.java146.utils;

import org.springframework.stereotype.Component;
import org.apache.commons.lang3.RandomUtils;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class NOutil {

    private static final SimpleDateFormat sf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
    public String getNo(){
        return sf.format(new Date())+RandomUtils.nextLong(100000,999999);
    }



}
