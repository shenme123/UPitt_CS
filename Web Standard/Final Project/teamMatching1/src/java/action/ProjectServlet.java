/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package action;


import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import util.*;
import bean.*;
/**
 *
 * @author xmrui_000
 */
public class ProjectServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ProjectServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ProjectServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
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
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      
        ProjectBean projectBean= new ProjectBean();
        ProposalBean proposalBean = new ProposalBean();
        String method = request.getParameter("method").trim();
        
        if(method.equals("ideaPost")){
            String pname=request.getParameter("pname").trim();
            String p_edate=request.getParameter("p_edate").trim();
            String ts=request.getParameter("teamsize").trim();
            String issueby=request.getParameter("username").trim();
            String proposal=request.getParameter("proposal").trim();
            
            int teamsize=Integer.parseInt(ts);
            
            int flag1=projectBean.addIdea(pname, teamsize, p_edate,issueby,proposal);
			if(flag1==Constant.SUCCESS){
                                int pid=projectBean.getPid(pname);
                                int flag2=proposalBean.getPropFreqUpdate(pid);
                                int flag3=proposalBean.getTagInfoUpdate(pid);
                                
                                int flag=flag2&flag3;
                                
                                if(flag==Constant.SUCCESS){
                                request.setAttribute("message", "Successfully!");
				request.getRequestDispatcher("/main.jsp").forward(request, response);
                                }else{
				request.setAttribute("message", "Oops,Error occurred!");
				request.getRequestDispatcher("/error.jsp").forward(request, response);
			     }
			}
			else{
				request.setAttribute("message", "Oops,Error occurred!");
				request.getRequestDispatcher("/error.jsp").forward(request, response);
			}
		}
        }
        
 }
