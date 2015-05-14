<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
	session="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<title>Pretraga knjiga</title>
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
	<form action="pretrazi" method="get">
		<table align="right">
			<tr>
				<td style="text-align:right">Pretraži po: <input type="radio" name="tipPretrage"
					value="naslov" checked>naslovu <input type="radio"
					name="tipPretrage" value="autori">autoru <input
					type="radio" name="tipPretrage" value="zanr">žanru <input
					type="radio" name="tipPretrage" value="godina">godini
					izdanja
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
	
	<table>
		<tr>
			<td>Naslov</td>
			<td>Autori</td>
			<td>Vlasnik</td>
			<td>Cijena</td>
		</tr>
		<c:forEach var="knjiga" items="${knjige}">
			<tr>
				<form action="pregledajKnjigu" method="post">
					<input type="hidden" name="id" value="${knjiga.id}">
					<td>${knjiga.naslov}</td>
					<td>${knjiga.autori}</td>
					<td>${knjiga.nadimakVlasnika}</td>
					<td>${knjiga.pocetnaCijena * knjiga.razinaStogaKupnje}</td>
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
	</div>
</body>
</html>