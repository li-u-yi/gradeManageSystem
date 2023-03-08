

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

@WebServlet({"/registerServlet"})
public class RegisterServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public RegisterServlet() {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        String uid = request.getParameter("id");
        String name = new String(request.getParameter("name").getBytes("ISO-8859-1"), "utf-8");
        String psw = request.getParameter("psw");
        String role = request.getParameter("role");

        try {
            Connection conn = JDBCUtils.getConnection();
            String str = "insert into worker(uid,uname,psw,role) values(?,?,?,?)";
            PreparedStatement pst = conn.prepareStatement(str);
            pst.setObject(1, uid);
            pst.setObject(2, name);
            pst.setObject(3, psw);
            pst.setObject(4, role);
            int rs = pst.executeUpdate();
            response.setCharacterEncoding("UTF-8");
            PrintWriter out = response.getWriter();
            if (rs > 0) {
                out.print("<script language='JavaScript'>alert('注册成功');location.href='login.jsp';</script>");
            } else {
                out.print("<script language='JavaScript'>alert('注册失败');location.href='login.jsp';</script>");
            }

            pst.close();
            conn.close();
        } catch (Exception var12) {
            var12.printStackTrace();
        }

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
