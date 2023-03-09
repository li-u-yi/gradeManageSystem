package com.ly.controller;

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

@WebServlet("/studentGradeSum")
public class StudentGradeSumServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentGradeSumServlet() {
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
        String query = request.getParameter("query");
        StudentService studentService = new StudentService();
        String stuId = studentService.getStudentIdByUid(userId);
        System.out.println(query);
        System.out.println(stuId);
        List<ScoreDto> scores = studentService.getStudentAllScoreList(stuId,query);
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        if (!scores.isEmpty()) {
            // 查询成功,传回scores对象列表
            request.setAttribute("scores", scores);
            request.getRequestDispatcher("gradeSum.jsp").forward(request, response);
        }else {
            //查询失败
            out.print("<script language='JavaScript'>alert('查询失败');location.href='gradeSearch.jsp';</script>");

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
