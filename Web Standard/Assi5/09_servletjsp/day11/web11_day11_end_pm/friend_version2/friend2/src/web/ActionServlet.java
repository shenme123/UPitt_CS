package web;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import dao.PicDAO;
import dao.UserDAO;
import entity.Pic;
import entity.User;

public class ActionServlet extends HttpServlet {

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String uri = request.getRequestURI();
		String action = uri.substring(
				uri.lastIndexOf("/"),uri.lastIndexOf("."));
		if(action.equals("/regist")){
			//先进行验证码的检验
			//用户名是否存在
			String username = request.getParameter("username");
			UserDAO dao = new UserDAO();
			try {
				User user = dao.findByUsername(username);
				if(user != null){
					request.setAttribute(
							"regist_error", "用户名已经存在");
					request.getRequestDispatcher("regist.jsp")
					.forward(request, response);
				}else{
					user = new User();
					//populate方法：会依据Map中的key
					//去给user对象对应的属性赋值。
					BeanUtils.populate(user, 
							request.getParameterMap());
					int id = dao.save(user);
					//为用户新建一个用来保存文件的文件加
					String path = 
						getServletContext().getRealPath("upload");
					File file = new File(path + "\\" + "pic_" + id);
					if(!file.exists())
						file.mkdirs();
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
				if(user !=null && user.getPwd().equals(pwd)){
					//登录成功
					HttpSession session = 
						request.getSession();
					session.setAttribute("user", user);
					response.sendRedirect("list.do");
				}else{
					request.setAttribute("login_error",
							"用户名或密码出错");
					request.getRequestDispatcher("login.jsp")
					.forward(request, response);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(action.equals("/list")){
			UserDAO dao = new UserDAO();
			try {
				List<User> users = dao.findAll();
				request.setAttribute("users", users);
				request.getRequestDispatcher("user_list.jsp")
				.forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
				throw new ServletException(e);
			}
		}else if(action.equals("/userDetail")){
			int id = Integer.parseInt(request.getParameter("id"));
			UserDAO dao = new UserDAO();
			PicDAO dao2 = new PicDAO();
			try {
				User user = dao.findByUserId(id);
				List<Pic> pics = dao2.findPics(id);
				request.setAttribute("user", user);
				request.setAttribute("pics", pics);
				request.getRequestDispatcher("userDetail.jsp")
				.forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
				throw new ServletException(e);
			}
			
		}else if(action.equals("/upload")){
			int userId = Integer.parseInt(request.getParameter("id"));
			DiskFileItemFactory factory = 
				new DiskFileItemFactory();
			ServletFileUpload sfu = 
				new ServletFileUpload(factory);
			try {
				List<FileItem> items = 
					sfu.parseRequest(request);
				for(int i=0;i<items.size();i++){
					FileItem curr = items.get(i);
					if(curr.isFormField()){
						//
					}else{
						String path = 
							getServletContext().getRealPath("upload");
						String fileName = curr.getName();
						//在某些操作系统上，fileName会包含有路径
						fileName = fileName.substring(
								fileName.lastIndexOf("/") + 1);
						curr.write(new File(path + "\\"
								+ "pic_"+ userId + "\\" + fileName));
						System.out.println("fileName:" + fileName);
						//另外，还要将上传的照片文件名称保存到数据库
						PicDAO dao = new PicDAO();
						Pic pic = new Pic();
						pic.setPicName(fileName);
						pic.setUserId(userId);
						dao.save(pic);
						response.sendRedirect(
								"userDetail.do?id=" + userId);
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}else if(action.equals("/logout")){
			HttpSession session = 
				request.getSession();
			session.invalidate();
			response.sendRedirect("login.jsp");
		}
	}

}
