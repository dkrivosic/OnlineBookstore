<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" session="true" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
	<head>
		<title>Registracija</title>
		
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
			td {
				padding: 8px;
				font-size: 13px;
			}
			div.a {
				padding: 50px;
				border: 5px solid navy;
				
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
		<form action="registracija" method="post">
		<input type="hidden" name="id" value="${zapis.id}" />
		<table align = "center">
		<tr>
		<td>Ime</td><td><input type="text" name="ime" value="${zapis.ime}" size="20" maxlength="40"></td>
		<td><c:if test="${zapis.imaPogresku('ime')}">
			<div class="greska"><c:out value="${zapis.dohvatiPogresku('ime')}" /></div>
		</c:if></td>
		</tr>
		<tr>
		<td>Prezime</td><td><input type="text" name="prezime" value="${zapis.prezime}" size="20" maxlength="40"></td>
		<td><c:if test="${zapis.imaPogresku('prezime')}">
			<div class="greska"><c:out value="${zapis.dohvatiPogresku('prezime')}" /></div>
		</c:if></td>
		</tr>
		<tr>
		<td>Nadimak</td><td><input type="text" name="nadimak" value="${zapis.nadimak}" size="20" maxlength="40"></td>
		<td><c:if test="${zapis.imaPogresku('nadimak')}">
			<div class="greska"><c:out value="${zapis.dohvatiPogresku('nadimak')}" /></div>
		</c:if></td>
		</tr>
		<tr>
		<td>e-mail</td><td><input type="text" name="email" value="${zapis.email}" size="20" maxlength="40"></td>
		<td><c:if test="${zapis.imaPogresku('email')}">
			<div class="greska"><c:out value="${zapis.dohvatiPogresku('email')}" /></div>
		</c:if></td>
		</tr>
		<tr>
		<td>Lozinka</td><td><input type="password" name="lozinka" size="20" maxlength="40"></td>
		</tr>
		<tr>
		<td>Potvrdi lozinku</td><td><input type="password" name="kontrola" size="20" maxlength="40"></td>
		<td><c:if test="${zapis.imaPogresku('kontrola')}">
			<div class="greska"><c:out value="${zapis.dohvatiPogresku('kontrola')}" /></div>
		</c:if></td>
		</tr>
		<tr>
		<td style="text-align:center"><input type="submit" name="metoda" value="Registriraj se"></td>
		<td style="text-align:center"><input type="submit" name="metoda" value="Odustani"></td>
		</tr>
		</table>
		</form>
		</div>
	</body>
</html>