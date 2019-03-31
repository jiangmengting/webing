package com.jiangmengting.loginServlet;

import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jiangmengting.utils.VerifyCode;


public class VerifyCodeServlet extends HttpServlet {     //VerifyCodeServlet是继承javax.http.HttpServlet的一个类；

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		VerifyCode vc = new VerifyCode(); //创建验证码类
		BufferedImage image = vc.getImage(90,30);   //图片宽度90，高度30；获取随机图片
		request.getSession().setAttribute("sessionverify", vc.getText());  //获取刚刚生成的随机图片上的文本,在调用了getImage()方法之后才能使用
		VerifyCode.output(image, response.getOutputStream());

	}

}
