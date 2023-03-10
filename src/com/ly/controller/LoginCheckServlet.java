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

@WebServlet({"/loginCheckServlet"})
public class LoginCheckServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public LoginCheckServlet() {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userid = request.getParameter("userid");
        String password = request.getParameter("password");
        String role = request.getParameter("role");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        //checkbox没选中传回空值
        if (role==null) role="1";
        UserService userService = new UserService();
        User res = userService.loginCheck(userid, password, role);
        PrintWriter out = response.getWriter();
        if (res != null) {
            //登陆成功
            Cookie cookie = new Cookie("userId",userid);
            cookie.setMaxAge(6000);
            response.addCookie(cookie);
            if (role.equals("1")) {//学生账号--跳转学生登陆界面
                request.getSession().setAttribute("loginUser", res);
                request.getRequestDispatcher("stuInfo").forward(request, response);

            } else if (role.equals("2")) {//管理员账号--跳转管理员登陆界面
                request.getSession().setAttribute("loginUser", res);
                request.getRequestDispatcher("managerGradeSearch.jsp").forward(request, response);

            }
        } else {
            //登陆失败
            request.setAttribute("msg", "登陆失败，请检查用户名和密码是否正确");
            out.print("<script language='JavaScript'>alert('登陆失败，请检查用户名和密码是否正确');location.href='login1.jsp';</script>");

        }
    }
}


