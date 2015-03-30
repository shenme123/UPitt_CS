package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CommentFilter2 implements Filter{
	private FilterConfig config;
	public void destroy() {
		
	}

	public void doFilter(ServletRequest arg0, 
			ServletResponse arg1, FilterChain arg2) throws IOException, ServletException {
		System.out.println("CommentFilter2's doFilter begin...");
		HttpServletRequest request = 
			(HttpServletRequest)arg0;
		HttpServletResponse response = 
			(HttpServletResponse)arg1;
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String content = request.getParameter("content");
		int size = Integer.parseInt(
				config.getInitParameter("size"));
		if(content.length() > size){
			out.println("your comment size illegal.");
		}else{
			arg2.doFilter(arg0, arg1);
		}
		System.out.println("CommentFilter2's doFilter end.");
	}

	public void init(FilterConfig arg0) throws ServletException {
		//将FilterConfig对象的引用保存下来。		
		config = arg0;
	}

}
