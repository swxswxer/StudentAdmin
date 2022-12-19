package com.swx.web.servlet;

import com.alibaba.fastjson.JSON;
import com.swx.pojo.User;
import com.swx.service.UserService;
import com.swx.service.impl.UserServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.HashMap;

@WebServlet(name = "LoginServlet", value = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserService userService = new UserServiceImpl();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
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
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(jsonString);
    }
}
