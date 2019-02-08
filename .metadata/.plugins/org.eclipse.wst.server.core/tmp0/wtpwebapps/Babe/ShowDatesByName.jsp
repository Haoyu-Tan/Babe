<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import = "sql.WebpgUtil"%>
<%@page import = "java.util.ArrayList"%>
<%@ page import = "java.text.SimpleDateFormat"%>
<%@ page import = "java.text.DateFormat"%> 
<%@ page import = "java.util.Date"%>
<%@ page import = "javabeans.salesReport"%>
<%@ page import = "javabeans.Dates"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Show Date By Name</title>
</head>
<body>
<h2>
Below is a list of dates that generate by a specific of customer
</h2>
<body>
<%
	System.out.println("before get session");
	ArrayList<Dates> dateList = WebpgUtil.getDatesByName(WebpgUtil.getSearchDateByNameSession());
	System.out.println("after get session");
%>
<center>

</center>
<table style="width:100%" border = "1">
		<tr>
			<th>Profile 1</th>
			<th>Profile 2</th>
			<th>Cust Rep</th>
			<th>Location</th>
			<th>Booking Fee</th>
			<th>Comments</th>
			<th>User1 Rating</th>
			<th>User2 Rating</th>
			<th>Date Time</th>
		</tr>
	
	<% 	
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		for(int i = 0; i < dateList.size(); i++){
			Dates date = dateList.get(i);
			Date d = date.getDateTime().getTime();%>
		<tr>
			
			<td>
					<textarea name = "profile1" style="border: none"><%= date.getProfile1()%></textarea>
			</td>
			<td>
					<textarea name = "profile2" style="border: none"><%= date.getProfile2()%></textarea>
			</td>	
			<td>
					<textarea name = "SSN" style="border: none"><%= date.getCustRep()%></textarea>
			</td>
			<td>
					<textarea name = "location" style="border: none"><%= date.getLocation()%></textarea>
			</td>
			<td>
					<textarea name = "fee" style="border: none"><%= date.getBookingFee()%></textarea>
			</td>
			<td>
					<textarea name = "common" style="border: none"><%= date.getComments()%></textarea>
			</td>
			<td>
					<textarea name = "rating1" style="border: none"><%= date.getUser1Rating()%></textarea>
			</td>
			<td>
					<textarea name = "rating2" style="border: none"><%= date.getUser2Rating()%></textarea>
			</td>
			
			<td>
					<textarea name = "getdate" style="border: none"><%= dateFormat.format(d)%></textarea>
			</td>
			
		</tr>
	<% } %>
	
	<form class = "Back" action = "${pageContext.request.contextPath}/ManagerProfile.jsp">
			<input type="submit" name="BacktoP" value="Back" maxlength="35">
	</form>		
</table>
</body>
</html>