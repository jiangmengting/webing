package com.jiangmengting.loginServlet;

import java.io.IOException;
//import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jiangmengting.loginDao.UserDao;

public class RegistServlet extends HttpServlet {   //RegistServlet是继承javax.http.HttpServlet的一个类；

	private static final long serialVersionUID = 1L;  //序列化长整型；

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");  //作用是设置对客户端请求进行重新编码的编码；
		response.setContentType("text/html;charset=utf-8");  //设置请求以及响应的内容类型以及编码方式；
		String username = request.getParameter("username"); //获取页面输入框输入的用户名；
		String password = request.getParameter("password"); //获取页面输入框输入的密码；
		String rpsw = request.getParameter("rpsw");  //获取页面输入框输入的确认密码；
		if(username==null||username.trim().isEmpty()){    //输入为空格也判断为空；
			request.setAttribute("msg", "用户名不能为空！");   //用于servlet页面传递参数给jsp；
			request.getRequestDispatcher("/regist.jsp").forward(request, response);   //将客户端的请求转向（forward）到getRequestDispatcher（）方法中参数定义的页面；
			return;
		}
		if(password==null||password.trim().isEmpty()){   //去掉字符串前后的空格，密码为空；
			request.setAttribute("msg", "密码为空！");  //setAttribute用于传递参数给jsp；
			request.getRequestDispatcher("/regist.jsp").forward(request, response);  //将客户端的请求转向（forward）到getRequestDispatcher（）方法中参数定义的页面；
			return;
		}
		if(!password.equals(rpsw)){   //密码和确认密码两个字符串不相等；
			request.setAttribute("msg", "两次密码输入不一致！");
			request.getRequestDispatcher("/regist.jsp").forward(request, response);  //将客户端的请求转向（forward）到getRequestDispatcher（）方法中参数定义的页面；
			return;
		}
		UserDao u = new UserDao();     
		try {
			u.addUser(username,password);   //调用Dao方法插入数据；
			request.setAttribute("msg", "恭喜您"+username+"注册成功！");
			request.getRequestDispatcher("/resuccess.jsp").forward(request, response);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			//e1.printStackTrace();
			request.setAttribute("msg", "该用户名已被注册，不能重复注册！");
			request.getRequestDispatcher("/regist.jsp").forward(request, response);
		}			
	}

}
