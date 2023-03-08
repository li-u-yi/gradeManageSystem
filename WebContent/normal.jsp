<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.sql.ResultSet" %>
<%@page import="java.sql.Connection" %>
<%@page import="java.sql.Statement" %>
<%@page import="java.sql.DriverManager" %>
<%@page import="com.ly.utils.JDBCUtils" %>
<%@page import="java.sql.PreparedStatement"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>员工管理页面</title>
<link href="https://cdn.jsdelivr.net/npm/@bootcss/v3.bootcss.com@1.0.20/dist/css/bootstrap.min.css" rel="stylesheet">
 <!-- Bootstrap theme -->
    <link href="https://cdn.jsdelivr.net/npm/@bootcss/v3.bootcss.com@1.0.20/dist/css/bootstrap-theme.min.css" rel="stylesheet">
    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <link href="https://cdn.jsdelivr.net/npm/@bootcss/v3.bootcss.com@1.0.20/assets/css/ie10-viewport-bug-workaround.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="https://cdn.jsdelivr.net/npm/@bootcss/v3.bootcss.com@1.0.20/examples/theme/theme.css" rel="stylesheet">
</head>
<body>
	<% 
  		//String userid = (String) request.getParameter("userid");
	String userid="";
	Cookie[] cookies=request.getCookies();
	
	
	if(cookies!=null){
		//遍历cookies数组？
		for(Cookie cookie : cookies){
			String name=cookie.getName();
				if("userid".equals(cookie.getName())){
					userid=cookie.getValue();
					}
				
		}
	}
	
  		%>
  		
  <%
	try{ 
		//加载驱动
		Connection conn=JDBCUtils.getConnection();
		String str="select role,uid,uname,age,department,position,date from worker where uid = '"+ userid + "'";
		PreparedStatement stmt = conn.prepareStatement(str);
		
		ResultSet rs=stmt.executeQuery(str);
		while(rs.next()){
	%>

	<div class="list-group">
  <a href="workerInsert.jsp?id=<%=rs.getInt(" list-group-item">姓名:	<%=rs.getString("uname")%>
  <a type="button" class="btn btn-danger btn-sm" style="float:right" href="DelServlet?id=<%=rs.getInt("uid")%>&x=uname">删除</a>
  <a type="button" class="btn btn-secondary btn-sm" style="float:right" href="workerUpdate.jsp?id=<%=rs.getInt(" button" class="btn btn-danger btn-sm" style="float:right" href="DelServlet?id=<%=rs.getInt("uid")%>&x=age">删除</a>
  <a type="button" class="btn btn-secondary btn-sm" style="float:right" href="workerUpdate.jsp?id=<%=rs.getInt(" button" class="btn btn-danger btn-sm" style="float:right" href="DelServlet?id=<%=rs.getInt("uid")%>&x=department">删除</a>
  <a type="button" class="btn btn-secondary btn-sm" style="float:right" href="workerUpdate.jsp?id=<%=rs.getInt(" button" class="btn btn-danger btn-sm" style="float:right" href="DelServlet?id=<%=rs.getInt("uid")%>&x=position">删除</a>
  <a type="button" class="btn btn-secondary btn-sm" style="float:right" href="workerUpdate.jsp?id=<%=rs.getInt(" button" class="btn btn-danger btn-sm" style="float:right" href="DelServlet?id=<%=rs.getInt("uid")%>&x=date">删除</a>
  <a type="button" class="btn btn-secondary btn-sm" style="float:right" href="workerUpdate.jsp?id=<%=rs.getInt(" navbar navbar-default" role="navigation">
    <div class="container-fluid">
    <div class="navbar-header">
        <a class="navbar-brand" >管理员查询</a>
    </div>
    <div>
        <form class="navbar-form navbar-right" role="search" action="manager_search.jsp">
        	<div class="form-group">
        	<a class="navbar-brand" >查询条件：</a>
        	<select class="navbar-text" name="x">
			 <option value ="uname">姓名</option>
			  <option value ="uid">工号</option>
			  <option value ="age">年龄</option>
			  <option value="department">部门</option>
			  <option value="position">职位</option>
			  <option value="date">入职时间</option>
			  </select>
        	</div>
            <div class="form-group">
                <input type="text" class="form-control" placeholder="Search" name="value">
            </div>
            <button type="submit" class="btn btn-default">查询</button>
        </form>
        
    </div>
    </div>
</nav>

<%  }
	}
	JDBCUtils.close(rs,stmt,conn);
	//rs.close();
	//stmt.close();
	//conn.close();
	}catch(Exception e){
		e.printStackTrace();
	}
%>
</body>
</html>