package com.swx.util;
import com.alibaba.fastjson.JSON;
import com.swx.pojo.Curriculum;
import java.util.HashMap;
public class CurriculumUtil {
    public Curriculum ParseStudentParams(String params) {
        HashMap<String, Object> studentMap = new HashMap<String, Object>();
        String[] splitParams = params.split("&");

        for (String x : splitParams) {
            String[] xSplit = x.split("=");
            String key = xSplit[0];
            String value = xSplit[1];
            if ("".equals(value)) {
                System.out.println("key: " + key + "is empty");
                continue;
            }
            studentMap.put(key, value);
        }
        String jsonString = JSON.toJSONString(studentMap);
        return JSON.parseObject(jsonString, Curriculum.class);
    }
}
