package com.ly.controller;

import com.ly.entity.Exam;
import com.ly.entity.Student;
import com.ly.service.ManagerService;
import com.ly.service.StudentService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/updateStudent")
public class UpdateStudentInfoServlet extends HttpServlet {
    public UpdateStudentInfoServlet(){
        super();
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userId="";
        Cookie[] cookies=request.getCookies();

        if(cookies!=null) {
            //遍历cookies数组？
            for (Cookie cookie : cookies) {
                String name = cookie.getName();
                if ("userId".equals(cookie.getName())) {
                    userId = cookie.getValue();
                }

            }
        }
        String stuName = request.getParameter("stuName");
        String stuId = request.getParameter("stuId");
        String major = request.getParameter("major");
        String stuClass = request.getParameter("stuClass");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        StudentService studentService = new StudentService();
        Student student = new Student();
        PrintWriter out = response.getWriter();
        student.setStuName(String.valueOf(stuName));
        student.setMajor(String.valueOf(major));
        student.setStuClass(Integer.valueOf(stuClass));
        student.setStuId(Integer.valueOf(stuId));
        student.setUid(Integer.valueOf(userId));
        if (studentService.getStudentIdByUid(userId)=="0")
            studentService.insertStu(student);
        else
            studentService.updateStu(student);
        out.print("<script language='JavaScript'>alert('更新成功');location.href='stuInfo';</script>");

    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }
}
