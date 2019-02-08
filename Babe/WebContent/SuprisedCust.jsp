<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import = "sql.WebpgUtil"%>
<%@ page import = "javabeans.Person"%>
<%@page import = "java.util.ArrayList"%>
<%@ page import = "java.text.SimpleDateFormat"%>
<%@ page import = "java.text.DateFormat"%> 
<%@ page import = "java.util.Date"%>
<%@ page import = "javabeans.Dates"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Most Revenue CR</title>
</head>
<body>
<%
	Person p = WebpgUtil.getRevPerson(WebpgUtil.getCustSession());
%>
<h1>The Employee Who Generated The Most Revenue Is:<br>
First Name: <%=p.getfirstName() %> <br>
Last Name: <%=p.getLastName() %><br>
SSN: <%=p.getSSN() %><br>
</h1>
<form class = "Back" action = "${pageContext.request.contextPath}/ManagerProfile.jsp" method="get">
			<input type="submit" name="BacktoP" value="Back" maxlength="35">
	</form>	

</body>
</html>