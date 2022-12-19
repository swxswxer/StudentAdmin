package com.swx.web.servlet;

import com.alibaba.fastjson.JSON;
import com.sun.org.apache.xpath.internal.functions.FuncFalse;
import com.swx.pojo.Student;
import com.swx.pojo.StudentUtil;
import com.swx.service.StudentService;
import com.swx.service.impl.StudentServiceimpl;
import com.swx.util.ResponseMsgUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

@WebServlet("/stu-admin/student/*")
public class StudentServlet extends BaseServlet {
    private StudentService studentService = new StudentServiceimpl();

    public void selectAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1 掉哦你service查询
        List<Student> brands = studentService.selectAll();
        HashMap<String, Object> msg = new HashMap<String, Object>();
        msg.put("data", brands);
        msg.put("status", true);
        //转为json
        String jsonString = JSON.toJSONString(msg);
//        System.out.println("12313121231312312312313");
        //写数据
        resp.setContentType("text/json;charset=utf-8");
        resp.getWriter().write(jsonString);
    }

    public void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        StudentUtil studentUtil = new StudentUtil();
        ResponseMsgUtil responseMsgUtil = new ResponseMsgUtil();

        BufferedReader br = req.getReader();
        String params = br.readLine();
        System.out.println(params);
        Student student = studentUtil.ParseStudentParams(params);

        Student oldData = studentService.selectById(student.getStudentid());
        if (oldData == null) {
            //调用service
            studentService.add(student);
            //响应成功的提示
            responseMsgUtil.add("success", true);
        } else {
            responseMsgUtil.add("success", false);
            responseMsgUtil.add("message", student.getStudentid() + "学号学生已存在");
        }
        //写数据
        resp.setContentType("text/json;charset=utf-8");
        resp.getWriter().write(responseMsgUtil.getString());
    }

    public void deleteById(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ResponseMsgUtil responseMsgUtil = new ResponseMsgUtil();
        String studentId = req.getParameter("student_id");
        Student oldData = studentService.selectById(Integer.parseInt(studentId));
        if(oldData!=null){
            //调用service
            studentService.deleteById(Integer.parseInt(studentId));
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

    public void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ResponseMsgUtil responseMsgUtil = new ResponseMsgUtil();
        StudentUtil studentUtil = new StudentUtil();
        BufferedReader br = req.getReader();
        String params = br.readLine();
        //转化为student对象
        Student student = studentUtil.ParseStudentParams(params);
        Student oldData = studentService.selectById(student.getStudentid());
        if(oldData!=null){
            //调用service
            studentService.update(student);
            responseMsgUtil.add("success",true);
        }else {
            responseMsgUtil.add("success",false);
            responseMsgUtil.add("message","不存在学号为"+student.getStudentid()+"的学生");
        }
        //响应成功的提示
        resp.setContentType("text/json;charset=utf-8");
        resp.getWriter().write(responseMsgUtil.getString());

    }


}
