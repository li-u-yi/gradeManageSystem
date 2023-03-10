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

@WebServlet("/updateGrade")
public class UpdateGradeServlet extends HttpServlet {
    public UpdateGradeServlet(){
        super();
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String examNum = request.getParameter("examNum");
        String manId = request.getParameter("manId");
        String check = request.getParameter("check");
        String score = request.getParameter("score");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        ManagerService managerService = new ManagerService();
        Exam obj = new Exam();
        PrintWriter out = response.getWriter();
        if (check.equals("1")) {
            obj.setScore(Integer.valueOf(score));
            obj.setExamNum(String.valueOf(examNum));
            obj.setManId(Integer.valueOf(manId));
            if (managerService.isManager(manId) && managerService.isExam(examNum)) {
                managerService.updateScore(obj);
                out.print("<script language='JavaScript'>alert('更新成功');location.href='managerGradeSearch.jsp';</script>");


            } else if(managerService.isExam(examNum)){//考试编号正确
                out.print("<script language='JavaScript'>alert('更新失败，请输入正确的管理员编号');location.href='managerGradeSearch.jsp';</script>");
            } else if (managerService.isManager(manId)) {//管理员编号正确
                out.print("<script language='JavaScript'>alert('更新失败，请输入正确的考试编号');location.href='managerGradeSearch.jsp';</script>");
            }
        } else {
            //更新失败，请确认后输入
            out.print("<script language='JavaScript'>alert('更新失败，请确认后输入');location.href='managerGradeSearch.jsp';</script>");


        }
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }
}
