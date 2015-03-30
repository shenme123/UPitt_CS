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
		//���session
		HttpSession session = 
			request.getSession();
		//session.setMaxInactiveInterval(40);
		System.out.println("sessionId:" + session.getId());
		//��session��ȡ�����ʴ���count
		Integer count = (Integer)session.getAttribute("count");
		//����ǵ�һ�η��ʣ���session��û�ж�Ӧ��countֵ��
		//��ʱ��Ӧ�ý�count��Ϊ1��
		if(count == null){
			count = 1;
		}else{
//			������ǵ�һ�Σ���ֻ��Ҫ��count��1����
			count ++;
		}
		session.setAttribute("count", count);
		out.println("���ǵ�:" + count+" �η���");
		//����ɾ��session
		//session.invalidate();
		out.close();
	}

}
