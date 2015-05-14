<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
	session="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>



<html>
<head>
<title>List d.o.o.</title>
</head>
<style>
body {
	background-color: #B2C9F9;
	width: 1200px;
	margin-left: auto;
	margin-right: auto;
	margin-top: 50px;
}

ol.a {
	text-align: left;
}

hr {
	width: 100%;
	height: 1px;
	background: #000000
}

div.a {
	background-color: #07F19F;
	padding-top: 30px;
	padding-bottom: 5px;
	text-align: center;
	font-family: "Courier New";
	font-style: oblique;
	font-weight: bold;
	font-size: 40px;
	color: #273724;
	text-shadow: 5px 5px 5px green;
}
</style>
<body>
	<div class="a">
		E-knjižara List
		<p
			style="color: black; font-weight: normal; text-align: right; font-size: 15px; text-decoration: underline;">List
			d.o.o., mat.br.: 81130234</p>
	</div>
	<c:choose>
		<c:when test="${applicationScope['korisnik'] != null}">

			<div
				style="background-color: #07B7F1; color: white; font-family: Arial; text-align: right;">
				Prijavljeni ste kao <b>${applicationScope['korisnik']}</b>
			</div>

			<table align="right">
				<tr>

					<td><form action="uredi" method="get">
							<input type="submit" name="metoda" value="Uredi profil">
						</form></td>
					<td><form action="listajKnjige" method="get">
							<input type="submit" name="metoda" value="Knjige">
						</form></td>
					<td><form action="listajKorisnike" method="get">
							<input type="submit" name="metoda" value="Korisnici">
						</form></td>
					<c:if test="${applicationScope['korisnik'].nadimak == 'vlasnik'}">
						<td><form action="dodajKnjigu" method="get">
								<input type="submit" name="metoda" value="Dodaj knjigu">
							</form></td>
					</c:if>
					<c:if test="${applicationScope['korisnik'].nadimak != 'vlasnik'}">
						<td><form action="klijentiPartneri" method="get">
								<input type="submit" name="metoda" value="Klijenti-partneri">
							</form></td>
					</c:if>
					<td><form action="odjava" method="get">
							<input type="submit" name="metoda" value="Odjavi se">
						</form></td>
				</tr>
			</table>
			<hr />
		</c:when>
		<c:otherwise>

			<form action="prijava" method="post">

				<table align="right">
					<tr>
						<td><input type="text" placeholder="Nadimak" name="nadimak"
							size="20" maxlength="40"></td>
						<td><input type="password" placeholder="Lozinka"
							name="lozinka" size="20" maxlength="40"></td>
						<td><input type="submit" name="metoda" value="Prijavi se"></td>
						<td><input type="submit" name="metoda" value="Registracija"></td>
					</tr>
				</table>

			</form>

		</c:otherwise>
	</c:choose>
	<br>
	<div style="float: left">
		Knjiga kupljeno od knjižare: ${prodaje}<br> Ukupno kupnji:
		${ukupnoKupnji} <br> <br>

		<c:if test="${!kupci.isEmpty()}">
		Rang korisnika po broju kupljenih knjiga:
		<ol class="a">
				<c:forEach var="kupac" items="${kupci}">
					<li>${kupac}</li>
				</c:forEach>
			</ol>
		</c:if>

		<c:if test="${!prodavaci.isEmpty()}">
		Rang korisnika po broju prodanih knjiga:
		<ol class="a">
				<c:forEach var="prodavac" items="${prodavaci}">
					<li>${prodavac}</li>
				</c:forEach>
			</ol>
		</c:if>

	</div>

</body>
</html>
