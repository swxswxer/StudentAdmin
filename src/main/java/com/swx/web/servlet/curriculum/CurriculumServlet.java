package com.swx.web.servlet.curriculum;

import com.alibaba.fastjson.JSON;
import com.swx.pojo.Curriculum;
import com.swx.pojo.Student;
import com.swx.service.ServiceInterface.CurriculumService;
import com.swx.service.impl.CurriculumServiceImpl;
import com.swx.util.CurriculumUtil;
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

@WebServlet("/stu-admin/curriculum/*")
public class CurriculumServlet extends BaseServlet {
    //selectAll
    private CurriculumService curriculumService = new CurriculumServiceImpl();
    public void selectAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        List<Curriculum> curriculumList = curriculumService.selectAll();
        HashMap<String, Object> msg = new HashMap<String, Object>();
        msg.put("data", curriculumList);
        msg.put("status", true);
        //转为json
        String jsonString = JSON.toJSONString(msg);
        //写数据
        resp.setContentType("text/json;charset=utf-8");
        resp.getWriter().write(jsonString);
    }

    //add
    public void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        CurriculumUtil curriculumUtil = new CurriculumUtil();
        ResponseMsgUtil responseMsgUtil = new ResponseMsgUtil();

        BufferedReader br = req.getReader();
        String params = br.readLine();
        System.out.println(params);
        Curriculum curriculum = curriculumUtil.ParseStudentParams(params);
        Curriculum oldData = curriculumService.selectById(curriculum.getId());
        if (oldData == null) {
            //调用service
            curriculumService.add(curriculum);
            //响应成功的提示
            responseMsgUtil.add("success", true);
        } else {
            responseMsgUtil.add("success", false);
            responseMsgUtil.add("message", curriculum.getId() + "ID已存在");
        }
        //写数据
        resp.setContentType("text/json;charset=utf-8");
        resp.getWriter().write(responseMsgUtil.getString());
    }

    //delete
    public void delectById(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        ResponseMsgUtil responseMsgUtil = new ResponseMsgUtil();
        String id = req.getParameter("id");
        Curriculum oldData = curriculumService.selectById(Integer.parseInt(id));
        if(oldData!=null){
            //调用service
            curriculumService.deleteById(Integer.parseInt(id));
            responseMsgUtil.add("success", true);
        }else {
            //响应成功的提示
            responseMsgUtil.add("success", false);
            responseMsgUtil.add("message", "改课程不存在");
        }
        //写数据
        resp.setContentType("text/json;charset=utf-8");
        resp.getWriter().write(responseMsgUtil.getString());
    }

    //update
    public void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        ResponseMsgUtil responseMsgUtil = new ResponseMsgUtil();
        CurriculumUtil curriculumUtil = new CurriculumUtil();
        BufferedReader br = req.getReader();
        String params = br.readLine();
        //转化为student对象
        Curriculum curriculum = curriculumUtil.ParseStudentParams(params);
        System.out.println(curriculum);
        Curriculum oldData = curriculumService.selectById(curriculum.getId());
        System.out.println(oldData);
        if(oldData!=null){
            //调用service
            curriculumService.update(curriculum);
            responseMsgUtil.add("success",true);
        }else {
            responseMsgUtil.add("success",false);
            responseMsgUtil.add("message","不存在ID为"+curriculum.getId()+"的课程");
        }
        //响应成功的提示
        resp.setContentType("text/json;charset=utf-8");
        resp.getWriter().write(responseMsgUtil.getString());

    }
}
