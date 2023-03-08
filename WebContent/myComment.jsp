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
String comment = request.getParameter("comment");
%>

<% //连接数据库，查询 
try{
	Connection conn=JDBCUtils.getConnection();
	String str;
	if(comment!=null){
	str="select* from worker where manager_id ="+mid+" and comment like'%"+comment+"%'";}
	else{
	str="select* from worker where manager_id ="+mid;}
	PreparedStatement stmt = conn.prepareStatement(str);
	
	ResultSet rs=stmt.executeQuery(str);
	
	


	

%>
 
  
  <header class="p-3 bg-dark text-white">
    <div class="container">
      <div class="d-flex flex-wrap align-items-center justify-content-center justify-content-lg-start">
       

        <ul class="nav col-6 col-lg-auto me-lg-auto mb-2 justify-content-center mb-md-0">
          <li><a href="manager.jsp" class="nav-link px-2 text-secondary">主页</a></li>
        </ul>

        <form class="col-12 col-lg-auto mb-3 mb-lg-0 me-lg-3" action="myComment.jsp">
        <div class="text-end">
          <input type="search" class=" form-control-dark" placeholder="搜索评论..." aria-label="Search" name="comment">
        

        
          <button type="submit" class="btn btn-outline-warning">搜索</button>
          
        </div>
        </form>
      </div>
    </div>
  </header>
  <div class="container">




<table class="table table-hover">

  <thead>
    <tr>
      <th scope="col">#</th>
      <th scope="col">姓名</th>
      <th scope="col">评价</th>
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
		<th scope="row"><%=i%></th>
		<td><%=rs.getString("uname") %></td>
		<td><%=rs.getString("comment") %></td>
        <td><a class="btn btn-outline-warning" href="comment.jsp?id=<%=rs.getString("uid")%>" role="button">修改评价</a>
        <a class="btn btn-outline-danger" href="DelCommentServlet?id=<%=rs.getString("uid")%>" role="button">删除评价</a></td>
</tr>
<%
}
%>

  </tbody>
</table>

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