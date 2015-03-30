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
/**
 * 容器在启动时，会创建过滤器实例，接下来，会调用
 * 过滤器的init方法，在调用该方法的时候，会先创建好
 * 符合FilterConfig接口的一个对象，可以通过该对象的
 * String getInitPararmeter(String paraName)方法来
 * 访问过滤器的初始化参数。
 * 
 * 当容器收到请求后，会调用过滤器的doFilter方法,此时，
 * 容器会将request,response对象作为参数传递给过滤器。
 * 过滤器可以调用这两个对象(比如可以通过request对象
 * 获得请求参数)。只有执行FilterChain的doFilter方法，
 * 容器才会调用后续的过滤器。
 * 
 * 当容器不再需要过滤器，会在删除过滤器之前，先调用
 * destroy方法。
 * 
 *过滤器实例只有一个。
 */
public class CommentFilter1 implements Filter{
	
	public CommentFilter1() {
		System.out.println("CommentFilter1's constructor...");
	}

	public void destroy() {
		
	}

	public void doFilter(ServletRequest arg0,
			ServletResponse arg1, FilterChain arg2) 
	throws IOException, ServletException {
		System.out.println("CommentFilter1's doFilter begin...");
		HttpServletRequest request = 
			(HttpServletRequest)arg0;
		HttpServletResponse response = 
			(HttpServletResponse)arg1;
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String content = request.getParameter("content");
		if(content.indexOf("dog") >=0){
			out.println("your comment is illegal.");
		}else{
			//调用后续的过滤器。
			arg2.doFilter(arg0, arg1);
		}
		System.out.println("CommentFilter1's doFilter end.");
	}

	public void init(FilterConfig arg0) throws ServletException {
		System.out.println("CommentFilter1's init...");
	}

}
