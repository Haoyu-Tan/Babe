<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import = "sql.WebpgUtil"%>
<%@ page import = "javabeans.Person"%>
<%@ page import = "javabeans.User"%>
<%@ page import = "java.text.SimpleDateFormat"%>
<%@ page import = "java.text.DateFormat"%> 
<%@ page import = "java.util.Date"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Employee Update User</title>
</head>
<body>
<center>
<h1>
Update Information For A Specific User
</h1>
</center>
<%
	System.out.println("before get session");
	User u = WebpgUtil.getUpdateUser(WebpgUtil.getSession());
	System.out.println("after get session");
	DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	Date d = u.getLastAct().getTime();
%>

<form class = "EeditU"  method = "post" action = "${pageContext.request.contextPath}/EupdateU">
		First Name: <input type="text" name="firstname" value="<%= u.getfirstName()%>"><br>
		Last Name: <input type="text" name="lastname" value="<%= u.getLastName()%>"><br>
		Password <input type="text" name="password" value="<%= u.getpassword()%>"><br>
		SSN: <input type="text" name="SSN" value="<%= u.getSSN()%>"><br>
		Street: <input type="text" name="street" value="<%= u.getStreet()%>"><br>
		City: <input type="text" name="city" value="<%= u.getCity()%>"><br>
		State: <input type="text" name="state" value="<%= u.getState()%>"><br>
		ZipCode: <input type="text" name="zipcode" value = "<%= u.getzip()%>"><br>
		Telephone: <input type="text" name="tel" value = "<%= u.gettelephone()%>"><br>
		Email: <input type="text" name="email" value = "<%= u.getemail()%>"><br>
		PPP: <input type="text" name="PPP" value="<%= u.getPPP()%>"><br>
		Rating: <input type="text" name="rating" value="<%= u.getRating()%>"><br>
		Date Of Last Act: <input name = "lastact" value="<%= dateFormat.format(d)%>"><br>
		
		
		<input type="submit" class="btn btn-lg btn-primary btn-block" value="Submit"></input>
</form>
<form class = "EeditU"  method = "post" action = "${pageContext.request.contextPath}/showUsers.jsp">
		<input type="submit" class="btn btn-lg btn-primary btn-block" value="Cancel"></input>
</form>
</body>
</html>