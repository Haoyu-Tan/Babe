<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Babe Login</title>
</head>
<body>
<h1 class = "WelcomeBrand">
Welcome Back!
</h1>
<h2 class = "LoginWords">
Please login First
</h2>
<div class = "loginBlock">
<form class="userLogin" style="float: left;" method = "post" action="${pageContext.request.contextPath}/Login">
<div>
<h4>
User Login
</h4>
</div>
<div>
User ID: <input type="text" name = "UserID" placeholder="User ID" required autofocus></input>
</div>
<div>
Password: <input type="password" name="Password" placeholder="User Password"></input>
</div>
<div>
 <input type="submit" class="btn btn-lg btn-primary btn-block" value="Log in"></input>
</div>
<div style="float: left;">
<p>Do not have account? <a href="signUp.jsp">Sign up now!</a></p>
</div>
</form>
<form class="employeeLogin" style="float: right" method = "post" action = "${pageContext.request.contextPath}/StaffLogin">
<h4>
Employee Login
</h4>
<div>
Employee SSN: <input type="text" name="ManagerID" placeholder="Employee SSN" required autofocus></input>
</div>
<div>
Password: <input type = "password" name = "Password" placeholder = "Employee Password"></input>
</div>
<div>
<input type="submit" class="btn btn-lg btn-primary btn-block" value="Log in"></input>
</div>
</form>
</div>
</body>
</html>