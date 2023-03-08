package com.ly.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ly.utils.JDBCUtils;

@WebServlet({"/loginCheckServlet"})
public class LoginCheckServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public LoginCheckServlet() {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String checkCode = (String)request.getSession(true).getAttribute("Verify");
        String Verify = request.getParameter("Verify");
        String rememberMe = request.getParameter("rememberMe");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        if (checkCode != null && checkCode.equalsIgnoreCase(Verify)) {
            String name = request.getParameter("userid");
            String psw = request.getParameter("password");

            try {
                String url = "jdbc:mysql://localhost:3306/workers?useUnicode=true&characterEncoding=UTF-8";
                Connection conn = JDBCUtils.getConnection();
                String str = "select uid,psw,role from manager where uid = '" + name + "'" + "and psw= '" + psw + "'";
                PreparedStatement stmt = conn.prepareStatement(str);
                ResultSet rs = stmt.executeQuery(str);
                RequestDispatcher dispatcher;
                if (rs.next()) {
                    dispatcher = request.getRequestDispatcher("/manager.jsp");
                    if (rememberMe != null) {
                        Cookie cookie1 = new Cookie("userid", name);
                        cookie1.setMaxAge(60);
                        response.addCookie(cookie1);
                        Cookie cookie2 = new Cookie("password", psw);
                        cookie2.setMaxAge(60);
                        response.addCookie(cookie2);
                        request.setAttribute("message", "登陆成功");
                        dispatcher.forward(request, response);
                    } else {
                        request.setAttribute("message", "登陆成功");
                        dispatcher.forward(request, response);
                    }
                } else {
                    request.setAttribute("message", "密码错误");
                    dispatcher = request.getRequestDispatcher("login.jsp");
                    dispatcher.forward(request, response);
                }

                JDBCUtils.close(rs, stmt, conn);
            } catch (Exception var16) {
                var16.printStackTrace();
            }
        } else {
            request.setAttribute("message", "验证码错误");
            PrintWriter out = response.getWriter();
            out.println("<script type='text/javascript' >alert('请重新输入验证码!');</script>");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }

    }
}
