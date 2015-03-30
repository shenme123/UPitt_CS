package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SomeServlet extends HttpServlet {

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		//先获得ServletContext
		ServletContext sctx = getServletContext();
		//绑订数据
		sctx.setAttribute("username", "abc");
		out.println("绑订数据成功");
		String company = sctx.getInitParameter("company");
		out.println(" company:" + company);
		out.close();
	}

}
