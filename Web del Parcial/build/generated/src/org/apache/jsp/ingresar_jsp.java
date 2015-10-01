package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class ingresar_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"es\">\n");
      out.write("<head>\n");
      out.write("\t<meta charset=\"UTF-8\">\n");
      out.write("\t<meta name=\"viewport\" content=\"width=device-width, initial-scale=1, maximun-scale=1\">\n");
      out.write("\n");
      out.write("\t<meta name=\"author\" content=\"Lucking\">\n");
      out.write("\t<meta name=\"description\" content=\"ingresar.html\">\n");
      out.write("\t<title>ingresar.html</title>\n");
      out.write("\t<link rel=\"stylesheet\" href=\"css/normalize.css\">\n");
      out.write("\t<link rel=\"stylesheet\" href=\"css/comun_estilos.css\">\n");
      out.write("\t<link rel=\"stylesheet\" href=\"css/ingresar_estilos.css\">\n");
      out.write("\t<script src=\"css/modernizr.custom.24970.js\"></script>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("\t<header>\n");
      out.write("\t\t<nav>\n");
      out.write("\t\t\t<img src=\"imagenes/logo.png\" />\n");
      out.write("\t\t\t<ul>\n");
      out.write("\t\t\t\t<li><a href=\"home.jsp\">Home</a></li>\n");
      out.write("\t\t\t\t<li><a href=\"crear_articulo.jsp\">Post an Article</a></li>\n");
      out.write("\t\t\t\t<li><a href=\"faq.jsp\">FAQ</a></li>\n");
      out.write("\t\t\t\t<li><a href=\"ingresar.jsp\">Salir</a></li>\n");
      out.write("\t\t\t</ul>\n");
      out.write("\t\t</nav>\n");
      out.write("\t</header>\n");
      out.write("\n");
      out.write("\t<section>\n");
      out.write("\t\t<h1>Ingresar</h1>\n");
      out.write("\t\t<article>\n");
      out.write("\t\t\t<form action=\"ServletUser\" method=\"post\">\n");
      out.write("                            <input type=\"hidden\" name=\"peticion\" value=\"login\" />\n");
      out.write("                            <label>Usuario:</label>\n");
      out.write("                            <input name=\"usuario\" type=\"text\" />\n");
      out.write("                            <label>ContraseÃ±a:</label>\n");
      out.write("                            <input name=\"contrasena\" type=\"text\" />\n");
      out.write("                            <div name=\"div_errores\">\n");
      out.write("                            </div>\n");
      out.write("                            <input name=\"acceder\" type=\"submit\" value=\"Acceder\" />\n");
      out.write("\t\t\t</form>\n");
      out.write("\t\t</article>\n");
      out.write("\t</section>\n");
      out.write("</body>\n");
      out.write("</html>");
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
