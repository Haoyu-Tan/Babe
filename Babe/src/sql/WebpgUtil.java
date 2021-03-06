package sql;

import java.sql.Connection; 
import java.util.ArrayList;

import javax.servlet.ServletRequest;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import javabeans.Dates;
import javabeans.Employee;
import javabeans.Person;
import javabeans.Profile;
import javabeans.User;
import javabeans.salesReport;
import javabeans.UserInformation;

public class WebpgUtil {
	
	public static final String ATT_NAME_CONNECTION = "ATTRIBUTE_FOR_CONNECTION";
	public static final String ATT_NAME_USER_NAME = "ATTRIBUTE_FOR_STORE_USER_NAME_IN_COOKIE";
	
	private static final WebpgUtil webutil= null;
	
	private static int userlevel = 0; // 0 = not login 1= user login 2= Cust Rep 3= Manager
	private static HttpSession session = null;
	private static boolean idExists = false;
	private static HttpSession session1 = null; //list of user
	private static HttpSession UUSsession = null;
	private static HttpSession Esession = null;
	private static HttpSession EESsession = null;
	private static HttpSession reportSession = null;
	private static HttpSession SearchDateByTimeSession = null;
	private static HttpSession SearchDateByNameSession = null;
	private static HttpSession SearchRevenueByTimeSession = null;
	private static HttpSession SearchRevenueByNameSession = null;
	private static HttpSession CRSession = null;
	private static HttpSession CustSession = null;
	private static HttpSession ActiveProfileSession = null;
	
	//*********************
	static UserInformation userInfo;
	//*********************

	private WebpgUtil() {
		
	}
	
	public static int getUserlevel() {
		return userlevel;
	}
	
	
	public static void setUserlevel(int newlevel){
		userlevel = newlevel;
	}
	//???
	public static boolean isIdExists() {
		return idExists;
	}
	//???
	public static void setIdExists(boolean idExists) {
		WebpgUtil.idExists = idExists;
	}

	public static HttpSession getSession() {
		return session;
	}

	public static void setSession(HttpSession session) {
		System.out.println("point 2");
		WebpgUtil.session = session;
	}

	public static void deleteSession() {
		session = null;
	}
	
	public static WebpgUtil getWebutil() {
		if(webutil == null) {
			return new WebpgUtil();
		}
		return webutil;
	}
	
	
	public static void setConnection(ServletRequest request, Connection connection) {
		request.setAttribute(ATT_NAME_CONNECTION, connection);
    }
	
	public static Connection getConnection(ServletRequest request) {
        Connection connection = (Connection) request.getAttribute(ATT_NAME_CONNECTION);
        return connection;
    }
	
	public static void remeberMe(HttpSession session, Profile loginedUser) {
		setSession(session);
		session.setAttribute("loginedUser", loginedUser);
	}
	
	public static Profile getOnlineUser(HttpSession session) {
        Profile loginedUser = (Profile) session.getAttribute("loginedUser");
        return loginedUser;
    }
	
	public static void storeInCookie(HttpServletResponse response, Profile user) {
		Cookie cookie = new Cookie(ATT_NAME_USER_NAME, user.getOwnerSSN());
		cookie.setMaxAge(4000);
		response.addCookie(cookie);
		
	}
	
	public static void remeberEmployee(HttpSession session, Employee loginedUser) {
		System.out.println("point 1");
		setSession(session);
		System.out.println("point 3");
		session.setAttribute("loginedUser", loginedUser);
		System.out.println("point 4");
	}
	
	
	public static Employee getEmployeeUser(HttpSession session) {
		Employee loginedUser = (Employee) session.getAttribute("loginedUser");
        return loginedUser;
    }
	
	public static void rememberUpdateUser(HttpSession session, User user) {
		setUUSsession(session);
		session.setAttribute("updateUser", user);
		
	}
	
	public static User getUpdateUser(HttpSession session) {
		User updateUser = (User) session.getAttribute("updateUser");
        return updateUser;
    }
	
