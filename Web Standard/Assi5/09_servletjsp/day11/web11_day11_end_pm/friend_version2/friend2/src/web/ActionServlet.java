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
			//�Ƚ�����֤��ļ���
			//�û����Ƿ����
			String username = request.getParameter("username");
			UserDAO dao = new UserDAO();
			try {
				User user = dao.findByUsername(username);
				if(user != null){
					request.setAttribute(
							"regist_error", "�û����Ѿ�����");
					request.getRequestDispatcher("regist.jsp")
					.forward(request, response);
				}else{
					user = new User();
					//populate������������Map�е�key
					//ȥ��user�����Ӧ�����Ը�ֵ��
					BeanUtils.populate(user, 
							request.getParameterMap());
					int id = dao.save(user);
					//Ϊ�û��½�һ�����������ļ����ļ���
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
					//��¼�ɹ�
					HttpSession session = 
						request.getSession();
					session.setAttribute("user", user);
					response.sendRedirect("list.do");
				}else{
					request.setAttribute("login_error",
							"�û������������");
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
						//��ĳЩ����ϵͳ�ϣ�fileName�������·��
						fileName = fileName.substring(
								fileName.lastIndexOf("/") + 1);
						curr.write(new File(path + "\\"
								+ "pic_"+ userId + "\\" + fileName));
						System.out.println("fileName:" + fileName);
						//���⣬��Ҫ���ϴ�����Ƭ�ļ����Ʊ��浽���ݿ�
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
