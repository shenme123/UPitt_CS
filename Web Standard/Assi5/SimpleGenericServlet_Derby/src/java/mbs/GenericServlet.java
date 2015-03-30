/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mbs;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;
import java.sql.*;

/**
 *
 * @author spring
 */
public class GenericServlet extends HttpServlet {

  private Connection conn;
  private Statement st;

  /**
   * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
   * @param request servlet request
   * @param response servlet response
   * @throws ServletException if a servlet-specific error occurs
   * @throws IOException if an I/O error occurs
   */
  public void init() {
    try {
      Class.forName("org.apache.derby.jdbc.ClientDriver"); 
      String connectionURL = "jdbc:derby://localhost:1527/Table_Metadata";
      conn = DriverManager.getConnection(connectionURL, "TEST", "TEST");
    } catch (SQLException se) {
      se.printStackTrace();
    } catch (ClassNotFoundException ex) {
          ex.printStackTrace();
      }

  }
/**  example of a dbms create statement
     *  number VARCHAR(40)  NOT NULL,
     *  name   VARCHAR(100) NOT NULL,
     *  ssn    VARCHAR(50)  NOT NULL,
     *  age    INTEGER      NOT NULL,
     *  CONSTRAINT cust_pk PRIMARY KEY (number),
     *  UNIQUE ( ssn ), // (An anonymous constraint)
     *  CONSTRAINT age_check CHECK (age >= 0 AND age < 200
     *  )
     */
  protected void processRequest(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    boolean ctable=false, irecord=false;
    String fieldstr = new String(), valuestr = new String();
    String cfieldstr = new String(), tablename = new String();
    // get the names of the parameters
    Enumeration pNames = request.getParameterNames();
    // pull out names that begin with table or db
    while (pNames.hasMoreElements()) {
      String pName = (String) pNames.nextElement();
      String pValue;
      if (pName.startsWith("table")) {
        tablename = request.getParameter(pName);
      } else if (pName.startsWith("db")){
        String[] pValues = request.getParameterValues(pName);
        if (pValues.length == 1) {
          pValue = pValues[0];
          if (pValue.length() == 0) {
            pValue = new String("No Value");
          }
        } else {
          pValue = new String();
          for (int i = 0; i < pValues.length; i++) {
            pValue += pValues[i] + ", ";
          }
          pValue = pValue.substring(0, pValue.length()-2);
        }
        fieldstr += pName + ", ";
        cfieldstr += pName + " VARCHAR(100) NOT NULL, ";
        valuestr += "'" + pValue + "',";
      }
    }
    // remove extra characters from strings
    cfieldstr = cfieldstr.substring(0, cfieldstr.length() - 2);
    fieldstr = fieldstr.substring(0, fieldstr.length() - 2);
    valuestr = valuestr.substring(0, valuestr.length() - 1);

    try {
      //check metadata for table
      DatabaseMetaData dbm = conn.getMetaData();
      ResultSet tables = dbm.getTables(null, null, tablename, null);
      //if table doesn't exist, create it
      if (!tables.next()) {
        String ct = new String("CREATE TABLE " + tablename
                + " ( " + cfieldstr + ")");
        st = conn.createStatement();        
        st.execute(ct);
        ctable =true;
      }
      // insert the record into the table
      String ir = new String("INSERT INTO " + tablename
              + "( " + fieldstr + ") VALUES (" + valuestr + ")");
       st = conn.createStatement();
       st.execute(ir);
       irecord=true;
    } catch (SQLException se) {
      se.printStackTrace();
    }
    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();
    try {
      // TODO output your page here
      out.println("<html>");
      out.println("<head>");
      out.println("<title>Servlet GenericServlet</title>");
      out.println("</head>");
      out.println("<body>");
      out.println("<h1>Servlet GenericServlet at " + request.getContextPath() + "</h1>");
      if (ctable){out.println("<p>Created Table "+tablename+" with fields<br />\n"+cfieldstr);}
      if (irecord){out.println("<p>Inserted record into "+tablename+" with values<br />\n"+valuestr);}
      out.println("</body>");
      out.println("</html>");
    } finally {
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
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    processRequest(request, response);
  }

  /**
   * Returns a short description of the servlet.
   * @return a String containing servlet description
   */
  public String getServletInfo() {
    return "Short description";
  }// </editor-fold>
}
