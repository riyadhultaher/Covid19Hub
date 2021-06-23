<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<title>Options</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="stylesheet" href="../resources/css/styles.css">
<link rel="preconnect" href="https://fonts.gstatic.com">
<link
	href="https://fonts.googleapis.com/css2?family=Source+Sans+Pro:wght@300&display=swap"
	rel="stylesheet">

<script type="text/javascript" src="../resources/js/scripts.js"></script>

<style>
#messageButton {
	top: 250px;
	left: 250px;
}

#messageButton a {
	text-decoration: none;
	color: white;
}

#button2 {
	display: flex;
	position: absolute;
	top: 250px;
	left: 450px;
	background-color: #1f1f1f;
	padding: 15px;
	color: white;
	font-family: 'Source Sans Pro', sans-serif;
	text-align: center;
}

#button2 a {
	text-decoration: none;
	color: white;
}

#button2:hover, .messageButton:focus {
	background-color: gray;
	cursor: pointer;
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

	<button id="messageButton" type="button">
		<a href="${contextPath}/changePassword">CHANGE PASSWORD</a>
	</button>
	<button id="button2" type="button">
		<a href="${contextPath}/addState">ADD STATE</a>
	</button>
</body>
</html>