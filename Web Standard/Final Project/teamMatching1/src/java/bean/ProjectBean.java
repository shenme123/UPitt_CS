package bean;

/**
 *
 * @author Rui Bi
 */

import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import util.*;


public class ProjectBean {
        private List list;
	private ResultSet rs;
	private String date=new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
	
    public int addIdea(String pname,int teamsize,String p_edate,String issueby,String proposal){
	  String p_idate=date;	
          String sql = "insert into PROJECTINFO (pname,teamsize,p_idate,p_edate,issueby,proposal) " +
				"values('"+pname+"','"+teamsize+"','"+p_idate+"','"+p_edate+"','"+issueby+"','"+proposal+"')";
		DBO dbo = new DBO();
		dbo.open();
		try{
			int i = dbo.executeUpdate(sql);
			if(i == 1)
				return Constant.SUCCESS;
			else
				return Constant.SYSTEM_ERROR;
		}catch(Exception e){
			e.printStackTrace();
			return Constant.SYSTEM_ERROR;
		}finally{
			dbo.close();
		}
	}
    
   public int getPid(String pname){
      String sql= "select pid from projectinfo where pname='"+pname+"'";
      DBO dbo = new DBO();
		dbo.open();
		try{
			rs = dbo.executeQuery(sql);
                       rs.next();
                       int pid=rs.getInt(1);
                       return pid;
                       
		}catch(Exception e){
			e.printStackTrace();
			return Constant.SYSTEM_ERROR;
		}finally{
			dbo.close();
		}
   }
    
    public List getProject(){ 
		String sql = "select pid,pname,teamsize,p_idate,p_edate,issueby from PROJECTINFO";
		DBO dbo=new DBO();
		list = new ArrayList();
		dbo.open();
		try{
			
			rs = dbo.executeQuery(sql);
			while(rs.next()){
				List list2=new ArrayList();
				list2.add(rs.getString(1));
				list2.add(rs.getString(2));
				list2.add(rs.getString(3));
				list2.add(rs.getString(4));
				list2.add(rs.getString(5));
				list2.add(rs.getString(6));
				list.add(list2);				
			}
			
			return list;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}finally{
			dbo.close();
		}
	}
    
  
      public List getProposal(){
         String sql = "select pid,proposal from ProjectInfo";
		list = new ArrayList();
		DBO dbo=new DBO();
                dbo.open();
		try{
			
			rs = dbo.executeQuery(sql);
			while(rs.next()){
				List list2=new ArrayList();
				list2.add(rs.getString(1));
				list2.add(rs.getString(2));
				list.add(list2);
			}
			
			return list;
		}catch(Exception e){
			return null;
		}finally{
			dbo.close();
		}	
      }
        
        public int[] getTid(){
                String sql0="select count(tid) as tidCount from Tehctaginfo";
                String sql1="select tid from Tehctaginfo"; 
                DBO dbo = new DBO();
		dbo.open();
                                
		try{
                       
                       rs = dbo.executeQuery(sql0);
                       rs.next();
                       int tidCount=rs.getInt(1);
                       
                       int[] t = null; 
                       int i;
                       for(i=0;i<tidCount;i++)
                       {      
                          rs = dbo.executeQuery(sql1);
                          rs.next();
                          t[i]=rs.getInt(1);
                        }
                      return t;
                     			
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}finally{
			dbo.close();
		}
	}
        
        
     
     
}
