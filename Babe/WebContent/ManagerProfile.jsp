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
<form method = "post" action="${pageContext.request.contextPath}/ManagerUpdate.jsp">
	<input type="submit" class="btn btn-lg btn-primary btn-block" placeholder="Edit"></input>
</form>
As a customer-representative, you are able to:
<form method = "post" action="${pageContext.request.contextPath}/MVUS">
<p>View all users and modify their information</p>
<input type="submit" class="btn btn-lg btn-primary btn-block" placeholder="View"></input>
</form>
<form method = "post" action="${pageContext.request.contextPath}/VES">
<p>View all employees and modify their information</p>
<input type="submit" class="btn btn-lg btn-primary btn-block" placeholder="View"></input>
</form>
<form method = "post" action="${pageContext.request.contextPath}/salereports">
<p>Obtain a sales report for a particular month</p>
<p>Please enter the year and month that you need want to generate a sales report</p>
Year: <input type="text" class="btn btn-lg btn-primary btn-block" name="year" placeholder="year"></input><br>
Month: <input type="text" class="btn btn-lg btn-primary btn-block" name="month" placeholder="month"><br>
<input type="submit" class="btn btn-lg btn-primary btn-block" value="View"></input>
</form>
<form method = "post" action="${pageContext.request.contextPath}/datebytime">
<p>Produce a list of date based on calendar date</p>
<p>Please enter a particular date of year</p>
Year: <input type="text" class="btn btn-lg btn-primary btn-block" name="dateyear" placeholder="yyyy"></input><br>
Month: <input type="text" class="btn btn-lg btn-primary btn-block" name="datemonth" placeholder="MM"></input><br>
Dates: <input type="text" class="btn btn-lg btn-primary btn-block" name="datedate" placeholder="dd"></input><br>
<input type="submit" class="btn btn-lg btn-primary btn-block" value="View"></input>
</form>
<form method = "post" action="${pageContext.request.contextPath}/datebyname">
<p>Produce a list of date based on provided name</p>
<p>Please enter a customer name</p>
<input type="text" class="btn btn-lg btn-primary btn-block" name="datename" placeholder="eg: Tom Cat"><br>
<input type="submit" class="btn btn-lg btn-primary btn-block" value="View"></input>
</form>
<form method = "post" action="${pageContext.request.contextPath}/revenuebytime">
<p>Produce a list of revenue based on provided name</p>
<p>Please enter a particular day</p>
Year: <input type="text" class="btn btn-lg btn-primary btn-block" name="ryear" placeholder="yyyy"></input><br>
Month: <input type="text" class="btn btn-lg btn-primary btn-block" name="rmonth" placeholder="MM"></input><br>
Dates: <input type="text" class="btn btn-lg btn-primary btn-block" name="rdate" placeholder="dd"></input><br>
<input type="submit" class="btn btn-lg btn-primary btn-block" value="View"></input>
</form>
<form method = "post" action="${pageContext.request.contextPath}/revenuebyname">
<p>Produce a list of revenue based on provided name</p>
<p>Please enter a customer name</p>
<input type="text" class="btn btn-lg btn-primary btn-block" name="revenuename" placeholder="eg: Tom Cat"><br>
<input type="submit" class="btn btn-lg btn-primary btn-block" value="View"></input>
</form>
<form method = "post" action="${pageContext.request.contextPath}/revenueCR">
<p>Produce a customer representative who generated the most revenue in total</p>
<input type="submit" class="btn btn-lg btn-primary btn-block" value="View"></input>
</form>
<form method = "post" action="${pageContext.request.contextPath}/revenueCus">
<p>Produce a customer who generated the most revenue in total</p>
<input type="submit" class="btn btn-lg btn-primary btn-block" value="View"></input>
</form>
<form method = "post" action="${pageContext.request.contextPath}/revenueCus">
<p>Produce a list of most active customers</p>
<input type="submit" class="btn btn-lg btn-primary btn-block" value="View"></input>
</form>

</body>
</html>