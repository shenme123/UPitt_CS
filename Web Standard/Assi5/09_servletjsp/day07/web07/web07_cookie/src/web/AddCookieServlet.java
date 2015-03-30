package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddCookieServlet extends HttpServlet {

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		//创建cookie
		String username = "小花";
		//encode:将username按照utf-8进行编码，编码之后
		//会得到一个字节数组，该方法接下来会将这个字节数组
		//转换成一个字符串，形如 %AF%84%F8...
		username = URLEncoder.encode(username,"utf-8");
		Cookie c = new Cookie("username",username);
		//c.setMaxAge(50);
		response.addCookie(c);
		Cookie c2 = new Cookie("addr","beijing tarena");
		response.addCookie(c2);
		out.println("添加cookie成功");
		out.close();
	}

}
