<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>    
    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Page</title>
<style type="text/css">
	.error{
		color: #ff0000;
	}
	.errorblock{
		color: #000;
		background-color: #ffEEEE;
		border: 3px solid #ff0000;
		padding: 8px;
		margin: 16px;
	}

</style>

</head>
<body>

	<form:form commandName="user">
		<form:errors path="*" cssClass="errorblock" element="div"/>
		<label for="textinput1">Enter User Name:</label>
		<form:input path="username" cssErrorClass="error"/>
		<form:errors path="username" cssClass="error" />
		<br>
		
		<label for="textinput2">Enter Password:</label>
		<form:password path="password" cssErrorClass="error"/>
		<form:errors path="password" cssClass="error" />
		<br>
		
		<input type="submit" class="btn" value="Login" />
	</form:form>
</body>
</html>