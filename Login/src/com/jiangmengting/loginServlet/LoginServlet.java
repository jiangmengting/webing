package com.jiangmengting.loginServlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jiangmengting.loginDao.UserDao;

public class LoginServlet extends HttpServlet {   //LoginServlet是继承javax.http.HttpServlet的一个类；

	private static final long serialVersionUID = 1L;  //序列化长整型；

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");    //作用是设置对客户端请求进行重新编码的编码；
		response.setContentType("text/html;charset=utf-8");  //设置请求以及响应的内容类型以及编码方式；
		String username = request.getParameter("username");  //获取页面输入框输入的用户名；
		String password = request.getParameter("password");  //获取页面输入框输入的密码；
		String verifyc  = request.getParameter("verifycode"); //获取页面输入框输入的验证码；
		String svc =(String) request.getSession().getAttribute("sessionverify");
		String psw =new UserDao().findUser(username);
		if(!svc.equalsIgnoreCase(verifyc)){   //equalsIgnoreCase()方法用于将字符串与指定的对象比较，不考虑大小写
			request.setAttribute("msg1", "请输入正确的验证码！");
			request.getRequestDispatcher("/index.jsp").forward(request, response);  //request转发 保存数据 但是地址是不调整的 ,response.sendRedirect重定向
			return;
		}
		if(psw ==null){
			request.setAttribute("msg2", "用户名不正确！");
			request.getRequestDispatcher("/index.jsp").forward(request, response);
			return;
		}
		if(psw!=null&&!psw.equals(password)){
			request.setAttribute("msg3", "密码不正确！");
			request.getRequestDispatcher("/index.jsp").forward(request, response);
			return;
		}
		if(psw.equals(password)){
			request.setAttribute("msg", "恭喜您"+username+",您已成功登陆，欢迎浏览！");
			request.getRequestDispatcher("/success.jsp").forward(request, response);
		}
		
	}

}
