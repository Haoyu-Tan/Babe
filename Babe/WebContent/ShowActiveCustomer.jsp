<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import = "sql.WebpgUtil"%>
<%@page import = "java.util.ArrayList"%>
<%@ page import = "java.text.SimpleDateFormat"%>
<%@ page import = "java.text.DateFormat"%> 
<%@ page import = "java.util.Date"%>
<%@ page import = "javabeans.Profile"%>
<%@ page import = "javabeans.Dates"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Most Active Customer</title>
</head>
<body>
<%
	ArrayList<Profile> profList =  WebpgUtil.getActiveUser(WebpgUtil.getActiveProfileSession());
%>
<table style="width:100%" border = "1">
		<tr>
			<th>ProfileID</th>
			<th>SSN</th>
			<th>Age</th>
			<th>Dating Age Range Start</th>
			<th>Dating Age Range End</th>
			<th>Dating Geo Range</th>
			<th>Gender</th>
			<th>Hobbies</th>
			<th>Height</th>
			<th>Weight</th>
			<th>Hair Color</th>
			<th>Creation Date</th>
			<th>Last Active Date</th>
		</tr>
	
	<% 	
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		for(int i = 0; i < profList.size(); i++){
			Profile p = profList.get(i);
			Date date1 = p.getCreationDate().getTime();
			Date date2 = p.getLastModDate().getTime();%>
		<tr>
			<form class = "userInfo" action = "${pageContext.request.contextPath}/UES">
			<td>
					<textarea name = "profID" style="border: none"><%= p.getProfileID()%></textarea>
			</td>	
			<td>
					<textarea name = "SSN" style="border: none"><%= p.getOwnerSSN()%></textarea>
			</td>
			<td>
					<textarea name = "age" style="border: none"><%= p.getAge()%></textarea>
			</td>
			<td>
					<textarea name = "agestart" style="border: none"><%= p.getDatingAgeRangeStart()%></textarea>
			</td>
			<td>
					<textarea name = "ageend" style="border: none"><%= p.getDatingAgeRangeEnd()%></textarea>
			</td>
			<td>
					<textarea name = "georange" style="border: none"><%= p.getDatingGeoRange()%></textarea>
			</td>
			<td>
					<textarea name = "gender" style="border: none"><%= p.getGender()%></textarea>
			</td>
			<td>
					<textarea name = "hobbies" style="border: none"><%= p.getHobbies()%></textarea>
			</td>
			<td>
					<textarea name = "height" style="border: none"><%= p.getHeight()%></textarea>
			</td>
			<td>
					<textarea name = "weight" style="border: none"><%= p.getWeight()%></textarea>
			</td>
			<td>
					<textarea name = "hairColor" style="border: none"><%= p.getHairColor()%></textarea>
			</td>
			<td>
					<textarea name = "creationdate" style="border: none"><%= dateFormat.format(date1)%></textarea>
			</td>
			<td>
					<textarea name = "lastactivedate" style="border: none"><%= dateFormat.format(date2)%></textarea>
			</td>
			</form>
		</tr>
	<% } %>
</table>

</body>
</html>