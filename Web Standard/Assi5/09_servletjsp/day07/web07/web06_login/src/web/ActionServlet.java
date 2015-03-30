package web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.MD5Util;

import dao.UserDAO;
import entity.User;

public class ActionServlet extends HttpServlet {

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String uri = request.getRequestURI();
		String action = uri.substring(
				uri.lastIndexOf("/"),uri.lastIndexOf("."));
		if(action.equals("/regist")){
			//����Ҫ�鿴�û����Ƿ���ڣ�������ڣ�
			//����ʾ�û���һ���û��������򣬲�����Ӧ�ļ�¼
			//,����ת����¼ҳ��
			String username = request.getParameter("username");
			UserDAO dao = new UserDAO();
			try {
				User user = dao.findByUsername(username);
				if(user != null){
					//�û������ڣ���ʾ�û���һ��
					request.setAttribute("regist_error", 
							"�û����Ѿ�����");
					request.getRequestDispatcher("regist.jsp")
					.forward(request, response);
				}else{
					//�����¼
					user = new User();
					user.setUsername(username);
					user.setPwd(
							MD5Util.encrypt(
									request.getParameter("pwd")));
					user.setAge(
							Integer.parseInt(
									request.getParameter("age")));
					dao.save(user);
					response.sendRedirect("login.jsp");
				}
			} catch (Exception e) {
				e.printStackTrace();
				throw new ServletException(e);
			}
		}else if(action.equals("/login")){
			String username = request.getParameter("username");
			String pwd = request.getParameter("pwd");
			UserDAO dao = new UserDAO();
			try {
				User user = dao.findByUsername(username);
				if(user != null && user.getPwd().equals(
						MD5Util.encrypt(pwd))){
					//��¼�ɹ�,��ת��������ҳ��
					response.sendRedirect("main.jsp");
				}else{
					//��¼ʧ��: �û��������ڣ��������벻ƥ�䡣
					request.setAttribute("login_error", 
							"�û��������������");
					request.getRequestDispatcher("login.jsp")
					.forward(request, response);
				}
			} catch (Exception e) {
				e.printStackTrace();
				throw new ServletException(e);
			}
		}
		
	}

}
