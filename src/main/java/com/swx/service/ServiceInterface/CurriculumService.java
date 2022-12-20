package com.swx.service.ServiceInterface;

import com.swx.pojo.Clazz;
import com.swx.pojo.Curriculum;

import java.util.List;

public interface CurriculumService {
    List<Curriculum> selectAll();

    void add(Curriculum curriculum);

    void deleteById(int id);

    void update(Curriculum curriculum);
}
