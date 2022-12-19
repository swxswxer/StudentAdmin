package com.swx.util;

import com.alibaba.fastjson.JSON;

import java.util.HashMap;

public class ResponseMsgUtil {
    HashMap<String,Object> msg;

    public void add(String key, Object value){
        msg.put(key, value);
    }

    public String getString() {
        String jsonString = JSON.toJSONString(msg);
        return jsonString;
    }

    public ResponseMsgUtil() {
       msg = new HashMap<String,Object>();
    }
}
