<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import = "sql.WebpgUtil"%>
<%@ page import = "javabeans.Person"%>
<%@ page import = "javabeans.Employee"%>
<%@ page import = "java.text.SimpleDateFormat"%>
<%@ page import = "java.text.DateFormat"%> 
<%@ page import = "java.util.Date"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Manager Update Employee</title>
</head>
<body>
<center>
<h1>
Update Information For A Specific Employee
</h1>
</center>
<%
	System.out.println("before get session");
	Employee e = WebpgUtil.getEmployee(WebpgUtil.getEESsession());
	System.out.println("after get session");
	DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	Date d = e.getStartDate().getTime();
%>

<form class = "EeditU"  method = "post" action = "${pageContext.request.contextPath}/MupdateE">
		First Name: <input type="text" name="firstname" value="<%= e.getfirstName()%>"><br>
		Last Name: <input type="text" name="lastname" value="<%= e.getLastName()%>"><br>
		Password <input type="text" name="password" value="<%= e.getpassword()%>"><br>
		SSN: <input type="text" name="SSN" value="<%= e.getSSN()%>"><br>
		Street: <input type="text" name="street" value="<%= e.getStreet()%>"><br>
		City: <input type="text" name="city" value="<%= e.getCity()%>"><br>
		State: <input type="text" name="state" value="<%= e.getState()%>"><br>
		ZipCode: <input type="text" name="zipcode" value = "<%= e.getzip()%>"><br>
		Telephone: <input type="text" name="tel" value = "<%= e.gettelephone()%>"><br>
		Email: <input type="text" name="email" value = "<%= e.getemail()%>"><br>
		PPP: <input type="text" name="role" value="<%= e.getRole()%>"><br>
		Rating: <input type="text" name="hourlyrate" value="<%= e.getHourlyRate()%>"><br>
		Date Of Last Act: <input name = "startdate" value="<%= dateFormat.format(d)%>"><br>
		
		
		<input type="submit" class="btn btn-lg btn-primary btn-block" value="Submit"></input>
</form>
<form class = "EeditU"  method = "post" action = "${pageContext.request.contextPath}/ShowAllEmployee.jsp">
		<input type="submit" class="btn btn-lg btn-primary btn-block" value="Cancel"></input>
</form>
</body>
</html>