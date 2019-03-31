package com.jiangmengting.utils;
import java.awt.Color;  //创建用户界面和绘制图形图像颜色；
import java.awt.Font;   //提供与字体相关的类和接口；
import java.awt.Graphics2D;  //使用Graphics2D类实现JAVA绘图；
import java.awt.image.BufferedImage;  //创建用户界面和绘制图形图像；
import java.io.IOException;  //发生I/O错误时引发的异常类；
import java.io.OutputStream;   //用OutPutStream类完成文件内容输出；
import java.util.Random;   //用于生成伪随机数；
import javax.imageio.ImageIO;  //读写图片的类；


public class VerifyCode {


	public static final char[] CHARS = { '1','2', '3', '4', '5', '6', '7', '8',
			'9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'J', 'K', 'L', 'M',
			'N','O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };

	public static Random random = new Random();

	public String getRandomString() {
		StringBuffer buffer = new StringBuffer();
		int index;   //获取随机CHARS下标；
		for (int i = 0; i < 4; i++) {
			index = random.nextInt(CHARS.length);  //获取随机CHARS下标
            buffer.append(CHARS[index]);  //往动态字符串数组中添加；
		}
		return buffer.toString();
	}//生成一串随机字符串，返回字符串；
	public  Color getRandomColor() {
		return new Color(random.nextInt(255), random.nextInt(255), random
				.nextInt(255));    //生成一个随机的int值，0到255之间，包含0但不包含255；
	}

	public  Color getReverseColor(Color c) {
		return new Color(255 - c.getRed(), 255 - c.getGreen(), 255 - c
				.getBlue());
	}
	String text = getRandomString();
	public String getText() {   //getText()获取文本的方法；
		return text;
	}

	public BufferedImage getImage(int width,int height ){
		Color color = getRandomColor();  //随机色，用于背景色
		Color reverse = getReverseColor(color); //反色，用于前景色
		BufferedImage bimage = new BufferedImage(width, height,  //创建图片缓存区 传参为宽高和图片类型；
				BufferedImage.TYPE_INT_RGB);   //创建一个BufferedImage对象；参数：宽度，高度，8 位 RGB 颜色分量
		Graphics2D g = bimage.createGraphics();  //创建Graphics对象,其作用相当于画笔
		g.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 20));  //设置字体样式 font(字体为SansSerif,加粗,字号为20号
		g.setColor(color);  //设置画笔颜色；
		g.fillRect(0, 0, width, height);  //填充矩形的起始X坐标，起始Y坐标，宽度，高度 绘制背景
		g.setColor(reverse);  //设置前景色；画笔颜色
		g.drawString(text, 10, 22);  //x坐标10，Y坐标22；绘制字符
		for (int i = 0, n = random.nextInt(100); i < n; i++) {   //设置最多100个噪音点
			g.drawRect(random.nextInt(width), random.nextInt(height), 1, 1);
		}
		return bimage;
		
	}
	public static void output(BufferedImage image, OutputStream out) throws IOException{
		ImageIO.write(image, "JPEG", out);  //将图片写入指定文件
	}

}

