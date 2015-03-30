package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import util.DBUtil;
import entity.User;

public class UserDAO {
	public User findByUsername(String username) 
	throws Exception{
		User user = null;
		Connection conn = null;
		try{
			conn = DBUtil.getConnection();
			PreparedStatement prep = 
				conn.prepareStatement("select * from " +
						"t_user where username=?");
			prep.setString(1, username);
			ResultSet rst = prep.executeQuery();
			if(rst.next()){
				user = new User();
				user.setId(rst.getInt("id"));
				user.setUsername(username);
				user.setPwd(rst.getString("pwd"));
				user.setAge(rst.getInt("age"));
			}
		}catch(Exception e){
			e.printStackTrace();
			throw e;
		}finally{
			DBUtil.close(conn);
		}
		return user;
	}
	
	public void save(User user) throws Exception{
		Connection conn = null;
		try{
			conn = DBUtil.getConnection();
			PreparedStatement prep = 
				conn.prepareStatement(
						"insert into t_user(username,pwd,age) " +
						"values(?,?,?)");
			prep.setString(1, user.getUsername());
			prep.setString(2, user.getPwd());
			prep.setInt(3, user.getAge());
			prep.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
			throw e;
		}finally{
			DBUtil.close(conn);
		}
	}
	
	
	
	
	
	
}
