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
	font-family: Verdana;
}

div.a {
	float: left;
	padding: 50px;
	padding-bottom: 15px;
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

div.h {
	float: right;
}

hr {
	width: 100%;
	height: 1px;
	background: #000000
}
</style>
</head>
<body>
	<div class="b">E-knjižara List</div>
	<div class="a">
		<form action="kupi" method="post">
			<table align="center">
				<tr>
					<td>Naslov</td>
					<td><input type="text" name="naslov" value="${knjiga.naslov}"
						size="40" maxlength="100" readonly="readonly"></td>
				</tr>
				<tr>
					<td>Autori (odvojeni zarezom)</td>
					<td><input type="text" name="autori" value="${knjiga.autori} "
						size="40" maxlength="100" readonly="readonly"></td>
				</tr>
				<tr>
					<td>Godina izdanja</td>
					<td><input type="text" name="datumIzdanja"
						value="${knjiga.godinaIzdanja}" size="11" maxlength="11"
						readonly="readonly"></td>
				</tr>
				<tr>
					<td>Broj stranica</td>
					<td><input type="text" name="brojStranica"
						value="${knjiga.brojStranica}" size="5" maxlength="5"
						readonly="readonly"></td>
				</tr>
				<tr>
					<td>Žanr</td>
					<td><input type="text" name="zanr" value="${knjiga.zanr}"
						size="40" maxlength="40" readonly="readonly"></td>
				</tr>
				<tr>
					<td>Ocjena</td>
					<td><input type="text" name="zanr"
						value="${knjiga.ocjenaKnjige}" size="5" maxlength="5"
						readonly="readonly"></td>
				</tr>
				<tr>
					<td>ISBN</td>
					<td><input type="text" name="isbn" value="${knjiga.isbn}"
						size="40" maxlength="100" readonly="readonly"></td>
				</tr>
				<tr>
					<td>Cijena (kn)</td>
					<td><input type="text" name="cijena"
						value="${knjiga.pocetnaCijena * knjiga.razinaStogaKupnje}"
						size="7" maxlength="7" readonly="readonly"></td>
				</tr>
				<tr>
					<td><input type="hidden" name="nadimakVlasnika"
						value="${knjiga.nadimakVlasnika}"></td>
					<td><input type="hidden" name="id" value="${knjiga.id}"></td>
					<td><input type="hidden" name="pocetnaCijena" value="${knjiga.pocetnaCijena}"></td>
					<td><input type="hidden" name="razinaStoga" value="${knjiga.razinaStogaKupnje}"></td>
				</tr>
				<tr style="text-align: center">
					<td><input type="submit" name="metoda" value="Kupi"></td>
					<td><input type="submit" name="metoda" value="Nazad"></td>
				</tr>
				</form>
				<tr>
					<td></td>
					<td><form action="komentiraj" method="get">
							<input type="hidden" name="id" value="${knjiga.id}"> <input
								type="submit" name="metoda" value="Komentiraj">
						</form></td>
				</tr>
				<tr>
				<td></td>
				<td><c:if test="${applicationScope['korisnik'].nadimak == 'vlasnik'}">
						<form action="brisiKnjigu" method="post">
								<input type="hidden" name="id" value="${knjiga.id}">
								<input type="submit" name="metoda" value="Obriši knjigu">
							</form>
					</c:if></td>
				</tr>
			</table>
	</div>
	<div class="h">
		<table align="right">
			<form action="ocjeni" method="post">
				<input type="hidden" name="id" value="${knjiga.id}">
				<tr>
					<td><input type="radio" name="ocjena" value="1"> 1</td>
				</tr>
				<tr>
					<td><input type="radio" name="ocjena" value="2"> 2</td>
				</tr>
				<tr>
					<td><input type="radio" name="ocjena" value="3"> 3</td>
				</tr>
				<tr>
					<td><input type="radio" name="ocjena" value="4"> 4</td>
				</tr>
				<tr>
					<td><input type="radio" name="ocjena" value="5"> 5</td>
				</tr>
				<tr>
					<td><input type="radio" name="ocjena" value="6"> 6</td>
				</tr>
				<tr>
					<td><input type="radio" name="ocjena" value="7"> 7</td>
				</tr>
				<tr>
					<td><input type="radio" name="ocjena" value="8"> 8</td>
				</tr>
				<tr>
					<td><input type="radio" name="ocjena" value="9"> 9</td>
				</tr>
				<tr>
					<td><input type="radio" name="ocjena" value="10" checked>
						10</td>
				</tr>
				<tr>
					<td><input type="submit" name="metoda" value="Ocjeni"></td>
				</tr>
			</form>
		</table>
	</div>


	<hr />

	<p style="padding-bottom: 5px; float: left">Komentari:</p>
	<br>
	<table align="right">
		<form action="filterKomentara" method="post">
			<tr>
				<td><input type="hidden" name="id" value="${knjiga.id}"></td>
				<td><input type="radio" name="filter" value="svi" checked>Svi</td>
				<td><input type="radio" name="filter" value="pozitivni">Pozitivni</td>
				<td><input type="radio" name="filter" value="negativni">Negativni</td>
				<td><input type="submit" name="metoda" value="Filtriraj"></td>
			</tr>
		</form>
	</table>
	<hr />
	<div>
		<c:forEach var="komentar" items="${komentari}">
		${komentar}<br>
		</c:forEach>
	</div>
</body>


</html>