package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Find_Add_CookieServlet extends HttpServlet {

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		//先查询有没有一个名称为"userprofile"的cookie
		Cookie[] cookies = request.getCookies();
		if(cookies != null){
			boolean flag = false;
			for(int i=0;i<cookies.length;i++){
				Cookie curr = cookies[i];
				if(curr.getName().equals("userprofile")){
					//找到了，输出其值
					out.println(curr.getValue());
					flag = true;
				}
			}
			if(!flag){
				//没有找到
				Cookie c = new Cookie("userprofile","abc");
				response.addCookie(c);
				out.println("添加cookie成功");
			}
		}else{
			//没有任何的cookie,要创建
			Cookie c = new Cookie("userprofile","abc");
			response.addCookie(c);
			out.println("添加cookie成功");
		}
		out.close();
	}

}
