package com.ly.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ly.utils.JDBCUtils;

@WebServlet({"/InsertServlet"})
public class InsertServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public InsertServlet() {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        String uname = new String(request.getParameter("username").getBytes("ISO-8859-1"), "utf-8");
        String age = request.getParameter("age");
        String dept = new String(request.getParameter("department").getBytes("ISO-8859-1"), "utf-8");
        String position = new String(request.getParameter("position").getBytes("ISO-8859-1"), "utf-8");
        String date = request.getParameter("date");
        String uid = request.getParameter("id");

        try {
            Connection conn = JDBCUtils.getConnection();
            String str = "update workers.worker set uname='" + uname + "',age='" + age + "',department='" + dept + "',position='" + position + "',date='" + date + "' where uid = '" + uid + "'";
            PreparedStatement pst = conn.prepareStatement(str);
            boolean rs = pst.execute(str);
            response.setCharacterEncoding("UTF-8");
            PrintWriter out = response.getWriter();
            if (!rs) {
                out.print("<script language='JavaScript'>alert('添加成功');location.href='normal.jsp';</script>");
            } else {
                out.print("<script language='JavaScript'>alert('添加失败');location.href='normal.jsp';</script>");
            }

            pst.close();
            conn.close();
        } catch (Exception var14) {
            var14.printStackTrace();
        }

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
