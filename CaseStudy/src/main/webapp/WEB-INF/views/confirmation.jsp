<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>

<head>
<title>COVID 19 Appointment Machine</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="stylesheet" href="../resources/css/styles.css">
<link rel="preconnect" href="https://fonts.gstatic.com">
<link
	href="https://fonts.googleapis.com/css2?family=Source+Sans+Pro:wght@300&display=swap"
	rel="stylesheet">

<script type="text/javascript" src="../resources/js/scripts.js"></script>

<style>
table {
	position: absolute;
	font-family: 'Source Sans Pro', sans-serif;
	border-spacing: 10px;
	top: 240px;
	left: 88px;
}

#message {
	left: 200px;
}
</style>
</head>
<body>

	<div class="dropdown">
		<button onclick="menu()" class="dropbtn">Contact</button>
		<div id="myDropdown" class="dropdown-content">
			<a href="${contextPath}/welcome">Home</a>
		</div>
	</div>

	<section>
		<p id="message">Thank you for signing up!</p>
		<table style="text-align: left">
			<tr>
				<th>Contributors</th>
				<th>Email</th>
				<th>Phone</th>
			</tr>
			<tr>
				<td>Riyadhul Taher</td>
				<td>riyadhultaher@fakeemail.com</td>
				<td>1-800-FAKENUMBER</td>
			</tr>
		</table>
	</section>

</body>
</html>