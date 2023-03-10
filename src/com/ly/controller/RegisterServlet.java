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

import com.ly.entity.User;
import com.ly.service.UserService;
import com.ly.utils.JDBCUtils;

@WebServlet({"/register"})
public class RegisterServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public RegisterServlet() {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userid = request.getParameter("userid");

        String password = request.getParameter("password");
        String manager = request.getParameter("manager");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");

        UserService userService = new UserService();
        User user = new User();
        PrintWriter out = response.getWriter();
        if (manager==null) {//学生注册
            user.setUid(Integer.valueOf(userid));
            user.setRole(1);
            user.setPsw(String.valueOf(password));
            userService.insertUser(user);
        } else {//管理员注册
            user.setUid(Integer.valueOf(userid));
            user.setRole(2);
            user.setPsw(String.valueOf(password));
            userService.insertUser(user);
        }
        out.print("<script language='JavaScript'>alert('注册成功');location.href='login1.jsp';</script>");
    }

}


