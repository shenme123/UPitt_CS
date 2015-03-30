/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import util.*;

/**
 *
 * @author Rui Bi
 */
public class UserBean {

    private List list;
    private ResultSet rs;
    private String date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime());

    public int memberLogin(String username, String password) {

        String sql = "select password from USERINFO where USERNAME='" + username + "'";

        DBO dbo = new DBO();
        dbo.open();
        try {
            rs = dbo.executeQuery(sql);
            if (rs.next()) {
                String str = rs.getString("PASSWORD");
                if (str.trim().equals(password)) {

                    return Constant.STUDENT_LOGIN;
                } else {
                    return Constant.ERROR_STATUS;
                }

            } else {
                return Constant.ERROR_STATUS;
            }

        } catch (Exception e) {
            return Constant.SYSTEM_ERROR;
        } finally {
            dbo.close();
        }
    }

    public int register(String username, String password, String f_name, String l_name, String gender, int tag_1, int tag_2, int tag_3) {
        String sql = "insert into UserInfo(username,password,f_name,l_name,gender,tag_1,tag_2,tag_3)" + " values('" + username + "','" + password + "','" + f_name + "','" + l_name + "','" + gender + "'," + tag_1 + "," + tag_2 + "," + tag_3 + ")";
        DBO dbo = new DBO();
        dbo.open();
        try {
            int i = dbo.executeUpdate(sql);
            if (i == 1) {

                return Constant.SUCCESS;
            } else {
                return Constant.SYSTEM_ERROR;
            }

        } catch (Exception e) {
            return Constant.SYSTEM_ERROR;
        } finally {
            dbo.close();
        }
    }
    
    public int updateUserInfo(int uid,String f_name, String l_name, int tag_1, int tag_2, int tag_3) {
        String sql = "update TEHCTAGINFO set f_name='" + f_name + "',l_name='" + l_name + "',tag_1=" + tag_1 + ",tag_2=" + tag_2 + ",tag_3=" + tag_3 + " where uid=" + uid + " ";
        DBO dbo = new DBO();
        dbo.open();
        try {
            int i = dbo.executeUpdate(sql);
            if (i == 1) {

                return Constant.SUCCESS;
            } else {
                return Constant.SYSTEM_ERROR;
            }

        } catch (Exception e) {
            return Constant.SYSTEM_ERROR;
        } finally {
            dbo.close();
        }
    }
    
    
    public int getUid(String username) {
        String sql = "select uid from UserInfo where username='" + username + "'";
        DBO dbo = new DBO();
        dbo.open();
        try {
            rs = dbo.executeQuery(sql);
            rs.next();
            int uid = rs.getInt("uid");
            return uid;
        } catch (Exception e) {
            return 0;
        } finally {
            dbo.close();
        }
    }

    public String getSname(String username) {
        String sql = "select f_name from UserInfo where username='" + username + "'";
        DBO dbo = new DBO();
        dbo.open();
        try {
            rs = dbo.executeQuery(sql);
            rs.next();
            String f_name = rs.getString("f_name");
            return f_name;
        } catch (Exception e) {
            return null;
        } finally {
            dbo.close();
        }
    }
   
    public String getTagName(int tid) {
        String sql = "select tagname from TEHCTAGINFO where tid="+tid+"";
        DBO dbo = new DBO();
        dbo.open();
        try {
            rs = dbo.executeQuery(sql);
            rs.next();
            String tagname = rs.getString("tagname");
            return tagname;
        } catch (Exception e) {
            return null;
        } finally {
            dbo.close();
        }
    }
    
    
    public List getUserInfo(int uid) {
        String sql = "select f_name,l_name,tag_1,tag_2,tag_3 from UserInfo where uid=" + uid + " ";
        DBO dbo = new DBO();
        list = new ArrayList();
        dbo.open();
        try {
            rs = dbo.executeQuery(sql);
            while (rs.next()) {
            
                list.add(rs.getString(1));
                list.add(rs.getString(2));
                list.add(rs.getString(3));
                list.add(rs.getString(4));
                list.add(rs.getString(5));
             
                
               
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            dbo.close();
        }
    }

    public List getTagInfo() {
        String sql = "select tid,tagName from TEHCTAGINFO";
        DBO dbo = new DBO();
        list = new ArrayList();
        dbo.open();
        try {
            rs = dbo.executeQuery(sql);
            while (rs.next()) {
                List list2 = new ArrayList();
                list2.add(rs.getString(1));
                list2.add(rs.getString(2));
                list.add(list2);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            dbo.close();
        }
    }
    
    
    
    public List getUserTag(int tid) {
        String sql = "select tid,tagname,tfreq from TEHCTAGINFO where tid=" + tid + "";
        DBO dbo = new DBO();
        list = new ArrayList();
        dbo.open();
        try {
            rs = dbo.executeQuery(sql);
            while (rs.next()) {
                List list2 = new ArrayList();
                list2.add(rs.getString(1));
                list2.add(rs.getString(2));
                list2.add(rs.getString(3));
                list.add(list2);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            dbo.close();
        }
    }
}
