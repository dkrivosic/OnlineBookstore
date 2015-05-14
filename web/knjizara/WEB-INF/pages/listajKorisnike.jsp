<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
	session="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<title>Pretraga korisnika</title>
<style>
	body {
		background-color: #8AB5EE;
		width: 1000px;
		margin-left: auto;
		margin-right: auto;
		margin-top: 60px;
		font-family:Arial;
	}
	div.a {
		padding: 50px;
		
	}
	table {
		text-align: left;
	}
	td {
		padding: 8px;
		font-size: 17px;
	}
	div.b {
		text-align: center;
	}
	div.c {
		padding-bottom: 10px;
		text-align:right;
		font-family: "Courier New";
		font-style:oblique;
		font-size: 30px;
		color: navy;
		font-weight: bold;
	}
	
	hr {
		width: 100%;
		height: 1px;
		background: #000000
	}	
</style>
</head>
<body>
	<div class="c">
		E-knjižara List
	</div>
	<div class="a">
	<form action="pretraziKorisnike" method="get">
		<table align="right">
			<tr>
				<td style="text-align:right">Pretraži po: <input type="radio" name="tipPretrage"
					value="ime">imenu <input type="radio"
					name="tipPretrage" value="prezime">prezimenu <input
					type="radio" name="tipPretrage" value="nadimak">nadimku
				</td>
			</tr>
			<tr>
				<td style="text-align:right"><input type="text" name="upit" size="40" maxlength="40">
				<input type="submit" name="metoda" value="Pretraži"></td>

			</tr>
			<tr>
		</table>
	</form>
	<hr />
	<table class>
		<tr>
			<td>Ime</td>
			<td>Prezime</td>
			<td>Nadimak</td>
		</tr>
		<c:forEach var="korisnik" items="${korisnici}">
			<tr>
				<form action="pregledajKorisnika" method="post">
					<input type="hidden" name="nadimak" value="${korisnik.nadimak}">
					<td>${korisnik.ime}</td>
					<td>${korisnik.prezime}</td>
					<td>${korisnik.nadimak}</td>
					<td><input type="submit" name="metoda" value="Pogledaj"></td>
				</form>
			</tr>
		</c:forEach>
	</table>
	<hr />
	<div class="b">
	<form action="naslovna" method="get">
		<input type="submit" name="metoda" value="Povratak na naslovnicu">
	</form>
	</div>
</body>
</html>