package com.swx.web.servlet;

import com.alibaba.fastjson.JSON;
import com.sun.org.apache.xpath.internal.functions.FuncFalse;
import com.swx.pojo.Student;
import com.swx.service.StudentService;
import com.swx.service.impl.StudentServiceimpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

@WebServlet("/student/*")
public class StudentServlet extends BaseServlet {
    private StudentService studentService = new StudentServiceimpl();
    public void selectAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1 掉哦你service查询
        List<Student> brands = studentService.selectAll();
        HashMap<String, Object> msg = new HashMap<String, Object>();
        msg.put("data", brands);
        msg.put("status",true);
        //转为json
        String jsonString = JSON.toJSONString(msg);
        //写数据
        resp.setContentType("text/json;charset=utf-8");
        resp.getWriter().write(jsonString);
    }
    public void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BufferedReader br = req.getReader();
        String params = br.readLine();
        //转化为student对象
        Student student = JSON.parseObject(params, Student.class);
        //调用service
        studentService.add(student);
        //响应成功的提示
        resp.getWriter().write("success");
    }
    public void deleteById(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BufferedReader br = req.getReader();
        String params = br.readLine();
        //转化为student对象
        Student student= JSON.parseObject(params, Student.class);
        //调用service
        studentService.deleteById(student.getStudentid());
        //响应成功的提示
        resp.getWriter().write("success");
    }
    public void update(HttpServletRequest req , HttpServletResponse resp) throws ServletException,IOException{

        BufferedReader br = req.getReader();
        String params = br.readLine();
        //转化为student对象
        Student student= JSON.parseObject(params, Student.class);
        //调用service
        studentService.update(student);
        //响应成功的提示
        resp.getWriter().write("success");
    }
}
