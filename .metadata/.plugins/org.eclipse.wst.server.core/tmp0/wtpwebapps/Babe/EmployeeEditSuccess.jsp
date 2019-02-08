<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Employee Edit Success</title>
</head>
<body background = 'success.jpg'>
	<div class="container-fluid text-center" action"${pageContext.request.contextPath}/EmployeeProfile">
	
		<br>
		<br>
		<br>
		<br>
		<center><h1>Edit Success! Congratulations!</h1></center>
		<br>
		<center><h2>Hit the button back to profile page</h2></center>
		<br>
		<br>
		<Center><button type="button" onclick="window.location.href='EmployeeProfile.jsp'">Back To Profile</button></Center>
		
	</div>

</body>
</html>