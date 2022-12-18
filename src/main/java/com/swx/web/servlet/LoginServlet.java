package com.swx.web.servlet;

import com.swx.pojo.User;
import com.swx.service.UserService;
import com.swx.service.impl.UserServiceImpl;
import org.apache.ibatis.annotations.Param;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/login/*")
public class LoginServlet extends BaseServlet {
    private UserService userService = new UserServiceImpl();
    public void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        User user = userService.login(username, password);
        if(user!=null){
            String contextPath = req.getContextPath();
//            resp.sendRedirect(contextPath + "/selectAllServlet");

        }
    }

    public void register(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        boolean flag = userService.register(user);

    }


}

