<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();    
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";  
%>
<!-- 获取web项目的根路径，返回协议的名称 ；获取你的服务器的名称；获取应用使用的端口；--> 
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
 <head>
 <base href="<%=basePath%>">          
<LINK REL=STYLESHEET TYPE="text/css" HREF="mylogin.css">
    <title>测试部欢迎您</title>
</head>	
  <body>
	<div id="main">
		<center><h1>测试部登陆</h1></center>
		<form action="LoginServlet" method="post">     <!--form表单，提交后，会跳转到LoginServlet，采用的方式是post--> 
			<table id="basic-table" >
				<tr>
					<td width="110" align="right"><font size="5">账&nbsp;&nbsp;号：</font></td>
					<td colspan="2"><input type="text" name="username" value="${username }"/></td>   <!-- 设置单元格可横跨的列数2 -->
					<td><font color="red" size="2"> ${msg2 }</font></td>   <!--font标签设置 文本的尺寸、字体和颜色 -->
				</tr>
				<tr>
					<td align="right"><font size="5">密&nbsp;&nbsp;码：</font></td>
					<td colspan="2"><input type="password" name="password" /></td>
					<td><font color="red" size="2"> ${msg3 }</font></td>
				</tr>
				<tr>
					<td align="right"><font size="5">验证码：</font></td>
				    <td width="110px" valign="middle"><input type="text" name="verifycode" /></td>
				    <td width="90px" valign="middle"><img src="VerifyCodeServlet" id="verify" alt="若看不清，则点击图片"  title="若看不清，则点击图片"  onclick="document.getElementById('verify').src='VerifyCodeServlet?'+Math.random();"></td>
					<td><font color="red" size="2"> ${msg1 }</font></td>
				</tr>
				<tr>
					<td>&nbsp;</td>
					<td colspan="2" align="center"><input type="submit" value="登&nbsp;&nbsp;录" /></td>
				</tr>
			</table>
			<a href="regist.jsp">还没有账号，点击注册</a>
		</form>
	</div>
  </body>
</html>
