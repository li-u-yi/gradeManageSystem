package com.ly.controller;

import com.ly.entity.Exam;
import com.ly.service.ManagerService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/delGrade")
public class DelGradeServlet extends HttpServlet {
    public DelGradeServlet(){
        super();
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String examNum = request.getParameter("examNum");

        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        ManagerService managerService = new ManagerService();
        managerService.deleteScore(examNum);
        PrintWriter out = response.getWriter();
        out.print("<script language='JavaScript'>alert('删除成功');location.href='managerGradeSearch.jsp';</script>");
    }


    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }
}
