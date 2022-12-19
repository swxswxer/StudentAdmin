package com.swx.web.servlet;

import com.alibaba.fastjson.JSON;
import com.swx.pojo.User;
import com.swx.service.UserService;
import com.swx.service.impl.UserServiceImpl;
import org.apache.ibatis.annotations.Param;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.HashMap;

@WebServlet("/login/*")
public class LoginServlet extends BaseServlet {
    private UserService userService = new UserServiceImpl();
    public void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        User user = userService.login(username, password);
        HashMap<Object, Object> loginMsg = new HashMap<Object, Object>();
        if(user!=null){
            //重定向
//            String contextPath = req.getContextPath();
//            resp.sendRedirect(contextPath + "/selectAllServlet");
            loginMsg.put("success",true);
            loginMsg.put("message","登陆成功");
        }else {
            loginMsg.put("success",false);
            loginMsg.put("message","用户名或密码错误");
        }
        String jsonString = JSON.toJSONString(loginMsg);
        //写数据
        resp.setContentType("text/json;charset=utf-8");
        resp.getWriter().write(jsonString);

    }

    public void register(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        boolean flag = userService.register(user);
        HashMap<Object, Object> registerMsg = new HashMap<Object, Object>();
        if(flag){
            registerMsg.put("success",true);
            registerMsg.put("message","注册成功");
        }else{
            registerMsg.put("success",false);
            registerMsg.put("message","组册失败，用户名已存在");
        }
        String jsonString = JSON.toJSONString(registerMsg);
        //写数据
        resp.setContentType("text/json;charset=utf-8");
        resp.getWriter().write(jsonString);
    }


}

