<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>About</title>

<link rel="stylesheet" href="../resources/css/styles.css">
<link rel="preconnect" href="https://fonts.gstatic.com">
<link
	href="https://fonts.googleapis.com/css2?family=Source+Sans+Pro:wght@300&display=swap"
	rel="stylesheet">

<script type="text/javascript" src="../resources/js/scripts.js"></script>
</head>
<body>

	<div class="dropdown">
		<button onclick="menu()" class="dropbtn">About</button>
		<div id="myDropdown" class="dropdown-content">
			<a href="${contextPath}/welcome">Home</a>
		</div>
	</div>

	<p id="message">
		This project began as several different ideas. The first idea was to
		create an automatic tracker with the ability to track vendor <br>
		websites that offered the COVID 19 vaccine. Securing an appointment
		became very difficult so the premise was for the tracker <br> to
		detect any changes in the HTML document representing the vendor
		webpage. After detecting a change, the program would <br> send an
		email to users that signed up with the corresponding information. As
		time went on, the project seemed to encapsulate <br> more of a
		stretch goal. Thus, the project was altered to operate more like a hub
		for users to quickly access COVID 19 regulations <br> based on US
		states. Users can create an account and add an initial US state then
		add any additional states once they are logged <br> in. A table
		will be displayed on their homepage, hyperlinking to the government
		site based on that US state.
	</p>
</body>
</html>