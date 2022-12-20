package com.swx.web.servlet.clazz;

import com.alibaba.fastjson.JSON;
import com.swx.pojo.Clazz;
import com.swx.pojo.Student;
import com.swx.service.ServiceInterface.ClazzService;
import com.swx.service.impl.ClazzServiceImpl;
import com.swx.util.ClazzUtil;
import com.swx.util.ResponseMsgUtil;
import com.swx.util.StudentUtil;
import com.swx.web.servlet.BaseServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

@WebServlet("/stu-admin/clazz/*")
public class ClazzServlet extends BaseServlet {
    //selectAll
    private ClazzService clazzService = new ClazzServiceImpl();
    public void selectAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Clazz> clazzs = clazzService.selectAll();
        System.out.println(clazzs);
        HashMap<String, Object> msg = new HashMap<String, Object>();
        msg.put("data", clazzs);
        msg.put("status", true);
        //转为json
        String jsonString = JSON.toJSONString(msg);
//        System.out.println("12313121231312312312313");
        //写数据
        resp.setContentType("text/json;charset=utf-8");
        resp.getWriter().write(jsonString);
    }
    //add
    public void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        ClazzUtil clazzUtil = new ClazzUtil();
        ResponseMsgUtil responseMsgUtil = new ResponseMsgUtil();

        BufferedReader br = req.getReader();
        String params = br.readLine();
        System.out.println(params);
        Clazz clazz = clazzUtil.ParseStudentParams(params);
        System.out.println(clazz);
        Clazz oldData = clazzService.selectById(clazz.getId());
        if (oldData == null) {
            //调用service
            clazzService.add(clazz);
            //响应成功的提示
            responseMsgUtil.add("success", true);
        } else {
            responseMsgUtil.add("success", false);
            responseMsgUtil.add("message", clazz.getId() + "课程id已存在");
        }
        //写数据
        resp.setContentType("text/json;charset=utf-8");
        resp.getWriter().write(responseMsgUtil.getString());
    }

    //delete
    public void delectById(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        ResponseMsgUtil responseMsgUtil = new ResponseMsgUtil();
        String id = req.getParameter("id");
        System.out.println(id);
        Clazz oldData = clazzService.selectById(Integer.parseInt(id));
        if(oldData!=null){
            //调用service
            clazzService.deleteById(Integer.parseInt(id));
            responseMsgUtil.add("success", true);
        }else {
            //响应成功的提示
            responseMsgUtil.add("success", false);
            responseMsgUtil.add("message", "改用户不存在");
        }
        //写数据
        resp.setContentType("text/json;charset=utf-8");
        resp.getWriter().write(responseMsgUtil.getString());
    }

    //update
    public void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        ResponseMsgUtil responseMsgUtil = new ResponseMsgUtil();
        ClazzUtil clazzUtil = new ClazzUtil();
        BufferedReader br = req.getReader();
        String params = br.readLine();
        //转化为student对象
        Clazz clazz = clazzUtil.ParseStudentParams(params);
        System.out.println(clazz);
        Clazz oldData = clazzService.selectById(clazz.getId());
        System.out.println(oldData);
        if(oldData!=null){
            //调用service
            clazzService.update(clazz);
            responseMsgUtil.add("success",true);
        }else {
            responseMsgUtil.add("success",false);
            responseMsgUtil.add("message","不存在学号为"+clazz.getId()+"的学生");
        }
        //响应成功的提示
        resp.setContentType("text/json;charset=utf-8");
        resp.getWriter().write(responseMsgUtil.getString());
    }
}
