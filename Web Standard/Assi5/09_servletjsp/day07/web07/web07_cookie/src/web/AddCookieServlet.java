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
		//����cookie
		String username = "С��";
		//encode:��username����utf-8���б��룬����֮��
		//��õ�һ���ֽ����飬�÷����������Ὣ����ֽ�����
		//ת����һ���ַ��������� %AF%84%F8...
		username = URLEncoder.encode(username,"utf-8");
		Cookie c = new Cookie("username",username);
		//c.setMaxAge(50);
		response.addCookie(c);
		Cookie c2 = new Cookie("addr","beijing tarena");
		response.addCookie(c2);
		out.println("���cookie�ɹ�");
		out.close();
	}

}
