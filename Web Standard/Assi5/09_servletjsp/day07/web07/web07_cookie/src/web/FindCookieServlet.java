package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FindCookieServlet extends HttpServlet {

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		Cookie[] cookies = request.getCookies();
		if(cookies != null){
			//遍历找到的所有的cookie
			for(int i=0;i<cookies.length;i++){
				Cookie curr = cookies[i];
				out.println(curr.getName() + " " 
						+ URLDecoder
						.decode(curr.getValue(),"utf-8" )+ "<br/>");
			}
		}else{
			//没有找到任何的cookie
			out.println("没有找到任何的cookie");
		}
		out.close();
	}

}
