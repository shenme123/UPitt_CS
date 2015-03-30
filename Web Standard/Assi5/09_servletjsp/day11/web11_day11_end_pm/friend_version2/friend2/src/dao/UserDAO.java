package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import util.DBUtil;
import entity.User;

public class UserDAO {
	public int save(User user) throws Exception{
		int id = -1;
		Connection conn = 
			DBUtil.getConnection();
		PreparedStatement prep = 
			conn.prepareStatement(
					"insert into f_user" +
					"(username,name,pwd,age,gender,phone,ask) " +
					"values(?,?,?,?,?,?,?)",
					java.sql.Statement.RETURN_GENERATED_KEYS);
		prep.setString(1, user.getUsername());
		prep.setString(2, user.getName());
		prep.setString(3, user.getPwd());
		prep.setInt(4, user.getAge());
		prep.setString(5, user.getGender());
		prep.setString(6, user.getPhone());
		prep.setString(7, user.getAsk());
		prep.executeUpdate();
		ResultSet rst = prep.getGeneratedKeys();
		if(rst.next()){
			//rst.getInt("id"); error!
			id = rst.getInt(1);
		}
		DBUtil.close(conn);
		return id;
	}
	
	public User findByUsername(String username) 
	throws Exception{
		User user = null;
		Connection conn = 
			DBUtil.getConnection();
		PreparedStatement prep = 
			conn.prepareStatement(
					"select * from f_user where username=?");
		prep.setString(1, username);
		ResultSet rst = prep.executeQuery();
		if(rst.next()){
			user = new User();
			user.setId(rst.getInt("id"));
			user.setUsername(username);
			user.setName(rst.getString("name"));
			user.setAge(rst.getInt("age"));
			user.setGender(rst.getString("gender"));
			user.setPhone(rst.getString("phone"));
			user.setPwd(rst.getString("pwd"));
			user.setAsk(rst.getString("ask"));
		}
		DBUtil.close(conn);
		return user;
	}
	
	public List<User> findAll() throws Exception{
		List<User> users = 
			new ArrayList<User>();
		Connection conn = 
			DBUtil.getConnection();
		Statement stat = conn.createStatement();
		ResultSet rst = stat.executeQuery(
				"select * from f_user");
		while(rst.next()){
			User user = new User();
			user.setId(rst.getInt("id"));
			user.setUsername(rst.getString("username"));
			user.setName(rst.getString("name"));
			user.setAge(rst.getInt("age"));
			user.setGender(rst.getString("gender"));
			user.setPhone(rst.getString("phone"));
			user.setPwd(rst.getString("pwd"));
			user.setAsk(rst.getString("ask"));
			users.add(user);
		}
		DBUtil.close(conn);
		return users;
	}
	
	public User findByUserId(int id) 
	throws Exception{
		User user = null;
		Connection conn = 
			DBUtil.getConnection();
		PreparedStatement prep = 
			conn.prepareStatement(
					"select * from f_user where id=?");
		prep.setInt(1, id);
		ResultSet rst = prep.executeQuery();
		if(rst.next()){
			user = new User();
			user.setId(id);
			user.setUsername(rst.getString("username"));
			user.setName(rst.getString("name"));
			user.setAge(rst.getInt("age"));
			user.setGender(rst.getString("gender"));
			user.setPhone(rst.getString("phone"));
			user.setPwd(rst.getString("pwd"));
			user.setAsk(rst.getString("ask"));
		}
		DBUtil.close(conn);
		return user;
	}
}
