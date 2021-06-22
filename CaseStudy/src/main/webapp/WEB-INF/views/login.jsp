
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<title>Home</title>

<link rel="stylesheet" href="../resources/css/styles.css">
<link rel="preconnect" href="https://fonts.gstatic.com">
<link
	href="https://fonts.googleapis.com/css2?family=Source+Sans+Pro:wght@300&display=swap"
	rel="stylesheet">

<script type="text/javascript" src="../resources/js/scripts.js"></script>

<style>
.form-control {
	position: relative;
	font-family: 'Source Sans Pro', sans-serif;
	top: 130px;
}

#messageButton {
	top: 475px;
}

#text-center {
	display: flex;
	position: absolute;
	top: 475px;
	left: 200px;
	background-color: #1f1f1f;
	padding: 15px;
	color: white;
	font-family: 'Source Sans Pro', sans-serif;
	text-align: center;
}

#text-center a {
	text-decoration: none;
	color: white;
}

#text-center:hover, .text-center:focus {
	background-color: gray;
	cursor: pointer;
}

#errormessage {
	top: 400px;
	left: 250px;
	font-family: 'Source Sans Pro', sans-serif;
	display: flex;
	position: absolute;
}
</style>

</head>

<body>

	<div class="dropdown">
		<button onclick="menu()" class="dropbtn">Home</button>
		<div id="myDropdown" class="dropdown-content">
			<a href="${contextPath}/registration">Start</a>
		</div>
	</div>

	<div class="container">
		<form method="POST" action="${contextPath}/login" class="form-signin">
			<p id="message">
				Coronavirus disease (COVID-19) is an <br> infectious disease
				caused by a newly <br> discovered coronavirus called
				SARS-CoV-2. <br> Researchers and scientists have <br>
				worked towards developing a vaccine <br> that is effective in
				preventing life <br> threatening symptoms caused by SARS CoV-2.
				<br> However, securing appointments <br> has been
				difficult in the United States. <br> This application will
				provide users information <br> regarding COVID-19 vaccines.
			</p>
			<div class="form-group ${error != null ? 'has-error' : ''}">
				<span>${message}</span> <input name="username" type="text"
					class="form-control" placeholder="Username" autofocus="true" /> <br>
				<input name="password" type="password" class="form-control"
					placeholder="Password" /> <span id="errormessage">${error}</span> <input
					type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />

				<button id="messageButton" type="submit">LOG IN</button>
				<button id="text-center" type="button">
					<a href="${contextPath}/registration">NEW USER</a>
				</button>
			</div>
		</form>
	</div>

	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>