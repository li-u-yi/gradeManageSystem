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

@WebServlet({"/managerUpdateServlet"})
public class ManagerUpdateServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public ManagerUpdateServlet() {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        String uid = request.getParameter("uid");
        String uname = new String(request.getParameter("uname").getBytes("ISO-8859-1"), "utf-8");
        String department = new String(request.getParameter("department").getBytes("ISO-8859-1"), "utf-8");
        String position = new String(request.getParameter("position").getBytes("ISO-8859-1"), "utf-8");
        String date = request.getParameter("date");
        String psw = request.getParameter("psw");
        PrintWriter out = response.getWriter();

        try {
            Connection conn = JDBCUtils.getConnection();
            String str = "update workers.manager set role = 2 , uname = '" + uname + "' ,psw = '" + psw + "'  ,date = '" + date + "' ,department = '" + department + "' ,position = '" + position + "' WHERE uid = '" + uid + "'";
            PreparedStatement pst = conn.prepareStatement(str);
            boolean rs = pst.execute(str);
            response.setCharacterEncoding("UTF-8");
            if (!rs) {
                out.print("<script language='JavaScript'>alert('更新成功');location.href='manager.jsp';</script>");
            } else {
                out.print("<script language='JavaScript'>alert('更新失败');location.href='manager.jsp';</script>");
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
