package com.swx.service.ServiceInterface;

import com.swx.pojo.Clazz;

import java.util.List;

public interface ClazzService {
     List<Clazz> selectAll();

    void add(Clazz clazz);

    void deleteById(int id);

    void update(Clazz clazz);
    Clazz selectByName(String classname);
    Clazz selectById(int id);
}
