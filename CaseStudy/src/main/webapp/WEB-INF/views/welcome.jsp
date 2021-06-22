<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<title>Welcome</title>

<style>
h2 {
	position: relative;
	font-family: 'Source Sans Pro', sans-serif;
	top: 70px;
	left: 150px;
}

table {
	position: absolute;
	font-family: 'Source Sans Pro', sans-serif;
	border-spacing: 10px;
	top: 240px;
	left: 88px;
}

#logoutbutton {
	cursor: pointer;
}
</style>

<link rel="stylesheet" href="../resources/css/styles.css">
<link rel="preconnect" href="https://fonts.gstatic.com">
<link
	href="https://fonts.googleapis.com/css2?family=Source+Sans+Pro:wght@300&display=swap"
	rel="stylesheet">

<script type="text/javascript" src="../resources/js/scripts.js"></script>
</head>
<body>
	<div class="dropdown">
		<button onclick="menu()" class="dropbtn">Welcome</button>
		<div id="myDropdown" class="dropdown-content">
			<a href="${contextPath}/options">Options</a> <a
				href="${contextPath}/about">About</a> <a
				href="${contextPath}/contact">Contact</a> <a id="logoutbutton"
				onclick="document.forms['logoutForm'].submit()">Logout</a>
		</div>
	</div>

	<div class="container">
		<c:if test="${pageContext.request.userPrincipal.name != null}">
			<form id="logoutForm" method="POST" action="${contextPath}/logout">
				<input type="hidden" name="${_csrf.parameterName}"
					value="${_csrf.token}" />
			</form>

			<h2>Welcome ${pageContext.request.userPrincipal.name}</h2>

		</c:if>
		<table style="text-align: left">
			<tr>
				<th>Your States</th>
			</tr>
			<c:forEach items="${listStates}" var="state">
				<tr>
					<td><a href="${state.hyperlink}" target="_blank">${state.name}</a></td>
					<td><a href="delete?name=${state.name}">Delete</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>