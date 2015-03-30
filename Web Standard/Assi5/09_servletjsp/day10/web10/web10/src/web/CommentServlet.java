package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CommentServlet extends HttpServlet {

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("service begin...");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String content = request.getParameter("content");
//		if(content.indexOf("dog") >=0){
//			out.println("your comment is illegal.");
//		}else{
//			out.println("your comment is " + content);
//		}
		out.println("your comment is " + content);
		out.close();
		System.out.println("service end.");
	}

}
