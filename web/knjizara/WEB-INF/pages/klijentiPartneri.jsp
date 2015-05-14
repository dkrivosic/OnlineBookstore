<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
	session="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<title>Klijenti-partneri</title>

<style type="text/css">
body {
	background-color: #8AB5EE;
	width: 800px;
	margin-left: auto;
	margin-right: auto;
	margin-top: 100px;
	font-family: Verdana;
}

ul.a {
	list-style-type: square;
	text-align: left;
}
div.b {
	padding-bottom: 20px;
	text-align: right;
	font-family: "Courier New";
	font-style: oblique;
	font-size: 30px;
	color: navy;
	font-weight: bold;
}
</style>
</head>
<body>
	<div class="b">E-knjižara List</div>
	Korisnici kojima ste prodali knjigu:
	<ul class="a">
		<c:forEach var="klijent" items="${klijenti}">
			<li>${klijent}</li>
		</c:forEach>
	</ul>
	<br> Korisnici od kojih ste kupili knjigu:
	<ul class="a">
		<c:forEach var="partner" items="${partneri}">
			<li>${partner}</li>
		</c:forEach>
	</ul>
	<hr />
	<div style="text-align:center">
	<form action="naslovna" method="get">
		<input type="submit" name="metoda" value="Povratak na naslovnicu">
	</form>
	</div>
</body>
</html>