	public static void remeberListUser(HttpSession session1, ArrayList<User> users) {
		setSession1(session1);
		session.setAttribute("users", users);
	}
	
	public static ArrayList<User> getListUser(HttpSession session1){
		ArrayList<User> listUser = (ArrayList<User>)session1.getAttribute("users");
		return listUser;
	}
	
	public static void rememberEmployeeList(HttpSession session, ArrayList<Employee> emp){
		setEsession(session);
		session.setAttribute("employees", emp);
	}
	
	public static ArrayList<Employee> getListEmployee(HttpSession session){
		ArrayList<Employee> listEmployee = (ArrayList<Employee>)session.getAttribute("employees");
		return listEmployee;
	}
	
	public static void rememberEmployee(HttpSession session, Employee em) {
		setEESsession(session);
		session.setAttribute("employee", em);
		
	}
	
	public static Employee getEmployee(HttpSession session) {
		Employee e = (Employee) session.getAttribute("employee");
		return e;
	}
	
	public static void rememberDateByTime(HttpSession session, ArrayList<Dates> dates) {
		
		setSearchDateByTimeSession(session);
		session.setAttribute("datesByTime", dates);
		System.out.println("yeah, remember");
	}
	
	public static ArrayList<Dates> getDateByTime(HttpSession session) {
		ArrayList<Dates> dates = (ArrayList<Dates>) session.getAttribute("datesByTime");
		System.out.println("yeah get the dates");
		return dates;
	}
	
	public static void rememberReport(HttpSession session, ArrayList<salesReport> report) {
		setReportSession(session);
		session.setAttribute("report", report);
	}
	
	public static ArrayList<salesReport> getReport(HttpSession session){
		ArrayList<salesReport> report = (ArrayList<salesReport>) session.getAttribute("report");
		return report;
	}
	
	
	public static void rememberDateByName(HttpSession session, ArrayList<Dates> dates) {
		setSearchDateByNameSession(session);
		session.setAttribute("datesByName", dates);
	}
	
	public static ArrayList<Dates> getDatesByName(HttpSession session){
		ArrayList<Dates> dates = (ArrayList<Dates>) session.getAttribute("datesByName");
		return dates;
	}
	
	public static void rememberRevenueByDate(HttpSession session, ArrayList<Dates> dates) {
		setSearchRevenueByTimeSession(session);
		session.setAttribute("revenue", dates);
	}
	
	public static ArrayList<Dates> getRevenueByDate(HttpSession session){
		ArrayList<Dates> dates = (ArrayList<Dates>) session.getAttribute("revenue");
		return dates;
	}
	
	public static void rememberRevenueByName(HttpSession session, ArrayList<Dates> dates) {
		setSearchRevenueByNameSession(session);
		session.setAttribute("rev", dates);
	}
	
	public static ArrayList<Dates> getRevenueByName(HttpSession session){
		ArrayList<Dates> dates = (ArrayList<Dates>) session.getAttribute("rev");
		return dates;
	}
	
	public static void rememberRevenuePerson(HttpSession session, Person p) {
		setCustSession(session);
		session.setAttribute("RevPer", p);
	}
	
	public static Person getRevPerson(HttpSession session) {
		Person p = (Person) session.getAttribute("RevPer");
		return p;
	}
	
	public static void rememberCustRep(HttpSession session, Person p) {
		setCRSession(session);
		session.setAttribute("custRep", p);
	}
	
	public static Person getCustRep(HttpSession session) {
		Person emp = (Person) session.getAttribute("custRep");
		return emp;
		
	}
	
	public static void rememberActiveUser(HttpSession session, ArrayList<Profile> prof) {
		setActiveProfileSession(session);
		session.setAttribute("ActiveUser", prof);
	}
	
	public static ArrayList<Profile> getActiveUser(HttpSession session){
		ArrayList<Profile> p = (ArrayList<Profile>) session.getAttribute("ActiveUser");
		return p;
	}
	
