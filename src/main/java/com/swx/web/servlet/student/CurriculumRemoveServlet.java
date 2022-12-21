package com.swx.web.servlet.student;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.swx.pojo.AddClassRequest;
import com.swx.service.ServiceInterface.StudentService;
import com.swx.service.impl.StudentServiceimpl;
import com.swx.util.HttpGetJson;
import com.swx.util.ResponseMsgUtil;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "CurriculumRemoveServlet", value = "/stu-admin/student/delectCurriculum")
public class CurriculumRemoveServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        StudentService studentService = new StudentServiceimpl();
        JSONObject data= HttpGetJson.getJson(request);
//        System.out.println(arrayList);
        AddClassRequest addClassRequest = JSON.parseObject(String.valueOf(data), AddClassRequest.class);
        System.out.println("addClassRequest = " + addClassRequest);
        for (int x : addClassRequest.getMajors()){
            studentService.deleteStudentCurriculum(addClassRequest.getStudent_id(),x);
        }
        ResponseMsgUtil responseMsgUtil = new ResponseMsgUtil();
        responseMsgUtil.add("success",true);
        String jsonString = responseMsgUtil.getString();
        //写数据
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(jsonString);
    }
}
