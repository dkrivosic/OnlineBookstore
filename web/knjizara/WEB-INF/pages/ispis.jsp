<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" session="true" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
	<head>
		<title>Poruka</title>
		<style>
		body {
				background-color: #8AB5EE;
				width: 800px;
				margin-left: auto;
				margin-right: auto;
				margin-top: 100px;
				
			}
			div.a {
			border: 5px;
			border-style: outset;
			padding: 10px;
			border-color: #0417C4;
			text-align:center;
			font-family: Arial"
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
	<p></p>
		<div class="a">
		${poruka}
		</div>
	
	</body>
</html>