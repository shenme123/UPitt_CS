package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CountServlet extends HttpServlet {

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		//获得session
		HttpSession session = 
			request.getSession();
		//session.setMaxInactiveInterval(40);
		System.out.println("sessionId:" + session.getId());
		//从session中取出访问次数count
		Integer count = (Integer)session.getAttribute("count");
		//如果是第一次访问，则session中没有对应的count值，
		//此时，应该将count置为1。
		if(count == null){
			count = 1;
		}else{
//			如果不是第一次，则只需要将count加1即可
			count ++;
		}
		session.setAttribute("count", count);
		out.println("你是第:" + count+" 次访问");
		//立即删除session
		//session.invalidate();
		out.close();
	}

}
