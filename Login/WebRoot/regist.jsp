<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>"> 
    <title>注册页面</title>
  </head>
  
  <body style="background-color:#8FBC8F;background-size:cover; ">
  <center>
    <div  style="position:fixed;left:40%;top:40%;">
    <h1>注册用户</h1>
    <form action="RegistServlet" method="post">    <!-- 向RegistServlet提交数据 -->
		    输入帐号：<input type="text" name="username"><br/>
		    输入密码：<input type="password" name="password"><br/>
		    确认密码：<input type="password" name="rpsw"><br/>
		    <p></p>
	      <input type="submit" value="注&nbsp;&nbsp;册">
    </form>
   	<font color="red" size="4"> ${msg }</font>
    </div>
    </center>
  </body>
</html>
