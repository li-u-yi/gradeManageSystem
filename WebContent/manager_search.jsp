<%@page import="java.sql.ResultSet" %>
<%@page import="java.sql.Connection" %>
<%@page import="java.sql.Statement" %>
<%@page import="java.sql.DriverManager" %>
<%@page import="com.ly.utils.JDBCUtils" %>
<%@page import="java.sql.PreparedStatement"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<title>员工信息查询</title>

<meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="keywords" content="">
    <meta name="description" content="">
    <link href="bootstrap5/bootstrap.min.css" rel="stylesheet">

</head>
<body>

<%
String x = request.getParameter("x");
String value = request.getParameter("value");
%>

<% //连接数据库，模糊查询 
    try {
        Connection conn = JDBCUtils.getConnection();
        String str = "select * from worker where " + x + " like'%" + value + "%'";
        PreparedStatement stmt = conn.prepareStatement(str);

        ResultSet rs = stmt.executeQuery(str);


%>
<div class="collapse" id="navbarToggleExternalContent">
    <div class="bg-dark p-4">
        <h5 class="text-white h4">员工管理系统</h5>
        <span class="text-muted"><a href="manager.jsp">返回主页</a></span>
    </div>
</div>
<nav class="navbar navbar-dark bg-dark">
    <div class="container-fluid">
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
                data-bs-target="#navbarToggleExternalContent" aria-controls="navbarToggleExternalContent"
                aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

    </div>
</nav>


<div class="container">


    <table class="table table-hover">

        <thead>
        <tr>
            <th scope="col">#</th>
            <th scope="col">姓名</th>
            <th scope="col">工号</th>
            <th scope="col">年龄</th>
            <th scope="col">部门</th>
            <th scope="col">职位</th>
            <th scope="col">入职时间</th>
            <th scope="col">操作</th>
        </tr>
        </thead>
        <tbody>
            <%
int i=0;
while(rs.next()){
	i++;
%>

        <tr>
            <th scope="row"><%=i%>
            </th>
            <td><%=rs.getString("uname") %>
            </td>
            <td><%=rs.getString("uid") %>
            </td>
            <td><%=rs.getString("age") %>
            </td>
            <td><%=rs.getString("department") %>
            </td>
            <td><%=rs.getString("position") %>
            </td>
            <td><%=rs.getString("date") %>
            </td>
            <td><a class="btn btn-outline-warning"
                   href="comment.jsp?id=<%=rs.getString("uid")%>">添加评价
            </a>
            </td>
        </tr>
            <% };JDBCUtils.close(rs,stmt,conn);
//rs.close();
//stmt.close();
//conn.close();
}catch(Exception e){
	e.printStackTrace();
}%>
</body>
</html>
