package com.ly.controller;

import com.ly.entity.Student;
import com.ly.entity.User;
import com.ly.entity.dto.ScoreDto;
import com.ly.service.ExamService;
import com.ly.service.ScoreService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import static java.lang.System.out;

@WebServlet("/StudentGradeSearchServlet")
public class StudentGradeSearchServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentGradeSearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String examNum = request.getParameter("exam_num");
        ExamService examService = new ExamService();
        List<ScoreDto> scores = examService.getExamList(examNum);
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        if (!scores.isEmpty()) {
            // 查询成功,传回scores对象列表
            request.setAttribute("scores", scores);
            request.getRequestDispatcher("gradeSearch.jsp").forward(request, response);
        }else {
            //查询失败
            out.print("<script language='JavaScript'>alert('查询失败，请检查考试编号是否正确');location.href='gradeSearch.jsp';</script>");

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
