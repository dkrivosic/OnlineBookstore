<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
	session="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<title>Nova knjiga</title>

<style type="text/css">
		.greska {
				font-family: Arial;
				font-size: 11px;
				color: #B22222;
			}
		body {
				background-color: #8AB5EE;
				width: 800px;
				margin-left: auto;
				margin-right: auto;
				margin-top: 100px;
				font-family:Verdana;
			}
			div.a {
				padding: 50px;
				border: 5px solid #040F37;
				
			}
			td {
				padding: 8px;
				font-size: 13px;
			}
			div.b  {
				padding-bottom: 15px;
				text-align:right;
				font-family: "Courier New";
				font-style:oblique;
				font-size: 30px;
				color: navy;
				font-weight: bold;
			}
</style>
</head>
<body>
	<div class="b">
		E-knjižara List
	</div>
<div class="a">
	<form action="spremiKnjigu" method="post">
		<table align="center">
			<tr>
				<td>Naslov</td>
				<td><input type="text" name="naslov" value="${zapis.naslov}"
					size="40" maxlength="100"></td>
				<td><c:if test="${zapis.imaPogresku('naslov')}">
						<div class="greska">
							<c:out value="${zapis.dohvatiPogresku('naslov')}" />
						</div>
					</c:if></td>
			</tr>
			<tr>
				<td>Autori (odvojeni zarezom)</td>
				<td><input type="text" name="autori" value="${zapis.autori}"
					size="40" maxlength="100"></td>
				<td><c:if test="${zapis.imaPogresku('autori')}">
						<div class="greska">
							<c:out value="${zapis.dohvatiPogresku('autori')}" />
						</div>
					</c:if></td>
			</tr>
			<tr>
				<td>Godina izdanja</td>
				<td><input type="text" name="datumIzdanja"
					value="${zapis.datumIzdanja}" size="11" maxlength="11"></td>
				<td><c:if test="${zapis.imaPogresku('datum')}">
						<div class="greska">
							<c:out value="${zapis.dohvatiPogresku('datum')}" />
						</div>
					</c:if></td>
			</tr>
			<tr>
				<td>Broj stranica</td>
				<td><input type="text" name="brojStranica"
					value="${zapis.brojStranica}" size="5" maxlength="5"></td>
				<td><c:if test="${zapis.imaPogresku('brojStranica')}">
						<div class="greska">
							<c:out value="${zapis.dohvatiPogresku('brojStranica')}" />
						</div>
					</c:if></td>
			</tr>
			<tr>
				<td>Žanr</td>
				<td><input type="text" name="zanr"
					value="${zapis.zanr}" size="40" maxlength="40"></td>
			</tr>
			<tr>
				<td>ISBN</td>
				<td><input type="text" name="isbn"
					value="${zapis.isbn}" size="40" maxlength="100"></td>
				<td><c:if test="${zapis.imaPogresku('isbn')}">
						<div class="greska">
							<c:out value="${zapis.dohvatiPogresku('isbn')}" />
						</div>
					</c:if></td>
			</tr>
			<tr>
				<td>Poveznica na knjigu</td>
				<td><input type="text" name="linkNaKnjigu"
					value="${zapis.linkNaKnjigu}" size="40" maxlength="100"></td>
				<td><c:if test="${zapis.imaPogresku('linkNaKnjigu')}">
						<div class="greska">
							<c:out value="${zapis.dohvatiPogresku('linkNaKnjigu')}" />
						</div>
					</c:if></td>
			</tr>
			<tr>
				<td>Certifikat autentičnosti</td>
				<td><input type="text" name="certifikat"
					value="${zapis.certifikat}" size="40" maxlength="100"></td>
				<td><c:if test="${zapis.imaPogresku('certifikat')}">
						<div class="greska">
							<c:out value="${zapis.dohvatiPogresku('certifikat')}" />
						</div>
					</c:if></td>
			</tr>
			<tr>
				<td>Početna cijena (kn)</td>
				<td><input type="text" name="pocetnaCijena"
					value="${zapis.pocetnaCijena}" size="7" maxlength="7"></td>
				<td><c:if test="${zapis.imaPogresku('cijena')}">
						<div class="greska">
							<c:out value="${zapis.dohvatiPogresku('cijena')}" />
						</div>
					</c:if></td>
			</tr>
			<tr style="text-align:center">
				<td><input type="submit" name="metoda" value="Spremi knjigu"></td>
				<td><input type="submit" name="metoda" value="Odustani"></td>
			</tr>
		</table>
	</form>
	</div>
</body>


</html>