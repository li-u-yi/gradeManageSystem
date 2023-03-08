<%@page import="java.sql.*"%>
<%@page import="com.ly.utils.JDBCUtils" %>
<%@page import="java.sql.ResultSet" %>
<%@page import="java.sql.Connection" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.sql.PreparedStatement"%>
  
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/@bootcss/v3.bootcss.com@1.0.20/dist/css/bootstrap.min.css" rel="stylesheet">
 <!-- Bootstrap theme -->
    <link href="https://cdn.jsdelivr.net/npm/@bootcss/v3.bootcss.com@1.0.20/dist/css/bootstrap-theme.min.css" rel="stylesheet">
    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <link href="https://cdn.jsdelivr.net/npm/@bootcss/v3.bootcss.com@1.0.20/assets/css/ie10-viewport-bug-workaround.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="https://cdn.jsdelivr.net/npm/@bootcss/v3.bootcss.com@1.0.20/examples/theme/theme.css" rel="stylesheet">
<meta charset="UTF-8">
<title>修改记录</title>
</head>
<body align="center">
<%
	
	String userID = request.getParameter("id");
	String x = request.getParameter("x");
	//Connection conn = null;
	//PreparedStatement pre = null;
	//ResultSet rs= null;
	try{
		String url="jdbc:mysql://localhost:3306/workers?useUnicode=true&characterEncoding=UTF-8";
		//建立数据库连接
		Connection conn=JDBCUtils.getConnection();
		//获得预处理对象
		String str="select uname,department,position,date,age,role,psw from worker where uid = '"+ userID +"'";
		PreparedStatement stmt = conn.prepareStatement(str);
		//执行sql语句
		ResultSet rs=stmt.executeQuery(str);
		while(rs.next()){
		request.setCharacterEncoding("utf-8");%>
	<form action="UpdateServlet?id=<%=userID%>&x=<%=x%>" method="post">
		<table>
			<% switch(x){
			case "uname" :%>
			<tr>
				<td><label for="name">姓名:</label></td>
				<td><input type="text" name="var" id="var" value=<%=rs.getString("uname") %>></td>
			</tr>
			<%break;case "age": %>
			<tr>
				<td><label for="age">年龄:</label></td>
				<td><input type="text" name="var" id="var" value=<%=rs.getString("age") %>></td>
			</tr>
			<%break;case "department": %>
			<tr>
				<td><label for="department">部门:</label></td>
				<td><input type="text" name="var" id="var"value=<%=rs.getString("department") %>></td>
			</tr>
			<%break;case "position": %>
			<tr>
				<td><label for="position">职位:</label></td>
				<td><input type="text" name="var" id="var" value=<%=rs.getString("position") %>></td>
			</tr>
			<%break;case "date": %>
			<tr>
				<td><label for="date">入职时间:</label></td>
				<td><input type="text" name="var" id="var" value=<%=rs.getString("date") %>></td>
			</tr>
			<%break;case "psw": %>
			<tr>
				<td><label for="psw">密码:</label></td>
				<td><input type="text" name="var" id="var" value=<%=rs.getString("psw") %>></td>
			</tr>
			<%break;} %>
			
<%
		}JDBCUtils.close(rs,stmt,conn);
	}catch(Exception ee){
		ee.printStackTrace();
	}
	
%>

				<tr>
			<!-- 提交按钮 -->
			<td><a type="submit" >修改</a></td>
			</tr>
		</table>
	</form>
</body>
</html>