package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import MB.ClickNumBean;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.Vector _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!-- java bean scoped in application so it is share by every visitors, can be used to caculate the click number -->\n");
      MB.ClickNumBean Online = null;
      synchronized (application) {
        Online = (MB.ClickNumBean) _jspx_page_context.getAttribute("Online", PageContext.APPLICATION_SCOPE);
        if (Online == null){
          Online = new MB.ClickNumBean();
          _jspx_page_context.setAttribute("Online", Online, PageContext.APPLICATION_SCOPE);
        }
      }
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Login</title>\n");
      out.write("    </head>\n");
      out.write("    <body style=\"text-align: center\">\n");
      out.write("        <h1>MessegeBox Login</h1>\n");
      out.write("        <form method=\"Post\" action=\"getInfo?act=view&page=1\">\n");
      out.write("            <!-- give different page according to UserName session value -->\n");
      out.write("            ");

            if(request.getSession().getAttribute("UserName")==null){
            
      out.write("\n");
      out.write("            Your name<input type=\"text\" name=\"UserName\" value=\"\" />\n");
      out.write("            <input type=\"submit\" value=\"Login\" />\n");
      out.write("            ");

            }else{
            
      out.write("\n");
      out.write("            Your name is ");
      out.print(request.getSession().getAttribute("UserName") );
      out.write(" <a href=\"getInfo?page=1&act=view\">Enter</a><br />\n");
      out.write("            <a href=\"Logout\" >Logout</a>\n");
      out.write("            ");
 
            }
            
      out.write("\n");
      out.write("        </form>\n");
      out.write("            <!-- get the click number -->\n");
      out.write("            <br />There are ");
      out.print(Online.getVisitNum());
      out.write(" clicks in this page.\n");
      out.write("            <br /><a href=\"getDescription\" target=\"_blank\">Description</a>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
