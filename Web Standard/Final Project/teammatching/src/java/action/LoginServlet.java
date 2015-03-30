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
import util.*;
import bean.*;
import java.util.List;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

/**
 *
 * @author Rui Bi
 */
public class LoginServlet extends HttpServlet {

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
            out.println("<title>Servlet LoginServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet LoginServlet at " + request.getContextPath() + "</h1>");
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

        HttpSession session = request.getSession();
        UserBean userBean = new UserBean();
        ProposalBean proposalBean = new ProposalBean();
        String method = request.getParameter("method").trim();

        if (method.equals("userLogin")) {
            String username = request.getParameter("username").trim();
            String password = request.getParameter("password").trim();
            int flag = userBean.memberLogin(username, password);

            if (flag == Constant.STUDENT_LOGIN) {
                int uid = userBean.getUid(username);
                String f_name = userBean.getSname(username);
                int flag2 = proposalBean.getRecmdInfo(uid);
                if (flag2 == Constant.SUCCESS) {
                    session.setAttribute("username", username);
                    session.setAttribute("uid", uid);
                    session.setAttribute("f_name", f_name);
                    request.getRequestDispatcher("/index.jsp").forward(request, response);
                } else if (flag == Constant.ERROR_STATUS) {
                    request.setAttribute("username", username);
                    request.setAttribute("message", "Your accounnt has not been verified");
                    request.getRequestDispatcher("/login.jsp").forward(request, response);
                }
            } else if (flag == Constant.ERROR_STATUS) {
                request.setAttribute("username", username);
                request.setAttribute("message", "Your accounnt has not been verified");
                request.getRequestDispatcher("/login.jsp").forward(request, response);
            } else if (flag == Constant.NAME_ERROR) {
                request.setAttribute("username", username);
                request.setAttribute("message", "Username not exist!");
                request.getRequestDispatcher("/login.jsp").forward(request, response);
            } else if (flag == Constant.PASSWORD_ERROR) {
                request.setAttribute("username", username);
                request.setAttribute("message", "Invalid password");
                request.getRequestDispatcher("/login.jsp").forward(request, response);

            }

        } else if (method.equals("register")) {
            String username = request.getParameter("username").trim();
            String f_name = request.getParameter("f_name").trim();
            String l_name = request.getParameter("l_name").trim();
            String password = request.getParameter("password").trim();
            String gender = request.getParameter("gender").trim();
            String t_1 = request.getParameter("tag_1").trim();
            String t_2 = request.getParameter("tag_2").trim();
            String t_3 = request.getParameter("tag_3").trim();
            int tag_1 = Integer.parseInt(t_1);
            int tag_2 = Integer.parseInt(t_2);
            int tag_3 = Integer.parseInt(t_3);

            int flag = userBean.register(username, password, f_name, l_name, gender, tag_1, tag_2, tag_3);
            if (flag == Constant.SUCCESS) {
                int uid = userBean.getUid(username);
                int flag2 = proposalBean.getRecmdInfo(uid);
                if (flag2 == Constant.SUCCESS) {
                    request.setAttribute("message", "Successfully!");

                    request.getRequestDispatcher("/login.jsp").forward(request, response);

                } else {
                    request.setAttribute("message", "Oops,Error occurred!");
                    request.getRequestDispatcher("/error.jsp").forward(request, response);
                }
            } else {
                request.setAttribute("message", "Oops,Error occurred!");
                request.getRequestDispatcher("/error.jsp").forward(request, response);
            }

        } else if (method.equals("updateInfo")) {
            String id = request.getParameter("uid").trim();
            String f_name = request.getParameter("f_name").trim();
            String l_name = request.getParameter("l_name").trim();
            String t_1 = request.getParameter("tag_1").trim();
            String t_2 = request.getParameter("tag_2").trim();
            String t_3 = request.getParameter("tag_3").trim();
            int uid = Integer.parseInt(id);
            int tag_1 = Integer.parseInt(t_1);
            int tag_2 = Integer.parseInt(t_2);
            int tag_3 = Integer.parseInt(t_3);

            int flag = userBean.updateUserInfo(uid, f_name, l_name, tag_1, tag_2, tag_3);
            if (flag == Constant.SUCCESS) {

                int flag2 = proposalBean.getRecmdInfo(uid);
                if (flag2 == Constant.SUCCESS) {
                    request.setAttribute("message", "Successfully!");

                    request.getRequestDispatcher("/userMain.jsp").forward(request, response);

                } else {
                    request.setAttribute("message", "Oops,Error occurred!");
                    request.getRequestDispatcher("/error.jsp").forward(request, response);
                }
            } else {
                request.setAttribute("message", "Oops,Error occurred!");
                request.getRequestDispatcher("/error.jsp").forward(request, response);
            }

        } else if (method.equals("exit")) {
            session.removeAttribute("username");
            session.removeAttribute("type");

            request.getRequestDispatcher("/login.jsp").forward(request, response);

        } else {
            request.getRequestDispatcher("/error.jsp").forward(request, response);
        }
    }

}
