package utilServlet;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
 
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javabeans.UserInformation;
import sql.WebpgUtil;

@WebFilter(urlPatterns = {"/*"})
public class LogFilter implements Filter{
	public LogFilter() {}
	
	@Override
	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("Log Filter init!");
	}
	
	@Override
	public void destroy() {
		System.out.println("Log Filter destory!");
	}
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest)request;
		String servletPath = req.getServletPath();
		String contextPath = req.getContextPath();
		
		
		System.out.println("in filter servlet path is " +  servletPath);
		
		ArrayList<String> targetJsp = new ArrayList<String>();
		targetJsp.add("/Home.jsp");
		targetJsp.add("/Signin.jsp");
		targetJsp.add("/signUp.jsp");
		targetJsp.add("/UserNotFound.jsp");
		targetJsp.add("/WrongPassword.jsp");
		targetJsp.add("/UserNotLogin.jsp");
		targetJsp.add("/Login");
		targetJsp.add("/NoPermission.jsp");
		targetJsp.add("/StaffLogin");
		
		
		
		if(servletPath.contains("Success.jsp")
			|| isPassed(servletPath, targetJsp) 
			|| servletPath.contains(".jpg")
			|| servletPath.contains(".png")){
			System.out.println("filter in success");
			chain.doFilter(request, response);
		}
		else if(servletPath.startsWith("/Employee")) {
			System.out.println("filter in employee");
			
			UserInformation userInfo = WebpgUtil.getUserInformation();
			
			
			if (userInfo == null) {
				((HttpServletResponse) response).sendRedirect(contextPath + "/UserNotLogin.jsp");
				
			}
			else {
				
				if(userInfo.getRole().equals("employee")) {
					chain.doFilter(req, (HttpServletResponse)response);
				}
				else {
					((HttpServletResponse) response).sendRedirect(contextPath + "/NoPermission.jsp");
				}
			}
			
			
		}
		else if (servletPath.startsWith("/Manager")) {
			System.out.println("filter in manager");
			
			UserInformation userInfo = WebpgUtil.getUserInformation();
			
			if (userInfo == null) {
				((HttpServletResponse) response).sendRedirect(contextPath + "/UserNotLogin.jsp");
				
			}
			else {
				if(userInfo.getRole().equals("manager")) {
					chain.doFilter(req, (HttpServletResponse)response);
				}
				else {
					((HttpServletResponse) response).sendRedirect(contextPath + "/NoPermission.jsp");
				}
			}
		}
		/*
		else if (servletPath.startsWith("/Staff")) {
			System.out.println("filter in staff");
			
			UserInformation userInfo = WebpgUtil.getUserInformation();
			
			
			
			if (userInfo == null) {
				((HttpServletResponse) response).sendRedirect(contextPath + "/UserNotLogin.jsp");
				
			}
			else {
				if(userInfo.getRole().equals("manager") || userInfo.getRole().equals("employee")) {
					chain.doFilter(req, (HttpServletResponse)response);
				}
				else {
					((HttpServletResponse) response).sendRedirect(contextPath + "/NoPermission.jsp");
				}
			}
		}
		*/
		else {
			//User
			UserInformation userInfo = WebpgUtil.getUserInformation();
			
			if(userInfo == null) {
				((HttpServletResponse) response).sendRedirect(contextPath + "/UserNotLogin.jsp");
			}
			else {
				if(userInfo.getRole().equals("user")) {
					
					chain.doFilter(req, (HttpServletResponse)response);
				}
				else {
					//a new jsp page
					((HttpServletResponse) response).sendRedirect(contextPath + "/NoPermission.jsp");
				}
			}
		}
		
	}
	
	public boolean isPassed(String path, ArrayList<String> target) {
		for(String tar : target) {
			if(path.equals(tar)) {
				return true;
			}
		}
			
		return false;
	}
	
	
	
}
