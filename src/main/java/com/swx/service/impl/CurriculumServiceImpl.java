package com.swx.service.impl;

import com.swx.mapper.ClazzMapper;
import com.swx.mapper.CurriculumMapper;
import com.swx.mapper.StudentMapper;
import com.swx.pojo.Clazz;
import com.swx.pojo.Curriculum;
import com.swx.pojo.Student;
import com.swx.service.ServiceInterface.CurriculumService;
import com.swx.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class CurriculumServiceImpl implements CurriculumService {
    SqlSessionFactory factory = SqlSessionFactoryUtils.getSqlSessionFactory();
    public List<Curriculum> selectAll() {
        SqlSession sqlSession = factory.openSession();
        //获取student mapper
        CurriculumMapper mapper = sqlSession.getMapper(CurriculumMapper.class);
        //执行方法
        List<Curriculum> Clazzs = mapper.selectAll();
        //释放资源
        sqlSession.close();
        return Clazzs;
    }

    public void add(Curriculum curriculum) {
        SqlSession sqlSession = factory.openSession();
        //获取student mapper
        CurriculumMapper mapper = sqlSession.getMapper(CurriculumMapper.class);
        //执行方法
        mapper.add(curriculum);
        sqlSession.commit();
        sqlSession.close();

    }

    public void deleteById(int id) {
        SqlSession sqlSession = factory.openSession();
        //获取student mapper
        CurriculumMapper mapper = sqlSession.getMapper(CurriculumMapper.class);
        mapper.deleteById(id);
        sqlSession.commit();
        sqlSession.close();
    }

    public void update(Curriculum curriculum) {
        SqlSession sqlSession = factory.openSession();
        //获取student mapper
        CurriculumMapper mapper = sqlSession.getMapper(CurriculumMapper.class);
        mapper.update(curriculum);
        sqlSession.commit();
        sqlSession.close();



        // selectByName

        //selectLikeName
    }

    @Override
    public Curriculum selectById(int id) {
        //获取sqlSession对象
        SqlSession sqlSession = factory.openSession();
        //获取brand mapper
        CurriculumMapper mapper = sqlSession.getMapper(CurriculumMapper.class);
        //执行方法
        Curriculum curriculum = mapper.selectById(id);
        sqlSession.commit();
        sqlSession.close();
        return curriculum;
    }
}
