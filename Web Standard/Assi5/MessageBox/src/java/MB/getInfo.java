/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package MB;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
/**
 *
 * @author Administrator
 * this class is main of the messagebox
 */
public class getInfo extends HttpServlet {

    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        //get Username and set the session
        if (request.getSession().getAttribute("UserName") == null) {
            request.getSession().setAttribute("UserName", request.getParameter("UserName"));
        }
        out.print("<html><head><title>MessageBox:"+request.getSession().getAttribute("UserName") +"</title></head><body>");
        out.print("<table width=100%>");
        int CurrentPage=Integer.parseInt(request.getParameter("page"));
        try {
                        DAL opDal=new DAL();
                        //if get act value equal add, we can do add one message info to the database
			if(request.getParameter("act").equals("add")){
                            //change \n to <br /> is because to present \n in the html page
                            opDal.nonQueryExecute("insert into Message(H_User,H_Chat,H_Time) values('"+request.getSession().getAttribute("UserName") +"','"+request.getParameter("Info").replaceAll("\n", "<br />") +"',#"+ new Date(System.currentTimeMillis())+" "+new Time(System.currentTimeMillis()) +"#)");
                            //redirect just avoid repeated post if user refresh the page
                            response.sendRedirect("getInfo?act=view&page=1");
                        }
                        String sql="";
                        //the following is divide page sql, now we have the first page, the second page and so on
                        if(CurrentPage==1){
                            sql="select top "+CurrentPage*20+" * from Message order by id desc";
                        }else{
                            sql="select top 20 * from Message where id not in ( select top "+(CurrentPage-1)*20+" id from Message order by id desc) order by id desc";
                        }
                        //cite the DAL layout to operate database
                        ResultSet rs=opDal.QueryExecute(sql);
			while (rs.next()) {
                            out.print("<tr>");
                            out.print("<td style=\"color:Green;width:10%\">");
                            out.println(rs.getString("H_User"));
                            out.println(":");
                            out.print("</td>");
                            out.print("<td style=\"color:Red\">");
                            out.println(rs.getString("H_Chat"));
                            out.print("</td>");
                            out.print("<td style=\"width:20%\">");
			    out.println(rs.getString("H_Time"));
                            out.print("</td>");
                            out.print("</tr>");
			}
                        //cite the DAL layout to operate database
                        ResultSet rs_navi=opDal.QueryExecute("select count(*) as Count from Message");
                        if(rs_navi.next()){
                            out.print("<tr><td colspan=\"3\">");
                            int Count=Integer.valueOf(rs_navi.getString("Count"))/20;
                            for(int i=1;i<=(1+Count);i++){
                                out.print("<a href=getInfo?act=view&page="+i+">"+i+"</a> ");
                            }
                            out.print("</td></tr>");
                        }
                        //dispose the resource
                        opDal.Dispose();
        }catch(Exception e){
            out.print(e.getMessage());
        } 
        finally {   
            out.print("</table>");
            //add form to post info
            out.print("<form method=\"post\" action=\"getInfo?page="+CurrentPage+"&act=add\"><textarea name=\"Info\" cols=\"100\" rows=\"5\"></textarea><br /><input type=\"submit\" value=\"Submit\" /></form>");
            out.print("<a href=\".\">Return</a>");
            out.print("</body></html>");
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