	public static void storeEmpyInCookie(HttpServletResponse response, Employee user) {
		Cookie cookie = new Cookie(ATT_NAME_USER_NAME, user.getSSN());
		cookie.setMaxAge(4000);
		response.addCookie(cookie);
		
	}
	
	public static String getUserInCookie (HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie c : cookies) {
                if (ATT_NAME_USER_NAME.equals(c.getName())) {
                    return c.getValue();
                }
            }
        }
        return null;
    }
	
	public static void deleteCookie(HttpServletResponse response) {
        Cookie cookie = new Cookie(ATT_NAME_USER_NAME, null);
        cookie.setMaxAge(0);
        response.addCookie(cookie);
    }

	public static HttpSession getSession1() {
		return session1;
	}

	public static void setSession1(HttpSession session1) {
		WebpgUtil.session1 = session1;
	}

	public static HttpSession getUUSsession() {
		return UUSsession;
	}

	public static void setUUSsession(HttpSession uUSsession) {
		UUSsession = uUSsession;
	}
	
	public static void storeUserAccount(HttpServletResponse response, User user) {
		Cookie cookie = new Cookie(ATT_NAME_USER_NAME, user.getSSN());
		cookie.setMaxAge(4000);
		response.addCookie(cookie);

		}
	
	public static void storeEmployeeAccount(HttpServletResponse response, Employee emp) {
		Cookie cookie = new Cookie(ATT_NAME_USER_NAME, emp.getSSN());
		cookie.setMaxAge(4000);
		response.addCookie(cookie);

		}

	public static HttpSession getEsession() {
		return Esession;
	}

	public static void setEsession(HttpSession esession) {
		Esession = esession;
	}

	public static HttpSession getEESsession() {
		return EESsession;
	}

	public static void setEESsession(HttpSession eESsession) {
		EESsession = eESsession;
	}

	public static HttpSession getReportSession() {
		return reportSession;
	}

	public static void setReportSession(HttpSession reportSession) {
		WebpgUtil.reportSession = reportSession;
	}

	public static HttpSession getSearchDateByTimeSession() {
		return SearchDateByTimeSession;
	}

	public static void setSearchDateByTimeSession(HttpSession searchDateByTimeSession) {
		SearchDateByTimeSession = searchDateByTimeSession;
	}

	public static HttpSession getSearchDateByNameSession() {
		return SearchDateByNameSession;
	}

	public static void setSearchDateByNameSession(HttpSession searchDateByNameSession) {
		SearchDateByNameSession = searchDateByNameSession;
	}

	public static HttpSession getSearchRevenueByTimeSession() {
		return SearchRevenueByTimeSession;
	}

	public static void setSearchRevenueByTimeSession(HttpSession searchRevenueByTimeSession) {
		SearchRevenueByTimeSession = searchRevenueByTimeSession;
	}

	public static HttpSession getSearchRevenueByNameSession() {
		return SearchRevenueByNameSession;
	}

	public static void setSearchRevenueByNameSession(HttpSession searchRevenueByNameSession) {
		SearchRevenueByNameSession = searchRevenueByNameSession;
	}

	public static HttpSession getCRSession() {
		return CRSession;
	}

	public static void setCRSession(HttpSession cRSession) {
		CRSession = cRSession;
	}

	public static HttpSession getCustSession() {
		return CustSession;
	}

	public static void setCustSession(HttpSession custSession) {
		CustSession = custSession;
	}

	public static HttpSession getActiveProfileSession() {
		return ActiveProfileSession;
	}

	public static void setActiveProfileSession(HttpSession activeProfileSession) {
		ActiveProfileSession = activeProfileSession;
	}
	
	public static void setUserInformation(UserInformation user) {
		userInfo = user;
	}
	
	public static UserInformation getUserInformation() {
		return userInfo;
	}
	
	
}
