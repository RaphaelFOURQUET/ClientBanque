<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ClientBanque</title>
</head>
<body>
	<div class="row">
		<form class="col" method="post" action="conversionServlet">
			<div class="row">
				<input id="montant" name="montant" type="text" class="validate"/>
				<label for="montant">Montant</label>
			</div>
			<button value="Conversion" type="submit">Conversion</button>
		</form>
	</div>
	<br />
	<div class="row">
		<form class="col" method="post" action="compteServlet">
			<div class="row">
				<input id="id" name="id" type="text" class="validate"/>
				<label for="id">ID Compte</label>
			</div>
			<button value="ID Compte" type="submit">Acceder compte</button>
		</form>
	</div>
	<br />
	<div class="row">
		<form class="col" method="post" action="comptesServlet">
			<button value="comptes" type="submit">Acceder comptes</button>
		</form>
	</div>
	<br />
</body>
</html>