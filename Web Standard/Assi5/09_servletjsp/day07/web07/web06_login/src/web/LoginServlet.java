package web;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.DBUtil;

public class LoginServlet extends HttpServlet {

		public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			Connection conn = null;
			try{
				conn = DBUtil.getConnection();
//				Statement stat = 
//					conn.createStatement();
				String username = request.getParameter("username");
				String pwd = request.getParameter("pwd");
//				String sql = 
//					"select * from t_user " +
//					"where username='" + username 
//					+ "' and pwd='" + pwd + "'";
//				System.out.println("sql:" + sql);
				String sql = "select * from t_user " +
						"where username=? and pwd=?";
				PreparedStatement stat = 
					conn.prepareStatement(sql);
				stat.setString(1, username);
				stat.setString(2, pwd);
				ResultSet rst = stat.executeQuery();
				if(rst.next()){
					System.out.println("µÇÂ¼³É¹¦");
				}else{
					System.out.println("µÇÂ¼Ê§°Ü");
				}
			}catch(Exception e){
				e.printStackTrace();
				throw new ServletException(e);
			}
		
	}

}
