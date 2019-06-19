<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<form action="/guest-book" method="post">
    Imię i nazwisko <input type="text" name="name">
    Opis <input type="text" name="description">
    <input type="submit" value="Wyślij">
</form>
<body>
<c:forEach items="${guestList}" var="guest">
    <p>${guest}</p>
</c:forEach>
</body>
</html>
