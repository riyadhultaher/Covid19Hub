<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<title>Get Started</title>

<link rel="stylesheet" href="../resources/css/styles.css">
<link rel="preconnect" href="https://fonts.gstatic.com">
<link
	href="https://fonts.googleapis.com/css2?family=Source+Sans+Pro:wght@300&display=swap"
	rel="stylesheet">

<script type="text/javascript" src="../resources/js/scripts.js"></script>

<style>
form {
	position: relative;
	font-family: 'Source Sans Pro', sans-serif;
	top: 150px;
}

#errorMessage {
	position: relative;
	font-family: 'Source Sans Pro', sans-serif;
	color: red;
	top: 130px;
}
</style>
</head>

<body>

	<div class="dropdown">
		<button onclick="menu()" class="dropbtn">Start</button>
		<div id="myDropdown" class="dropdown-content">
			<a href="${contextPath}/login">Home</a>
		</div>
	</div>

	<div class="container">
		<p id="message">
			Please create a username and password below to get started. <br>
			Your password must contain at least 8 characters.<br>
		</p>
		<span id="errorMessage">${errorMessage}</span>
		<form:form method="POST" modelAttribute="userForm" class="form-signin">
			<spring:bind path="username">
				<div class="form-group ${status.error ? 'has-error' : ''}">
					<form:input type="text" path="username" class="form-control"
						placeholder="Username" autofocus="true" ></form:input>
					<form:errors path="username"></form:errors>
				</div>
			</spring:bind>

			<spring:bind path="password">
				<div class="form-group ${status.error ? 'has-error' : ''}">
					<form:input type="password" path="password" class="form-control"
						placeholder="Password"></form:input>
					<form:errors path="password"></form:errors>
				</div>
			</spring:bind>

			<spring:bind path="passwordConfirm">
				<div class="form-group ${status.error ? 'has-error' : ''}">
					<form:input type="password" path="passwordConfirm"
						class="form-control" placeholder="Confirm your password"></form:input>
					<form:errors path="passwordConfirm"></form:errors>
				</div>
			</spring:bind>

			<spring:bind path="states">
				<div class="form-group ${status.error ? 'has-error' : ''}">
					<form:select path="states[0].name" items="${allStates}" />
				</div>
			</spring:bind>
			<button id="messageButton" type="submit">SUBMIT</button>
		</form:form>

	</div>

	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>