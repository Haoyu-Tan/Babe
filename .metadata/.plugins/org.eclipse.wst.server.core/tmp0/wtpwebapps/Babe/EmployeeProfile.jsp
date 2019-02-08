<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import = "sql.WebpgUtil"%>
<%@ page import = "javabeans.Person"%>
<%@ page import = "javabeans.Employee"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Employee Profile</title>
</head>
<body>

<%
	System.out.println("before get session");
	Employee em = WebpgUtil.getEmployeeUser(WebpgUtil.getSession());
	System.out.println("after get session");
%>
<center>
<h2 class = "employee_title">
Employee Profile
<h2>
</center>
<div class = "employee_photo" alt="profilePicture">
<img src = "p1.png" width="100" height="100">
</div>
<div>
<table>
<tbody>
<tr>
	<td>
		First Name:
	</td>
	<td>
		<%=em.getfirstName()%>
	</td>
</tr>
<tr>
	<td>
		Last Nane: 
	</td>
	<td>
		<%=em.getLastName()%>
	</td>
</tr>
<tr>
	<td>
		Password: 
	</td>
	<td>
		<%=em.getpassword()%>
	</td>
</tr>
<tr>
	<td>
		SSN: 
	</td>
	<td>
		<%=em.getSSN()%>
	</td>
</tr>
<tr>
	<td>
		Role: 
	</td>
	<td>
		<%=em.getRole()%>
	</td>
</tr>
<tr>
	<td>
		Address:
	</td>
	<td>
		<%=em.getStreet()%>
	</td>
	<td>
		<%=em.getCity()%>
	</td>
	<td>
		<%=em.getState()%>
	</td>
	<td>
		<%=em.getzip()%>
	</td>
</tr>
<tr>
	<td>
		Email:
	</td>
	<td>
		<%=em.getemail()%>
	</td>
</tr>
<tr>
	<td>
		Telephone:
	</td>
	<td>
		<%=em.gettelephone()%>
	</td>
</tr>
</tbody>
</table>
</div>
<form method = "post" action="${pageContext.request.contextPath}/EeditEmp.jsp">
	<input type="submit" class="btn btn-lg btn-primary btn-block" value="Edit"></input>
</form>
As a customer-representative, you are able to:
<form method = "post" action="${pageContext.request.contextPath}/VUS">
<p>View all users and modify their information</p>
<input type="submit" class="btn btn-lg btn-primary btn-block" value="View"></input>
</form>
<form method = "post" action="${pageContext.request.contextPath}/Enter The Path Here">
<p>Record A Date</p>
<input type="submit" class="btn btn-lg btn-primary btn-block" value="Record"></input>
</form>
<br>
</body>
</html>