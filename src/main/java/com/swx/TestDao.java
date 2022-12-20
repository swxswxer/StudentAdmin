package com.swx;

import com.swx.service.impl.ClazzServiceImpl;
import org.junit.Test;

public class TestDao {

    @Test
    public void userServiceTest(){
        ClazzServiceImpl clazzService = new ClazzServiceImpl();
        System.out.println(clazzService.selectAll());

    }
}
