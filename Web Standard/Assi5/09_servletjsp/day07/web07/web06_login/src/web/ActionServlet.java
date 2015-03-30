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
			//首先要查看用户名是否存在，如果存在，
			//则提示用户换一个用户名，否则，插入相应的记录
			//,并跳转到登录页面
			String username = request.getParameter("username");
			UserDAO dao = new UserDAO();
			try {
				User user = dao.findByUsername(username);
				if(user != null){
					//用户名存在，提示用户换一个
					request.setAttribute("regist_error", 
							"用户名已经存在");
					request.getRequestDispatcher("regist.jsp")
					.forward(request, response);
				}else{
					//插入记录
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
					//登录成功,跳转到主功能页面
					response.sendRedirect("main.jsp");
				}else{
					//登录失败: 用户名不存在，或者密码不匹配。
					request.setAttribute("login_error", 
							"用户名或者密码错误");
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
