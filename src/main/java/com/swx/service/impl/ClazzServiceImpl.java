package com.swx.service.impl;

import com.swx.mapper.ClazzMapper;
import com.swx.pojo.Clazz;
import com.swx.service.ServiceInterface.ClazzService;
import com.swx.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class ClazzServiceImpl implements ClazzService {
    SqlSessionFactory factory = SqlSessionFactoryUtils.getSqlSessionFactory();

    public List<Clazz> selectAll() {
        SqlSession sqlSession = factory.openSession();
        //获取student mapper
        ClazzMapper mapper = sqlSession.getMapper(ClazzMapper.class);
        //执行方法
        List<Clazz> Clazzs = mapper.selectAll();
        //释放资源
        sqlSession.close();
        return Clazzs;
    }


    public void add(Clazz clazz) {
        SqlSession sqlSession = factory.openSession();
        //获取student mapper
        ClazzMapper mapper = sqlSession.getMapper(ClazzMapper.class);
        mapper.add(clazz);
        sqlSession.commit();
        sqlSession.close();
    }

    public void deleteById(int id) {
        SqlSession sqlSession = factory.openSession();
        //获取brand mapper
        ClazzMapper mapper = sqlSession.getMapper(ClazzMapper.class);
        //执行方法
        mapper.deleteById(id);
        sqlSession.commit();
        sqlSession.close();
    }

    public void update(Clazz clazz) {
        //获取sqlSession对象
        SqlSession sqlSession = factory.openSession();
        //获取brand mapper
        ClazzMapper mapper = sqlSession.getMapper(ClazzMapper.class);
        //执行方法
        mapper.update(clazz);
        sqlSession.commit();
        sqlSession.close();
    }


    public Clazz selectByName(String classname) {
        SqlSession sqlSession = factory.openSession();
        //获取student mapper
        ClazzMapper mapper = sqlSession.getMapper(ClazzMapper.class);
        Clazz clazz = mapper.selectByName(classname);
        sqlSession.close();
        return clazz;
    }

    @Override
    public Clazz selectById(int id) {
        SqlSession sqlSession = factory.openSession();
        //获取student mapper
        ClazzMapper mapper = sqlSession.getMapper(ClazzMapper.class);
        Clazz clazz = mapper.selectById(id);
        sqlSession.close();
        return clazz;
    }
}
