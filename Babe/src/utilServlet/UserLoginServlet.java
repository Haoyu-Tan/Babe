package utilServlet;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;

import javax.servlet.http.HttpSession;

import javabeans.Person;
import javabeans.Profile;
import javabeans.User;
import javabeans.UserInformation;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;


import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.sql.Connection;
import java.io.IOException;
import java.io.PrintWriter;

import sql.*;

@WebServlet("/Login")
public class UserLoginServlet extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//Serialize
	
	public UserLoginServlet() {
		super();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		//ServletOutputStream out = response.getOutputStream();
		String contextPath = request.getContextPath();
		
		String uid = request.getParameter("UserID");
		String password = request.getParameter("Password");
		
		boolean submit1 = request.getParameter("Submit1") != null;
		User user = null;
		System.out.println("User login");
		try{
			
			SqlConnection sqlCon = new SqlConnection();
			sqlCon.readDatabase();
			Connection conn = sqlCon.getConnected();
			
			
			Profile pro  = UsersData.searchProfile(conn, uid);
			//System.out.println("return null");
			if (pro == null) {
				System.out.println("in null");
				
				response.sendRedirect(contextPath + "/UserNotFound.jsp");
				return;
			}
			//System.out.println("ssn is " + pro.getOwnerSSN());
			Person per = UsersData.searchPerson(conn, pro.getOwnerSSN());
			//System.out.println(per.getpassword());
			
			if (per != null){
				
				if (per.getpassword().equals(password)) {
					System.out.println("after password check");
					HttpSession session = request.getSession(true);
					WebpgUtil.remeberMe(session, pro);
					//WebpgUtil.storeInCookie(response, pro);
					WebpgUtil.setUserlevel(1);
					System.out.println("");
					
					UserInformation userInfo = new UserInformation(per.getSSN(), "user", pro.getProfileID());
					System.out.println(userInfo.getRole());
					WebpgUtil.setUserInformation(userInfo);
					System.out.println("user role is " + WebpgUtil.getUserInformation().getRole());
					
					ArrayList<Profile> profileList = new ArrayList<Profile>();
					profileList.add(pro);
					ArrayList<Person> personList = new ArrayList<Person>();
					personList.add(per);
					System.out.println("profileID: " + pro.getProfileID());
					request.setAttribute("profileInfo", profileList);
					request.setAttribute("personInfo", personList);
					request.getRequestDispatcher("userprofile.jsp").forward(request, response);
					
					//response.sendRedirect(contextPath + "/userprofile.jsp");
				}
				else {
					
					//PrintWriter output = response.getWriter();
					//response.setContentType("text/html");
					//output.println("<script type=\"text/javascript\">");
					//output.println("alert('Password Incorrect, Try Again!');");
					//output.println("/script");
					response.sendRedirect(contextPath + "/WrongPassword.jsp");
					
				}
				
			}
			else {
				response.sendRedirect(contextPath + "/UserNotFound.jsp");
				//PrintWriter output = response.getWriter();
				//response.setContentType("text/html");
				//output.println("<script type=\"text/javascript\">");
				//output.println("alert('Please Sign Up And Then Try Again');");
				//output.println("/script");
			}
			sqlCon.close();
		}
		catch(SQLException e) {
			response.sendRedirect(contextPath + "/Error.jsp");
		}
		catch (Exception e) {
			response.sendRedirect(contextPath + "/Error.jsp");
		}
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
