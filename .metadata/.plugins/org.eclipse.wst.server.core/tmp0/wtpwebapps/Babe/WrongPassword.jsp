<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Babe-WrongPassword!!</title>

</head>
<body background = 'ErrorBG.jpg'>
	<div class="container-fluid text-center" action"${pageContext.request.contextPath}/Error">
	
		<br>
		<br>
		<br>
		<br>
		<center><h1>Oops! Password is wrong...</h1></center>
		<br>
		<br>
		<Center><button type="button" onclick="window.location.href='Signin.jsp'">Back To Login!</button></Center>
		
	</div>

</body>
</html>