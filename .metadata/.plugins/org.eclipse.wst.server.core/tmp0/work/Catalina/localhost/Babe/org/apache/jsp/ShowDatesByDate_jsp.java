/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.37
 * Generated at: 2019-01-25 01:34:42 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import sql.WebpgUtil;
import java.util.ArrayList;
import java.text.SimpleDateFormat;
import java.text.DateFormat;
import java.util.Date;
import javabeans.salesReport;
import javabeans.Dates;

public final class ShowDatesByDate_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("javabeans.salesReport");
    _jspx_imports_classes.add("java.util.Date");
    _jspx_imports_classes.add("java.text.SimpleDateFormat");
    _jspx_imports_classes.add("sql.WebpgUtil");
    _jspx_imports_classes.add("javabeans.Dates");
    _jspx_imports_classes.add("java.text.DateFormat");
    _jspx_imports_classes.add("java.util.ArrayList");
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    final java.lang.String _jspx_method = request.getMethod();
    if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET POST or HEAD");
      return;
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write(" \n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("<title>Show Date By Date</title>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("<h2>\n");
      out.write("Below is a list of dates that generate by a specific of time\n");
      out.write("</h2>\n");
      out.write("<body>\n");

	System.out.println("before get session");
	ArrayList<Dates> dateList = WebpgUtil.getDateByTime(WebpgUtil.getSearchDateByTimeSession());
	System.out.println("after get session");

      out.write("\n");
      out.write("<center>\n");
      out.write("\n");
      out.write("</center>\n");
      out.write("<table style=\"width:100%\" border = \"1\">\n");
      out.write("\t\t<tr>\n");
      out.write("\t\t\t<th>Profile 1</th>\n");
      out.write("\t\t\t<th>Profile 2</th>\n");
      out.write("\t\t\t<th>Cust Rep</th>\n");
      out.write("\t\t\t<th>Location</th>\n");
      out.write("\t\t\t<th>Booking Fee</th>\n");
      out.write("\t\t\t<th>Comments</th>\n");
      out.write("\t\t\t<th>User1 Rating</th>\n");
      out.write("\t\t\t<th>User2 Rating</th>\n");
      out.write("\t\t\t<th>Date Time</th>\n");
      out.write("\t\t</tr>\n");
      out.write("\t\n");
      out.write("\t");
 	
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		for(int i = 0; i < dateList.size(); i++){
			Dates date = dateList.get(i);
			Date d = date.getDateTime().getTime();
      out.write("\n");
      out.write("\t\t<tr>\n");
      out.write("\t\t\t\n");
      out.write("\t\t\t<td>\n");
      out.write("\t\t\t\t\t<textarea name = \"profile1\" style=\"border: none\">");
      out.print( date.getProfile1());
      out.write("</textarea>\n");
      out.write("\t\t\t</td>\n");
      out.write("\t\t\t<td>\n");
      out.write("\t\t\t\t\t<textarea name = \"profile2\" style=\"border: none\">");
      out.print( date.getProfile2());
      out.write("</textarea>\n");
      out.write("\t\t\t</td>\t\n");
      out.write("\t\t\t<td>\n");
      out.write("\t\t\t\t\t<textarea name = \"SSN\" style=\"border: none\">");
      out.print( date.getCustRep());
      out.write("</textarea>\n");
      out.write("\t\t\t</td>\n");
      out.write("\t\t\t<td>\n");
      out.write("\t\t\t\t\t<textarea name = \"location\" style=\"border: none\">");
      out.print( date.getLocation());
      out.write("</textarea>\n");
      out.write("\t\t\t</td>\n");
      out.write("\t\t\t<td>\n");
      out.write("\t\t\t\t\t<textarea name = \"fee\" style=\"border: none\">");
      out.print( date.getBookingFee());
      out.write("</textarea>\n");
      out.write("\t\t\t</td>\n");
      out.write("\t\t\t<td>\n");
      out.write("\t\t\t\t\t<textarea name = \"common\" style=\"border: none\">");
      out.print( date.getComments());
      out.write("</textarea>\n");
      out.write("\t\t\t</td>\n");
      out.write("\t\t\t<td>\n");
      out.write("\t\t\t\t\t<textarea name = \"rating1\" style=\"border: none\">");
      out.print( date.getUser1Rating());
      out.write("</textarea>\n");
      out.write("\t\t\t</td>\n");
      out.write("\t\t\t<td>\n");
      out.write("\t\t\t\t\t<textarea name = \"rating2\" style=\"border: none\">");
      out.print( date.getUser2Rating());
      out.write("</textarea>\n");
      out.write("\t\t\t</td>\n");
      out.write("\t\t\t\n");
      out.write("\t\t\t<td>\n");
      out.write("\t\t\t\t\t<textarea name = \"getdate\" style=\"border: none\">");
      out.print( dateFormat.format(d));
      out.write("</textarea>\n");
      out.write("\t\t\t</td>\n");
      out.write("\t\t\t\n");
      out.write("\t\t</tr>\n");
      out.write("\t");
 } 
      out.write("\n");
      out.write("\t\n");
      out.write("\t<form class = \"Back\" action = \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/ManagerProfile.jsp\">\n");
      out.write("\t\t\t<input type=\"submit\" name=\"BacktoP\" value=\"Back\" maxlength=\"35\">\n");
      out.write("\t</form>\t\t\n");
      out.write("</table>\n");
      out.write("</body>\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
