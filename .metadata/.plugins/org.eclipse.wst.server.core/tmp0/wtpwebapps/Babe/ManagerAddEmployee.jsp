<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="sql.WebpgUtil"%>
<%@ page import="utilServlet.inputValidate"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employee Sign Up</title>
</head>
<body>
	<!-- SignUp Modal -->
	<%
		//This code is for alerting there is an userID which is same as user signed up.

			if (WebpgUtil.isIdExists()) {
	%>
	<script type="text/javascript">
		alert("The id already exists");
		$(document).ready(function() {
			$("#mySignUp").modal("show");
		});
	</script>

	<%
		WebpgUtil.setIdExists(false);
			}
	%>

	<%
		//This code is for alerting password confirmation doesn't match password.

		if (inputValidate.isMismatch()) {
	%>
	<script type="text/javascript">
		alert("Password Confirmation does not match");
		$(document).ready(function() {
			$("#mySignUp").modal("show");
		});
	</script>

	<%
	inputValidate.setMismatch(false);
		}
	%>

	<%
		//This code is for validating ssn

		if (inputValidate.ssnInvalid()) {
	%>
	<script type="text/javascript">
		alert("Invalid Social Security Number");
		$(document).ready(function() {
			$("#mySignUp").modal("show");
		});
	</script>

	<%
	inputValidate.validateSSN(false);
		}
	%>

	<%
		//This code is for validating zipCode

		if (inputValidate.zipCodeInvalid()) {
	%>
	<script type="text/javascript">
		alert("Invalid Zip Code");
		$(document).ready(function() {
			$("#mySignUp").modal("show");
		});
	</script>

	<%
	inputValidate.validateZip(false);
		}
	%>

	<%
		//This code is for validating credit card

		if (inputValidate.creditCardInvalid()) {
	%>
	<script type="text/javascript">
		alert("Invalid Credit Card");
		$(document).ready(function() {
			$("#mySignUp").modal("show");
		});
	</script>

	<%
	inputValidate.validateCCD(false);
		}
	%>

	<Center>
		<b>Add A New Employee</b>
	</Center>
	<form role="form" data-toggle="validator" name="signupForm"
		action="${pageContext.request.contextPath}/MaddE" method="POST">
		<div Class="Reg">
			<input type="text" class="form-control" id="ssn"
				placeholder="Social Security Number" name="SSN" required>
			SSN
		</div>

		<div Class="Reg">
			<input type="password" class="form-control" id="pwd"
				placeholder="Password" name="Password" required> Password
		</div>

		<div Class="Reg">
			<input type="password" class="form-control" id="pwd2"
				placeholder="Password confirm" name="PasswordConf" required>
			Confirm Password
		</div>

		<div Class="Reg">
			<input type="text" class="form-control" id="fname"
				placeholder="First Name" name="FirstName" required> First
			Name
		</div>

		<div Class="Reg">
			<input type="text" class="form-control" id="lname"
				placeholder="Last Name" name="LastName" required> Last Name
		</div>

		<div Class="Reg">
			<input type="text" class="form-control" id="street" name="Street"
				placeholder="Street" required> Street
		</div>

		<div Class="Reg">
			<input type="text" class="form-control" name="City" id="city"
				placeholder="city" required> City
		</div>
		<div Class="Reg">
			<input type="text" class="form-control" id="state" name="State"
				placeholder="state" required> State
		</div>
		<div Class="Reg">
			<input type="text" class="form-control" name="Zipcode" id="zipcode"
				placeholder="zipcode" required> Zipcode
		</div>
		<div Class="Reg">
			<input type="email" class="form-control" id="email" name="Email"
				placeholder="email" required> Email
		</div>
		<div Class="Reg">
			<input type="text" class="form-control" id="telephone"
				name="Telephone" placeholder="telephone" required> Phone
			Number
		</div>
		
		<div Class="Reg">
			<input type="text" class="form-control" id="role" name="role"
				placeholder="role" required> Role
		</div>
	
		<div Class="Reg">
			<input type="text" class="form-control" id="hourlyrate" name="hourlyrate"
				placeholder="hourlyrate" required> Hourly Rate
		</div>
		<div Class="Reg">
			<input type="text" class="form-control" id="CreditCardNo" name="CreditCardNo"
				placeholder="CreditCardNo" required> Credit Card Number
		</div>
		
		<form class = "addUser" action = "${pageContext.request.contextPath}/MaddE" method="get">
			<input type="submit" name="Add" value="Add">
		</form>	
	</form>

	<input type="submit" class="btn btn-default pull-left"
		data-dismiss="modal" value="Cancel" onclick="window.location.href='ShowAllEmployee.jsp'">
		<span class="glyphicon glyphicon-remove"></span>
	</button>
</body>
</html>