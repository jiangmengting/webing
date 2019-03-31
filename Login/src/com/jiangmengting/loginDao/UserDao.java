package com.jiangmengting.loginDao;

import java.sql.Connection;     //链接数据库所需要的包；
import java.sql.DriverManager;  //连接数据库所需要的包；
import java.sql.PreparedStatement; //预声明；
import java.sql.ResultSet;     //结果集；
import java.sql.SQLException;  //SQL抛出异常所需要的包；

public class UserDao {                 //新建UserDao类；
	
	public String findUser(String username){ //定义一个返回值为字符串的finduser方法 修饰符 返回值类型 方法名(参数类型 参数名)；
		String psw = null;   //初始化密码为空；
		String sql = "select * from user_info where username=?";
		Connection con =getConnection();  
		PreparedStatement pstmt =null;
		ResultSet rs = null;  //固定的数据库连接语句   初始化；
		try {
			pstmt = con.prepareStatement(sql);  //获取连接；
			pstmt.setString(1, username);   //sql语句中的第一个？参数设置string的值userName；
			rs = pstmt.executeQuery();    //返回结果集 ；如果有数据就获取数据；executeQuery()方法是进行查询用的
			if(rs.next()){    // next()将光标向后一行；
				psw=rs.getString("password");
			}else{
				psw=null;
			}
		} catch (SQLException e) {
			e.printStackTrace();          //异常处理，即处理异常代码，输出异常的位置；
		}finally {
			try {
				if(pstmt!=null)pstmt.close();
				if(con!=null)con.close();    //资源释放或状态还原的代码放到finally块中；
			} catch (SQLException e) {		
				e.printStackTrace();
			}      
		}
		return psw;
	}
	public void addUser(String username,String psw)  //定义一个无返回值的addUser方法；
			throws Exception{
		Connection con = getConnection();
		PreparedStatement pstmt =null;   //声明变量pstmt的值为空；
		String sql = "INSERT INTO user_info(username,password) VALUES(?,?)";
		try {
			pstmt = con.prepareStatement(sql);  // 获取连接；
			pstmt.setString(1, username);  //sql语句中的第一个？参数设置string的值userName；
			pstmt.setString(2, psw);  //sql语句中的第二个？参数设置string的值psw；
			pstmt.executeUpdate();  //executeUpdate( )执行数据库的更新操作；
		} 
	finally {
				if(pstmt!=null)pstmt.close();
				if(con!=null)con.close();   //资源释放或状态还原的代码放到finally块中；
			}
	}
	
	public static Connection getConnection(){    //定义一个公共静态的返回值为connection的方法；
		String mydriver ="com.mysql.jdbc.Driver";   //注册JDBC驱动；驱动名为mydriver；
		String url ="jdbc:mysql://localhost:3306/db_user";  //数据库地址；
		String user ="root";  //数据库账号；
		String password ="root";  //数据库密码；
		Connection connection =null;
		try {
			Class.forName(mydriver);   //驱动名；
			connection =DriverManager.getConnection(url, user, password);  //连接数据库；
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}

}
