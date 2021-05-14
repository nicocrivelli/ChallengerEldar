<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<body>
<h1>Challenger Java  Backend</h1>
<h3>Nicolas Crivelli</h3>

<br>

<h2>Consulta tasa de operacion</h2>

<form action="/consultarTasa" method="post">
	<label>Marca</label>
	<br>
	<input type="radio" id="VISA" name="marca" value="VISA" required="required">
	<label for="VISA">VISA</label><br>
 	<input type="radio" id="NARA" name="marca" value="NARA" required="required">
 	<label for="NARA">NARA</label><br>
 	<input type="radio" id="AMEX" name="marca" value="AMEX" required="required">
 	<label for="AMEX">AMEX</label>
 	<br>
 	<br>
 	<label>Monto</label>
 	<br>
 	<input type="number" name="monto" required="required">
 	
 	<input type="hidden" value="Generico" name="cardholder">
	<input type="hidden" value=123456 name="numeroTarjeta">
	
	
	<input type="submit" value="Consultar">
</form>

<br>

</body>
</html>