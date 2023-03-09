package com.ly.controller;

import com.ly.entity.dto.ScoreDto;
import com.ly.service.ManagerService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/ManagerGradeSearchServlet")
public class ManagerGradeSearchServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManagerGradeSearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String manId = request.getParameter("man_id");
        ManagerService managerService = new ManagerService();
        List<ScoreDto> scores = managerService.getExamList(manId);
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        if (!scores.isEmpty()) {
            // 查询成功,传回scores对象列表
            request.setAttribute("scores", scores);
            request.getRequestDispatcher("managerGradeSearch.jsp").forward(request, response);
        }else {
            //查询失败
            out.print("<script language='JavaScript'>alert('查询失败，请检查管理员编号是否正确');location.href='gradeSearch.jsp';</script>");

        }

    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doPost(request,response);
    }

}

