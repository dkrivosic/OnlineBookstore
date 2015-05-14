<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
	session="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<title>Komentiraj</title>
<style>
body {
	background-color: #8AB5EE;
	width: 800px;
	margin-left: auto;
	margin-right: auto;
	margin-top: 100px;
	font-family: Verdana;
}
div.b {
	padding-bottom: 15px;
	text-align: right;
	font-family: "Courier New";
	font-style: oblique;
	font-size: 30px;
	color: navy;
	font-weight: bold;
}
div.a {
	padding: 50px;
	border: 5px solid #040F37;
}
td {
	text-align: center;
	padding: 8px;
	font-size: 13px;
}
</style>
</head>
<body>
	<div class="b">E-knjižara List</div>
	<div class="a">
	<form action="spremiKomentar" method="post">
		<table align = "center">
			<tr>
				<td><input type="hidden" name="nadimak"
					value="${applicationScope['korisnik'].nadimak}"></td>
			</tr>
			<tr>
				<td><input type="hidden" name="id" value="${id}"></td>
			</tr>
			<tr>
				<td>Tekst komentara:</td>
				<td><textarea rows="5" cols="40" name="tekst"></textarea></td>
			</tr>
			<tr>
			<td><input type="radio" name="like" value="true" checked>Sviđa mi se</td>
			<td><input type="radio" name="like" value="false">Ne sviđa mi se</td>
			</tr>
			<tr>
			<td><input type="submit" name="metoda" value="Komentiraj"></td>
			<td><input type="submit" name="metoda" value="Odustani"></td>
			</tr>
		</table>
	</form>
	</div>
</body>
</html>