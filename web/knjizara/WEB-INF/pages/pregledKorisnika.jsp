<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
	session="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<title>${korisnik.nadimak}</title>

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
	font-family: Verdana;
}

div.a {
	padding: 50px;
	border: 5px solid #040F37;
}

td {
	padding: 8px;
	font-size: 13px;
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
</style>
</head>
<body>
	<div class="b">E-knjižara List</div>
	<div class="a">
		<form action="listajKorisnike" method="get">
			<table align="center">
				<tr>
					<td>Ime</td>
					<td><input type="text" name="ime" value="${korisnik.ime}"
						size="40" maxlength="100" readonly="readonly"></td>
				</tr>
				<tr>
					<td>Prezime</td>
					<td><input type="text" name="prezime" value="${korisnik.prezime} "
						size="40" maxlength="100" readonly="readonly"></td>
				</tr>
				<tr>
					<td>Nadimak</td>
					<td><input type="text" name="nadimak"
						value="${korisnik.nadimak}" size="40" maxlength="40"
						readonly="readonly"></td>
				</tr>
				<tr>
					<td>e-mail</td>
					<td><input type="text" name="brojStranica"
						value="${korisnik.email}" size="40" maxlength="40"
						readonly="readonly"></td>
				</tr>
				<tr style="text-align: center">
					<td></td>
					<td><input type="submit" name="metoda" value="Nazad"></td>
				</tr>
			</table>
		</form>
		Kupio knjiga: ${brojKupljenih}<br>
		Prodao knjiga: ${brojProdanih}<br>
		Potrošio: ${potroseno} kn<br>
		Zaradio: ${zaradio} kn
	</div>
</body>


</html>