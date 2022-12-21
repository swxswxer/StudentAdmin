package com.swx.web.servlet.student;

import com.alibaba.fastjson.JSON;
import com.swx.pojo.Curriculum;
import com.swx.pojo.Student;
import com.swx.util.StudentUtil;
import com.swx.service.ServiceInterface.StudentService;
import com.swx.service.impl.StudentServiceimpl;
import com.swx.util.ResponseMsgUtil;
import com.swx.web.servlet.BaseServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;

@WebServlet("/stu-admin/student/*")
public class StudentServlet extends BaseServlet {
    private StudentService studentService = new StudentServiceimpl();

    public void selectAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1 掉哦你service查询
        List<Student> brands = studentService.selectAll();
        System.out.println(brands);
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
        req.setCharacterEncoding("utf-8");
        StudentUtil studentUtil = new StudentUtil();
        ResponseMsgUtil responseMsgUtil = new ResponseMsgUtil();
        BufferedReader br = req.getReader();
        String params = br.readLine();
        params = URLDecoder.decode(params,"UTF-8");
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
        params = URLDecoder.decode(params,"UTF-8");
        System.out.println(params);
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

    public void selectByName(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ResponseMsgUtil responseMsgUtil = new ResponseMsgUtil();
        String name = req.getParameter("name");
        //1 掉哦你service查询
        System.out.println(name);
        List<Student> students = studentService.selectByName(name);

        System.out.println(students);
        responseMsgUtil.add("data",students);
        responseMsgUtil.add("status",true);

        String jsonString = responseMsgUtil.getString();
        System.out.println(jsonString);
        //写数据
        resp.setContentType("text/json;charset=utf-8");
        resp.getWriter().write(jsonString);
    }

    public void selectByMajor(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ResponseMsgUtil responseMsgUtil = new ResponseMsgUtil();
        String major = req.getParameter("major");
        //1 掉哦你service查询
        List<Student> students = studentService.selectByMajor(major);
//
//        if(students==null){
//            responseMsgUtil.add("success",false);
//            responseMsgUtil.add("message","查找不到姓名为"+name+"的学生");
//        }else {
//            responseMsgUtil.add("success",true);
//        }
        responseMsgUtil.add("data",students);
        responseMsgUtil.add("status",true);

        String jsonString = responseMsgUtil.getString();
        //写数据
        resp.setContentType("text/json;charset=utf-8");
        resp.getWriter().write(jsonString);
    }

    public void selectById(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        ResponseMsgUtil responseMsgUtil = new ResponseMsgUtil();

        String id = req.getParameter("id");
        Student student = studentService.selectById(Integer.parseInt(id));
        if(student!=null){
           responseMsgUtil.add("data",student);
           responseMsgUtil.add("success",true);
        }else {
            responseMsgUtil.add("success",false);
            responseMsgUtil.add("message","找不到该用户");
        }
        String jsonString = responseMsgUtil.getString();
        //写数据
        resp.setContentType("text/json;charset=utf-8");
        resp.getWriter().write(jsonString);
    }

    public void selectStudentAllCurriculum(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        ResponseMsgUtil responseMsgUtil = new ResponseMsgUtil();
        String studentid = req.getParameter("studentid");
        List<Curriculum> studentCurriculum = studentService.getCurriculumByIds(studentService.getStudentCurriculumList(Integer.parseInt(studentid)));

        responseMsgUtil.add("data",studentCurriculum);
        responseMsgUtil.add("status",true);

        String jsonString = responseMsgUtil.getString();
        resp.setContentType("text/json;charset=utf-8");
        resp.getWriter().write(jsonString);
    }

}
