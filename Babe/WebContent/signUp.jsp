<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>


<%@ page import="utilServlet.inputValidate"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Sign Up</title>
<script type="text/javascript">
	function handleCheck(){
		var able = document.getElementById("registered").checked;
		if (able == true){
			document.getElementById("fname").disabled = true;
			document.getElementById("lname").disabled = true;
			document.getElementById("street").disabled = true;
			document.getElementById("city").disabled = true;
			document.getElementById("state").disabled = true;
			document.getElementById("zipcode").disabled = true;
			document.getElementById("email").disabled = true;
			document.getElementById("telephone").disabled = true;
			document.getElementById("registered").value = "yes";
		}
		else{
			//set value to able
			document.getElementById("fname").disabled = false;
			document.getElementById("lname").disabled = false;
			document.getElementById("street").disabled = false;
			document.getElementById("city").disabled = false;
			document.getElementById("state").disabled = false;
			document.getElementById("zipcode").disabled = false;
			document.getElementById("email").disabled = false;
			document.getElementById("telephone").disabled = false;
			document.getElementById("registered").value = null;
		}
	}
	
	
</script>

</head>
<body>

	<Center>
		<b>Welcome!</b>
	</Center>
	<form role="form" data-toggle="validator" name="signupForm"
		action="${pageContext.request.contextPath}/signup" method="POST">
		<p>Profile Information</p>
		
		<div Class="Reg">
			Profile ID: <input type="text" class="form-control" id="profileid"
				name="profileID" placeholder="eg:John123" required>
				
		</div>
		
		<div Class="Reg">
			Password: <input type="password" class="form-control" id="pwd"
				placeholder="Password" name="Password" required> 
		</div>

		<div Class="Reg">
			Confirm Password: <input type="password" class="form-control" id="pwd2"
				placeholder="Password confirm" name="PasswordConf" required>
			
		</div>
		
		<div Class="Reg">
			Age: <input type="number" class="form-control" id="age"
				name="age" min="18" required>
		</div>
		
		<div Class="Reg">
			Dating Age Range: 
			<br>
			From: <input type="number" class="form-control" id="ageRangeStart"
				name="ageRangeStart" min="18" required>
			<br>
			to <input type="number" class="form-control" id="ageRangeEnd"
			    name="ageRangeEnd" min="18" required>
		</div>
		
		<!-- private int datingGeoRange; -->
		
		<div Class="Reg">
			Gender: 
			<select class="form-control" id="gender" name="gender" required>
				<option value="male">Male</option>
				<option value="female">Female</option>
				<option value="others">Others</option>
			</select>
		</div>
		
		
		<div Class="Reg">
			Hobbies: 
			<input type="text" class="form-control" id="hobbies" name="hobbies" required
			 placeholder="please seperate your hobbies by comma(,)" maxlength="1000">
		</div>
		
		<div Class="Reg">
			Height:
			<input type="number" step="0.01" id="height" name="height" placeholder="eg:1.70" min = "0"> meters
		</div>
			
		<div Class="Reg">
			Weight:
			<input type="number" step="0.01" id="weight" name="weight" placeholder="eg:56.3" min = "0"> kg
		</div>
	
		<div Class="Reg">
			Hair Color:
			<input type="text" id="hairColor" name="hairColor" maxlength="20">
			
		</div>		
		
		<p>Basic Information</p>
		<div Class="Reg">
			<input type="checkbox" name="registered"  id="registered" onclick="handleCheck()" value="no">
			I have already used this SSN to sign up for this website.<br>
			Without checking this, the information below will be updated<br>
			to all of your profile related to this SSN<br>
		</div>
		<div Class="Reg">
			SSN: <input type="text" class="form-control" id="ssn"
				placeholder="Social Security Number" name="SSN" required>
			
		</div>

		<div Class="Reg">
			First Name: <input type="text" class="form-control" id="fname"
				placeholder="First Name" name="FirstName" required>
		
		</div>

		<div Class="Reg">
			Last Name: <input type="text" class="form-control" id="lname"
				placeholder="Last Name" name="LastName" required> 
		</div>

		<div Class="Reg">
			Street: <input type="text" class="form-control" id="street" name="Street"
				placeholder="Street" required>
		</div>

		<div Class="Reg">
			City: <input type="text" class="form-control" name="City" id="city"
				placeholder="city" required>
		</div>
		<div Class="Reg">
			State: <input type="text" class="form-control" id="state" name="State"
				placeholder="state" required>
		</div>
		<div Class="Reg">
			Zipcode: <input type="text" class="form-control" name="Zipcode" id="zipcode"
				placeholder="zipcode" required>
		</div>
		
		<!-- 
			<div Class="Reg">
			Credit Card Number: <input type="text" class="form-control" name="CreditCardNo"
				id="creditCardNo" placeholder="creditCardNo" required>
			
			</div>
		 -->
		
		<div Class="Reg">
			Email: <input type="email" class="form-control" id="email" name="Email"
				placeholder="email" required> 
		</div>
		<div Class="Reg">
			Phone Number:<input type="text" class="form-control" id="telephone"
				name="Telephone" placeholder="telephone" required> 
		</div>
		
		
		<input type="submit" name="signupBtn" value="Sign Up"
			class="btn btn-block sign-up-button" />
	</form>

	<button type="submit" class="btn btn-default pull-left"
		data-dismiss="modal" onclick="window.location.href = 'Signin.jsp'">
		<span class="glyphicon glyphicon-remove"></span> Cancel
	</button>
</body>


</html>