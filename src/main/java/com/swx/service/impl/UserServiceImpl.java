package com.swx.service.impl;

import com.swx.mapper.UserMapper;
import com.swx.pojo.User;
import com.swx.service.ServiceInterface.UserService;
import com.swx.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class UserServiceImpl implements UserService {

    SqlSessionFactory factory = SqlSessionFactoryUtils.getSqlSessionFactory();
    public User login(String username, String password) {
        SqlSession sqlSession = factory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.select(username, password);
        sqlSession.close();
        return user;
    }

    public boolean register(User user) {
        SqlSession sqlSession = factory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        //判断用户名是否存在
        User u = mapper.selectByUsername(user.getUsername());
        if (u == null) {
            //用户名不存在 可以注册
            mapper.add(user);
            sqlSession.commit();
        }
        return u == null;
    }

    public void add(User user) {
        //获取sqlSession对象
        SqlSession sqlSession = factory.openSession();
        //获取brand mapper
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        //执行方法
        mapper.add(user);
        sqlSession.commit();
        sqlSession.close();
    }
}
