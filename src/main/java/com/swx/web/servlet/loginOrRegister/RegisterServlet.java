package com.swx.web.servlet.loginOrRegister;

import com.alibaba.fastjson.JSON;
import com.swx.pojo.User;
import com.swx.service.UserService;
import com.swx.service.impl.UserServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.HashMap;

@WebServlet(name = "RegisterServlet", value = "/stu-admin/register")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserService userService = new UserServiceImpl();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
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
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(jsonString);
    }
}
