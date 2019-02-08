<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Edit Employee</title>
</head>
<body>
	<center>
		<h2>
			Edit Employee Information
		</h2>
	</center>
	<form class = "EeditE"  method = "post" action="${pageContext.request.contextPath}/EupdateE">
		First Name: <input type="text" name="firstname"><br>
		Last Name: <input type="text" name="lastname"><br>
		Password <input type="text" name="password"><br>
		SSN: <input type="text" name="SSN"><br>
		Street: <input type="text" name="street"><br>
		City: <input type="text" name="city"><br>
		State: <input type="text" name="state"><br>
		ZipCode: <input type="text" name="zipcode"><br>
		Telephone: <input type="text" name="tel"><br>
		Email: <input type="text" name="email"><br>
		<input type="submit" class="btn btn-lg btn-primary btn-block" value="Submit"></input>
		
	</form>
	<form class = "ECancel" method = "post" action = "${pageContext.request.contextPath}/EmployeeProfile.jsp">
		<input type="submit" class="btn btn-lg btn-primary btn-block" value="Cancel"></input>
	</form>
</body>
</html>