<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>

<head>
<title>Change Password</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

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
	top: 250px;
	right: 120px;
}

#message {
	left: 200px;
}
</style>
</head>
<body>

	<div class="dropdown">
		<button onclick="menu()" class="dropbtn">Options</button>
		<div id="myDropdown" class="dropdown-content">
			<a href="${contextPath}/welcome">Home</a>
		</div>
	</div>
	<p id="message">
		Your password must contain at least 8 characters.<br>
	</p>
	<form:form method="POST" modelAttribute="user" class="form-signin">
		<div class="form-group ${status.error ? 'has-error' : ''}">
			<form:input type="password" path="password" class="form-control"
				placeholder="New password" value=""></form:input>
			<form:errors path="password"></form:errors>
		</div>

		<div class="form-group ${status.error ? 'has-error' : ''}">
			<form:input type="password" path="passwordConfirm"
				class="form-control" placeholder="Confirm your password"></form:input>
			<form:errors path="passwordConfirm"></form:errors>
		</div>
		<button id="messageButton" type="submit">SUBMIT</button>
	</form:form>
</body>
</html>