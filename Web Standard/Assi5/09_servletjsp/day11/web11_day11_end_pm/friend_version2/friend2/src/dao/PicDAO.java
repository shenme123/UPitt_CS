package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import util.DBUtil;
import entity.Pic;

public class PicDAO {
	public void save(Pic pic) throws Exception{
		Connection conn = 
			DBUtil.getConnection();
		PreparedStatement prep = 
			conn.prepareStatement(
					"insert into f_pic(picName,userId) " +
					"values(?,?)");
		prep.setString(1, pic.getPicName());
		prep.setInt(2, pic.getUserId());
		prep.executeUpdate();
		DBUtil.close(conn);
	}
	
	public List<Pic> findPics(int userId) throws Exception{
		List<Pic> pics = 
			new ArrayList<Pic>();
		Connection conn = 
			DBUtil.getConnection();
		PreparedStatement prep = 
			conn.prepareStatement(
					"select * from f_pic where userId=?");
		prep.setInt(1, userId);
		ResultSet rst = prep.executeQuery();
		while(rst.next()){
			Pic pic = new Pic();
			pic.setPicName(rst.getString("picName"));
			pic.setId(rst.getInt("id"));
			pic.setUserId(userId);
			pics.add(pic);
		}
		DBUtil.close(conn);
		return pics;
	}
}
