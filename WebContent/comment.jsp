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

<title>用户评价</title>

<meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="keywords" content="">
    <meta name="description" content="">
    <link href="bootstrap5/bootstrap.min.css" rel="stylesheet">

</head>
<body>
<%//连接数据库
	
	String userID = request.getParameter("id");
	
	//Connection conn = null;
	//PreparedStatement pre = null;
	//ResultSet rs= null;
	try{
		String url="jdbc:mysql://localhost:3306/workers?useUnicode=true&characterEncoding=UTF-8";
		//建立数据库连接
		Connection conn=JDBCUtils.getConnection();
		//获得预处理对象
		String str="select uname from worker where uid = '"+ userID +"'";
		PreparedStatement stmt = conn.prepareStatement(str);
		//执行sql语句
		ResultSet rs=stmt.executeQuery(str);
		while(rs.next()){
		request.setCharacterEncoding("utf-8");
		%>
		
  <div class="collapse" id="navbarToggleExternalContent">
  <div class="bg-dark p-4">
    <h5 class="text-white h4">员工管理系统</h5>
     <span class="text-muted"><a href="manager.jsp">返回主页</a></span>
  </div>
</div>
<nav class="navbar navbar-dark bg-dark">
  <div class="container-fluid">
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarToggleExternalContent" aria-controls="navbarToggleExternalContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
  </div>
</nav>

<div class="container">

 <div class="row align-items-center">
 	<div class="mb-3 row">
    	<label for="staticEmail" class="col-sm-2 col-form-label">员工姓名</label>
    	<div class="col-sm-10">
      		<input type="text" readonly class="form-control-plaintext" id="staticEmail" value=<%=rs.getString("uname")%>>
    	</div>
  	</div>

	<div class="mb-3">
	<form action="commentServlet?id=<%=userID%>&manager_id=1001" method="post">
  		<label for="exampleFormControlTextarea1" class="form-label">员工评价</label>
  		<textarea name="comments" class="form-control" id="exampleFormControlTextarea1" rows="3">请输入评价</textarea>
	  <input class="btn btn-primary" type="submit" value="提交评价" >
	</form>
	</div>
  	
 
  
  	</div>
 
	</div>
	


<%
JDBCUtils.close(rs,stmt,conn);}}
//rs.close();
//stmt.close();
//conn.close();
catch(Exception e){
	e.printStackTrace();
}
%>
 <script src="bootstrap5/bootstrap.bundle.min.js" ></script>
</body>
</html>