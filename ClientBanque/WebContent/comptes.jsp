<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Comptes</title>
</head>
<body>
	Les comptes disponibles sont :
	<br />
	<c:forEach items="${comptes}" var="c">
  	 	Compte <c:out value="${c}"/><p>
	</c:forEach>
</body>
</html>