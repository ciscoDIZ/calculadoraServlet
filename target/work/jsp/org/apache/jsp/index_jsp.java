package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.Vector _jspx_dependants;

  private org.apache.jasper.runtime.ResourceInjector _jspx_resourceInjector;

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
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.apache.jasper.runtime.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("<html>\n");
      out.write("<body>\n");
      out.write("<h2>Calculadora</h2>\n");
      out.write("<form action=\"operadora\" method=\"post\">\n");
      out.write("    <table>\n");
      out.write("        <tr>\n");
      out.write("            <td><input type=\"text\" placeholder=\"operando\" name=\"opa\" size=\"2\"></td>\n");
      out.write("            <td>\n");
      out.write("                <select name=\"opr\" id=\"opr\">\n");
      out.write("                    <option value=\"+\">+</option>\n");
      out.write("                    <option value=\"-\">-</option>\n");
      out.write("                    <option value=\"*\">*</option>\n");
      out.write("                    <option value=\"/\">/</option>\n");
      out.write("                </select>\n");
      out.write("            </td>\n");
      out.write("            <td><input type=\"text\" placeholder=\"operando\" name=\"opb\" size=\"2\"></td>\n");
      out.write("        </tr>\n");
      out.write("        <tr>\n");
      out.write("            <td colspan=\"2\"><input type=\"submit\" value=\"Enviar\"></td>\n");
      out.write("            <td><a href=\"gestor?his=1\">ver historial...</a></td>\n");
      out.write("        </tr>\n");
      out.write("    </table>\n");
      out.write("    ");

        if(request.getAttribute("res") != null){
            String res = (String)request.getAttribute("res");
            out.print(res);
        }
    
      out.write("\n");
      out.write("</form>\n");
      out.write("</body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
