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

<%
//String x = request.getParameter("x");
int mid=1001;
%>

<% //连接数据库，查询 
try{
	Connection conn=JDBCUtils.getConnection();
	String str="select* from worker where manager_id ="+mid;
	PreparedStatement stmt = conn.prepareStatement(str);
	
	ResultSet rs=stmt.executeQuery(str);

	

%>
<!-- 导航栏 -->
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
<main>
  <div class="container">
<div class="py-5 text-left">
      <h2>个人信息修改</h2>
      <p class="lead">在一下表格中填写要修改的个人信息</p>
    </div>
<div class="col-md-7 col-lg-8">
        <form class="needs-validation" action="managerUpdateServlet" method="post">
            
            <div class="col-12">
              <label for="address" class="form-label">工号</label>
              <input type="text" class="form-control" id="address" placeholder="请输入工号" name="uid">
              <div class="invalid-feedback">
                工号
              </div>
            </div>
            <div class="col-12">
              <label for="address" class="form-label">密码</label>
              <input type="text" class="form-control" id="address" placeholder="请输入密码" name="psw">
              <div class="invalid-feedback">
                Please enter your shipping address.
              </div>
            </div>
            
            <div class="row g-2">
             <div class="col-6">
              <label for="username" class="form-label">姓名</label>
              <div class="input-group has-validation">
                <input type="text" class="form-control" id="username" placeholder="Username" name="uname">
              <div class="invalid-feedback">
                  请输入姓名
                </div>
              </div>
            </div>
            <div class="col-sm-6">
              <label for="lastName" class="form-label">年龄</label>
              <input type="text" class="form-control" id="lastName" placeholder="" value="" name="age">
              <div class="invalid-feedback">
                Valid last name is required.
              </div>
            </div>
            </div>
            
             <div class="row g-3">
            <div class="col-md-5">
              <label for="country" class="form-label">部门</label>
              <select class="form-select" id="country" name="department">
                <option value="技术部">技术部</option>
                <option value="人事部">人事部</option>
                <option value="销售部">销售部</option>
                <option value="管理部">管理部</option>
              </select>
              <div class="invalid-feedback">
                Please select a valid country.
              </div>
            </div>

            <div class="col-md-4">
              <label for="state" class="form-label">职位</label>
              <select class="form-select" id="state" name="position">
                <option value="职员">职员</option>
                <option value="经理">经理</option>
                <option value="主管">主管</option>
                
              </select>
              <div class="invalid-feedback">
                Please provide a valid state.
              </div>
            </div>

            <div class="col-md-3">
              <label for="zip" class="form-label">入职日期</label>
              <input type="text" class="form-control" id="zip" placeholder="" name=date>
          
            </div>
             
         
			</div>
          <hr class="my-4">
<button class="w-100 btn btn-primary btn-lg" type="submit">确认无误，提交</button>
  </form></div>
  </div>
  </main>        
<footer class="my-5 pt-5 text-muted text-center text-small">
    <p class="mb-1">© 2021–2022 ly</p>
    
  </footer>



  <!-- Content here -->
</div>



<%
JDBCUtils.close(rs,stmt,conn);
//rs.close();
//stmt.close();
//conn.close();
}catch(Exception e){
	e.printStackTrace();
}
%>
 <script src="bootstrap5/bootstrap.bundle.min.js" ></script>
</body>
</html>