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

@WebServlet({"/DelCommentServlet"})
public class DelCommentServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public DelCommentServlet() {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        String uid = request.getParameter("id");
        PrintWriter out = response.getWriter();

        try {
            Connection conn = JDBCUtils.getConnection();
            String str = "update workers.worker set comment = NULL ,manager_id = NULL WHERE uid = '" + uid + "'";
            PreparedStatement pst = conn.prepareStatement(str);
            boolean rs = pst.execute(str);
            response.setCharacterEncoding("UTF-8");
            if (!rs) {
                out.print("<script language='JavaScript'>alert('删除成功');location.href='myComment.jsp';</script>");
            } else {
                out.print("<script language='JavaScript'>alert('删除失败');location.href='myComment.jsp';</script>");
            }

            pst.close();
            conn.close();
        } catch (Exception var9) {
            var9.printStackTrace();
        }

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
