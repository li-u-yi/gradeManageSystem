package com.ly.controller;

import com.ly.entity.Student;
import com.ly.entity.dto.ScoreDto;
import com.ly.service.StudentService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/stuInfo")
public class StuInfoServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public StuInfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
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
        StudentService studentService = new StudentService();
        Student student = studentService.getStudentByUid(userId);
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        request.setAttribute("student",student);
        request.getRequestDispatcher("stuInfo.jsp").forward(request, response);
        }



    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doPost(request,response);
    }

}
