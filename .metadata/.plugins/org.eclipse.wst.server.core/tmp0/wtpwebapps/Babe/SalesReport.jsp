<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import = "sql.WebpgUtil"%>
<%@ page import = "javabeans.User"%>
<%@page import = "java.util.ArrayList"%>
<%@ page import = "java.text.SimpleDateFormat"%>
<%@ page import = "java.text.DateFormat"%> 
<%@ page import = "java.util.Date"%>
<%@ page import = "javabeans.salesReport"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>View Sale Report</title>
</head>
<body>
<%
	System.out.println("before get session");
	ArrayList<salesReport> reportList = WebpgUtil.getReport(WebpgUtil.getReportSession());
	System.out.println("after get session");
%>
<center>
<h1>
User Information List
</h1>
</center>
<table style="width:100%" border = "1">
		<tr>
			<th>Profile A</th>
			<th>Profile B</th>
			<th>Cust Rep SSN</th>
			<th>Fees</th>
			<th>Date</th>
		</tr>
	
	<% 	
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		for(int i = 0; i < reportList.size(); i++){
			salesReport r = reportList.get(i);
			Date d = r.getDate().getTime();%>
		<tr>
			
			<td>
					<textarea name = "profileA" style="border: none"><%= r.getProfileA()%></textarea>
			</td>
			<td>
					<textarea name = "profileB" style="border: none"><%= r.getProfileB()%></textarea>
			</td>	
			<td>
					<textarea name = "SSN" style="border: none"><%= r.getCustRepSSN()%></textarea>
			</td>
			<td>
					<textarea name = "fees" style="border: none"><%= r.getFees()%></textarea>
			</td>
			<td>
					<textarea name = "getdate" style="border: none"><%= dateFormat.format(d)%></textarea>
			</td>
			
		</tr>
	<% } %>
	
	<form class = "Back" action = "${pageContext.request.contextPath}/ManagerProfile.jsp" method="get">
			<input type="submit" name="BacktoP" value="Back" maxlength="35">
	</form>		
</table>
</body>
</html>