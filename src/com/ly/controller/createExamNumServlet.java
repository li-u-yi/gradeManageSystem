package com.ly.controller;

import com.ly.entity.Course;
import com.ly.entity.Exam;
import com.ly.service.CourseService;
import com.ly.service.ManagerService;
import com.ly.service.StudentService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.Time;

@WebServlet("/createExamNum")
public class createExamNumServlet extends HttpServlet {
    public createExamNumServlet(){
        super();
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String stuName = request.getParameter("stuName");
        String stuId = request.getParameter("stuId");
        String major = request.getParameter("major");
        String stuClass = request.getParameter("stuClass");
        String courseName = request.getParameter("courseName");
        String courseType = request.getParameter("courseType");
        String date = request.getParameter("date");
        String time = request.getParameter("time");

        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        StudentService studentService = new StudentService();
        CourseService courseService = new CourseService();
        Exam obj = new Exam();
        Course course = new Course();
        PrintWriter out = response.getWriter();
        Integer courseId = courseService.getCourseIdByName(courseName).getCourseId();
        //生成考试编码
        String examNum = String.valueOf(courseId) + stuId;
        obj.setExamNum(String.valueOf(examNum));
        obj.setCourseId(Integer.valueOf(courseId));
        obj.setDate(Date.valueOf(date));
        obj.setStuId(Integer.valueOf(stuId));
        obj.setTime(Time.valueOf(time));
        studentService.insertExam(obj);
        request.setAttribute("examNum", examNum);
        request.getRequestDispatcher("examNum.jsp").forward(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }
}
