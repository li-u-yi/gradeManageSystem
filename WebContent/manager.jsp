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

<title>评价查询</title>

<meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="keywords" content="">
    <meta name="description" content="">
    <link href="bootstrap5/bootstrap.min.css" rel="stylesheet">

</head>
<body>
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
<div class="px-4 py-5 my-5 text-center">
    <h1 class="display-5 fw-bold">管理员主页</h1>
    <div class="col-lg-6 mx-auto">
      <p class="lead mb-4">Welcome to the Employee Management System and have fun.</p>
      <div class="d-grid gap-2 d-sm-flex justify-content-sm-center">
        
        <a class="btn btn-primary btn-lg px-4 gap-3" href="manager_update.jsp" role="button">修改个人信息</a>
        <a class="btn btn-outline-secondary btn-lg px-4" href="myComment.jsp" role="button">查看已评价员工</a>
      </div>
    </div>
  </div>	
<div class="container">

<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <div class="container-fluid">
    <a class="navbar-brand" href="#">员工信息搜索</a>
    
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
         
      </ul>
      <form class="d-flex" role="search" action="manager_search.jsp">
        	<select class="navbar-text" name="x">
			 <option value ="uname">姓名</option>
			  <option value ="uid">工号</option>
			  <option value ="age">年龄</option>
			  <option value="department">部门</option>
			  <option value="position">职位</option>
			  <option value="date">入职时间</option>
			  </select>
        <input name="value" class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
        <button class="btn btn-outline-success" type="submit">Search</button>
      </form>
    </div>
  </div>
</nav>

 
</div>


<script src="bootstrap5/bootstrap.bundle.min.js" ></script>
</body>
</html>