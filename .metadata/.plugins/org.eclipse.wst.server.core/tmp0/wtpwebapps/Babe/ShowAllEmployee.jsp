<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import = "sql.WebpgUtil"%>
<%@ page import = "javabeans.Employee"%>
<%@page import = "java.util.ArrayList"%>
<%@ page import = "java.text.SimpleDateFormat"%>
<%@ page import = "java.text.DateFormat"%> 
<%@ page import = "java.util.Date"%>
<%@ page import = "javabeans.Dates"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ViewAllUsers</title>
</head>
<body>
<%
	System.out.println("before get session");
	ArrayList<Employee> employeeList = WebpgUtil.getListEmployee(WebpgUtil.getEsession());
	System.out.println("after get session");
%>
<center>
<h1>
Employee Information List
</h1>
</center>
<table style="width:100%" border = "1">
		<tr>
			<th>First Name</th>
			<th>Last Name</th>
			<th>SSN</th>
			<th>Password</th>
			<th>Role</th>
			<th>Hourly Rate</th>
			<th>Street</th>
			<th>City</th>
			<th>State</th>
			<th>Zip Code</th>
			<th>Telephone</th>
			<th>Email</th>
			<th>Start Date</th>
			<th>Update</th>
			<th>Delete</th>
		</tr>
	
	<% 	
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		for(int i = 0; i < employeeList.size(); i++){
			Employee u = employeeList.get(i);
			Date d = u.getStartDate().getTime();%>
		<tr>
			<form class = "userInfo" action = "${pageContext.request.contextPath}/UES">
			<td>
					<textarea name = "firstname" style="border: none"><%= u.getfirstName()%></textarea>
			</td>
			<td>
					<textarea name = "lastname" style="border: none"><%= u.getLastName()%></textarea>
			</td>	
			<td>
					<textarea name = "SSN" style="border: none"><%= u.getSSN()%></textarea>
			</td>
			<td>
					<textarea name = "password" style="border: none"><%= u.getpassword()%></textarea>
			</td>
			<td>
					<textarea name = "role" style="border: none"><%= u.getRole()%></textarea>
			</td>
			<td>
					<textarea name = "hourlyrate" style="border: none"><%= u.getHourlyRate()%></textarea>
			</td>
			<td>
					<textarea name = "street" style="border: none"><%= u.getStreet()%></textarea>
			</td>
			<td>
					<textarea name = "city" style="border: none"><%= u.getCity()%></textarea>
			</td>
			<td>
					<textarea name = "state" style="border: none"><%= u.getState()%></textarea>
			</td>
			<td>
					<textarea name = "zipcode" style="border: none"><%= u.getzip()%></textarea>
			</td>
			<td>
					<textarea name = "telephone" style="border: none"><%= u.gettelephone()%></textarea>
			</td>
			<td>
					<textarea name = "email" style="border: none"><%= u.getemail()%></textarea>
			</td>
			<td>
					<textarea name = "startdate" style="border: none"><%= dateFormat.format(d)%></textarea>
			</td>
			
			<td>
				
				<input type="submit"  name="Edit" value="Edit" method="get"></input>
				
			</td>
			
			
				<td>
					<input type="submit" name="Delete" value="Delete" method = "post"></input>
				</td>
			</form>
		</tr>
	<% } %>
	
	<form class = "addUser" action = "${pageContext.request.contextPath}/ManagerAddEmployee.jsp" method="get">
			<input type="submit" name="Add" value="Add" maxlength="35">
	</form>
	<form class = "Back" action = "${pageContext.request.contextPath}/ManagerProfile.jsp" method="get">
			<input type="submit" name="BacktoP" value="Back" maxlength="35">
	</form>		
</table>
</body>
</html>