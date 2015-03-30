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
		//�Ȳ�ѯ��û��һ������Ϊ"userprofile"��cookie
		Cookie[] cookies = request.getCookies();
		if(cookies != null){
			boolean flag = false;
			for(int i=0;i<cookies.length;i++){
				Cookie curr = cookies[i];
				if(curr.getName().equals("userprofile")){
					//�ҵ��ˣ������ֵ
					out.println(curr.getValue());
					flag = true;
				}
			}
			if(!flag){
				//û���ҵ�
				Cookie c = new Cookie("userprofile","abc");
				response.addCookie(c);
				out.println("���cookie�ɹ�");
			}
		}else{
			//û���κε�cookie,Ҫ����
			Cookie c = new Cookie("userprofile","abc");
			response.addCookie(c);
			out.println("���cookie�ɹ�");
		}
		out.close();
	}

}
